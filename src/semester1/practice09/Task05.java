package semester1.practice09;

public class Task05 {
    public static void run(){
        RgbColor color=new RgbColor(10,11,12);
        System.out.println(color);

    }
}
class RgbColor{
    private final int red;
    private final int green;
    private final int blue;
    RgbColor(int red, int green, int blue){
        this.red = clamp(red);
        this.green = clamp(green);
        this.blue = clamp(blue);
    }
    private static int clamp(int val){
        return Math.clamp(val, 0, 255);
    }
    public String toHex(){
        return String.format("#%02X%02X%02X", red, green, blue);
    }
    public RgbColor invert(){
        return new RgbColor(
                255 - red,
                255 - green,
                255 - blue
        );
    }
    public RgbColor mixWith(RgbColor other){
       return new RgbColor(
               (red + other.red) / 2,
               (green + other.green) / 2,
               (blue + other.blue) / 2
       );

    }
    @Override
    public String toString() {
        return "Червоний: " + red +
                ", Зелений: " + green +
                ", Синій: " + blue +
                ", HEX: " + toHex();
    }
}
