public class WindowMalfunction extends Event{
    public WindowMalfunction (long delayTime, Controller controller){
        super(delayTime, controller);
    }
    public void action() throws ControllerException{
        controller.setVariable("Window Ok", false);
        System.out.println("Windows are malfunctioned");
    }
}