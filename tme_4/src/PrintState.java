public class PrintState extends Event {
    public PrintState(long delayTime, Controller controller) {
        super(delayTime, controller);
    }

    public void action() throws ControllerException {
        System.out.println(controller);
    }
}

