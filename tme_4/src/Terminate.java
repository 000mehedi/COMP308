public class Terminate extends Event {
    public Terminate(long delayTime, Controller controller) {
        super(delayTime, controller);
    }

    public void action() throws ControllerException {
        System.out.println("Terminating...");

    }
}

