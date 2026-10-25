package semester1.practice07;

public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;
   public BankAccount(String accountNumber, String ownerName, double initialBalance){
        this.accountNumber=accountNumber;
        this.balance=initialBalance;
        this.ownerName=ownerName;
        if(initialBalance < 0){
            this.balance=0;
        }

    }
    public void deposit(double amount){
        if (amount>0){
            this.balance+=amount;
        }
    }
    public boolean withdraw(double amount){
        if (amount>balance||amount<=0){
            return false;
        }else {
            this.balance-=amount;
            return true;
        }
    }
    public void printAccount(){
        System.out.println("Рахунок: " + accountNumber);
        System.out.println("Власник: " + ownerName);
        System.out.println("Баланс: " + balance + " грн");
    }
}
