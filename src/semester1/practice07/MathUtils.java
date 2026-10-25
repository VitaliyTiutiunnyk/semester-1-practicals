package semester1.practice07;

public class MathUtils {
    private MathUtils() {}
    public static final double PI = 3.1415926535;
    public static final double E = 2.7182818284;
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число не може бути від'ємним!");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;

    }
    public static double power(double base, int exp) {
            if (base == 0 && exp < 0) {
                throw new IllegalArgumentException("Неможливо ділити на нуль!");
            }
            double result = 1;
            for (int i = 0; i < Math.abs((long) exp); i++) {
                result *= base;
            }
            if (exp < 0) {
                result = 1 / result;
            }
            return result;
        }

        public static int gcd(int a, int b) {
            a = Math.abs(a);
            b = Math.abs(b);

            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }

            return a;
        }

        public static int clamp(int val, int min, int max) {
            if (min > max) {
                throw new IllegalArgumentException("min не може бути більшим за max!");
            }

            if (val < min) {
                return min;
            } else if (val > max) {
                return max;
            } else {
                return val;
            }
    }
}
