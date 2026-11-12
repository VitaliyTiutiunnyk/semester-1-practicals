package semester1.practice10;

public class Task13 {
    public static void run(){
        EmergencyBeacon emergencyBeacon = new EmergencyBeacon();
        System.out.println(emergencyBeacon.emitAlert());

    }
}
interface AcousticSignal{
    default String emitAlert() { return "🔊 Звукова сирена 110 дБ"; }
}
interface  OpticalSignal{
    default String emitAlert() { return "🚨 Стробоскопічний маячок"; }
}
 class EmergencyBeacon implements AcousticSignal, OpticalSignal{
     @Override public String emitAlert(){
         return AcousticSignal.super.emitAlert()+"\n"+
         OpticalSignal.super.emitAlert();
     }


 }