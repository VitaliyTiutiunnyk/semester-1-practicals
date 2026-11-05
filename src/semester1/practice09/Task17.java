package semester1.practice09;

public class Task17 {
    public static void run(){
        Polyline line = new Polyline(5);

        line.addVertex(0, 0);
        line.addVertex(3, 0);
        line.addVertex(3, 4);

        System.out.println("Довжина ламаної: " + line.getTotalLength());
        System.out.println("Замкнений периметр: " + line.getClosedPerimeter());
    }

    }
class Polyline{
    private final Point2D[] vertices;
    private int count;
    Polyline(int capacity) {
        vertices = new Point2D[capacity];
        count = 0;
    }
    public void addVertex(double x, double y){
        if (count < vertices.length) {
            vertices[count] = new Point2D(x, y);
            count++;
        }

    }
    public double getTotalLength(){
        double total=0;
        for (int i=0;i<count-1;i++){
            total += vertices[i].distanceTo(vertices[i + 1]);

        }
        return total;
    }
    public double getClosedPerimeter(){
        if (count < 2) {
            return 0;
        }
        double total = getTotalLength();
        total += vertices[count - 1].distanceTo(vertices[0]);
        return total;
    }
}