package semester1.practice07;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private String category;

    public Product(String name, double price, int quantity, String category) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        if (this.price < 0) {
            this.price = 0.0;
        }
        if (this.quantity < 0) {
            this.quantity = 0;
        }
    }

    public double getTotalValue() {
        return price * quantity;
    }

    public void applyDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            return;
        }
        price = price * (1 - percent / 100);
    }

    public void printProduct() {
        System.out.println("Товар: " + name + " | Категорія: " + category);
        System.out.println("Ціна: " + price + " грн | Кількість: " + quantity + " шт");
        System.out.println("Вартість партії: " + getTotalValue() + " грн");
    }
}
