package semester1.practice10;

public class Task02 {
    public static Shape2D findMaxAreaShape(Shape2D[] shapes) {
        if (shapes == null || shapes.length == 0) {
            return null;
        }
        Shape2D maxShape = shapes[0];
        for (Shape2D shape : shapes) {
            if (shape.getArea() > maxShape.getArea()) {
                maxShape = shape;
            }
        }
        return maxShape;
    }
    public static void run(){
        Shape2D[] shapes = {
                new CircleShape(5),
                new RectangleShape(4, 6),
                new EquilateralTriangleShape(10)
        };
        for (Shape2D shape : shapes) {
            System.out.println("Площа: " + shape.getArea());
            System.out.println("Периметр: " + shape.getPerimeter());
            System.out.println("------------------");
        }
        Shape2D maxShape = findMaxAreaShape(shapes);
        System.out.println("Найбільша площа: " + maxShape.getArea());
    }
}
abstract class Shape2D{
    public abstract double getArea();
    public abstract double getPerimeter();
}
class CircleShape extends Shape2D{
    private double radius;
    CircleShape(double radius){
        this.radius=radius;
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }
    public double getDiameter() {
        return radius * 2;
    }
}
class RectangleShape extends Shape2D{
    private double a;
    private double b;
    RectangleShape(double a, double b){
        this.a=a; this.b=b;
    }

    @Override
    public double getArea() {
        return a*b;
    }

    @Override
    public double getPerimeter() {
        return 2*(a+b);
    }
    public double getDiagonal() {
        return Math.sqrt(a * a + b * b);
    }

    public boolean isSquare() {
        return a == b;
    }
}
class EquilateralTriangleShape extends Shape2D{
    private double a;
    EquilateralTriangleShape(double a){
        this.a=a;
    }

    @Override
    public double getArea() {
        return ((a*a)*Math.sqrt(3))/4;
    }

    @Override
    public double getPerimeter() {
        return 3*a;
    }
}
