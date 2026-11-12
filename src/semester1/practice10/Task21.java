package semester1.practice10;

public class Task21 {
    public static void run(){
        AbstractVehicle[] vehicles = {
                new ElectricCityBus("2",80000, 20, 100),
                new DieselDumpTruck("228", 100000, 40),
                new CargoPassengerVan(35, 20, "23", 30000)
        };
        for (AbstractVehicle vehicle : vehicles) {
            System.out.println("\n=== Транспортний засіб ===");
            System.out.println("Номерний знак: " + vehicle.getPlateNumber());

            if (vehicle instanceof PassengerCarrier passenger) {
                System.out.println("Кількість пасажирських місць: " + passenger.getSeatCount());
            }

            if (vehicle instanceof CargoCarrier cargo) {
                System.out.println("Вантажопідйомність: " + cargo.getMaxPayloadTons() + " тонн");
            }

            if (vehicle instanceof ElectricPowered electric) {
                System.out.println("Ємність батареї: " + electric.getBatteryCapacityKwh() + " кВт·год");
            }

        }
    }
}
abstract class AbstractVehicle{
    private final String plateNumber;
    protected double mileageKm;
    AbstractVehicle(String plateNumber, double mileageKm){
        this.plateNumber=plateNumber;
        this.mileageKm=mileageKm;
    }
    public String getPlateNumber() {
        return plateNumber;
    }
}
interface CargoCarrier{
    double getMaxPayloadTons();
}
interface PassengerCarrier{
    int getSeatCount();
}
interface ElectricPowered{
    double getBatteryCapacityKwh();
}
class ElectricCityBus extends AbstractVehicle implements PassengerCarrier, ElectricPowered{
    private final int seats;
    private final double batteryCapacity;
    ElectricCityBus(String plateNumber, double mileageKm, int seats, double batteryCapacity ){
        super(plateNumber, mileageKm);
        if (seats>15&&seats<30){
            this.seats=seats;
        }else this.seats=19;
        if (batteryCapacity<=0){
            this.batteryCapacity=250;
        }else this.batteryCapacity=batteryCapacity;
    }

    @Override
    public int getSeatCount() {
        return seats;
    }

    @Override
    public double getBatteryCapacityKwh() {
        return batteryCapacity;
    }
}
class DieselDumpTruck extends AbstractVehicle implements CargoCarrier{
    private final int maxPayLoadTons;
    DieselDumpTruck(String plateNumber, double mileageKm, int maxPayLoadTons){
        super(plateNumber, mileageKm);
       if (maxPayLoadTons>0)this.maxPayLoadTons=maxPayLoadTons;
       else this.maxPayLoadTons=40;
    }

    @Override
    public double getMaxPayloadTons() {
        return  maxPayLoadTons;
    }
}
class CargoPassengerVan extends AbstractVehicle implements CargoCarrier, PassengerCarrier{
    private final double  maxPayLoadTons;
    private final int seats;
    CargoPassengerVan(double maxPayLoadTons, int seats, String plateNumber, double mileageKm ){
        super(plateNumber, mileageKm);
        this.maxPayLoadTons=maxPayLoadTons;
        this.seats=seats;
    }

    @Override
    public double getMaxPayloadTons() {
        return  maxPayLoadTons;
    }

    @Override
    public int getSeatCount() {
        return seats;
    }
}