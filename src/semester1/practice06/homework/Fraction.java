package semester1.practice06.homework;

 class Fraction {private int numerator;
    private int denominator;
    public void setValues(int num, int den) {
        if (den == 0) {
            System.out.println("Помилка: знаменник не може дорівнювати 0!");
            numerator = num;
            denominator = 1;
            return;
        }
        if (den < 0) {
            numerator = -num;
            denominator = -den;
        } else {
            numerator = num;
            denominator = den;
        }
    }
    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
    public void simplify() {
        int divisor = gcd(numerator, denominator);
        if (divisor != 0) {
            numerator /= divisor;
            denominator /= divisor;
        }
    }
    public double toDecimal() {
        return (double) numerator / denominator;
    }
    public void add(int otherNum, int otherDen) {
        if (otherDen == 0) {
            System.out.println("Помилка: знаменник не може дорівнювати 0!");
            return;
        }
        numerator = numerator * otherDen + otherNum * denominator;
        denominator = denominator * otherDen;
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        simplify();
    }
    public void printFraction() {
        if (denominator == 1) {
            System.out.println(numerator);
        } else {
            System.out.println(numerator + "/" + denominator);
        }
    }
}
