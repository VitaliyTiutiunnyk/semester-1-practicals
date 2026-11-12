package semester1.practice10;

public class Task08 {
    public static void run(){
        IndustrialAsset[] assets = {
                new LinearDepreciationAsset("Верстат", 100000, 10),
                new DecliningBalanceAsset("Компресор", 80000, 8),
                new LinearDepreciationAsset("Конвеєр", 60000, 12)
        };

        double totalValue = 0;

        for (IndustrialAsset asset : assets) {
            double value = asset.getBookValueAfterYears(3);

            System.out.println(asset.getClass().getSimpleName()
                    + ": " + value);

            totalValue += value;
        }

        System.out.println("Загальна залишкова вартість: " + totalValue);
    }
}
abstract class IndustrialAsset{
    private final String name;
    protected final double initialCost;
    protected final int usefulLifeYears;
    IndustrialAsset(String name, double initialCost, int usefulLifeYears){
        this.name=name;
        this.initialCost=initialCost;
        this.usefulLifeYears=usefulLifeYears;

    }
    public abstract double getBookValueAfterYears(int years);
}
class LinearDepreciationAsset extends IndustrialAsset{
    LinearDepreciationAsset(String name, double initialCost, int usefulLifeYears){
        super(name, initialCost, usefulLifeYears);
    }

    @Override
    public double getBookValueAfterYears(int years) {
        return initialCost*(1- (double) years /usefulLifeYears);
    }
}
class DecliningBalanceAsset extends IndustrialAsset{
    DecliningBalanceAsset(String name, double initialCost, int usefulLifeYears){
        super(name, initialCost, usefulLifeYears);
    }

    @Override
    public double getBookValueAfterYears(int years) {
        return initialCost*Math.pow(1 - 2.0 / usefulLifeYears, years );
    }
}
