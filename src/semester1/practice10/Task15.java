package semester1.practice10;

public class Task15 {
    public static void applyGlobalTransform(Transformable2D[] objects,
                                            double dx,
                                            double dy,
                                            double scaleFactor){
        for (Transformable2D transform : objects){
            transform.translate(dx, dy);
            transform.scale(scaleFactor);
        }

    }
    public static void run(){
        Transformable2D[] objects = {
                new BoundingBox(10, 20, 100, 50),
                new CircleRegion(30, 40, 15)
        };
        System.out.println("До трансформації:");

        for (Transformable2D object : objects) {
            System.out.println(object);
        }
        applyGlobalTransform(objects, 5, 10, 2);
        System.out.println("\nПісля трансформації:");
        for (Transformable2D object : objects) {
            System.out.println(object);
        }
    }
}
interface Transformable2D{
    void translate(double dx, double dy);
    void scale(double factor);
}
class BoundingBox implements Transformable2D{
    private double x;
    private double y;
    private double width;
    private double height;
    BoundingBox(double x, double y , double width, double height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }

    @Override
    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }
    @Override
    public void scale(double factor) {
        width *= factor;
        height *= factor;
    }
    @Override
    public String toString() {
        return "BoundingBox: x=" + x + ", y=" + y
                + ", width=" + width + ", height=" + height;
    }
}
class CircleRegion implements Transformable2D {
    private double x;
    private double y;
    private double radius;
    CircleRegion(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    @Override
    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }
    @Override
    public void scale(double factor) {
        radius *= factor;
    }
    @Override
    public String toString() {
        return "CircleRegion: x=" + x + ", y=" + y
                + ", radius=" + radius;
    }
}