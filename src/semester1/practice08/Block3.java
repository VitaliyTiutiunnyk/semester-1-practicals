package semester1.practice08;

public class Block3 {
    public static void task17(){
        StaffMember staff = new StaffMember("Олег", 20000);
        Manager manager = new Manager("Андрій", 30000, 5000);
        SalesPerson salesPerson = new SalesPerson("Іван", 20000, 100000, 5);
        System.out.println(staff);
        System.out.println(manager);
        System.out.println(salesPerson);
    }
    public static void task18(){
        StandardTransfer standard = new StandardTransfer(1000);
        InternationalTransfer international =
                new InternationalTransfer(1000, "US");
        System.out.println(standard);
        System.out.println(international);
    }
    public static void task19(){
        Ticket ticket = new Ticket("Концерт", 1000);
        StudentTicket studentTicket = new StudentTicket("Концерт", 1000, "123");
        VipTicket vipTicket = new VipTicket("Концерт", 1000, true, 500);
        System.out.println(ticket);
        System.out.println(studentTicket);
        System.out.println(vipTicket);
        System.out.println("Перевірка цін:");
        System.out.println("Звичайний квиток: " + ticket.getFinalPrice());
        System.out.println("Студентський квиток: " + studentTicket.getFinalPrice());
        System.out.println("VIP-квиток: " + vipTicket.getFinalPrice());

    }
    public static void task20(){
        Weapon sword=new Weapon("Меч Морна", 79);
        EnchantedSword sword1=new EnchantedSword("Фростморн", 100, "Розлад",
                70, 5);
        System.out.println(sword);
        System.out.println(sword1);

    }
    public  static void task21(){
        Parcel parcel=new Parcel("12345", 20) ;
FragileParcel parcel1=new FragileParcel("12421", 3, true
,10000);
        System.out.println(parcel);
        System.out.println(parcel1);


    }
    public static void task22(){
        Appliance appliance = new Appliance("Samsung", 2000);
        EcoHeater heater = new EcoHeater("EcoHeat", 2000, true);
        System.out.println(appliance);
        System.out.println(heater);

        System.out.println("Споживання звичайного приладу: "
                + appliance.getDailyConsumptionKWh(5) + " кВт·год");
        System.out.println("Споживання екообігрівача: "
                + heater.getDailyConsumptionKWh(5) + " кВт·год");
    }
    public static void task23(){
        Point2D point2D=new Point2D(5, 7);
        Point3D point3D=new Point3D(10 ,15, 24);
        System.out.println(point2D);
        System.out.println(point3D);

    }
    public  static void task24(){
        Coffee coffee = new Coffee("Середнє", 200, 50);
        LatteWithAddons latte = new LatteWithAddons(
                "Середнє", 300, 70, "рослинне", 2
        );

        System.out.println(coffee);
        System.out.println();
        System.out.println(latte);
    }
}
class StaffMember{
    String name;
    double baseSalary;
    StaffMember(String name, double baseSalary){
        this.name=name;
        this.baseSalary=baseSalary;
    }
    public double calculateMonthlyPay(){
        return baseSalary;
    }
    @Override
    public String toString() {
        return "StaffMember{name='" + name
                + "', baseSalary=" + baseSalary
                + ", finalPay=" + calculateMonthlyPay() + "}";
    }
}
class Manager extends StaffMember{
    double teamBonus;
    Manager(String name, double baseSalary, double teamBonus){
        super(name, baseSalary);
       this.teamBonus=teamBonus;
    }
    @Override public double calculateMonthlyPay(){
     return super.calculateMonthlyPay() + teamBonus;
    }
    @Override
    public String toString() {
        return "Manager{name='" + name
                + "', baseSalary=" + baseSalary
                + ", teamBonus=" + teamBonus
                + ", finalPay=" + calculateMonthlyPay() + "}";
    }
}
class SalesPerson extends StaffMember{
    double salesVolume;
    double commissionRate;
    SalesPerson(String name, double baseSalary, double
                salesVolume, double commissionRate){
        super(name, baseSalary);
        this.salesVolume=salesVolume;
        this.commissionRate=commissionRate;
    }
    @Override public double calculateMonthlyPay(){
        return super.calculateMonthlyPay() + salesVolume * (commissionRate / 100.0);
    }
    @Override
    public String toString() {
        return "SalesPerson{name='" + name
                + "', baseSalary=" + baseSalary
                + ", salesVolume=" + salesVolume
                + ", commissionRate=" + commissionRate
                + "%, finalPay=" + calculateMonthlyPay() + "}";
    }
}
class StandardTransfer{
    protected double amount;
    StandardTransfer(double amount){
        this.amount=amount;
    }
    public double getFee(){
        return amount*0.01;
    }
    public double getTotalWithFee(){
        return amount + getFee();
    }
    @Override
    public String toString() {
        return "Стандартний переказ{сума=" + amount
                + ", комісія=" + getFee()
                + ", загальна сума=" + getTotalWithFee() + "}";
    }
}
class InternationalTransfer extends StandardTransfer{
    private String countryCode;
    private double swift=15;
    InternationalTransfer(double amount, String countryCode ){
        super(amount); this.countryCode=countryCode;
    }
    @Override public double getFee(){
        return super.getFee() * 2 + swift;
    }

