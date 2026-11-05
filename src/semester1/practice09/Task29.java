package semester1.practice09;

public class Task29 {
    public static void run(){
        DomesticTransfer domestic = new DomesticTransfer("TX001", 500);
        CryptoTransfer crypto = new CryptoTransfer("TX002", 1000, 25);
        System.out.println(domestic);
        System.out.println(crypto);
    }
}
abstract class AbstractTransaction {
    private final String txId;
    protected final double amount;

    AbstractTransaction(String txId, double amount) {
        this.txId = txId;
        this.amount = amount;
    }

    public abstract double calculateCommission();

    public final double getTotalDebit() {
        return amount + calculateCommission();
    }

    @Override
    public String toString() {
        return "ID переказу: " + txId +
                ", сума: " + amount +
                ", комісія: " + calculateCommission() +
                ", загальне списання: " + getTotalDebit();
    }
}
class DomesticTransfer extends AbstractTransaction {
    DomesticTransfer(String txId, double amount) {
        super(txId, amount);
    }

    @Override
    public double calculateCommission() {
        double commission = amount * 0.005;

        if (commission < 5) {
            return 5;
        }
        return commission;
    }
}

class CryptoTransfer extends AbstractTransaction {
    private double networkGasFee;
    CryptoTransfer(String txId, double amount, double networkGasFee) {
        super(txId, amount);
        this.networkGasFee = networkGasFee;
    }
    @Override
    public double calculateCommission() {
        return networkGasFee;
    }
}
