package semester1.practice07;

public class ClientAccount {
  private String iban;
  private String owner;
  private double balance;
    public ClientAccount(String iban, String owner, double balance) {
        this.iban = iban;
        this.owner = owner;
        this.balance = balance;
    }
    public boolean transferTo(ClientAccount recipient, double amount){
        if (recipient == null||recipient == this){
            return false;
        }
        if (amount < 0 || this.balance < amount){
            return false;

        }
        this.balance -= amount;
        recipient.balance += amount;
        return true;
    }
    public void printAccount() {
        System.out.println("Власник: " + owner);
        System.out.println("IBAN: " + iban);
        System.out.println("Баланс: " + balance + " грн");
    }
    public double getBalance() {
        return balance;
    }

}
