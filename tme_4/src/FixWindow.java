public class FixWindow extends Event{
    public FixWindow (long delayTime, Controller controller){
        super(delayTime, controller);
    }


    public void action() throws ControllerException{
        controller.setVariable("Window Ok", true);
        System.out.println("Windows are fixed");
    }
}