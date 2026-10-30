package semester1.practice08;

public class Block4 {
    public static void task25(){
        DotaHero hero=new DotaHero("WraithKing","Strength", 700);
        StrengthHero hero1=new StrengthHero("Axe", "Strength", 650, 35);
        AlchemistHero alchemistHero=new AlchemistHero("Alchemist", "Strength",
                630, 60, 50);
        System.out.println(hero);
        System.out.println();
        System.out.println(hero1);
        System.out.println();
        System.out.println(alchemistHero);

    }
    public static void task26(){
        ElectricCar car = new ElectricCar(
                "Tesla", 2024, 450, 4, 82.5, 550
        );
        System.out.println(car);

    }
    public static void task27(){
        CashbackPlatinumCard card = new CashbackPlatinumCard(
                "Віталій", 10000, 3000, 5
        );
        System.out.println("До покупки:");
        System.out.println(card);
        System.out.println("\nПокупка на 2000 грн:");
        System.out.println("Успішна оплата: " + card.pay(2000));
        System.out.println("\nПокупка на 4000 грн:");
        System.out.println("Успішна оплата: " + card.pay(4000));
        System.out.println("\nПісля покупок:");
        System.out.println(card);

    }
    public static void task28(){
        CustomTerminal terminal = new CustomTerminal();
        System.out.println(terminal.getWelcomeBanner());
        System.out.println(terminal.generateAuthHash("Vitaliy"));
    }
    public static void task29(){
        ImmutableServerCredentials credentials =
                new ImmutableServerCredentials("localhost", 8080, "mySecret123");
        System.out.println("=== SERVER CREDENTIALS ===");
        System.out.println(credentials);
        System.out.println("Host: " + credentials.getHost());
        System.out.println("Port: " + credentials.getPort());
        System.out.println("API Key: " + credentials.getApiKey());
    }
    public static void task30(){
        Segment1D segment = new Segment1D(5);
        Square2D square = new Square2D(5);
        Cube3D cube = new Cube3D(5);

        System.out.println(segment);
        System.out.println(square);
        System.out.println(cube);
    }
    public static void task31(){
            PostgraduateStudent student = new PostgraduateStudent(
                    101,
                    "student@gmail.com",
                    "КНД-11",
                    90.5,
                    "Штучний інтелект у сучасних інформаційних системах",
                    "Іваненко Іван Іванович"
            );
            System.out.println("=== ДОСЬЄ АСПІРАНТА ===");
            System.out.println(student);
    }
    public static void task32(){
        ControlledSubstance medicine1 =
                new ControlledSubstance("Препарат А", 250, false,
                        "LIC-123", 20);

        ControlledSubstance medicine2 =
                new ControlledSubstance("Препарат Б", 300, true,
                        "LIC-456", 25);

        ControlledSubstance medicine3 =
                new ControlledSubstance("Препарат В", 150, false,
                        "LIC-789", 16);
        System.out.println("=== ПЕРЕВІРКА ПРОДАЖУ ===");
        System.out.println("Умова 1: " + medicine1.canSell(true));
        System.out.println("Умова 2: " + medicine2.canSell(true));
        System.out.println("Умова 3: " + medicine3.canSell(true));
        System.out.println("Без рецепта: " + medicine1.canSell(false));
        System.out.println("\n=== ДОСЬЄ ПРЕПАРАТУ ===");
        System.out.println(medicine1);
    }
}
class DotaHero{
    private String name;
    private String primaryAttribute;
    private int baseHp;
    DotaHero(String name, String primaryAttribute, int baseHp){
        this.name=name; this.primaryAttribute=primaryAttribute;
        this.baseHp=baseHp;
    }
    public int getMaxHp(){
        return baseHp;
    }
    @Override
    public String toString() {
        return "Герой{ім'я='" + name
                + "', основний атрибут='" + primaryAttribute
                + "', базове HP=" + baseHp + "}";
    }
}
class StrengthHero extends DotaHero{
    private int strength;
    StrengthHero(String name, String primaryAttribute, int baseHp, int strength){
        super(name, primaryAttribute, baseHp);
        this.strength=strength;
    }
    @Override public int getMaxHp(){
      return   super.getMaxHp()+strength*22;
    }
    @Override
    public String toString() {
        return "Герой сили{" + super.toString()
                + ", сила=" + strength
                + ", максимальне HP=" + getMaxHp() + "}";
    }
}
class AlchemistHero extends StrengthHero{
    private int greevilsGreedBonusGold;
    AlchemistHero(String name, String primaryAttribute, int baseHp, int strength,
                  int greevilsGreedBonusGold){
        super(name, primaryAttribute, baseHp, strength);
        this.greevilsGreedBonusGold=greevilsGreedBonusGold;
    }
    public String chemicalRage(){
        return "Алхімік активує Chemical Rage! Швидкість атаки та відновлення збільшуються.";
        }
    @Override
    public String toString() {
        return "Алхімік{" + super.toString()
                + ", бонус золота Greevil's Greed=" + greevilsGreedBonusGold
                + ", ульта=" + chemicalRage()
                + "}";
    }
    }
    class BaseVehicle{
        String brand;
        int year;
        BaseVehicle(String brand, int year){
            this.brand=brand;
            this.year=year;
        }
        @Override
        public String toString() {
            return "Марка='" + brand
                    + "', рік=" + year;
        }
    }
    class MotorCar extends BaseVehicle{
      private int horsePower;
      private int doorsCount;
        MotorCar(String brand, int year, int horsePower, int doorsCount) {
            super(brand, year);
            this.horsePower = horsePower;
            this.doorsCount = doorsCount;
        }
        @Override
        public String toString() {
            return "Автомобіль{" + super.toString()
                    + ", потужність=" + horsePower + " к.с."
                    + ", кількість дверей=" + doorsCount + "}";
        }
    }
