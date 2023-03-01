public class ThermostatNight extends Event {
    public ThermostatNight(long delayTime, Controller controller) {
        super(delayTime, controller);
    }

    public void action() throws ControllerException {
        controller.setVariable("Thermostat", "Night");
        System.out.println("The thermostat is now on nighttime settings");
    }
}
