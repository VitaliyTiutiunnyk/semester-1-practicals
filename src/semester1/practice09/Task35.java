package semester1.practice09;

public class Task35 {
    public static void run(){
        LandPlot plot = new LandPlot(1000, 10);
        plot.addStructure(new RectangleShape( "Сірий",15, 10));
        plot.addStructure(new CircleShape(10, "Зелений"));
        System.out.println("Вільна площа газону: " +
                plot.getFreeGreenArea());
        System.out.println("Додавання великої споруди: " +
                plot.addStructure(new RectangleShape("Білий", 20, 30)));

    }
}

class LandPlot {
    private final double totalPlotAreaM2;
    private final AbstractShape[] structures;
    private int count;

    LandPlot(double totalPlotAreaM2, int capacity) {
        this.totalPlotAreaM2 = totalPlotAreaM2;
        structures = new AbstractShape[capacity];
        count = 0;
    }

    public boolean addStructure(AbstractShape s) {
        if (s == null || count >= structures.length) {
            return false;
        }

        double totalArea = s.getArea();

        for (int i = 0; i < count; i++) {
            totalArea += structures[i].getArea();
        }

        if (totalArea > totalPlotAreaM2 * 0.6) {
            return false;
        }

        structures[count] = s;
        count++;
        return true;
    }
    public double getFreeGreenArea() {
        double usedArea = 0;

        for (int i = 0; i < count; i++) {
            usedArea += structures[i].getArea();
        }
        return totalPlotAreaM2 - usedArea;
    }
}