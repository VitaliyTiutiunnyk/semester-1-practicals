package semester1.practice06;

public class Stopwatch {
    int seconds;
    public void tick(){
        seconds+=1;
    }
    public void addSeconds(int s){
        seconds+=s;


    }
    public void displayTime(){
        int minutes=seconds/60;
        int sec=seconds%60;
        System.out.printf("%02d:%02d%n", minutes, sec);
    }
}
