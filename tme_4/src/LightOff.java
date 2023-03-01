public class LightOff extends Event{
    public LightOff (long delayTime, Controller controller){
        super(delayTime, controller);
    }
    public void action() throws ControllerException{
        controller.setVariable("Lights", false);
        System.out.println("Lights are off");
    }
}