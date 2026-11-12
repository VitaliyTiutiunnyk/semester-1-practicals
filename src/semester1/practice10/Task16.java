package semester1.practice10;

public class Task16 {
    public static void run(){
        DataExportable[] data = {
                new WeatherObservation("Конотоп", 3, 40),
                new StudentGradeRecord("Віталій", 11, 60)
        };
        System.out.println("TO JSON: ");
        for (DataExportable dataExportable : data){
            System.out.println(dataExportable.toJson());
        }
        System.out.println("\nTO CSV ROW: ");
        for (DataExportable dataExportable : data){
            System.out.println(dataExportable.toCsvRow());
        }
    }
}
interface DataExportable{String toJson(); String toCsvRow();}
class StudentGradeRecord implements DataExportable{
   private String name; private int group; private double gpa;
   StudentGradeRecord(String name, int group, double gpa){
       this.name=name; this.group=group; this.gpa=gpa;
   }
    @Override
    public String toJson() {
        return "{\"name\":\"" + name + "\", \"group\":" + group
                + ", \"gpa\":" + gpa + "}";
    }

    @Override
    public String toCsvRow() {
        return name + "," + group + "," + gpa;
    }
}
class WeatherObservation implements DataExportable {
    private String city;
    private double tempC;
    private int humidity;
    WeatherObservation(String city, double tempC, int humidity) {
        this.city = city;
        this.tempC = tempC;
        this.humidity = humidity;
    }
    @Override
    public String toJson() {
        return "{\"city\":\"" + city + "\", \"tempC\":" + tempC
                + ", \"humidity\":" + humidity + "}";
    }
    @Override
    public String toCsvRow() {
        return city + "," + tempC + "," + humidity;
    }
}
