package semester1.practice10;

public class Task25 {
    public static void run(){
        Shape2D[] shapes = {
                new CircleShape(5),
                new RectangleShape(4, 6),
                new CircleShape(3),
                new RectangleShape(5, 5)
        };
        for (Shape2D shape : shapes) {
            if (shape instanceof CircleShape c) {
                System.out.println("Коло:");
                System.out.println("Діаметр: " + c.getDiameter());
            } else if (shape instanceof RectangleShape r) {
                System.out.println("Прямокутник:");
                System.out.println("Діагональ: " + r.getDiagonal());
                System.out.println("Це квадрат: " + r.isSquare());
            }

            System.out.println();
        }
        System.out.println("null instanceof Shape2D: " + (null instanceof Shape2D));
    }
}
