package semester1.practice10;

public class Task14 {
    public static void run(){
        EscrowSmartContract contract = new EscrowSmartContract();
        System.out.println(contract.verifySignature("SECRET123"));
        System.out.println(contract.getAuditTrail());
        System.out.println(contract.executeContract(150));
    }
}
interface Authenticatable{
  boolean verifySignature(String key);
}
interface Auditable{
    String getAuditTrail();
}
interface BlockchainSmartContract extends Authenticatable, Auditable{
    boolean executeContract(double gasLimit);
}
class EscrowSmartContract implements BlockchainSmartContract{
    @Override
    public boolean verifySignature(String key) {
        return key.equals("SECRET123");
    }

    @Override
    public String getAuditTrail() {
        return "Контракт створено, перевірено та виконано";
    }

    @Override
    public boolean executeContract(double gasLimit) {
        return gasLimit >= 100;
    }
}

