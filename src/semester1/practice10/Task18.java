package semester1.practice10;

public class Task18 {
    public static void run(){
        SmartLedChandelier chandelier =
                new SmartLedChandelier("Вітальня", "LED-100", true);
        SmartUnderfloorHeating heating =
                new SmartUnderfloorHeating("Ванна", "Heat-200", true);
        chandelier.setBrightness(50);
        heating.setTargetTemperature(30);
        AbstractSmartAppliance[] appliances = {
                chandelier,
                heating
        };
        double totalWatts = 0;
        for (AbstractSmartAppliance appliance : appliances) {
            totalWatts += appliance.getCurrentWatts();
        }
        System.out.println("Загальне енергоспоживання: " + totalWatts + " Вт");
    }
}
abstract class AbstractSmartAppliance{
    private final String room;
    private final String model;
    protected boolean poweredOn;
    AbstractSmartAppliance(String room, String model, boolean poweredOn){
        this.room=room;
        this.model=model;
        this.poweredOn=poweredOn;
    }
    public abstract double getCurrentWatts();
}
interface Dimmable{
    void setBrightness(int percent);
}
interface HeatingCapable{
    void setTargetTemperature(double celsius);
}
class SmartLedChandelier extends AbstractSmartAppliance implements Dimmable{
   private int brightness = 100;
    SmartLedChandelier(String room, String model, boolean poweredOn){
        super(room, model, poweredOn);
    }
    @Override
    public double getCurrentWatts() {
        if (!poweredOn) return 0;
        return 60 * brightness / 100.0;

    }

    @Override
    public void setBrightness(int percent) {
        if (percent >= 0 && percent <= 100) {
            brightness = percent;
        }else brightness=100;
    }
}
class SmartUnderfloorHeating extends AbstractSmartAppliance implements HeatingCapable {
    private double targetTemperature = 25;
    SmartUnderfloorHeating(String room, String model, boolean poweredOn) {
        super(room, model, poweredOn);
    }
    @Override
    public void setTargetTemperature(double celsius) {
        if (celsius >= 10 && celsius <= 40) {
            targetTemperature = celsius;
        } else targetTemperature=25;
    }
    @Override
    public double getCurrentWatts() {
        if (!poweredOn) return 0;
        return 1000 * (targetTemperature - 10) / 30.0;
    }
}
