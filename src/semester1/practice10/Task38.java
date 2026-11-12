package semester1.practice10;

public class Task38 {
    public static void run() {
        CubicFunction function = new CubicFunction();
        double integral = function.integrateTrapezoid(0, 3, 1000);
        double root = function.findRootBisection(2, 3, 0.000001);
        System.out.println("Інтеграл на [0; 3]: " + integral);
        System.out.println("Корінь рівняння: " + root);
        System.out.println("Перевірка f(x): " + function.evaluate(root));
    }
}
interface Integrable1D {
    double evaluate(double x);
    default double integrateTrapezoid(double a, double b, int n) {
        double h = (b - a) / n;

        double sum = (evaluate(a) + evaluate(b)) / 2;

        for (int i = 1; i < n; i++) {
            sum += evaluate(a + i * h);
        }
        return sum * h;
    }
}
interface RootFindable {
    double findRootBisection(double left, double right, double eps);
}
abstract class AbstractAnalyticFunction implements Integrable1D {
}
class CubicFunction extends AbstractAnalyticFunction implements RootFindable {
    @Override
    public double evaluate(double x) {
        return x * x * x - 2 * x - 5;
    }
    @Override
    public double findRootBisection(double left, double right, double eps) {
        while (right - left > eps) {
            double middle = (left + right) / 2;

            if (evaluate(left) * evaluate(middle) <= 0) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return (left + right) / 2;
    }
}
