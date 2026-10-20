package semester1.practice06;

public class CarSpeedometer {
    private int speed = 0;
    public void accelerate(int delta){
        speed+=delta;
        if (speed>240){
            speed=240;
        }

    }
    public void brake(int delta){
        speed-=delta;
        if (speed<0){
            speed=0;
        }
    }
    public int getSpeed(){
        return speed;
    }
}