    @Override
    public String toString() {
        return "Міжнародний переказ{код країни='" + countryCode
                + "', сума переказу=" + amount
                + ", комісія=" + getFee()
                + ", загальна сума=" + getTotalWithFee() + "}";
    }
}
class Ticket{
    private String eventName;
    private double basePrice;
    Ticket(String eventName, double basePrice){
        this.eventName=eventName;
        this.basePrice=basePrice;
    }
    public double getFinalPrice(){
        return basePrice;
    }
    @Override
    public String toString() {
        return "Квиток{назва події='" + eventName
                + "', базова ціна=" + basePrice + "}";
    }
}
class StudentTicket extends Ticket{
    private String studentCardNumber;
    StudentTicket(String eventName, double basePrice, String studentCardNumber){
        super(eventName, basePrice); this.studentCardNumber=studentCardNumber;
    }
    @Override public double getFinalPrice(){
        return super.getFinalPrice() * 0.5;
    }
    @Override
    public String toString() {
        return "Студентський квиток{" + super.toString()
                + ", номер студентського квитка='" + studentCardNumber
                + "', кінцева ціна=" + getFinalPrice() + "}";
    }
}
class VipTicket extends Ticket{
    private boolean includesBackstage; private double loungeFee;
    VipTicket(String eventName, double basePrice, boolean includesBackstage,
              double loungeFee){
        super(eventName, basePrice);
        this.includesBackstage=includesBackstage;
        this.loungeFee=loungeFee;
    }
    @Override public double getFinalPrice(){
        return super.getFinalPrice()+loungeFee;
    }
    @Override
    public String toString() {
        return "VIP-квиток{" + super.toString()
                + ", доступ за лаштунки=" + includesBackstage
                + ", плата за лаунж=" + loungeFee
                + ", кінцева ціна=" + getFinalPrice() + "}";
    }
}
class Weapon{
    private String title;
    private int baseDamage;
    Weapon(String title, int baseDamage){
        this.title=title;
        this.baseDamage=baseDamage;
    }
    public int calculateDamage(){
        return baseDamage;
    }
    public int getBaseDamage() {
        return baseDamage;
    }
    @Override public String toString(){
        return "Зброя{ "+title
                +" | Фіз. дамаг: "+baseDamage
                +"| }";
    }
}
class EnchantedSword extends Weapon{
    private String element;
    private int magicPower;
    private int enchantmentLevel;
    EnchantedSword(String title, int baseDamage, String element
    , int magicPower, int enchantmentLevel){
        super(title, baseDamage);
        this.element=element;
        this.magicPower=magicPower;
        this.enchantmentLevel=enchantmentLevel;
    }
    @Override public int calculateDamage(){
        return super.calculateDamage() + magicPower * enchantmentLevel;
    }
    @Override public String toString(){
        return "Зачарована зброя{ "+super.toString()
                +" Елемент зачара: "+element
                +" | Сила зачара: "+magicPower
                +" | Мішаний дамаг: "+calculateDamage()
                +"}";
    }

}
class Parcel{
    private String trackingCode;
    private double weightKg;
    Parcel(String trackingCode, double weightKg){
        this.trackingCode=trackingCode;
        this.weightKg=weightKg;
    }
    public double calculateShippingCost(){
        return 50+weightKg*12;

    }
    @Override
    public String toString() {
        return "Посилка{трек-код='" + trackingCode
                + "', вага=" + weightKg + " кг"
                + ", вартість доставки=" + calculateShippingCost() + " грн}";
    }
}
class FragileParcel extends Parcel{
    private boolean requiresWoodenBox;
    private double insuranceValue;
    FragileParcel(String trackingCode, double weightKg,
                  boolean requiresWoodenBox, double insuranceValue){
        super(trackingCode, weightKg);
        this.requiresWoodenBox=requiresWoodenBox;
        this.insuranceValue=insuranceValue;
    }
        @Override
        public double calculateShippingCost() {
            double cost = super.calculateShippingCost();
            cost += insuranceValue * 0.015;

            if (requiresWoodenBox) {
                cost += 120.0;
            }

            return cost;
        }
    @Override
    public String toString() {
        return "Крихка посилка{" + super.toString()
                + ", дерев'яна обрешітка=" + requiresWoodenBox
                + ", страхова вартість=" + insuranceValue + " грн"
                + ", підсумкова вартість=" + calculateShippingCost() + " грн}";
    }

    }
    class Appliance{
        private String model;
        private double powerWatts;
        Appliance(String model, double powerWatts){
            this.model=model;
            this.powerWatts=powerWatts;
        }
        public double getDailyConsumptionKWh(int hours){
            return (powerWatts * hours) / 1000.0;
        }
        @Override
        public String toString() {
            return "Прилад{модель='" + model
                    + "', потужність=" + powerWatts + " Вт}";
        }
    }
    class EcoHeater extends Appliance{
      private boolean ecoModeActive;
        EcoHeater(String model, double powerWatts, boolean ecoModeActive){
            super(model, powerWatts);
            this.ecoModeActive=ecoModeActive;
        }
        @Override public double getDailyConsumptionKWh(int hours){
            double with= super.getDailyConsumptionKWh(hours);
            if (ecoModeActive){
                with=with-with*0.75;
            }
            return with;
        }
        @Override
        public String toString() {
            return "Екообігрівач{" + super.toString()
                    + ", режим економії="
                    + (ecoModeActive ? "увімкнено" : "вимкнено") + "}";
        }
    }
    class Point2D{
        private double x;
        private double y;
        Point2D(double x, double y){
            this.x=x; this.y=y;
        }
        public double getX() {
            return x;
        }
        public double getY() {
            return y;
        }
        public double distanceToOrigin(){
          return   Math.sqrt(x*x+y*y);
        }

        @Override
        public String toString() {
             return "{ A( "+x+", "+y+" )"
                     +" | Distance to origin = "+distanceToOrigin()
                     +" | }";

        }
    }
    class Point3D extends Point2D{
    private double z;
    Point3D(double x, double y, double z){
        super(x, y);
        this.z=z;
    }
        @Override
        public double distanceToOrigin() {
            return Math.sqrt(
                    Math.pow(super.distanceToOrigin(), 2) + z * z
            );
        }

        @Override
        public String toString() {
            return "{A ( " + getX() + ", " + getY() + ", " + z + ")"
                    + " | Відстань до початку координат = "
                    + distanceToOrigin() + "| }";
        }
    }
