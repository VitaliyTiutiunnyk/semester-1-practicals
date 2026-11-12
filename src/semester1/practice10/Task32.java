package semester1.practice10;

public class Task32 {
    public static void run() {
        CargoContainer[] containers = {
                new CargoContainer("Електроніка", 500),
                new ChemicalCargo("Хімікати", 300, 3),
                new FrozenFoodCargo("Заморожені продукти", 800, -18)
        };

        for (CargoContainer container : containers) {
            System.out.println("\nКонтейнер: " + container.getName());

            if (container instanceof HazardousCargo hazardous) {
                System.out.println("Небезпечний вантаж!");
                System.out.println("Клас небезпеки: " + hazardous.getHazardClass());
                System.out.println("Відправлено у спеціальний бокс.");

            } else if (container instanceof RefrigeratedCargo refrigerated) {
                System.out.println("Потрібне охолодження!");
                System.out.println("Необхідна температура: "
                        + refrigerated.getRequiredTempC() + " °C");
                System.out.println("Підключено до електроживлення.");

            } else {
                System.out.println("Звичайний вантаж. Стандартна перевірка.");
            }
        }
    }
}

class CargoContainer {
    private final String name;
    private final double weightKg;

    CargoContainer(String name, double weightKg) {
        this.name = name;
        this.weightKg = weightKg;
    }

    public String getName() {
        return name;
    }

    public double getWeightKg() {
        return weightKg;
    }
}

interface HazardousCargo {
    int getHazardClass();
}

interface RefrigeratedCargo {
    double getRequiredTempC();
}

class ChemicalCargo extends CargoContainer implements HazardousCargo {
    private final int hazardClass;

    ChemicalCargo(String name, double weightKg, int hazardClass) {
        super(name, weightKg);
        this.hazardClass = hazardClass;
    }

    @Override
    public int getHazardClass() {
        return hazardClass;
    }
}

class FrozenFoodCargo extends CargoContainer implements RefrigeratedCargo {
    private final double requiredTempC;

    FrozenFoodCargo(String name, double weightKg, double requiredTempC) {
        super(name, weightKg);
        this.requiredTempC = requiredTempC;
    }

    @Override
    public double getRequiredTempC() {
        return requiredTempC;
    }
}
