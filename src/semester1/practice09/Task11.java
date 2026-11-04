package semester1.practice09;

public class Task11 {
    public static void run(){
        Battery battery = new Battery(5000, 100);
        Display display = new Display(6.8, 80);
        SmartDevice device = new SmartDevice(battery, display);
        System.out.println(device);
        device.watchVideo(50);
        System.out.println("Після перегляду: ");
        System.out.println(device);
    }
}
class Battery{
    private int capacityMah;
    private int chargePercent;
    Battery(int capacityMah, int chargePercent){
        this.capacityMah=capacityMah;
        if (chargePercent>=0&&chargePercent<=100){
            this.chargePercent=chargePercent;
        }else {
            this.chargePercent=67;
        }
    }
    public int drain(int percent){
        if (percent < 0) return chargePercent;
        chargePercent -= percent;
        if (chargePercent < 0) {
            chargePercent = 0;
        }
        return chargePercent;
    }
    public int charge(int percent){
        if (percent < 0) return chargePercent;
        chargePercent += percent;
        if (chargePercent > 100) {
            chargePercent = 100;
        }
        return chargePercent;
    }
    public int getChargePercent() {
        return chargePercent;
    }
} class Display{
    private double diagonalInches;
    private int brightnessPercent;
    Display(double diagonalInches, int brightnessPercent){
        this.diagonalInches=diagonalInches;
        if (brightnessPercent>=10&&brightnessPercent<=100){
            this.brightnessPercent=brightnessPercent;
        }else {
            this.brightnessPercent=10;
        }
    }
    public int getBrightnessPercent() {
        return brightnessPercent;
    }
    @Override
    public String toString() {
        return "Діагональ: " + diagonalInches + " дюймів" +
                "\nЯскравість: " + brightnessPercent + "%";
    }
}
class SmartDevice {
    private final Battery battery;
    private final Display display;
    SmartDevice(Battery battery, Display display) {
        this.battery = battery;
        this.display = display;
    }
    public void watchVideo(int minutes) {
        int percent = display.getBrightnessPercent() > 70 ? 2 : 1;
        int drain = (minutes / 10) * percent;
        battery.drain(drain);
        if (battery.getChargePercent() == 0) {
            System.out.println("Пристрій вимкнувся");
        }
    }
    @Override
    public String toString() {
        return "Заряд батареї: " + battery.getChargePercent() + "%" +
                "\n" + display;
    }
}