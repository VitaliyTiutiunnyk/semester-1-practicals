package semester1.practice10;

public class Task28 {
    public static void run(){
        ShipModule[] modules = {
                new ShieldGenerator("Щитовий генератор", false),
                new WarpDrive("Варп-двигун", false),
                new LifeSupportModule("Система життєзабезпечення", true)
        };
        runShipInspection(modules);
    }
    public static void runShipInspection(ShipModule[] modules) {
        for (ShipModule module : modules) {
            System.out.println("\n=== Перевірка модуля ===");
            System.out.println("Назва: " + module.getName());
            System.out.println("Пошкоджений: " + module.isDamaged());
            if (module instanceof ShieldGenerator shield) {
                shield.rechargeShields(500);
            } else if (module instanceof WarpDrive warp) {
                System.out.println("Антиматеріальне утримання: "
                        + warp.checkAntimatterContainment());
            } else if (module instanceof LifeSupportModule lifeSupport) {
                System.out.println("Рівень кисню: "
                        + lifeSupport.getOxygenPercent() + "%");
            }
        }
    }
}
abstract class ShipModule {
    private final String name;
    private final boolean damaged;

    ShipModule(String name, boolean damaged) {
        this.name = name;
        this.damaged = damaged;
    }

    public String getName() {
        return name;
    }

    public boolean isDamaged() {
        return damaged;
    }
}

class ShieldGenerator extends ShipModule {
    ShieldGenerator(String name, boolean damaged) {
        super(name, damaged);
    }

    public void rechargeShields(int megajoules) {
        System.out.println("Щити заряджено на " + megajoules + " МДж");
    }
}

class WarpDrive extends ShipModule {
    WarpDrive(String name, boolean damaged) {
        super(name, damaged);
    }

    public boolean checkAntimatterContainment() {
        return !isDamaged();
    }
}

class LifeSupportModule extends ShipModule {
    LifeSupportModule(String name, boolean damaged) {
        super(name, damaged);
    }

    public double getOxygenPercent() {
        return isDamaged() ? 45.0 : 100.0;
    }
}
