package semester1.practice07;

public class Box {
    private double width;
    private double height;
    private double depth;
    private String material;
    public Box(double width, double height, double depth, String material){
        this.width=width; this.height=height; this.depth=depth; this.material=material;
    }
   public Box(double size, String material){
        this(size, size, size, material);
   }
    public Box(Box other){
        this(other.width, other.height, other.depth, other.material);

    }
    public double getVolume(){
        return width*height*depth;
    }
    public double getSurfaceArea(){
        return (2*(width*height+width*depth+depth*height));
    }
    public void printBox(){
        System.out.println("Матеріал: " + material);
        System.out.println("Ширина: " + width);
        System.out.println("Висота: " + height);
        System.out.println("Глибина: " + depth);
        System.out.println("Об'єм: " + getVolume());
        System.out.println("Площа поверхні: " + getSurfaceArea());
    }

}