class ElectricCar extends MotorCar {
    private double batteryCapacityKWh;
    private int rangeKm;
    ElectricCar(String brand, int year, int horsePower, int doorsCount,
                double batteryCapacityKWh, int rangeKm) {

        super(brand, year, horsePower, doorsCount);
        this.batteryCapacityKWh = batteryCapacityKWh;
        this.rangeKm = rangeKm;
    }
    @Override
    public String toString() {
        return "Електромобіль{" + super.toString()
                + ", ємність батареї=" + batteryCapacityKWh + " кВт·год"
                + ", запас ходу=" + rangeKm + " км}";
    }
}
 class PaymentCard {
    private String cardHolder;
    protected double balance;

    PaymentCard(String cardHolder, double balance) {
        this.cardHolder = cardHolder;
        this.balance = balance;
    }

    public boolean pay(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "Власник картки='" + cardHolder
                + "', баланс=" + balance + " грн";
    }
}

class DebitCard extends PaymentCard {
    private double dailyLimit;

    DebitCard(String cardHolder, double balance, double dailyLimit) {
        super(cardHolder, balance);
        this.dailyLimit = dailyLimit;
    }

    @Override
    public boolean pay(double amount) {
        if (amount > dailyLimit) {
            return false;
        }

        return super.pay(amount);
    }

    @Override
    public String toString() {
        return "Дебетова картка{" + super.toString()
                + ", денний ліміт=" + dailyLimit + " грн}";
    }
}

class CashbackPlatinumCard extends DebitCard {
    private double cashbackPercent;
    private double accumulatedCashback;

    CashbackPlatinumCard(String cardHolder, double balance,
                         double dailyLimit, double cashbackPercent) {
        super(cardHolder, balance, dailyLimit);
        this.cashbackPercent = cashbackPercent;
        this.accumulatedCashback = 0;
    }

