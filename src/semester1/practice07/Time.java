package semester1.practice07;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;
    public Time(int hours, int minutes, int seconds){
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;
        if (hours<0||hours>23){
            this.hours=0;
        }
        if (minutes<0||minutes>59){
            this.minutes=0;
        }
        if (seconds<0||seconds>59){
            this.seconds=0;
        }
    }
    public void tick(){
        seconds++;
        if (seconds == 60) { seconds = 0; minutes++; }
        if (minutes == 60) { minutes = 0; hours++; }
        if (hours == 24)   { hours = 0; }
    }
    public String toUniversalString(){
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);

    }
    public String toStandardString(){
        int hour12 = hours % 12;
        if (hour12 == 0) hour12 = 12;
        String period = hours < 12 ? "AM" : "PM";
        return String.format("%d:%02d:%02d %s", hour12, minutes, seconds, period);
    }


}
