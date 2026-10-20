package semester1.practice06;

public class TrafficLight {
    String currentColor;
    public void changeColor(String newColor){
        currentColor=newColor;
    }
    public void showSignal(){
        if (currentColor.equals("Червоний")){
            System.out.println("Стій!");
        } else if (currentColor.equals("Жовтий")) {
            System.out.println("Приготуйся!");

        }else if (currentColor.equals("Зелений")){
            System.out.println("Вперед!");
        }

    }
}
