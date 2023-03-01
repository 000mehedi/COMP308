public class WaterOff extends Event{
    public WaterOff (long delayTime, Controller controller){
        super(delayTime, controller);
    }
    public void action() throws ControllerException{
        controller.setVariable("Water", false);
        System.out.println("Water Off");
    }
}