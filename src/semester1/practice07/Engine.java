package semester1.practice07;

public class Engine {
    String serialNumber;
    int horsePower;
    boolean isRunning;
    public Engine(String serialNumber, int horsePower) {
        this.serialNumber = serialNumber;
        this.horsePower = horsePower;
        this.isRunning = false;
    }
    public void start(){
        isRunning=true;
    }
    public void stop(){
        isRunning=false;
    }
    public boolean isRunning(){
       return this.isRunning;
    }
}
