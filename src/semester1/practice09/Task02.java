package semester1.practice09;

import java.util.Arrays;

public class Task02 {
    public static void run(){
        double[] externalSamples = {10.5, 20.5, 30.5};
        LabMeasurement measurement = new LabMeasurement("Експеримент №1", externalSamples);
        externalSamples[0] = 999;
        System.out.println("Після зміни зовнішнього масиву:");
        System.out.println(Arrays.toString(measurement.getSamples()));
        double[] copiedSamples = measurement.getSamples();
        copiedSamples[1] = 888;
        System.out.println("Після зміни масиву з геттера:");
        System.out.println(Arrays.toString(measurement.getSamples()));
    }

    }


class LabMeasurement {
    private final String experimentName;
    private final double[] samples;
    public LabMeasurement(String experimentName, double[] samples) {
        this.experimentName = experimentName;

        if (samples == null) {
            this.samples = new double[0];
        } else {
            this.samples = Arrays.copyOf(samples, samples.length);
        }
    }

    public double[] getSamples() {
        return Arrays.copyOf(samples, samples.length);
    }

}