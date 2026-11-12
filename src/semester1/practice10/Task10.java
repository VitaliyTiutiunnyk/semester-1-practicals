package semester1.practice10;

public class Task10 {
    public static void run(){
        EnergyConvertible[] devices = {
                new KineticBody(10, 20),
                new BatteryCell(100)
        };
        for (EnergyConvertible device : devices) {
            System.out.println("Енергія: " + device.getEnergyJoules() + " Дж");
            System.out.println("Енергія: " + device.getEnergyKwh() + " кВт·год");
        }

    }
}
interface  EnergyConvertible{
    double SPEED_OF_LIGHT = 299_792_458.0;
    double JOULES_PER_KWH = 3_600_000.0;
    double getEnergyJoules();
    default double getEnergyKwh(){
        return getEnergyJoules()/JOULES_PER_KWH;
    }
}
class KineticBody implements EnergyConvertible {
    private double mass;
    private double speed;

    KineticBody(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    @Override
    public double getEnergyJoules() {
        return mass * speed * speed / 2;
    }
}
class BatteryCell implements EnergyConvertible {
    private double capacityWh;

    BatteryCell(double capacityWh) {
        this.capacityWh = capacityWh;
    }

    @Override
    public double getEnergyJoules() {
        return capacityWh * 3600;
    }
}
