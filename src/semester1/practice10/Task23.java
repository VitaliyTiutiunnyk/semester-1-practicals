package semester1.practice10;

public class Task23 {
    public static void run(){
        AbstractLabDevice[] devices = {
                new ElectronicScale("EL-101"),
                new GlassThermometer("GT-202")
        };
        for (AbstractLabDevice device : devices) {
            System.out.println("\n=== Лабораторний прилад ===");
            System.out.println("Інвентарний код: " + device.getInventoryCode());
            device.performMeasurement();
            if (device instanceof Calibratable calibratable) {
                calibratable.calibrate(100.0);
            }
            if (device instanceof SelfDiagnostic diagnostic) {
                System.out.println("Результат самодіагностики: "
                        + diagnostic.runSelfCheck());
            }
        }
    }
}
abstract class AbstractLabDevice {
    private final String inventoryCode;

    AbstractLabDevice(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    public String getInventoryCode() {
        return inventoryCode;
    }

    public abstract void performMeasurement();
}

interface Calibratable {
    void calibrate(double referenceValue);
}

interface SelfDiagnostic {
    boolean runSelfCheck();
}

class ElectronicScale extends AbstractLabDevice implements Calibratable, SelfDiagnostic {

    ElectronicScale(String inventoryCode) {
        super(inventoryCode);
    }

    @Override
    public void performMeasurement() {
        System.out.println("Вимірювання маси: 25.5 кг");
    }

    @Override
    public void calibrate(double referenceValue) {
        System.out.println("Ваги відкалібровано за значенням: "
                + referenceValue + " кг");
    }

    @Override
    public boolean runSelfCheck() {
        return true;
    }
}

class GlassThermometer extends AbstractLabDevice {

    GlassThermometer(String inventoryCode) {
        super(inventoryCode);
    }

    @Override
    public void performMeasurement() {
        System.out.println("Вимірювання температури: 36.6 °C");
    }
}
