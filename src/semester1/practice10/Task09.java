package semester1.practice10;

public class Task09 {
    public static double computeAverage(Measurable[] items) {
        double sum = 0;
        if (items.length == 0) {
            return 0;
        }
        for (Measurable item : items) {
            sum += item.getMeasure();
        }

        return sum / items.length;
    }
    public static void run(){
        Measurable[] items = {
                new BankVault(500),
                new HighwayRoute(250),
                new CpuCore(4.5)
        };
        System.out.println("Середнє значення: " + computeAverage(items));

    }
}
interface Measurable{
    double getMeasure();
}
class BankVault implements Measurable{
    private double goldKg;
    BankVault(double goldKg){
        this.goldKg=goldKg;
    }

    @Override
    public double getMeasure() {
        return goldKg;
    }
}
class HighwayRoute implements Measurable{
    private double lengthKm;
    HighwayRoute(double lengthKm){
        this.lengthKm=lengthKm;
    }

    @Override
    public double getMeasure() {
        return lengthKm;
    }
}
class CpuCore implements Measurable {
    private double frequencyGHz;

    CpuCore(double frequencyGHz) {
        this.frequencyGHz = frequencyGHz;
    }
    @Override
    public double getMeasure() {
        return frequencyGHz;
    }
}
