package semester1.practice09;

public class Task28 {
    public static void run(){
        HarmonicSequence harmonic = new HarmonicSequence();
        SquareNumbersSequence square = new SquareNumbersSequence();
        System.out.println(harmonic);
        System.out.println("Сума перших 5 членів: " + harmonic.sumFirstN(5));
        System.out.println(square);
        System.out.println("Сума перших 5 членів: " + square.sumFirstN(5));
    }
}
abstract class AbstractSequence {
    private final String title;

    AbstractSequence(String title) {
        this.title = title;
    }

    public abstract double getTerm(int index);

    public double sumFirstN(int n) {
        double sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += getTerm(i);
        }

        return sum;
    }

    @Override
    public String toString() {
        return "Послідовність: " + title;
    }
}

class HarmonicSequence extends AbstractSequence {
    HarmonicSequence() {
        super("Гармонічна");
    }

    @Override
    public double getTerm(int index) {
        return 1.0 / index;
    }
}

class SquareNumbersSequence extends AbstractSequence {
    SquareNumbersSequence() {
        super("Квадрати натуральних чисел");
    }

    @Override
    public double getTerm(int index) {
        return index * index;
    }
}

