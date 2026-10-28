package semester1.practice08;

import java.util.Arrays;

public class Block1 {
    public static void task01() {
        Student student=new Student("Віталій",1, 60);
        System.out.println(student);

    }
    public static void task02(){
        Product monitor=new Product("228", "Монітор", 5300, 2 );
        Product mouse=new Product("1488", "Ігрова миша", 1300, 5);
        System.out.println(monitor);
        System.out.println(mouse);

    }
    public static void task03(){
        Circle circle=new Circle(5);
        Circle circle1=new Circle(-2);
        System.out.println(circle);
        System.out.println(circle1);

    }
    public static void task04(){
        CardWallet wallet = new CardWallet("1234567890124589", "1234", 12500.00);
        System.out.println(wallet);
        System.out.println(wallet.changePin("1234", "5678"));
        System.out.println(wallet.changePin("1234", "1111"));
        System.out.println(wallet);

    }
    public static void task05(){
        SensorNode sensor = new SensorNode("Arthas", 2.5, 20.0);
        System.out.println(sensor);
        System.out.println("ID: " + sensor.getSensorId());
        System.out.println("Calibrated: " + sensor.getCalibratedValue());

    }
    public static void task06(){
        double [] temps={18.0, 20.0, 22.0, 16.0};
        WeatherDay day=new WeatherDay("28.10.26", temps);
        System.out.println(day);
        System.out.println("Min: " + day.getMinTemp());
        System.out.println("Average: " + day.getAverageTemp());

    }
    public static void task07(){
        IntRange range=new IntRange(1, 10);
        System.out.println(range.contains(5));
        System.out.println(range.contains(12));
        System.out.println(range.contains(3));
        System.out.println(range);

    }
    public static void task08(){
        InvoiceItem item = new InvoiceItem("Под", 2, 650, 10);
        System.out.println("Позиція чека: " + item);

    }

}
        class Student {
            private String name;
            private int course;
            private double gpa;

            public Student(String name, int course, double gpa) {
                this.name = name;
                setCourse(course);
                setGpa(gpa);
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getCourse() {
                return course;
            }

            public void setCourse(int course) {
                if (course >= 1 && course <= 6) {
                    this.course = course;
                } else {
                    this.course = 1;
                }
            }

            public double getGpa() {
                return gpa;
            }

            public void setGpa(double gpa) {
                if (gpa >= 0.0 && gpa <= 100.0) {
                    this.gpa = gpa;
                } else {
                    this.gpa = 60;
                }
            }

            @Override
            public String toString() {
                return "Student{name='" + name + "', course=" + course
                        + ", gpa=" + gpa + "}";
            }
        }
        class Product{
            String sku;
            String title;
            double price;
            int stock;
            public Product(String sku, String title, double price, int stock){
                this.sku=sku; setPrice(price); setStock(stock);
                this.title=title;
            }
            public String getSku(){
                return sku;
            }
            public void setSku(String sku) {
                this.sku = sku;
            }
            public String getTitle(){
                return title;
            }
            public void setTitle(String title){
                this.title=title;
            }
            public double getPrice(){
                return price;
            }

            public void setPrice(double price) {
                if (price>=0){
                    this.price=price;
                }else {
                    this.price=0;
                }
            }
            public int getStock() {
                return stock;
            }
            public void setStock(int stock) {
                if (stock>=0){
                    this.stock=stock;
                }else {
                    this.stock=0;
                }
            }
            public double getTotalCost(){
                return price * stock;
            }
            @Override public String toString(){
             return String.format("[SKU: %s | Title: %s | Cost: %.2f грн | Stock: %d | TotalCost: %.2f грн]",
                     sku, title, price, stock, getTotalCost());
            }
        }
        class Circle{
            private double radius;
            public Circle(double radius){
               setRadius(radius);
            }

            public double getRadius() {
                return radius;
            }

            public void setRadius(double radius) {
                if (radius>0){
                    this.radius=radius;
                }else {
                    this.radius=1.0;
                }
            }
            public double getArea(){
                return Math.PI*radius*radius;
            }
            public double getCircumference(){
                return 2*Math.PI*radius;
            }
            @Override public String toString(){
                return String.format("[Радіус: %.2f | Площа: %.2f | Довжина кола: %.2f]",
                        radius, getArea(), getCircumference()
                );
            }
        }
        class CardWallet {
            String cardNumber;
            String pinCode;
            double balance;

            public CardWallet(String cardNumber, String pinCode, double balance) {
                if (cardNumber.matches("\\d{16}")) {
                    this.cardNumber = cardNumber;
                } else {
                    this.cardNumber = "0000000000000000";
                }
                this.pinCode = pinCode;
                this.balance = balance;
            }

            public boolean changePin(String oldPin, String newPin) {
                if (pinCode.equals(oldPin) && newPin.matches("\\d{4}")) {
                    pinCode = newPin;
                    return true;
                }
                return false;
            }
            @Override public String toString() {
                String maskedCard = "**** **** **** " +
                        cardNumber.substring(12);
                return String.format(
                        "CardWallet{card='%s', balance=%.2f UAH}",
                        maskedCard, balance
                );
            }
        }
        class SensorNode{
            private String sensorId;
            protected double calibrationOffset;
            private double rawValue;
            public SensorNode(String sensorId, double calibrationOffset, double rawValue){
                this.sensorId=sensorId; this.calibrationOffset=calibrationOffset; this.rawValue=rawValue;
            }
            public String getSensorId(){
                return sensorId;
            }
            public double getCalibratedValue(){
                return rawValue + calibrationOffset;
            }
            @Override public String toString() {
                return "SensorNode{sensorId='" + sensorId
                        + "', rawValue=" + rawValue
                        + ", calibratedValue=" + getCalibratedValue() + "}";
            }


        }
        class WeatherDay{
            String date;
            double[] hourlyTemps;
            public WeatherDay(String date, double[] hourlyTemps){
               this.date=date;
               this.hourlyTemps=new double[hourlyTemps.length];
               for (int i=0;i< hourlyTemps.length; i++){
                   this.hourlyTemps[i]=hourlyTemps[i];
               }
            }

            public double getMinTemp() {
                double min=hourlyTemps[0];
                for (int i=0;i< hourlyTemps.length; i++){
                    if (min>hourlyTemps[i]){
                        min=hourlyTemps[i];
                    }
                }
                return min;

            }
            public double getMaxTemp(){
                double max=hourlyTemps[0];
                for (int i=0;i< hourlyTemps.length; i++){
                    if (max<hourlyTemps[i]){
                        max=hourlyTemps[i];
                    }
                }
                return max;
            }
            public double getAverageTemp(){
                double average =0; double sum=0;
                for (int i=0; i<hourlyTemps.length; i++){
                    sum+=hourlyTemps[i];
                }
                average=sum/ hourlyTemps.length;
                return average;
            }
            @Override
            public String toString() {
                return "WeatherDay{date='" + date
                        + "', hourlyTemps=" + Arrays.toString(hourlyTemps)
                        + ", averageTemp=" + getAverageTemp() + "}";
            }

        }
        class IntRange{
            private int min;
            private int max;
            public IntRange(int min, int max){
                if (min<=max){
                    this.min=min; this.max=max;
                }
                if (min>max){
                   this.max=min;
                   this.min=max;
                }
            }
            public boolean contains(int value){
                return value >= min && value <= max;
            }
            public int getLength() {
                return max - min;
            }
            @Override public String toString() {
                return "[" + min + " .. " + max + "] (довжина: " + getLength() + ")";
            }
        }
        class InvoiceItem {
            String description;
            int quantity;
            double unitPrice;
            double discountPercent;

            public InvoiceItem(String description, int quantity, double unitPrice, double discountPercent) {
                this.description = description;
                this.quantity = quantity;
                this.unitPrice = unitPrice;
                setDiscountPercent(discountPercent);
            }

            public void setDiscountPercent(double discountPercent) {
                if (discountPercent >= 0 && discountPercent <= 50) {
                    this.discountPercent = discountPercent;
                } else {
                    this.discountPercent = 0;
                }
            }

            public double getFinalAmount() {
                return quantity * unitPrice * (1 - discountPercent / 100);
            }

            @Override
            public String toString() {
                return String.format("%s | Кількість: %d | Ціна: %.2f | Знижка: %.1f%% | Сума: %.2f",
                        description, quantity, unitPrice, discountPercent, getFinalAmount()
                );
            }
        }

