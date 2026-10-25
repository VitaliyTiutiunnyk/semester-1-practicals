package semester1.practice07;

public class CarWithEngine {
    String brand;
    String model;
    Engine engine;
    public CarWithEngine(String brand, String model, Engine engine){
        this.brand=brand; this.model=model; this.engine=engine;
    }
    public void startCar(){
        this.engine.start();
        System.out.println(brand+" готовий до руху!");
    }
    public void turnOff(){
        this.engine.stop();
        System.out.println(brand+" не заведена!");
    }
    public void printSpecs(){
        System.out.println("Бренд: "+brand);
        System.out.println("Модель: "+model);
        System.out.println("Потужність двигуна: "+engine.horsePower+" к.c.");
        System.out.println("Двигун працює: " + engine.isRunning());
    }


}
