package semester1.practice09;

public class Task15 {
    public static void run(){
        DeliveryAddress address1 = new DeliveryAddress(
                "Київ", "Хрещатик", 15);
        DeliveryAddress address2 = new DeliveryAddress(
                "Львів", "Шевченка", 20);
        ParcelOrder order = new ParcelOrder("ORD-001", 5.5, address1);
        System.out.println(order);
        System.out.println("\nЗміна адреси до відправки:");
        System.out.println(order.changeDestination(address2));
        order.markAsShipped();
        System.out.println("\nЗміна адреси після відправки:");
        System.out.println(order.changeDestination(address1));
        System.out.println("\nФінальний стан:");
        System.out.println(order);

    }
}
class DeliveryAddress{
    private String city;
    private String street;
    private int postOfficeNumber;
    DeliveryAddress(String  city, String street, int postOfficeNumber){
        this.city=city; this.street=street;
        this.postOfficeNumber=postOfficeNumber;
    }
    private void validate() {
        if (city == null || city.isBlank()) {
            city = "Не вказано";
        }
        if (street == null || street.isBlank()) {
            street = "Не вказано";
        }
        if (postOfficeNumber <= 0) {
            postOfficeNumber = 1;
        }
    }
    @Override
    public String toString() {
        return "Місто: " + city +
                "\nВулиця: " + street +
                "\nНомер відділення: " + postOfficeNumber;
    }
}
class ParcelOrder {
    private final String orderId;
    private double weightKg;
    private DeliveryAddress destination;
    private boolean shipped;

    ParcelOrder(String orderId, double weightKg, DeliveryAddress destination) {
        this.orderId = orderId;
        this.weightKg = weightKg;
        this.destination = destination;
        this.shipped = false;
    }

public boolean changeDestination(DeliveryAddress newAddress) {
    if (!shipped && newAddress != null) {
        destination = newAddress;
        return true;
    }
    return false;
}

public void markAsShipped() {
    shipped = true;
}

@Override
public String toString() {
    return "Номер замовлення: " + orderId +
            "\nВага: " + weightKg + " кг" +
            "\nАдреса доставки:\n" + destination +
            "\nСтатус: " + (shipped ? "Відправлено" : "Не відправлено");
}
}