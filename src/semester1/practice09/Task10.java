package semester1.practice09;

public class Task10 {
    public static void run(){
        Engine engine = new Engine("Бензин", 2000, 0);
        Automobile car = new Automobile("BMW M5", 0, engine);
        engine.start();
        car.accelerate(20);
        car.accelerate(30);
        System.out.println(car);
        engine.stop();
        System.out.println(car);

    }
}
class Engine{
    private final String fuelType;
    private final int volumeCc;private int rpm;
    private boolean started;
    Engine(String fuelType, int volumeCc, int rpm){
        this.fuelType=fuelType;
        this.volumeCc=volumeCc;
        this.rpm=rpm;
        this.started=false;
    }
    public void start(){
        started=true;
    }
    public void stop(){
        started=false;
        rpm = 0;
    }
    public void setRpm(int rpm){
        if (started && rpm >= 0) {
            this.rpm = rpm;
        }
    }
    public boolean isStarted() {
        return started;
    }
    @Override
    public String toString() {
        return "Тип палива: " + fuelType +
                "\nОб'єм: " + volumeCc + " см³" +
                "\nОбертів: " + rpm +
                "\nСтан: " + (started ? "Працює" : "Вимкнений");
    }
}
class Automobile{
    private final String model;
    private double speed;
    private final Engine engine;
    Automobile(String model, double speed, Engine engine){
        this.model=model;
        this.speed=speed;
        this.engine=engine;
    }
    public void accelerate(double deltaSpeed){
        if (deltaSpeed > 0&& engine.isStarted()) {
            speed += deltaSpeed;
            engine.setRpm((int) (speed * 50));
        }

    }
    @Override
    public String toString() {
        return "Модель: " + model +
                "\nШвидкість: " + speed +
                "\nДвигун:\n" + engine;
    }
}