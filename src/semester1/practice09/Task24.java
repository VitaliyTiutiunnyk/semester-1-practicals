package semester1.practice09;

public class Task24 {
    public static void run(){
        EquationSystem system = new EquationSystem(3);
        system.addEquation(new LinearEquation(2, 1, 7));
        system.addEquation(new LinearEquation(1, -1, 1));
        system.addEquation(new LinearEquation(3, 2, 13));
        System.out.println(system);
        double x = 3;
        double y = 1;
        System.out.println("Перевірка x = " + x + ", y = " + y);
        System.out.println("Чи є розв'язком системи: " +
                system.checkSolution(x, y));
        double x2 = 2;
        double y2 = 3;
        System.out.println("\nПеревірка x = " + x2 + ", y = " + y2);
        System.out.println("Чи є розв'язком системи: " +
                system.checkSolution(x2, y2));
    }
}
class LinearEquation {
    private final double a;
    private final double b;
    private final double c;
    LinearEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public boolean isSatisfiedBy(double x, double y) {
        double left = a * x + b * y;
        return Math.abs(left - c) < 0.000001;
    }
    @Override
    public String toString() {
        return a + "x + " + b + "y = " + c;
    }
}
class EquationSystem {
    private final LinearEquation[] equations;
    private int count;

    EquationSystem(int capacity) {
        equations = new LinearEquation[capacity];
        count = 0;
    }

    public void addEquation(LinearEquation equation) {
        if (equation != null && count < equations.length) {
            equations[count] = equation;
            count++;
        }
    }

    public boolean checkSolution(double x, double y) {
        for (int i = 0; i < count; i++) {
            if (!equations[i].isSatisfiedBy(x, y)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "=== СИСТЕМА РІВНЯНЬ ===\n";

        for (int i = 0; i < count; i++) {
            result += equations[i] + "\n";
        }

        return result;
    }
}
