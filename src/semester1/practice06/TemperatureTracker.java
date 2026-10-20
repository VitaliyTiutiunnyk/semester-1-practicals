package semester1.practice06;

public class TemperatureTracker {
    private double[] dailyTemps=new double[7];
    public void setTemps(double[] temps){
        for (int i=0;i< dailyTemps.length;i++){
            dailyTemps[i]=temps[i];
        }
    }
    public int countDaysAbove(double threshold){
        int count=0;
        for (int i=0;i<dailyTemps.length;i++)
        if (dailyTemps[i]>threshold){
            count++;
        }
        return count;
    }
    public void printWeeklyReport(){
        String[] days={
                "Понеділок", "Вівторок", "Середа",
                "Четвер", "П'ятниця", "Субота", "Неділя"
        };
        int warmestDay = 0;
        System.out.println("____ЗВІТ ЗА ТИЖДЕНЬ____");
        for (int i = 0; i < dailyTemps.length; i++) {
            System.out.println(days[i] + ": " + dailyTemps[i] + " °C");

            if (dailyTemps[i] > dailyTemps[warmestDay]) {
                warmestDay = i;
            }
        }
        System.out.println("Найтепліший день: " + days[warmestDay]);
        System.out.println("Температура: " + dailyTemps[warmestDay] + " °C");

    }

}
