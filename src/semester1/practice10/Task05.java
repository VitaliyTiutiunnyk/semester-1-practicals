package semester1.practice10;

public class Task05 {
    public static ShippingTariff findCheapestTariff(ShippingTariff[] tariffs,
                                                    double weightKg,
                                                    double distanceKm) {
        ShippingTariff cheapest = tariffs[0];
        for (ShippingTariff tar : tariffs) {
            if (tar.calculateCost(weightKg, distanceKm)
                    < cheapest.calculateCost(weightKg, distanceKm)) {
                cheapest = tar;
            }
        }
        return cheapest;
    }
    public static void run(){
        ShippingTariff[] tariffs ={
                new RoadTruckTariff(),
                new AirCargoTariff(),
                new RailFreightTariff()
        };
        ShippingTariff cheapest = findCheapestTariff(tariffs, 250, 600);
        System.out.println("Найвигідніший тариф: "
                + cheapest.getClass().getSimpleName());
        System.out.println("Вартість: "
                + cheapest.calculateCost(250, 600));
    }
}
abstract class ShippingTariff{
    public abstract double calculateCost(double weightKg, double distanceKm);
}
class RoadTruckTariff extends ShippingTariff{
    @Override
    public double calculateCost(double weightKg, double distanceKm) {
       return 15*distanceKm+2.5*weightKg;
    }
}
class AirCargoTariff extends ShippingTariff{
    @Override
    public double calculateCost(double weightKg, double distanceKm) {
        return 45*distanceKm+18*weightKg+500;
    }
}
class RailFreightTariff extends ShippingTariff{
    @Override
    public double calculateCost(double weightKg, double distanceKm) {
        return 1200+4*distanceKm+0.8*weightKg;
    }
}
