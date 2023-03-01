//Student ID: 3619873
//   Student Name: Md Abdullah Mehedi Patwary
//    Student email: mpatwary1@athabasca.edu
//Date: 07/12/2022

public abstract class Event implements Runnable {
    protected final long delayTime;
    protected long currentTime;
    protected long lastTime;
    protected final Controller controller;

    public Event(long delayTime, Controller controller) {
        this.delayTime = delayTime;
        this.currentTime = delayTime;
        this.controller = controller;
    }

    //threading starts
    public void run() {
        lastTime = System.currentTimeMillis();

        try {
            synchronized(controller) {
                controller.increaseThreads();
            }

            while(tick()) {
                synchronized(controller) {
                    while(!controller.running() || controller.kill()) {
                        if(controller.kill()) return;
                        controller.wait();
                        lastTime = System.currentTimeMillis();
                    }
                }
            }

            action();

        } catch(InterruptedException e) {
            e.printStackTrace();
        } catch(ControllerException e) {
            synchronized(controller) {
                controller.shutdown(e.getMessage());
            }
        } finally {
            synchronized(controller) {
                controller.decreaseThreads();
                controller.callback(this);
            }
        }
    }

    // Countdown
    private Boolean tick() {
        long now = System.currentTimeMillis();
        long delta = now - lastTime;

        this.currentTime -= delta;
        this.lastTime = now;

        return currentTime > 0;
    }

    public long getTime() {
        return currentTime;
    }

    public String serialize() {
        return "event=" + getClass().getSimpleName() + ",delay= " + currentTime;
    }

    public abstract void action() throws ControllerException;
}

