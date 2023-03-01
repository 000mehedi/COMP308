public class FansOn extends Event{
    public FansOn (long delayTime, Controller controller){
        super(delayTime, controller);
    }
    public void action() throws ControllerException{
        controller.setVariable("Fans", true);
        System.out.println("Fans are on");
    }
}