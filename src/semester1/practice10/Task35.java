package semester1.practice10;

public class Task35 {
    public static void run() {
        MetricSpaceElement[] vectors = {
                new ImmutableVector3D(3, 4, 0),
                new ImmutableVector3D(0, 0, 5),
                new ImmutableVector3D(1, 2, 2)
        };
        for (MetricSpaceElement vector : vectors) {
            System.out.println("Довжина вектора: " + vector.getNorm());
        }
        System.out.println("\nВідстань між векторами: "
                + vectors[0].distanceTo(vectors[1]));
    }
}

interface MetricSpaceElement {
    double distanceTo(MetricSpaceElement other);

    double getNorm();
}

final class ImmutableVector3D implements MetricSpaceElement {
    private final double x;
    private final double y;
    private final double z;

    ImmutableVector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double getNorm() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public double distanceTo(MetricSpaceElement other) {
        if (other instanceof ImmutableVector3D vector) {
            double dx = x - vector.x;
            double dy = y - vector.y;
            double dz = z - vector.z;

            return Math.sqrt(dx * dx + dy * dy + dz * dz);
        }

        throw new IllegalArgumentException("Несумісний тип елемента!");
    }
}