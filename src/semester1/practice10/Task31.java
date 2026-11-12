package semester1.practice10;

public class Task31 {
    public static void run(){
        Matrix2x2[] matrices = {
                new RotationMatrix2x2(90),
                new SingularMatrix2x2(1, 2, 2, 4)
        };
        for (Matrix2x2 m : matrices) {
            System.out.println("\nВизначник: " + m.determinant());

            if (m instanceof InvertibleMatrix inv) {
                System.out.println("Обернена матриця:");
                inv.inverse().printMatrix();
            } else {
                System.out.println("Матриця не має оберненої.");
            }
            if (m instanceof OrthogonalMatrix orthogonal) {
                System.out.println("Ортогональна: "
                        + orthogonal.checkOrthogonality());
            }
        }
    }
}
class Matrix2x2 {
    protected final double a11;
    protected final double a12;
    protected final double a21;
    protected final double a22;
    Matrix2x2(double a11, double a12, double a21, double a22) {
        this.a11 = a11;
        this.a12 = a12;
        this.a21 = a21;
        this.a22 = a22;
    }
    public double determinant() {
        return a11 * a22 - a12 * a21;
    }
    public void printMatrix() {
        System.out.println(a11 + "  " + a12);
        System.out.println(a21 + "  " + a22);
    }
}
interface InvertibleMatrix {
    Matrix2x2 inverse();
}
interface OrthogonalMatrix {
    boolean checkOrthogonality();
}
class RotationMatrix2x2 extends Matrix2x2
        implements InvertibleMatrix, OrthogonalMatrix {
    RotationMatrix2x2(double angleDegrees) {
        super(
                Math.cos(Math.toRadians(angleDegrees)),
                -Math.sin(Math.toRadians(angleDegrees)),
                Math.sin(Math.toRadians(angleDegrees)),
                Math.cos(Math.toRadians(angleDegrees))
        );
    }
    @Override
    public Matrix2x2 inverse() {
        return new Matrix2x2(a11, a21, a12, a22);
    }
    @Override
    public boolean checkOrthogonality() {
        double firstColumn = a11 * a11 + a21 * a21;
        double secondColumn = a12 * a12 + a22 * a22;
        double dotProduct = a11 * a12 + a21 * a22;

        return Math.abs(firstColumn - 1) < 0.000001
                && Math.abs(secondColumn - 1) < 0.000001
                && Math.abs(dotProduct) < 0.000001;
    }
}
class SingularMatrix2x2 extends Matrix2x2 {
    SingularMatrix2x2(double a11, double a12, double a21, double a22) {
        super(a11, a12, a21, a22);
    }
}
