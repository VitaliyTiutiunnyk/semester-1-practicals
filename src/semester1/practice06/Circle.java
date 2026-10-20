package semester1.practice06;

public class Circle {
    double radius;
    public double getArea(){
        return Math.PI*Math.pow(radius,2);
    }
    public double getCircumference(){
        return 2*Math.PI*radius;
    }
}
