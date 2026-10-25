package semester1.practice07;

public class Order {
  private   Customer customer;
  private   Product1[] items;
    int itemCount;
   public Order(Customer customer, int maxItems){
       this.customer=customer; this.items=new Product1[maxItems]; this.itemCount=0;
   }
    public void addProduct(Product1 p){
        if (p == null) {
            System.out.println("Товар не може бути null!");
            return;
        }
        if (itemCount < items.length) {
            items[itemCount] = p;
            itemCount++;
            System.out.println("Товар додано до замовлення!");
        } else {
            System.out.println("Замовлення заповнене!");
        }
    }
     public double calculateTotal(){
       double sum=0;
       for (int i=0; i<itemCount; i++){
           sum+=items[i].getPrice();
       }
       return sum;
     }
    public boolean checkout() {
        double total = calculateTotal();
        if (customer.pay(total)) {
            System.out.println("=== ЧЕК ===");
            System.out.println("Кількість товарів: " + itemCount);
            System.out.println("Загальна сума: " + total + " грн");
            System.out.println("Оплата успішна!");
            return true;
        } else {
            System.out.println("Недостатньо коштів для оплати!");
            return false;
        }
    }
}
