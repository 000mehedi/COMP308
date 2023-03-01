public class ThermostatDay extends Event {
    public ThermostatDay(long delayTime, Controller controller) {
        super(delayTime, controller);
    }

    public void action() throws ControllerException {
        controller.setVariable("Thermostat", "Day");
        System.out.println("The thermostat is now on daytime settings");
    }
}
