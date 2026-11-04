package semester1.practice09;

public class Task13 {
    public static void run(){
        BankAccount familyAccount = new BankAccount("UA123456789", 10000);
        PlasticCard card1 = new PlasticCard("1111", "12/28", familyAccount);
        PlasticCard card2 = new PlasticCard("2222", "10/29", familyAccount);
        System.out.println("Початковий баланс: " + familyAccount.getBalance());
        System.out.println("Оплата першою карткою: " + card1.payAtTerminal(2000));
        System.out.println("Оплата другою карткою: " + card2.payAtTerminal(3000));
        System.out.println("Залишок сімейного рахунку: " + familyAccount.getBalance());
    }
}
class BankAccount{
    private final String iban;
    private double balance;
    BankAccount(String iban, double balance){
        this.iban=iban;
        if (balance<0){
            this.balance=0;
        }else {
            this.balance=balance;
        }
    }
    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        balance += amount;
        return true;
    }
    public boolean withdraw(double amount) {
        if (amount <= 0 || balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }
    public double getBalance() {
        return balance;
    }

    }
    class PlasticCard {
        private final String cardNumber;
        private final String expiryDate;
        private boolean blocked;
        private final BankAccount linkedAccount;

        PlasticCard(String cardNumber, String expiryDate, BankAccount linkedAccount) {
            this.cardNumber = cardNumber;
            this.expiryDate = expiryDate;
            this.linkedAccount = linkedAccount;
            this.blocked = false;
        }
        public boolean payAtTerminal(double amount) {
            return !blocked && linkedAccount.withdraw(amount);
        }

        }

