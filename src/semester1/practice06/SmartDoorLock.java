package semester1.practice06;

public class SmartDoorLock {
    private int pinCode = 1234;
    private boolean isLocked = true;
    private int failedAttempts = 0;
    public void enterPin(int enteredPin){
        if (failedAttempts >= 3){
            System.out.println("СИСТЕМА ЗАБЛОКОВАНА! Викличте охорону.");
        }
        else if (enteredPin==pinCode){
            isLocked = false;
            failedAttempts=0;
            System.out.println("Замок відчинено!");

        }
        else {
            failedAttempts+=1;
            System.out.println("Неправильний пін!");
        }
        if (failedAttempts >= 3) {
            System.out.println("СИСТЕМА ЗАБЛОКОВАНА! Викличте охорону.");
        }
    }
}
