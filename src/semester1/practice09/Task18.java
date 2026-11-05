package semester1.practice09;

public class Task18 {
    public static void run(){
        ShoppingOrder order=new ShoppingOrder(10);
        order.addItem("Кетчуп", 30, 1);
        order.addItem("Айран", 50, 3);
        order.addItem("Хліб", 30, 2);
        System.out.println(order);

    }
}
class OrderItem{
    private final String productName;
    private final double unitPrice;
    private int quantity;
    OrderItem(String productName, double unitPrice, int quantity){
        this.productName=productName;
        this.unitPrice=unitPrice;
        this.quantity=quantity;
    }
    public double getItemTotal(){
        return unitPrice*quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getProductName() {
        return productName;
    }
    public void increaseQuantity(int qty) {
        quantity += qty;
    }
}
class ShoppingOrder{
    private final OrderItem[] items;
    private int itemCount;
    ShoppingOrder(int capacity){
        if (capacity > 10) {
            capacity = 10;
        }
        if (capacity < 1) {
            capacity = 1;
        }
        items = new OrderItem[capacity];
    }
    public void addItem(String name, double price, int qty){
        for (int i=0; i<itemCount; i++){
            if (items[i].getProductName().equals(name)){
                items[i].increaseQuantity(qty);
                return;
            }
        }
        if (itemCount<items.length){
            items[itemCount]=new OrderItem(name, price, qty);
            itemCount++;
        }else {
            System.out.println("Замовлення заповнене!!");
        }
    }
    public double calculateGrandTotal(){
        double total=0;
        for (int i=0; i<itemCount; i++){
            total+=items[i].getItemTotal();
        }
        return total;
    }
    @Override
    public String toString() {
        String receipt = "========== ФІСКАЛЬНИЙ ЧЕК ==========\n";
        for (int i = 0; i < itemCount; i++) {
            receipt += items[i].getProductName() +
                    " | Кількість: " + items[i].getQuantity() +
                    " | Сума: " + items[i].getItemTotal() + " грн\n";
        }
        receipt += "-----------------------------------\n";
        receipt += "ЗАГАЛЬНА СУМА: " + calculateGrandTotal() + " грн\n";
        receipt += "===================================";
        return receipt;
    }
}

