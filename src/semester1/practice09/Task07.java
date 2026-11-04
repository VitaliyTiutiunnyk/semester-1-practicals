package semester1.practice09;
import java.util.Arrays;


public class Task07 {
    public static void run(){
        double[] coeffs = {5, 4, 3, 2};
        EncapsulatedPolynomial polynomial = new EncapsulatedPolynomial(coeffs);
        System.out.println("Многочлен: " + polynomial);
        System.out.println("Степінь: " + polynomial.getDegree());
        System.out.println("Коефіцієнт x²: " + polynomial.getCoefficient(2));
        System.out.println("Значення при x = 2: " + polynomial.evaluate(2));
    }

}
class EncapsulatedPolynomial {
    private final double[] coeffs;

    EncapsulatedPolynomial(double[] coeffs) {
        this.coeffs = Arrays.copyOf(coeffs, coeffs.length);
    }

    public int getDegree() {
        for (int i = coeffs.length - 1; i >= 0; i--) {
            if (coeffs[i] != 0) {
                return i;
            }
        }
        return 0;
    }

    public double getCoefficient(int power) {
        if (power < 0 || power >= coeffs.length) {
            return 0;
        }
        return coeffs[power];
    }

    public double evaluate(double x) {
        double result = 0;

        for (int i = 0; i < coeffs.length; i++) {
            result += coeffs[i] * Math.pow(x, i);
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = coeffs.length - 1; i >= 0; i--) {
            if (coeffs[i] != 0) {
                result.append(coeffs[i])
                        .append(i == 0 ? "" : i == 1 ? "x" : "x^" + i)
                        .append(" + ");
            }
        }
        return result.isEmpty() ? "0" : result.substring(0, result.length() - 3);
    }
}
