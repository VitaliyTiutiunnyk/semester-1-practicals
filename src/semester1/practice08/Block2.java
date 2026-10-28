package semester1.practice08;

public class Block2 {
    public static void task09(){
        Employee employee = new Employee("Демид", 25000);
        Developer developer = new Developer("Виталий", 35000, "Java");

        System.out.println(employee);
        System.out.println(developer);

    }
    public static void task10(){
        Dog dog = new Dog("Джус", 7, 5, "Бродяга");
        Cat cat = new Cat("Саша", 6, 1.5, true);
        System.out.println(dog);
        System.out.println(dog.fetchStick());
        System.out.println(cat);
        System.out.println(cat.purr());
    }
    public static void task11(){
        PassengerCar car = new PassengerCar("Toyota", 200, 50, 5);
        CargoTruck truck = new CargoTruck("Volvo", 120, 300, 20);
        System.out.println(car);
        System.out.println(truck);
    }
    public static void task12(){
        Rectangle rectangle=new Rectangle(5, 9);
        Box3D box=new Box3D(2, 6 ,8);
        System.out.println(rectangle);
        System.out.println(box);
    }
    public static void task13(){
        UniversityStudent student = new UniversityStudent(
                "Віталій Тютюнник", 2009, "KN-11", "Computer Science", 2000
        );
        Professor professor = new Professor(
                "Олександр Іваненко", 1980, "Доцент", 25
        );

        System.out.println("Вік студента: " + student.getAge(2026));
        System.out.println("Вік викладача: " + professor.getAge(2026));

    }
    public static void task14(){
        Smartphone phone1 = new Smartphone("Samsung", 25000, 256, true);
        Smartphone phone2 = new Smartphone("Xiaomi", 12000, 128);
        Smartphone phone3 = new Smartphone("iPhone");
        System.out.println(phone1.toString());
        System.out.println(phone2.toString());
        System.out.println(phone3.toString());

    }
    public static void task15(){
        AudioBook book = new AudioBook(
                "Кобзар", "Тарас Шевченко", 1840, 195, "Олександр"
        );
        System.out.println(book);

    }
    public static void task16(){
        Gamer gamer = new Gamer("Shadow", 1500);
        ProEsportsPlayer player = new ProEsportsPlayer(
                "N0tail", 5000, "OG", 2000000, 4
        );
        ProEsportsPlayer player2 = new ProEsportsPlayer(
                "NoWins", 100, "TeamFalcons", 5000, 0
        );
        System.out.println(gamer);
        System.out.println(player);
        System.out.println("Середній приз за перемогу: "
                + player.getAveragePrizePerWin());
        System.out.println(player2);
        System.out.println("Середній приз за перемогу: "
                + player2.getAveragePrizePerWin());

    }
}
    class Employee{
        private String name;
        protected double salary;
       public Employee(String name, double salary){
           this.name=name;
           this.salary=salary;
       }
       public String getName(){
           return name;
       }
        @Override
        public String toString() {
            return "Employee{name='" + name + "', salary=" + salary + "}";
        }

}
     class Developer extends Employee{
        private String programmingLanguage;
        Developer(String name, double salary, String programmingLanguage){
            super(name, salary);
            this.programmingLanguage=programmingLanguage;
        }
         @Override public String toString() {
             return "Developer{name='" + getName()
                     + "', salary=" + salary
                     + ", programmingLanguage='" + programmingLanguage + "'}";
         }
    }
     class Animal{
         private String name;
         private int age;
         private double weight;
         public Animal(String name, int age, double weight){
             this.name=name; this.age=age; this.weight=weight;
         }
         public String getName(){
             return name;
         }
         public int getAge(){
             return age;
         }
         public double getWeight(){
             return weight;
         }

    }
    class Dog extends Animal{
       private String breed;
        Dog(String name, int age, double weight, String breed){
            super(name, age, weight);
            this.breed=breed;
        }
        public String fetchStick(){
            return getName()+ " приносить палицю! ";

        }
        @Override public String toString() {
            return "Dog{name='" + getName()
                    + "', age=" + getAge()
                    + ", weight=" + getWeight()
                    + ", breed='" + breed + "'}";
        }

    }
    class Cat extends Animal{
    private boolean isIndoor;
    Cat(String name, int age, double weight, boolean isIndoor){
        super(name, age, weight);
        this.isIndoor=isIndoor;
    }
        public String purr(){
            return getName() + " муркоче: мур-мур!";
        }
        @Override public String toString() {
            return "Cat{name='" + getName()
                    + "', age=" + getAge()
                    + ", weight=" + getWeight()
                    + ", isIndoor=" + isIndoor + "}";
        }
    }
    class Vehicle{
        protected String brand;
        protected int maxSpeed;
        protected double fuelTankCapacity;
        Vehicle(String brand, int maxSpeed, double fuelTankCapacity){
            this.brand=brand; this.maxSpeed=maxSpeed; this.fuelTankCapacity=fuelTankCapacity;
        }
        public String getBrand(){
            return brand;
        }
        public int getMaxSpeed(){
            return maxSpeed;
        }
        public double getFuelTankCapacity(){
            return fuelTankCapacity;
        }

    }
    class PassengerCar extends Vehicle{
        private int passengerSeats;
        PassengerCar(String brand, int maxSpeed, double fuelTankCapacity, int passengerSeats){
            super(brand, maxSpeed, fuelTankCapacity);
            this.passengerSeats=passengerSeats;
        }

        public int getPassengerSeats() {
            return passengerSeats;
        }
        @Override
        public String toString() {
            return "PassengerCar{brand='" + brand
                    + "', maxSpeed=" + maxSpeed
                    + ", fuelTankCapacity=" + fuelTankCapacity
                    + ", passengerSeats=" + passengerSeats + "}";
        }
    }
    class CargoTruck extends Vehicle {
        private double maxLoadTons;

        CargoTruck(String brand, int maxSpeed, double fuelTankCapacity, double maxLoadTons) {
            super(brand, maxSpeed, fuelTankCapacity);
            this.maxLoadTons = maxLoadTons;
        }

        public double getMaxLoadTons() {
            return maxLoadTons;
        }

        public double getFuelConsumption() {
            return 20 + maxLoadTons * 2;
        }

        @Override
        public String toString() {
            return "CargoTruck{brand='" + brand
                    + "', maxSpeed=" + maxSpeed
                    + ", fuelTankCapacity=" + fuelTankCapacity
                    + ", maxLoadTons=" + maxLoadTons
                    + ", fuelConsumption=" + getFuelConsumption() + " л/100 км}";
        }
    }
    class Rectangle{
    private double width;
    private double height;
    Rectangle(double width, double height){
        this.width=width; this.height=height;
    }
        public double getWidth() {
            return width;
        }

        public double getHeight() {
            return height;
        }
        public double getArea(){
        return width*height;
        }
        @Override public String toString(){
        return "Rectangle{width = " +getWidth()
                +", "+"height = "+getHeight()
                +", "+"area = "+getArea()+"}";
        }
    }
    class Box3D extends Rectangle{
        private double depth;
        Box3D(double width, double height, double depth){
            super(width, height); this.depth=depth;
        }
        public double getVolume(){
            return super.getArea()*depth;
        }
        @Override public String toString(){
            return "Box3D{width = " +getWidth()
                    +", "+"height = "+getHeight()
                    +", "+"depth = "+depth
                    +", "+"volume = "+getVolume()+"}";
        }
    }
    class Person{
        private String fullName;
        private int birthYear;
        Person(String fullName, int birthYear){
            this.fullName=fullName; this.birthYear=birthYear;
        }
        public int getAge(int currentYear){
            return currentYear-birthYear;
        }
    }
    class UniversityStudent extends Person{
        private String studentId;
        private String major;
        private int scholarship;
        UniversityStudent(String fullName, int birthYear, String studentId
        , String major, int scholarship){
            super(fullName, birthYear); this.studentId=studentId;
            this.major=major; this.scholarship=scholarship;
        }
    }
    class Professor extends Person{
        private String academicTitle;
        private int publicationsCount;
        Professor(String fullName, int birthYear, String academicTitle, int publicationsCount){
            super(fullName, birthYear);
            this.academicTitle=academicTitle; this.publicationsCount= publicationsCount;
        }
    }
    class Gadget{
        private String brand;
        private double price;
        Gadget(String brand, double price){
            this.brand=brand; this.price=price;
        }
        public String getBrand() {
            return brand;
        }

        public double getPrice() {
            return price;
        }
    }
    class Smartphone extends Gadget{
        private int memoryGb;
        private boolean has5G;
        Smartphone(String brand, double price, int memoryGb, boolean has5G){
            super(brand, price);
        }
        Smartphone(String brand, double price, int memoryGb){
            this(brand, price, memoryGb, true);
        }
        Smartphone(String brand){
            this(brand, 9999.0, 128, false);
        }
        @Override public String toString() {
            return "Smartphone{brand='" + getBrand()
                    + "', price=" + getPrice()
                    + ", memoryGb=" + memoryGb
                    + ", has5G=" + has5G + "}";
        }
    }
    class Publication{
        private String title;
        private String author;
        private int releaseYear;
         Publication(String title, String author, int releaseYear){
            this.title=title;
            this.author=author;
            this.releaseYear=releaseYear;
        }
        public String getTitle(){
             return title;
        }
        public String getAuthor(){
             return author;
        }
        public int getReleaseYear() {
            return releaseYear;
        }
    }
    class PrintedBook extends Publication{
        private int pageCount;
        private String coverType;
        PrintedBook(String title, String author, int releaseYear,
                    int pageCount, String coverType){
            super(title, author, releaseYear);
            this.pageCount=pageCount; this.coverType=coverType;
        }
    }
    class AudioBook extends Publication{
        private int durationMinutes;
        private String narrator;
        AudioBook(String title, String author, int releaseYear, int durationMinutes, String narrator){
            super(title, author, releaseYear);
            this.durationMinutes=durationMinutes;
            this.narrator=narrator;
        }
        public String getFormattedDuration() {
            int hours = durationMinutes / 60;
            int minutes = durationMinutes % 60;

            return hours + " год " + minutes + " хв";
        }
        @Override public String toString() {
            return "AudioBook{title='" + getTitle()
                    + "', author='" + getAuthor()
                    + "', releaseYear=" + getReleaseYear()
                    + ", duration=" + getFormattedDuration()
                    + ", narrator='" + narrator + "'}";
        }
    }
    class Gamer{
        private String nickname;
        private int hoursPlayed;
        Gamer(String nickname, int hoursPlayed){
            this.nickname=nickname; this.hoursPlayed=hoursPlayed;
        }
        public String getNickname(){
            return nickname;
        }
        public int getHoursPlayed() {
            return hoursPlayed;
        }
        @Override
        public String toString() {
            return "Gamer{nickname='" + nickname
                    + "', hoursPlayed=" + hoursPlayed + "}";
        }
    }
    class ProEsportsPlayer extends Gamer{
        private String teamName;
        private double prizeMoneyUSD;
        private int tournamentsWon;
        ProEsportsPlayer(String nickname, int hoursPlayed,
                         String teamName, double prizeMoneyUSD,
                         int tournamentsWon){
            super(nickname, hoursPlayed);
            this.teamName=teamName;
            this.prizeMoneyUSD=prizeMoneyUSD;
            this.tournamentsWon=tournamentsWon;
        }
        public double getAveragePrizePerWin(){
            if (tournamentsWon == 0) {
                return 0;
            }
            return prizeMoneyUSD / tournamentsWon;
        }
        @Override
        public String toString() {
            return "ProEsportsPlayer{nickname='" + getNickname()
                    + "', hoursPlayed=" + getHoursPlayed()
                    + ", teamName='" + teamName
                    + "', prizeMoneyUSD=" + prizeMoneyUSD
                    + ", tournamentsWon=" + tournamentsWon
                    + ", averagePrizePerWin=" + getAveragePrizePerWin()
                    + "}";
        }
    }


