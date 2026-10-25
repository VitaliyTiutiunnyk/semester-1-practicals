
package semester1.practice07;

public class Car {
  private   String brand;
  private   String model;
  private   int year;
    double mileage;
  private   boolean engineStarted;
    public Car(String brand, String model, int year, double mileage){
        this.brand=brand; this.model=model; this.year=year; this.mileage=mileage; this.engineStarted=false;
    }
   public Car(String brand, String model, int year){
       this(brand, model, year, 0.0);

   }
   public Car(){
       this("Unknown", "Standard", 2024);

   }
    public void startEngine(){
        this.engineStarted=true;
    }
    public void stopEngine(){
        this.engineStarted=false;
    }
    public void drive(double distance){
        if (engineStarted){
            mileage+=distance;
        }else {
            System.out.println("Спершу заведіть двигун!");
        }
    }
    public double getMileage(){
        return mileage;
    }
}
