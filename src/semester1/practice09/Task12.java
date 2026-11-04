package semester1.practice09;

public class Task12 {
    public static void run(){
        Point2D start = new Point2D(0, 0);
        Point2D end = new Point2D(4, 6);
        LineSegment segment = new LineSegment(start, end);
        System.out.println(segment);
    }
}
class LineSegment {
    private final Point2D start;
    private final Point2D end;

    LineSegment(Point2D start, Point2D end) {
        this.start = new Point2D(start.getX(), start.getY());
        this.end = new Point2D(end.getX(), end.getY());
    }

    public double getLength() {
        return start.distanceTo(end);
    }

    public Point2D getMidpoint() {
        return new Point2D(
                (start.getX() + end.getX()) / 2,
                (start.getY() + end.getY()) / 2
        );
    }

    @Override
    public String toString() {
        return "Початок: " + start +
                "\nКінець: " + end +
                "\nДовжина: " + getLength() +
                "\nСередина: " + getMidpoint();
    }
}