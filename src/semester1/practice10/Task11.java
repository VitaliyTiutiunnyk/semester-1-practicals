package semester1.practice10;

public class Task11 {
    public static void testFlight(Flyable f) {
        f.takeOff();
        System.out.println("Максимальна висота: " + f.getMaxAltitude());
    }

    public static void testDiving(Swimmable s) {
        s.dive(20);
        System.out.println("Максимальна глибина: " + s.getMaxDepth());
    }

    public static void logPosition(GpsTrackable g) {
        System.out.println("Координати: " + g.getCoordinates());
    }
    public static void run(){
        AmphibiousRescueDrone drone = new AmphibiousRescueDrone();
        testFlight(drone);
        testDiving(drone);
        logPosition(drone);
    }
}
interface Flyable{
    void takeOff();
    double getMaxAltitude();
}
interface Swimmable{
    void dive(double depthMeters);
    double getMaxDepth();
}
interface GpsTrackable{
    String getCoordinates();
}
class AmphibiousRescueDrone implements Flyable, Swimmable, GpsTrackable{
    @Override
    public void takeOff() {
        System.out.println("Дрон злітає!");
    }

    @Override
    public double getMaxAltitude() {
        return 500;
    }

    @Override
    public void dive(double depthMeters) {
        System.out.println("Дрон занурився на " + depthMeters + " метрів");
    }

    @Override
    public double getMaxDepth() {
        return 50;
    }

    @Override
    public String getCoordinates() {
        return "50.4501, 30.5234";
    }

}

