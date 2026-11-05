package semester1.practice09;

public class Task34 {
    public static void run(){
        Spacecraft ship = new Spacecraft("Orion", 20, 5);
        ship.addThruster(new ChemicalThruster("CH-01", 500, 120));
        ship.addThruster(new ChemicalThruster("CH-02", 500, 120));
        ship.addThruster(new IonThruster("ION-01", 10, 0.5));
        System.out.println(ship);
    }
}
abstract class AbstractThruster {
    private final String thrusterId;

    AbstractThruster(String thrusterId) {
        this.thrusterId = thrusterId;
    }

    public abstract double getThrustKn();

    public abstract double getFuelBurnRate();

    @Override
    public String toString() {
        return "Двигун: " + thrusterId +
                ", тяга: " + getThrustKn() + " кН" +
                ", витрата палива: " + getFuelBurnRate();
    }
}

class ChemicalThruster extends AbstractThruster {
    private double thrustKn;
    private double fuelBurnRate;

    ChemicalThruster(String thrusterId, double thrustKn, double fuelBurnRate) {
        super(thrusterId);
        this.thrustKn = thrustKn;
        this.fuelBurnRate = fuelBurnRate;
    }

    @Override
    public double getThrustKn() {
        return thrustKn;
    }

    @Override
    public double getFuelBurnRate() {
        return fuelBurnRate;
    }
}

class IonThruster extends AbstractThruster {
    private double thrustKn;
    private double fuelBurnRate;

    IonThruster(String thrusterId, double thrustKn, double fuelBurnRate) {
        super(thrusterId);
        this.thrustKn = thrustKn;
        this.fuelBurnRate = fuelBurnRate;
    }

    @Override
    public double getThrustKn() {
        return thrustKn;
    }

    @Override
    public double getFuelBurnRate() {
        return fuelBurnRate;
    }
}

class Spacecraft {
    private final String shipName;
    private final double dryMassTons;
    private final AbstractThruster[] thrusters;
    private int count;

    Spacecraft(String shipName, double dryMassTons, int capacity) {
        this.shipName = shipName;
        this.dryMassTons = dryMassTons;
        this.thrusters = new AbstractThruster[capacity];
        this.count = 0;
    }

    public boolean addThruster(AbstractThruster thruster) {
        if (thruster == null || count >= thrusters.length) {
            return false;
        }

        thrusters[count] = thruster;
        count++;
        return true;
    }

    public double getTotalThrust() {
        double total = 0;

        for (int i = 0; i < count; i++) {
            total += thrusters[i].getThrustKn();
        }

        return total;
    }

    public double getInitialAcceleration() {
        // 1 кН = 1000 Н, 1 тонна = 1000 кг
        // Тому числове значення тяги в кН ділимо на масу в тоннах
        return getTotalThrust() / dryMassTons;
    }

    @Override
    public String toString() {
        String result = "Корабель: " + shipName +
                "\nСуха маса: " + dryMassTons + " тонн";

        for (int i = 0; i < count; i++) {
            result += "\n" + thrusters[i];
        }

        result += "\nСумарна тяга: " + getTotalThrust() + " кН";
        result += "\nПочаткове прискорення: " + getInitialAcceleration() + " м/с²";

        return result;
    }
}
