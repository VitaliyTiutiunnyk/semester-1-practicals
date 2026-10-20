package semester1.practice06.homework;

public class Task3Vector2D {
    public static void main(String[] args) {
        Vector2D a = new Vector2D();
        Vector2D b = new Vector2D();
        System.out.println("_____ВЕКТОРНИЙ АНАЛІЗАТОР_____");
        a.set(3, 4);
        b.set(-4, 3);
        System.out.print("Вектор A: ");
        a.printVector();
        System.out.print("Вектор B: ");
        b.printVector();

        System.out.println("Скалярний добуток: "
                + a.dotProduct(b.getX(), b.getY()));
        System.out.println("Вектори перпендикулярні: "
                + a.isPerpendicularTo(b.getX(), b.getY()));

        System.out.println("Нормалізація вектора A...");
        a.normalize();
        System.out.print("Вектор A після нормалізації: ");
        a.printVector();
        System.out.println("_______________________________");
    }
}
