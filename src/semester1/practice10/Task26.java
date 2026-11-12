package semester1.practice10;

public class Task26 {
    public static void run(){
        Object[] warehouse = {
                new Laptop(),
                new ElectricScooter(),
                new SmartWatch(),
                new DesktopMonitor(),
                new WiredPrinter()
        };
        int charged = chargeAllPossible(warehouse);
        System.out.println("Успішно заряджено пристроїв: " + charged);
    }
    public static int chargeAllPossible(Object[] items) {
        int count = 0;
        for (Object item : items) {
            if (item instanceof Rechargeable r) {
                r.chargeToFull();
                count++;
            }
        }
        return count;
    }
}
interface Rechargeable {
    void chargeToFull();
}

class Laptop implements Rechargeable {
    @Override
    public void chargeToFull() {
        System.out.println("Ноутбук заряджено!");
    }
}

class ElectricScooter implements Rechargeable {
    @Override
    public void chargeToFull() {
        System.out.println("Електросамокат заряджено!");
    }
}

class SmartWatch implements Rechargeable {
    @Override
    public void chargeToFull() {
        System.out.println("Смартгодинник заряджено!");
    }
}

class DesktopMonitor {
}

class WiredPrinter {
}
