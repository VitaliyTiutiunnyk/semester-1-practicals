package semester1.practice06;

public class DiscountCard {
    private String ownerName;
    private double totalSpent;
    private int discountPercent=1;
    public void addPurchase(double cost){
        totalSpent+=cost;
        if (totalSpent >= 10000){
            discountPercent=10;
        }
        else if (totalSpent >= 5000&&totalSpent<10000){
           discountPercent=5;
        }else {
            discountPercent=1;
        }
    }
    public void printCardInfo(){
        System.out.println("Власник: "+ownerName);
        System.out.println("Cума покупок: "+totalSpent);
        System.out.println("Знижка: "+discountPercent+"%");

    }
    public void setOwnerName(String ownerName){
        this.ownerName=ownerName;
    }
}
