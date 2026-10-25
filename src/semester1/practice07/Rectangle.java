package semester1.practice07;

public class Rectangle {
    private double width;
    private double height;
    Rectangle(){
        this.width=1.0;
        this.height=1.0;
    }
    Rectangle(double size){
        this.height=size;
        this.width=size;

    }
    Rectangle(double width, double height){
        this.width=width;
        this.height=height;
    }
    public double getArea(){
        return height*width;
    }
    public double getPerimeter(){
        return (height+width)*2;
    }
    public boolean isSquare(){
        return height==width;


    }
}
