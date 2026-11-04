package semester1.practice09;



public class Task06 {
    public static void run(){
        HighSecuritySafe safe=new HighSecuritySafe(228, 10000);
        safe.putCash(1231,122);
        System.out.println(safe);
        safe.takeCash(23121, 1500);
        System.out.println(safe);
        safe.takeCash(228,5000);
        System.out.println(safe);


    }
}
class HighSecuritySafe{
    private int pinCode;
    private double storedCash;
    private int failedAttempts;
    private boolean permanentlyBlocked;
    HighSecuritySafe(int pinCode, double storedCash){
        this.pinCode=pinCode;
        this.storedCash=storedCash;
        this.failedAttempts=0;
        this.permanentlyBlocked=false;
    }


    private boolean checkAccess(int enteredPin){
        if (permanentlyBlocked) return false;
        if (enteredPin!=pinCode){
            failedAttempts++;
            if (failedAttempts==3){
                permanentlyBlocked=true;

            }
            return false;
        }else {
            failedAttempts=0;
            return true;

        }
    }
  public boolean putCash(int pin, double amount){
        if (checkAccess(pin)&&amount>0){
            storedCash+=amount;
            return true;

        }
        return false;
  }
  public boolean takeCash(int pin, double amount){
        if (checkAccess(pin)&&amount>0&& storedCash >= amount){
            storedCash-=amount;
            return true;
        }
        return false;
  }
    @Override
    public String toString() {
        return "Баланс сейфа: " + storedCash +
                "\nНевдалі спроби: " + failedAttempts +
                "\nСтатус: " + (permanentlyBlocked ? "Заблокований" : "Активний");
    }

}