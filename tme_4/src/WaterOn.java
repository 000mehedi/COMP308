public class WaterOn extends Event{
    public WaterOn (long delayTime, Controller controller){
        super(delayTime, controller);
    }
    public void action() throws ControllerException{
        controller.setVariable("Water", true);
        System.out.println("Water On");
    }
}