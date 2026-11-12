package semester1.practice10;

public class Task03 {
    public static void run(){
        BinaryOperation[] operations = {
                new AddOp(),
                new MultiplyOp(),
                new HypotenuseOp()
        };
        for (BinaryOperation op : operations) {
            System.out.println(op.apply(3.0, 4.0));
        }

    }
}
class VectorMathOverload {
    public static double norm(double x) {
        return Math.abs(x);
    }

    public static double norm(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }

    public static double norm(double[] v) {
        double sum = 0;

        for (double value : v) {
            sum += value * value;
        }

        return Math.sqrt(sum);
    }
}
abstract class BinaryOperation {
    public abstract double apply(double a, double b);
}
class AddOp extends BinaryOperation {

    @Override
    public double apply(double a, double b) {
        return a + b;
    }
}
class MultiplyOp extends BinaryOperation {

    @Override
    public double apply(double a, double b) {
        return a * b;
    }
}
class HypotenuseOp extends BinaryOperation {

    @Override
    public double apply(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }
}
