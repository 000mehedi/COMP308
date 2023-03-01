public class PowerOn extends Event{
    public PowerOn (long delayTime, Controller controller){
        super(delayTime, controller);
    }
    public void action() throws ControllerException{
        controller.setVariable("Power", true);
        System.out.println("Power ON");
    }
}