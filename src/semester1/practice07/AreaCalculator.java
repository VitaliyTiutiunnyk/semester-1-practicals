package semester1.practice07;

public class AreaCalculator {
    public double calculateArea(double side){
        return side*side;
    }
    public double calculateArea(double width, double height){
        return width*height;
    }
    public double calculateArea(double radius, boolean isCircle){
        return Math.PI*(radius*radius);
    }
    public double calculateArea(double a, double b, double c){
        double p=(a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
    public double calculateArea(double base1, double base2, double height, boolean isTrapezoid){
        return (base1 + base2) * height / 2;

    }
}
