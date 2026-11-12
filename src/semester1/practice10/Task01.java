package semester1.practice10;

public class Task01 {
    public static void run(){
        PaymentInstrument[] instruments = {
                new BankCardInstrument("Віталій"),
                new CryptoTokenInstrument("Віталій"),
                new IbanDirectInstrument("Віталій")
        };
        double amount = 10000;
        for (PaymentInstrument instrument : instruments){
            System.out.println("Комісія: " + instrument.calculateFee(amount));
            System.out.println("Сума списання: " +instrument.processPayment(amount));
        }
    }
}
abstract class PaymentInstrument {
    private final String payerName;

    PaymentInstrument(String payerName) {
        this.payerName = payerName;
    }
    public abstract double calculateFee(double amount);

    public double processPayment(double amount){
        return amount + calculateFee(amount);
    }
}
class BankCardInstrument extends PaymentInstrument{
    BankCardInstrument(String payerName){
        super(payerName);
    }

    @Override
    public double calculateFee(double amount) {
        return amount*0.015+5;
    }
}
class CryptoTokenInstrument extends PaymentInstrument{
   private final double gasFeeUah = 30.0;
    CryptoTokenInstrument(String payerName){
        super(payerName);
    }

    @Override
    public double calculateFee(double amount) {
       return gasFeeUah;
    }
}
class IbanDirectInstrument extends PaymentInstrument{
    IbanDirectInstrument(String payerName){
        super(payerName);
    }

    @Override
    public double calculateFee(double amount) {
        if (amount<=50000){
            return 0;
        }else return amount*0.005;
    }
}