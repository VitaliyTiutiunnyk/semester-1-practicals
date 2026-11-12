package semester1.practice10;

public class Task06 {
    public static void run(){
        DifferentiableFunction[] functions = {
                new QuadraticParabola(),
                new NaturalLogFunction(),
                new ExponentialGrowth()
        };
        double x = 2.0;
        for (DifferentiableFunction function : functions) {
            System.out.println("Функція: " + function.getClass().getSimpleName());
            System.out.println("Значення: " + function.f(x));
            System.out.println("Похідна: " + function.derivativeAt(x));
            System.out.println("----------------------");
        }
    }
}
abstract class DifferentiableFunction{
    public abstract double f(double x);
    public double derivativeAt(double x) {
        double h = Math.pow(10, -5);

        return (f(x + h) - f(x - h)) / (2 * h);
    }
}
class QuadraticParabola extends  DifferentiableFunction{
    @Override
    public double f(double x) {
        return x * x;
    }
}
class NaturalLogFunction extends DifferentiableFunction {
    @Override
    public double f(double x) {
        return Math.log(x);
    }
}
class ExponentialGrowth extends DifferentiableFunction {
    @Override
    public double f(double x) {
        return Math.exp(x);
    }
}
