package semester1.practice09;

public class Task26 {
    public static void run(){
        SolarPowerPlant plant=new SolarPowerPlant("Undefined", 100, 0.5 );
        WindPowerPlant plant1=new WindPowerPlant("Unknow",100, 15 );
        System.out.println(plant);
        System.out.println(plant1);

    }
}
abstract class AbstractPowerPlant{
    private final String stationName;
    protected double baseCapacityMw;
    AbstractPowerPlant(String stationName, double baseCapacityMw){
        this.stationName=stationName;
        this.baseCapacityMw=baseCapacityMw;
    }
    public abstract double generateMegawatts();
    public double calculateDailyProfit(double tariffPerMwh) {
        return generateMegawatts()*24*tariffPerMwh;
    }
    @Override
    public String toString() {
        return "Назва станції: " + stationName +
                ", базова потужність: " + baseCapacityMw +
                ", фактична потужність: " + generateMegawatts() + " МВт";
    }
}
class SolarPowerPlant extends AbstractPowerPlant{
    private double sunIntensityFactor;
    SolarPowerPlant(String stationName, double baseCapacityMw, double sunIntensityFactor){
        super(stationName, baseCapacityMw);
        if (sunIntensityFactor>=0.0 && sunIntensityFactor<=1.0){
            this.sunIntensityFactor=sunIntensityFactor;
        }else this.sunIntensityFactor=1.0;
    }
    @Override
    public double generateMegawatts() {
        return baseCapacityMw * sunIntensityFactor;
    }
}
class WindPowerPlant extends AbstractPowerPlant{
 private double windSpeedMs;
    WindPowerPlant(String stationName, double baseCapacityMw, double windSpeedMs){
        super(stationName, baseCapacityMw);
        this.windSpeedMs=windSpeedMs;
    }
    @Override
    public double generateMegawatts(){
        if (windSpeedMs<3 || windSpeedMs>25){
            return 0;
        }
        return baseCapacityMw*windSpeedMs/25;
    }
}