import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.ArrayList;


public abstract class Controller {
    protected Boolean running;
    protected Boolean kill;
    protected TextArea outPut;

    protected ArrayList<Event> events;

    protected Object o;
    protected Method m;

    protected int threadCount;

    public Controller(TextArea outPut, Object o, Method m) {
        this.events = new ArrayList<>();

        this.running = true;
        this.kill = false;

        this.outPut = outPut;

        this.o = o;
        this.m = m;
    }

    public void addEvent(Event e) {
        events.add(e);

        this.kill = false;

        Thread.UncaughtExceptionHandler h = (thread, throwable) -> shutdown(throwable.getMessage());

        Thread thread = new Thread(e);
        thread.setUncaughtExceptionHandler(h);
        thread.start();
    }

    public void addEvent(String name, long delayTime) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class cl = Class.forName("events." + name);
        Constructor constructor = cl.getConstructor(long.class, Controller.class);
        Object o = constructor.newInstance(delayTime, this);
        Event e = (Event)o;

        this.addEvent(e);

    }

    public Boolean running() {
        synchronized(this) {
            notifyAll();
        }
        return this.running;
    }

    public void running(Boolean running) {
        synchronized(this) {
            this.running = running;
            notifyAll();
        }
    }

    public Boolean kill() {
        synchronized(this) {
            notifyAll();
        }
        return this.kill;
    }

    public void increaseThreads() {
        threadCount++;
    }

    public void decreaseThreads() {
        threadCount--;
    }

    public void callback(Event e) {
        try {
            this.m.invoke(o, e);
        } catch(Exception throwable) {
            throwable.printStackTrace();
        }
    }

    public abstract void shutdown(String message);
    public abstract void setVariable(String key, Object value) throws ControllerException;


}