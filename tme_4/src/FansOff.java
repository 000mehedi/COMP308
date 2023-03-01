public class FansOff extends Event{
    public FansOff (long delayTime, Controller controller){
        super(delayTime, controller);
    }
    public void action() throws ControllerException{
        controller.setVariable("Fans", false);
        System.out.println("Fans are off");
    }
}