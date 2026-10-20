package semester1.practice06.homework;

public class Task1Fraction {
    public static void main(String[] args) {
        Fraction fraction = new Fraction();
        System.out.println("_____КАЛЬКУЛЯТОР ДРОБІВ_____");
        fraction.setValues(8, 12);
        System.out.print(" Початковий дріб: ");
        fraction.printFraction();
        fraction.simplify();
        System.out.print(" Після скорочення: ");
        fraction.printFraction();
        System.out.printf(" Десятковий вигляд: %.4f%n",
                fraction.toDecimal());
        System.out.println(" Додаємо дріб 3/4...");
        fraction.add(3, 4);
        System.out.print(" Результат: ");
        fraction.printFraction();
        System.out.printf(" Десятковий вигляд: %.4f%n",
                fraction.toDecimal());
        System.out.println("___________________________");

    }
}
