package semester1.practice10;

public class Task37 {
    public static void run() {
        PowerProducer[] stations = {
                new NuclearStation("NUC-01", 1000),
                new SolarFarmStation("SOL-01", 200),
                new HydroDamStation("HYD-01", 300)
        };
        double totalGeneration = 0;
        for (PowerProducer station : stations) {
            if (station instanceof WeatherDependent wd) {
                if (station instanceof SolarFarmStation) {
                    wd.updateWeatherCondition(0.7);
                } else if (station instanceof HydroDamStation) {
                    wd.updateWeatherCondition(0.9);
                }
            }
            if (station instanceof AbstractPowerStation powerStation) {
                double output = powerStation.getNetOutputMw();
                System.out.println("Станція: " + powerStation.getStationId());
                System.out.println("Генерація з урахуванням втрат: "
                        + output + " МВт");
                totalGeneration += output;
            }
            System.out.println();
        }
        System.out.println("Загальна генерація мережі: "
                + totalGeneration + " МВт");
    }
}
interface PowerProducer {
    double produceMw();
}
interface WeatherDependent {
    void updateWeatherCondition(double factor);
}
abstract class AbstractPowerStation implements PowerProducer {
    private final String stationId;
    AbstractPowerStation(String stationId) {
        this.stationId = stationId;
    }

    public String getStationId() {
        return stationId;
    }

    public final double getNetOutputMw() {
        return produceMw() * 0.95;
    }
}
class NuclearStation extends AbstractPowerStation {
    private final double power;
    NuclearStation(String stationId, double power) {
        super(stationId);
        this.power = power;
    }
    @Override
    public double produceMw() {
        return power;
    }
}
class SolarFarmStation extends AbstractPowerStation implements WeatherDependent {
    private final double maxPower;
    private double weatherFactor = 1.0;
    SolarFarmStation(String stationId, double maxPower) {
        super(stationId);
        this.maxPower = maxPower;
    }
    @Override
    public void updateWeatherCondition(double factor) {
        weatherFactor = factor;
    }
    @Override
    public double produceMw() {
        return maxPower * weatherFactor;
    }
}
class HydroDamStation extends AbstractPowerStation implements WeatherDependent {
    private final double maxPower;
    private double weatherFactor = 1.0;
    HydroDamStation(String stationId, double maxPower) {
        super(stationId);
        this.maxPower = maxPower;
    }
    @Override
    public void updateWeatherCondition(double factor) {
        weatherFactor = factor;
    }
    @Override
    public double produceMw() {
        return maxPower * weatherFactor;
    }
}