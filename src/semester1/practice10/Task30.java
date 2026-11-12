package semester1.practice10;

public class Task30 {
    public static void run(){
        //Головне: у calculateDiscount() немає жодного instanceof, приведення типів або перевірки конкретного класу.
        //Метод просто викликає getDiscountPercent(), а Java сама визначає, яку реалізацію використати.
        AbstractCustomer[] customers = {
                new VipCustomer(),
                new StudentCustomer(),
                new RegularCustomer()
        };
        double price = 1000;
        for (AbstractCustomer customer : customers) {
            double finalPrice = calculateDiscount(customer, price);
            System.out.println(customer.getClass().getSimpleName()
                    + " — знижка: " + customer.getDiscountPercent() + "%"
                    + ", ціна: " + finalPrice);
        }
    }
    public static double calculateDiscount(AbstractCustomer customer, double price) {
        return price * (1.0 - customer.getDiscountPercent() / 100.0);
    }
}
abstract class AbstractCustomer {
    public abstract double getDiscountPercent();
}

class VipCustomer extends AbstractCustomer {
    @Override
    public double getDiscountPercent() {
        return 20;
    }
}

class StudentCustomer extends AbstractCustomer {
    @Override
    public double getDiscountPercent() {
        return 10;
    }
}

class RegularCustomer extends AbstractCustomer {
    @Override
    public double getDiscountPercent() {
        return 0;
    }
}
