public class PowerOff extends Event{
    public PowerOff (long delayTime, Controller controller){
        super(delayTime, controller);
    }
    public void action() throws ControllerException{
        controller.setVariable("Power", false);
        System.out.println("Power Off");
    }
}