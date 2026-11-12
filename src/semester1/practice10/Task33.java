package semester1.practice10;

import java.util.Arrays;

public class Task33 {
    public static void run() {
        FinalCalibrationTable table = new FinalCalibrationTable(
                "SENSOR-001",
                new double[]{1.5, 2.5, 3.5}
        );

        System.out.println("Сила тяжіння: " + FinalCalibrationTable.GRAVITY_G);
        System.out.println("Серійний номер: " + table.getSensorSerial());
        double[] coefficients = table.getCoefficients();
        System.out.println("Коефіцієнти: " + Arrays.toString(coefficients));
        // Спроба змінити отриманий масив
        coefficients[0] = 999;

        System.out.println("Після зміни копії: "
                + Arrays.toString(coefficients));

        System.out.println("Оригінальні коефіцієнти: "
                + Arrays.toString(table.getCoefficients()));
    }
}

class FinalCalibrationTable {
    public static final double GRAVITY_G = 9.80665;

    private final String sensorSerial;
    private final double[] coefficients;

    FinalCalibrationTable(String sensorSerial, double[] coefficients) {
        this.sensorSerial = sensorSerial;
        this.coefficients = Arrays.copyOf(coefficients, coefficients.length);
    }

    public String getSensorSerial() {
        return sensorSerial;
    }

    public double[] getCoefficients() {
        return Arrays.copyOf(coefficients, coefficients.length);
    }
}