    @Override
    public boolean pay(double amount) {
        if (super.pay(amount)) {
            accumulatedCashback += amount * cashbackPercent / 100;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Platinum-картка{" + super.toString()
                + ", кешбек=" + cashbackPercent + "%"
                + ", накопичений кешбек=" + accumulatedCashback + " грн}";
    }
}
class SecurityTerminal{
    public final String generateAuthHash(String user){
        return "AUTH-SHA-" + user.toUpperCase();
    }
}
class CustomTerminal extends SecurityTerminal{
    public String getWelcomeBanner() {
        return "Welcome! " + super.generateAuthHash("Vitaliy");
    }
    // Помилка компіляції виникне, якщо спробувати перевизначити
    // generateAuthHash(), тому що цей метод у батьківському класі має final.
    // Методи final не можна перевизначати в дочірніх класах.
    }
 final class ImmutableServerCredentials{
    private final String host; private final int port;
    private final String apiKey;
  public   ImmutableServerCredentials(String host, int port, String apiKey){
        this.host=host; this.port=port;
        this.apiKey=apiKey;
    }
    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getApiKey() {
        return apiKey;
    }
     @Override
     public String toString() {
         return "ImmutableServerCredentials{" +
                 "host='" + host + '\'' +
                 ", port=" + port +
                 ", apiKey='***SECRET***'" +
                 '}';
     }
}
 class Segment1D{
     protected double length;
     Segment1D(double length){
         this.length=length;
     }
     @Override
     public String toString() {
         return "Відрізок: довжина = " + length;
     }
 }
 class Square2D extends Segment1D{
    Square2D(double length){
        super(length);
    }
    public double getPerimeter(){
        return super.length*4;
    }
    public double getArea(){
        return super.length*super.length;
    }
     @Override
     public String toString() {
         return super.toString() +
                 ", периметр квадрата = " + getPerimeter() +
                 ", площа квадрата = " + getArea();
     }
 }
 class Cube3D extends Square2D{
    Cube3D(double length){
        super(length);
    }
     @Override public double getArea(){
        return 6*super.getArea();
     }
     public double getVolume(){
        return super.length*super.length*super.length;
     }
     @Override
     public String toString() {
         return super.toString() +
                 ", площа поверхні куба = " + getArea() +
                 ", об'єм куба = " + getVolume();}
 }
class User {
    protected int id;
    protected String email;

    User(int id, String email) {
        this.id = id;
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Email: " + email;
    }
}

class StudentUser extends User {
    protected String groupCode;
    protected double gpa;

    StudentUser(int id, String email, String groupCode, double gpa) {
        super(id, email);
        this.groupCode = groupCode;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Група: " + groupCode +
                ", GPA: " + gpa;
    }
}
class PostgraduateStudent extends StudentUser {
    private String thesisTopic;
    private String supervisorName;
    PostgraduateStudent(int id, String email, String groupCode,
                        double gpa, String thesisTopic, String supervisorName) {
        super(id, email, groupCode, gpa);
        this.thesisTopic = thesisTopic;
        this.supervisorName = supervisorName;
    }
    public boolean canDefendThesis() {
        return gpa >= 85.0 &&
                thesisTopic != null &&
                !thesisTopic.trim().isEmpty();
    }
    @Override
    public String toString() {
        return super.toString() +
                ", Тема дисертації: " + thesisTopic +
                ", Науковий керівник: " + supervisorName +
                ", Допуск до захисту: " +
                (canDefendThesis() ? "Так" : "Ні");
    }
}
class Medicine {
    protected String name;
    protected double price;
    protected boolean isExpired;

    Medicine(String name, double price, boolean isExpired) {
        this.name = name;
        this.price = price;
        this.isExpired = isExpired;
    }

    @Override
    public String toString() {
        return "Препарат: " + name +
                ", ціна: " + price +
                ", прострочений: " + (isExpired ? "Так" : "Ні");
    }
}

class PrescriptionMedicine extends Medicine {
    protected String doctorLicense;

    PrescriptionMedicine(String name, double price, boolean isExpired,
                         String doctorLicense) {
        super(name, price, isExpired);
        this.doctorLicense = doctorLicense;
    }

    public boolean canSell(boolean hasPrescription) {
        return !isExpired && hasPrescription;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", ліцензія лікаря: " + doctorLicense;
    }
}

class ControlledSubstance extends PrescriptionMedicine {
    private int patientAge;

    ControlledSubstance(String name, double price, boolean isExpired,
                        String doctorLicense, int patientAge) {
        super(name, price, isExpired, doctorLicense);
        this.patientAge = patientAge;
    }

    @Override
    public boolean canSell(boolean hasPrescription) {
        return super.canSell(hasPrescription) && patientAge >= 18;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", вік пацієнта: " + patientAge +
                ", продаж дозволено: " +
                (canSell(true) ? "Так" : "Ні");
    }
}
