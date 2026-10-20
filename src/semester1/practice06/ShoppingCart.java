package semester1.practice06;

public class ShoppingCart {
    private double[] itemPrices=new double[10];
    private int count=0;
    public void addItem(double price){
        if (count< itemPrices.length){
            itemPrices[count]=price;
            count++;
        } else {
            System.out.println("Кошик заповнений!");
        }
    }
    public double getTotalCost(){
        double sum=0;
        for (int i=0;i<itemPrices.length;i++){
            sum+=itemPrices[i];
        }
        return sum;
    }
    public void applyDiscount(double percent){
        for (int i=0; i<itemPrices.length;i++){
            itemPrices[i]=itemPrices[i]*(1-percent/100);


        }
    }
}
