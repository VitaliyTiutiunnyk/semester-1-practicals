package semester1.practice06;

public class Lamp {
    boolean isOn;
    public void turnOn(){
        isOn = true;
    }
    public void turnOff(){
        isOn = false;

    }
    public void toggle(){
        if (isOn==true){
            isOn=false;
        }
        else {
           isOn=true;
        }
    }
    public void status(){
        if (isOn){
            System.out.println("Лампа світить");
        }
        else {
            System.out.println("Лампа ввимкнена");

        }

    }
}
