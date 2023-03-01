public class LightOn extends Event{
    public LightOn (long delayTime, Controller controller){
        super(delayTime, controller);
    }
    public void action() throws ControllerException{
        controller.setVariable("Lights", false);
        System.out.println("Lights are on");
    }
}