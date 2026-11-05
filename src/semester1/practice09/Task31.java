package semester1.practice09;

public class Task31 {
    public static void run(){
        PressureSensor pressure = new PressureSensor(
                "Котельня", 1.0, 5.0, 4.0, 1.1
        );
        RadiationSensor radiation = new RadiationSensor(
                "Лабораторія", 0.0, 0.3, 0.5
        );
        System.out.println(pressure);
        System.out.println(radiation);
    }
}
abstract class AbstractSensor {
    private final String location;
    private final double minSafe;
    private final double maxSafe;

    AbstractSensor(String location, double minSafe, double maxSafe) {
        this.location = location;
        this.minSafe = minSafe;
        this.maxSafe = maxSafe;
    }

    public abstract double readValue();

    public abstract String getUnit();

    public final boolean isAlarmTriggered() {
        double value = readValue();
        return value < minSafe || value > maxSafe;
    }

    @Override
    public String toString() {
        return "Місце: " + location +
                ", показник: " + readValue() + " " + getUnit() +
                ", тривога: " + (isAlarmTriggered() ? "АКТИВНА" : "ВІДСУТНЯ");
    }
}

class PressureSensor extends AbstractSensor {
    private double pressure;
    private double calibrationFactor;
    PressureSensor(String location, double minSafe, double maxSafe,
                   double pressure, double calibrationFactor) {
        super(location, minSafe, maxSafe);
        this.pressure = pressure;
        this.calibrationFactor = calibrationFactor;
    }

    @Override
    public double readValue() {
        return pressure * calibrationFactor;
    }

    @Override
    public String getUnit() {
        return "бар";
    }
}

class RadiationSensor extends AbstractSensor {
    private double radiationLevel;

    RadiationSensor(String location, double minSafe, double maxSafe, double radiationLevel) {
        super(location, minSafe, maxSafe);
        this.radiationLevel = radiationLevel;
    }

    @Override
    public double readValue() {
        return radiationLevel;
    }

    @Override
    public String getUnit() {
        return "мкЗв/год";
    }
}

