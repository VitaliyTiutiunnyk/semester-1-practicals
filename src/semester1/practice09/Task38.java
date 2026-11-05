package semester1.practice09;

public class Task38 {
    public static void run(){
        SmartLab lab = new SmartLab(5);
        lab.addSensor(new PressureSensor("Реактор", 1, 5, 4, 1.1));
        lab.addSensor(new RadiationSensor("Лабораторія", 0.1, 0.3, 0.5));
        lab.runDiagnostics();
    }
}
class EmergencySiren {
    private boolean sounding;

    EmergencySiren() {
        sounding = false;
    }

    public void activate() {
        sounding = true;
    }

    public boolean isSounding() {
        return sounding;
    }
}

class SmartLab {
    private final EmergencySiren siren;
    private final AbstractSensor[] sensors;
    private int count;

    SmartLab(int capacity) {
        siren = new EmergencySiren();
        sensors = new AbstractSensor[capacity];
        count = 0;
    }

    public boolean addSensor(AbstractSensor sensor) {
        if (sensor == null || count >= sensors.length) {
            return false;
        }

        sensors[count] = sensor;
        count++;
        return true;
    }

    public void runDiagnostics() {
        boolean alarmDetected = false;

        System.out.println("=== ДІАГНОСТИКА ЛАБОРАТОРІЇ ===");

        for (int i = 0; i < count; i++) {
            System.out.println("Перевірка датчика " + (i + 1));

            if (sensors[i].isAlarmTriggered()) {
                alarmDetected = true;
                System.out.println("ВИЯВЛЕНО НЕБЕЗПЕКУ!");
            } else {
                System.out.println("Показники в нормі.");
            }
        }

        if (alarmDetected) {
            siren.activate();
            System.out.println("УВАГА! СИРЕНУ АКТИВОВАНО!");
        } else {
            System.out.println("Небезпеки не виявлено.");
        }

        System.out.println("Стан сирени: " +
                (siren.isSounding() ? "УВІМКНЕНО" : "ВИМКНЕНО"));
    }
}
