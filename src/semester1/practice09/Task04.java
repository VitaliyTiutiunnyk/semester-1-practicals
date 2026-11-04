package semester1.practice09;

public class Task04 {
    public static void run(){
        ClosedInterval interval=new ClosedInterval(-5, 17);
        System.out.println();
        System.out.println(interval);
        interval.resize(15, 13);
        System.out.println();
        System.out.println("Після зміни:");
        System.out.println(interval);

    }
}
class ClosedInterval {
    private double start;
    private double end;

    ClosedInterval(double start, double end) {
        if (start <= end) {
            this.start = start;
            this.end = end;
        } else {
            this.start = end;
            this.end = start;
        }

    }

    public void resize(double newStart, double newEnd) {
        if (newStart > newEnd) {
            double temp = newStart;
            newStart = newEnd;
            newEnd = temp;
        }

        this.start = newStart;
        this.end = newEnd;
    }
    public double getLength(){
        return end-start;
    }
    public double getMidpoint(){
      return   (start+end)/2;
    }
    public boolean overlaps(ClosedInterval other){
        return !(end < other.start) && !(start > other.end);
    }

    @Override
    public String toString() {
        return "Відрізок: "+"[ "+start+"; "+end+" ]"+" (центр: "+getMidpoint()+", "
                +"довжина: "+getLength()+")";

    }
}