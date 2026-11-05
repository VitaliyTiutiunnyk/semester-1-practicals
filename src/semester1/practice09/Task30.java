package semester1.practice09;

public class Task30 {
    public static void run(){
        Sphere3D sphere = new Sphere3D("Сталь", 7850, 0.5);
        Cylinder3D cylinder = new Cylinder3D("Золото", 19300, 0.3, 1.0);
        System.out.println(sphere);
        System.out.println(cylinder);
    }
}
abstract class Solid3D {
    private final String materialName;
    private final double densityKgPerM3;

    Solid3D(String materialName, double densityKgPerM3) {
        this.materialName = materialName;
        this.densityKgPerM3 = densityKgPerM3;
    }

    public abstract double getVolume();

    public abstract double getSurfaceArea();

    public final double getMassKg() {
        return densityKgPerM3 * getVolume();
    }

    @Override
    public String toString() {
        return "Матеріал: " + materialName +
                ", об'єм: " + getVolume() + " м³" +
                ", площа поверхні: " + getSurfaceArea() + " м²" +
                ", маса: " + getMassKg() + " кг";
    }
}

class Sphere3D extends Solid3D {
    private double radius;

    Sphere3D(String materialName, double densityKgPerM3, double radius) {
        super(materialName, densityKgPerM3);
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public double getSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }
}

class Cylinder3D extends Solid3D {
    private double radius;
    private double height;

    Cylinder3D(String materialName, double densityKgPerM3, double radius, double height) {
        super(materialName, densityKgPerM3);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public double getSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }
}

