package semester1.practice10;

public class Task20 {
    public static void run(){
       Vec2D vector= new Vec2D(-1, 2);

        Rotation2DOperator rotation = new Rotation2DOperator(90);

        Vec2D rotated = rotation.transform(vector);
        System.out.println("Після повороту:");
        System.out.println("X: " + rotated.getX());
        System.out.println("Y: " + rotated.getY());

        Vec2D restored = rotation.inverseTransform(rotated);
        System.out.println("\nПісля зворотного повороту:");
        System.out.println("X: " + restored.getX());
        System.out.println("Y: " + restored.getY());

        ProjectionXOperator projection = new ProjectionXOperator();
        Vec2D projected = projection.transform(vector);

        System.out.println("\nПроєкція на вісь X:");
        System.out.println("X: " + projected.getX());
        System.out.println("Y: " + projected.getY());
    }
    }

class  Vec2D{
    private final double x;
    private final double y;
    Vec2D(double x, double y){
        this.x=x;
        this.y=y;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
abstract class AbstractVectorOperator{
    private final String name;
    AbstractVectorOperator(String name){
        this.name=name;
    }
    public abstract Vec2D transform(Vec2D v);
}
interface InvertibleOperator{
    Vec2D inverseTransform(Vec2D v);
}
class Rotation2DOperator extends AbstractVectorOperator implements InvertibleOperator {
    private final double angle;

    Rotation2DOperator(double angle) {
        super("Поворот");
        this.angle = Math.toRadians(angle);
    }

    @Override
    public Vec2D transform(Vec2D v) {
        double x = v.getX() * Math.cos(angle) - v.getY() * Math.sin(angle);
        double y = v.getX() * Math.sin(angle) + v.getY() * Math.cos(angle);

        return new Vec2D(x, y);
    }

    @Override
    public Vec2D inverseTransform(Vec2D v) {
        double x = v.getX() * Math.cos(angle) + v.getY() * Math.sin(angle);
        double y = -v.getX() * Math.sin(angle) + v.getY() * Math.cos(angle);

        return new Vec2D(x, y);
    }
}
class ProjectionXOperator extends AbstractVectorOperator {

    ProjectionXOperator() {
        super("Проєкція на вісь X");
    }

    @Override
    public Vec2D transform(Vec2D v) {
        return new Vec2D(v.getX(), 0);
    }
}