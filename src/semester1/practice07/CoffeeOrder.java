package semester1.practice07;

public class CoffeeOrder {
 private    String type;
 private String size;
 private int sugarCount;
    boolean withSyrup;
    double finalPrice;
    private double calculatePrice(){
        double price=0;
        switch (type){
            case "Еспрессо":
                price=40;
                break;
            case "Капучино":
                price=55;
                break;
            case "Лате":
                price=60;
                break;
        }
        switch (size){
            case "Small":
                price*=1.0;
                break;
            case "Medium":
                price*=1.3;
                break;
            case "Large":
                price*=1.6;

        }
        if (withSyrup){
            price+=15;
        }
        return price;

    }
  public   CoffeeOrder(String type, String size, int sugarCount, boolean withSyrup){
      this.type = type;
      this.size = size;
      this.sugarCount = sugarCount;
      this.withSyrup = withSyrup;
      this.finalPrice = calculatePrice();

  }
  public   CoffeeOrder(String type, String size){
        this(type, size, 0, false );
  }
  public   CoffeeOrder(String type){
        this(type, "Medium");
  }
    public void printReceipt(){
        System.out.println("_____ЗАМОВЛЕННЯ______");
        System.out.println(" Кава - "+type);
        System.out.println(" Розмір - "+size);
        System.out.println(" Цукор - "+sugarCount);
        System.out.println(" З сиропом - "+withSyrup);
        System.out.println("_____________________");
    }
}
