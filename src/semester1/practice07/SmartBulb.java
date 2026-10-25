package semester1.practice07;

public class SmartBulb {
    private int brightness;
    private int colorTemp;
    private boolean isOn;
   public SmartBulb(int brightness, int colorTemp, boolean isOn){
       this.brightness=brightness; this.colorTemp=colorTemp; this.isOn=true;
       if (brightness<0||brightness>100){
           this.brightness=0;
       }
       if (colorTemp<2700||colorTemp>6500){
           this.colorTemp=2700;
       }
   }
   public SmartBulb(int brightness){
       this(100, 4000, true );
   }
   public SmartBulb(){
       this(50);
    }
    public void printStatus(){
        System.out.println("Яскравість лампи: "+brightness+"%");
        System.out.println("Температура: "+colorTemp+"К");
        System.out.println("Ввімкнена?: "+isOn+" |");
        System.out.println();
    }
}
