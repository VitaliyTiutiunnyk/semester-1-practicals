package semester1.practice07;

public class Fraction {
    private int numerator;
    private int denominator;
 public    Fraction(int numerator, int denominator){
        this.denominator=denominator;
        this.numerator=numerator;
        if (this.denominator==0){
            this.denominator=1;
            System.out.println("Знаменник не повинен дорівнювати 0!!!");
        }
        if (this.denominator<=-1){
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;

        }
        int divisor = gcd(Math.abs(this.numerator), this.denominator);
        this.numerator = this.numerator / divisor;
        this.denominator = this.denominator / divisor;

        }
    private int gcd(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
 public    Fraction(int wholeNumber){
        this(wholeNumber, 1);
    }
 public    Fraction(){
        this(0,1);
    }
    public void print(){
        if (denominator == 1) {
            System.out.println("Дріб: " + numerator);
        } else {
            System.out.println("Дріб: " + numerator + "/" + denominator);
        }

    }
    public double toDouble(){
        return (double)numerator/denominator;
    }
    }

