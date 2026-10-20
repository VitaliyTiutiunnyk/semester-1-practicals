package semester1.practice06;

public class BankAccount {
    private String accountNumber;
    private double balance;
    public void deposit(double amount){
        if (amount>0){
            balance+=amount;
        }

    }
    public boolean withdraw(double amount){
        if (amount>balance){
            return false;

        }
        balance-=amount;
        return true;
    }
    public double getBalance(){
        return balance;
    }
}
