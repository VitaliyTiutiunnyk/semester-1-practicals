package semester1.practice07;

public class FleetCar {
    String vinCode;
    double currentMileage;
    private static int totalCars = 0;
    private static double totalCompanyMileage = 0.0;
   public FleetCar(String vinCode, double initialMileage){
       this.vinCode=vinCode;
       this.currentMileage=initialMileage;
       totalCars++;
       totalCompanyMileage+=initialMileage;
   }
   public void addTrip(double km){
       this.currentMileage+=km;
       totalCompanyMileage+=km;
   }
    public static void printFleetSummary(){
        System.out.println("Кількість автомобілів: " + totalCars);
        System.out.println("Загальний пробіг парку: " + totalCompanyMileage + " км");

    }
}
