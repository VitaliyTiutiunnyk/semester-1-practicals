package semester1.practice09;

public class Task09 {
    public static void run(){
        CompositeCircle circle = new CompositeCircle(0, 0, 5);
        Point2D point1 = new Point2D(3, 4);
        Point2D point2 = new Point2D(6, 0);
        System.out.println("Перша точка: ");
        System.out.println(point1);
        System.out.println("Друга точка: ");
        System.out.println(point2);
        System.out.println(circle.containsPoint(point1));
        System.out.println(circle.containsPoint(point2));
        System.out.println(circle);

    }
}
class Point2D{
    private double x;private double y;
    Point2D(double x, double y){
        this.x = x; this.y = y;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
   public double distanceTo(Point2D other){
       return Math.sqrt(
               Math.pow(other.x - this.x, 2) +
                       Math.pow(other.y - this.y, 2)
       );
   }
    @Override
    public String toString() {
        return "A(" + x + ", " + y + ")";
    }
}
class CompositeCircle{
    private double radius;
    private final Point2D center;
    CompositeCircle(double centerX, double centerY, double radius){
        this.center = new Point2D(centerX, centerY);
        this.radius=radius;
    }
    public boolean containsPoint(Point2D p){
        return center.distanceTo(p) <= radius;
    }
    @Override
    public String toString() {
        return "Центр кола: " + center + ", Радіус: " + radius;
    }
}
