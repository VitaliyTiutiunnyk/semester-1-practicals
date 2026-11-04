package semester1.practice09;

import java.util.Objects;

public class Task03 {
    public static void run() {
        CryptoVault vault = new CryptoVault(
                "BTC-12345",
                "java",
                2.5,
                true
        );

        System.out.println("Початковий стан:");
        System.out.println(vault);
        System.out.println("\nРозблокування:");
        System.out.println(vault.unlock("java"));

        System.out.println("\nПереказ BTC:");
        System.out.println(vault.sendBtc(1.0, "BTC-67890"));

        System.out.println("\nСтан після переказу:");
        System.out.println(vault);

        vault.lock();

        System.out.println("\nПісля блокування:");
        System.out.println(vault);
    }

    }

class CryptoVault{
    private final String walletAddress;
    private String secretRecoveryPhrase;
    private double btcBalance;
    private boolean locked;
    CryptoVault(String walletAddress, String secretRecoveryPhrase, double btcBalance,
               boolean locked){
        this.walletAddress=walletAddress;
        this.secretRecoveryPhrase = secretRecoveryPhrase;
        this.btcBalance=btcBalance;
        this.locked=locked;
    }
    public boolean unlock(String phrase){
        if (secretRecoveryPhrase.equals(phrase)){
             locked=false;
             return true;
        }else {
             locked=true;
             return false;
        }
    }
    public void lock(){
        locked=true;
    }
    public boolean sendBtc(double amount, String destination){
        if (!locked && amount > 0 && btcBalance >= amount){
            btcBalance-=amount;
            return true;

        }else {
            return false;
        }
    }
    @Override
    public String toString() {
        return "Адрес гаманця: " + walletAddress +
                "\nСтатус блокування: " + (locked ? "Заблокований" : "Розблокований") +
                "\nБаланс BTC: " + btcBalance;
    }
}
