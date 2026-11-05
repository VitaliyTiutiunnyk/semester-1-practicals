package semester1.practice09;

public class Task25 {
    public static void run(){
        CircleShape circle = new CircleShape(5, "Червоний");
        RectangleShape rectangle = new RectangleShape("Синій", 4, 6);
        System.out.println("Коло: ");
        System.out.println(circle);
        System.out.println("Прямокутник: ");
        System.out.println(rectangle);
    }
}
abstract class AbstractShape{
    private String color;
    AbstractShape(String color){
        this.color=color;
    }
    public String getColor(){
        return color;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
    @Override
    public String toString() {
        return "Колір: " + getColor() +
                ", площа: " + getArea() +
                ", периметр: " + getPerimeter();
    }
}
 class  CircleShape extends AbstractShape{
    private int radius;
    CircleShape(int radius, String color){
        super(color);
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

 }
 class RectangleShape extends AbstractShape{
    private int width;
    private int height;
    RectangleShape(String color, int width, int height){
        super(color);
        this.width=width;
        this.height=height;
    }

     @Override
     public double getArea() {
         return width*height;
     }

     @Override
     public double getPerimeter() {
         return 2*(height+width);
     }
 }