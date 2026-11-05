package semester1.practice09;

public class Task33 {
    public static void run(){
        DesktopPC pc = new DesktopPC(750, 5);
        pc.addPart(new ProcessorPart("Intel Core i7", 15000, 8, 125));
        pc.addPart(new VideoCardPart("RTX 4070", 25000, 12, 200));
        pc.addPart(new ProcessorPart("AMD Ryzen 5", 8000, 6, 65));
        System.out.println(pc);
    }
}
abstract class AbstractPcPart {
    private final String model;
    private final double priceUah;

    AbstractPcPart(String model, double priceUah) {
        this.model = model;
        this.priceUah = priceUah;
    }

    public abstract int getPowerConsumptionWatts();

    @Override
    public String toString() {
        return "Модель: " + model +
                ", ціна: " + priceUah + " грн" +
                ", споживання: " + getPowerConsumptionWatts() + " Вт";
    }
}

class ProcessorPart extends AbstractPcPart {
    private int cores;
    private int watts;

    ProcessorPart(String model, double priceUah, int cores, int watts) {
        super(model, priceUah);
        this.cores = cores;
        this.watts = watts;
    }

    @Override
    public int getPowerConsumptionWatts() {
        return watts;
    }
}

class VideoCardPart extends AbstractPcPart {
    private int vramGb;
    private int watts;

    VideoCardPart(String model, double priceUah, int vramGb, int watts) {
        super(model, priceUah);
        this.vramGb = vramGb;
        this.watts = watts;
    }

    @Override
    public int getPowerConsumptionWatts() {
        return watts;
    }
}

class DesktopPC {
    private final int psuMaxWatts;
    private final AbstractPcPart[] parts;
    private int partCount;

    DesktopPC(int psuMaxWatts, int capacity) {
        this.psuMaxWatts = psuMaxWatts;
        this.parts = new AbstractPcPart[capacity];
        this.partCount = 0;
    }

    public boolean addPart(AbstractPcPart part) {
        if (part == null || partCount >= parts.length) {
            return false;
        }

        parts[partCount] = part;
        partCount++;
        return true;
    }

    public int getTotalPowerConsumption() {
        int total = 0;

        for (int i = 0; i < partCount; i++) {
            total += parts[i].getPowerConsumptionWatts();
        }

        return total;
    }

    public boolean isStable() {
        return psuMaxWatts >= getTotalPowerConsumption() * 1.2;
    }

    @Override
    public String toString() {
        String result = "Потужність блока живлення: " + psuMaxWatts + " Вт\n";

        for (int i = 0; i < partCount; i++) {
            result += parts[i] + "\n";
        }

        result += "Загальне споживання: " + getTotalPowerConsumption() + " Вт";
        result += "\nСтабільність системи: " + (isStable() ? "Так" : "Ні");

        return result;
    }
}
