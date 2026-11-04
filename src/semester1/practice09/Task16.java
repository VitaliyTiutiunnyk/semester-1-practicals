package semester1.practice09;


public class Task16 {
    public static void run(){
        TemperatureSensor sensor = new TemperatureSensor(18.0);
        HeatingUnit heatingUnit = new HeatingUnit(2.5);
        ClimateController controller = new ClimateController(
                sensor, heatingUnit, 22.0
        );
        System.out.println("До регулювання:");
        System.out.println(controller);
        controller.regulate();
        System.out.println("\nПісля регулювання:");
        System.out.println(controller);
    }
}
class TemperatureSensor{
    private double currentTemp;
    TemperatureSensor(double currentTemp){
        if (currentTemp>=-30&&currentTemp<=40){
           this.currentTemp=currentTemp;
        }else this.currentTemp=0;
    }

    public double getCurrentTemp() {
        return currentTemp;
    }
}
class  HeatingUnit{
    private boolean heatingOn;
    private double powerKw;
    HeatingUnit(double powerKw){
        if (powerKw > 0) {
            this.powerKw = powerKw;
        } else {
            this.powerKw = 1;
        }
        this.heatingOn=false;
    }
    public void turnOn() {
        heatingOn = true;
    }
    public void turnOff() {
        heatingOn = false;
    }
    public boolean isHeatingOn() {
        return heatingOn;
    }
    public double getPowerKw() {
        return powerKw;
    }
}
class ClimateController{
   private TemperatureSensor sensor;
   private HeatingUnit heatingUnit;
    private double targetTemp;
    ClimateController(TemperatureSensor sensor, HeatingUnit heatingUnit, double targetTemp){
        this.sensor=sensor;
        this.heatingUnit=heatingUnit;
        this.targetTemp=targetTemp;
    }
    public void regulate(){
        if (sensor.getCurrentTemp() < targetTemp - 0.5){
            heatingUnit.turnOn();
        } else if (sensor.getCurrentTemp() > targetTemp + 0.5) {
            heatingUnit.turnOff();
        }
    }
    @Override
    public String toString() {
        return "=== ЗВІТ КЛІМАТ-КОНТРОЛЮ ===" +
                "\nПоточна температура: " + sensor.getCurrentTemp() + " °C" +
                "\nЦільова температура: " + targetTemp + " °C" +
                "\nСтан опалення: " + (heatingUnit.isHeatingOn() ? "Увімкнено" : "Вимкнено") +
                "\nПотужність опалення: " + heatingUnit.getPowerKw() + " кВт";
    }
}

