package semester1.practice09;

public class Task01 {
    public static void run() {
        ImmutableGeoPoint point = new ImmutableGeoPoint(45, 120);
        System.out.println("Початкова точка:");
        System.out.println(point);
        ImmutableGeoPoint newPoint = point.shift(60, 100);
        System.out.println("Нова точка:");
        System.out.println(newPoint);
        System.out.println("Початкова точка після зміщення:");
        System.out.println(point);
    }
}
final class ImmutableGeoPoint{
    private final double latitude;
    private final double longitude;
    ImmutableGeoPoint(double latitude, double longitude) {
        this.latitude = Math.clamp(latitude, -90, 90);
        this.longitude = Math.clamp(longitude, -180, 180);

    }
    public ImmutableGeoPoint shift(double dLat, double dLon){
        return new ImmutableGeoPoint(latitude+dLat, longitude+dLon);

    }
    @Override public String toString(){
        return "Широта: " + latitude + ", Довгота: " + longitude;
    }

}

