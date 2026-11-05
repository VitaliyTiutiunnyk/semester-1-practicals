package semester1.practice09;

public class Task39 {
    public static void run(){
        SignalProcessor processor = new SignalProcessor(5);
        processor.addFilter(new AmplifierFilter("Підсилювач", 2));
        processor.addFilter(new ClippingFilter("Обмежувач", 10));
        double[] signal = {2, 5, -4, 8, -7};
        double[] result = processor.processSignal(signal);
        System.out.println("Початковий сигнал:");
        for (double value : signal) {
            System.out.print(value + " ");
        }
        System.out.println("\nОброблений сигнал:");
        for (double value : result) {
            System.out.print(value + " ");
        }

    }
}
abstract class AbstractFilter {
    private final String filterName;

    AbstractFilter(String filterName) {
        this.filterName = filterName;
    }

    public abstract double processSample(double x);

    @Override
    public String toString() {
        return "Фільтр: " + filterName;
    }
}

class AmplifierFilter extends AbstractFilter {
    private final double gain;

    AmplifierFilter(String filterName, double gain) {
        super(filterName);
        this.gain = gain;
    }

    @Override
    public double processSample(double x) {
        return x * gain;
    }
}

class ClippingFilter extends AbstractFilter {
    private final double threshold;

    ClippingFilter(String filterName, double threshold) {
        super(filterName);
        this.threshold = threshold;
    }

    @Override
    public double processSample(double x) {
        if (x > threshold) {
            return threshold;
        } else if (x < -threshold) {
            return -threshold;
        }

        return x;
    }
}

class SignalProcessor {
    private final AbstractFilter[] pipeline;
    private int count;

    SignalProcessor(int capacity) {
        pipeline = new AbstractFilter[capacity];
        count = 0;
    }

    public boolean addFilter(AbstractFilter filter) {
        if (filter == null || count >= pipeline.length) {
            return false;
        }

        pipeline[count] = filter;
        count++;
        return true;
    }

    public double[] processSignal(double[] signal) {
        double[] result = signal.clone();

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < count; j++) {
                result[i] = pipeline[j].processSample(result[i]);
            }
        }

        return result;
    }
}