class Coffee {
    private String roastType;
    private int volumeMl;
    private double basePrice;

    Coffee(String roastType, int volumeMl, double basePrice) {
        this.roastType = roastType;
        this.volumeMl = volumeMl;
        this.basePrice = basePrice;
    }

    public double calculateCalories() {
        return volumeMl * 0.5;
    }

    public double calculatePrice() {
        return basePrice;
    }

    public String getRoastType() {
        return roastType;
    }

    public int getVolumeMl() {
        return volumeMl;
    }

    @Override
    public String toString() {
        return "Кава: " + roastType
                + " | Об'єм: " + volumeMl + " мл"
                + " | Ціна: " + calculatePrice() + " грн";
    }
}

class LatteWithAddons extends Coffee {
    private String milkType;
    private int syrupPumps;

    LatteWithAddons(String roastType, int volumeMl, double basePrice,
                    String milkType, int syrupPumps) {
        super(roastType, volumeMl, basePrice);
        this.milkType = milkType;
        this.syrupPumps = syrupPumps;
    }

    @Override
    public double calculateCalories() {
        double calories = super.calculateCalories();
        calories += syrupPumps * 20;
        return calories;
    }

    @Override
    public double calculatePrice() {
        double price = super.calculatePrice();

        if (milkType.equalsIgnoreCase("рослинне")) {
            price += 20;
        }

        price += syrupPumps * 12;
        return price;
    }
    @Override
    public String toString() {
        return "========== ЧЕК КАВ'ЯРНІ =========="
                + "\nНапій: Лате"
                + "\nОбсмажування кави: " + getRoastType()
                + "\nОб'єм: " + getVolumeMl() + " мл"
                + "\nМолоко: " + milkType
                + "\nНатискання сиропу: " + syrupPumps
                + "\nКалорійність: " + calculateCalories() + " ккал"
                + "\nДо сплати: " + calculatePrice() + " грн"
                + "\n=================================";
    }
}



