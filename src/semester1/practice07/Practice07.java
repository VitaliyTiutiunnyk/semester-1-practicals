package semester1.practice07;

import java.util.Arrays;

public class Practice07 {
    public static void main(String[] args) {
        task01();
        task02();
        task03();
        task04();
        task05();
        task06();
        task07();
        task08();
        task09();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
        task23();
        task24();
        task25();
        task26();
        task27();
        task28();
        task29();
        task30();
        task31();
        task32();
        task33();
        task34();
        task35();
        task36();
        task37();
        task38();
        task39();
        task40();
    }

    public static void task01() {
        Book book1=new Book();
        Book book2=new Book("1984", "Джордж Орвелл", 1949, 320.5);
        book1.printInfo();
        book2.printInfo();
    }
    public static void task02(){
        Student student=new Student("Віталій",17,4.7);
        Student student1=new Student("Максим", 14,6);
        student.printStudent();
        student1.printStudent();
    }
    public static void task03(){
        BankAccount account=new BankAccount("125","Віталій",2000);
        BankAccount account1=new BankAccount("169","Макс",1000);
        account.deposit(1000);
        account.withdraw(1500);
        account1.deposit(500);
        account1.withdraw(2000);
        account.printAccount();
        account1.printAccount();
    }
    public static void task04(){
        Point2D a = new Point2D();
        Point2D b = new Point2D(3, 4);

        a.printPoint();
        b.printPoint();
        System.out.println("b до початку: " + b.distanceToOrigin());
        System.out.println("b до (0,0): " + b.distanceTo(0, 0));
    }
    public static void task05(){
        Product product=new Product("Монітор", 500, 4, "Техніка");
        product.printProduct();
        product.applyDiscount(20);
        System.out.println("--- Після знижки 20% ---");
        product.printProduct();
    }
    public static void task06(){
        Time time = new Time(23, 59, 58);
        System.out.println(time.toUniversalString());
        time.tick();
        System.out.println(time.toUniversalString());
        time.tick();
        System.out.println(time.toUniversalString());
        System.out.println(time.toStandardString());

    }
    public static void task07(){
        Rectangle r = new Rectangle(4.0, 2.0);
        Rectangle sq = new Rectangle(3.0);
        System.out.println("Прямокутник: площа " + r.getArea() + ", периметр " + r.getPerimeter());
        System.out.println("Квадрат: площа " + sq.getArea() + ", периметр " + sq.getPerimeter());
        System.out.println("Прямокутник — квадрат? " + r.isSquare());
        System.out.println("Квадрат — квадрат? " + sq.isSquare());

    }
    public static void task08(){
        Employee employee=new Employee(4, "Віталій Тютюнник","Java junior developer",21000);
        employee.printBadge();
        employee.raiseSalary(15);
        System.out.println("--- Після підвищення на 15% ---");
        employee.printBadge();



    }
    public static void task09(){
        User user1 = new User("vitaliy", "vitaliy@gmail.com", "ADMIN", true);
        User user2 = new User("maks", "maks@gmail.com");
        User user3 = new User("olena");
        User user4 = new User();
        user1.printProfile();
        user2.printProfile();
        user3.printProfile();
        user4.printProfile();
    }
    public static void task10(){
        Fraction fraction1 = new Fraction(4, 8);
        Fraction fraction2 = new Fraction(1, -2);
        Fraction fraction3 = new Fraction(6, -3);
        Fraction fraction4 = new Fraction(7);
        Fraction fraction5 = new Fraction();
        fraction1.print();
        fraction2.print();
        fraction3.print();
        fraction4.print();
        fraction5.print();
        System.out.println("4/8 = " + fraction1.toDouble());
        System.out.println("1/-2 = " + fraction2.toDouble());

    }
    public static void task11(){
        Car car = new Car("Toyota", "Corolla", 2023);
        car.drive(150);                                       // попередження
        car.startEngine();
        car.drive(150);
        car.stopEngine();
        car.drive(50);
        System.out.println("Пробіг після поїздки: "+car.getMileage());
    }
    public static void task12(){
        SmartBulb bulb=new SmartBulb();
        SmartBulb bulb1=new SmartBulb(50);
        SmartBulb bulb2=new SmartBulb(101, 9000, false );
        SmartBulb bulb3=new SmartBulb(100, 4500, true );
        bulb.printStatus();
        bulb1.printStatus();
        bulb2.printStatus();
        bulb3.printStatus();
    }
    public static void task13(){
        String sql = new QueryBuilder("users")
                .select("id, name, email")
                .where("age >= 18")
                .build();

        System.out.println(sql);

    }
    public static void task14(){
        CoffeeOrder order=new CoffeeOrder("Капучино");
        CoffeeOrder order1=new CoffeeOrder("Лате", "Medium");
        CoffeeOrder order2=new CoffeeOrder("Еспресо", "Large", 2, true);
        order.printReceipt();
        order1.printReceipt();
        order2.printReceipt();

    }
    public static void task15(){
        Box box1 = new Box(5, "Картон");
        Box box2 = new Box(box1);
        System.out.println("Оригінальна коробка");
        box1.printBox();
        System.out.println("        Копія        ");
        box2.printBox();
        System.out.println("Об'єми рівні: "
                + (box1.getVolume() == box2.getVolume()));

    }
    public static void task16(){
        FlightTicket ticket=new FlightTicket( "AB123",
                "Ivan Petrenko",
                "PS101",
                "Kyiv",
                "Warsaw",
                "12A",
                true);
        FlightTicket ticket1=new FlightTicket("AB123",
                "Ivan Petrenko",
                "PS101",
                "Kyiv",
                "Warsaw");
        ticket.printBoardingPass();
        ticket1.printBoardingPass();

    }
    public static void task17(){
        MathOperations math = new MathOperations();
        System.out.println(math.add(5, 3));
        System.out.println(math.add(2.5, 3.5));
        System.out.println(math.add(1, 2, 3));
        System.out.println(math.add("Hello", "World"));
        System.out.println(math.multiply(4, 5));
        System.out.println(math.multiply(2.5, 4.0));
        System.out.println(math.multiply("Hi", 3));
    }
    public static void task18(){
        DocumentPrinter printer = new DocumentPrinter();
        printer.print("Hello, world!");
        printer.print(123);
        printer.print(12.3456, 2);
        String[] lines = {"First line", "Second line", "Third line"};
        printer.print(lines);
        printer.print("hello, world!", true);

    }
    public static void task19(){
        AreaCalculator calculator = new AreaCalculator();
        System.out.println("Площа квадрата: "
                + calculator.calculateArea(5));
        System.out.println("Площа кола: "
                + calculator.calculateArea(3, true));
        System.out.println("Площа прямокутника: "
                + calculator.calculateArea(4, 6));
        System.out.println("Площа трапеції: "
                + calculator.calculateArea(4, 6, 3, true));

    }
    public static void task20(){
        Logger logger = new Logger();
        logger.log("Програма запущена");
        logger.log("WARNING", "Мало пам'яті");
        logger.log("ERROR", 404, "Сторінку не знайдено");
        logger.log("EVENT", "Користувач увійшов у систему", true);

    }
    public static void task21(){
        ArraySearcher searcher = new ArraySearcher();
        int[] numbers = {10, 20, 30, 20, 40};
        System.out.println(searcher.find(numbers, 20));
        System.out.println(searcher.find(numbers, 20, 2));
        System.out.println(searcher.find(numbers, 50));
        String[] words = {"Java", "Python", "JAVA", "C++"};
        System.out.println(searcher.find(words, "Java"));
        System.out.println(searcher.find(words, "java", false));
        System.out.println(searcher.find(words, "java", true));

    }
    public static void task22(){
        DateService date = new DateService(15, 3, 2024);
        date.add(20);
        date.printDate();
        date.add(0, 3);
        date.printDate();

    }
    public static void task23(){
        SalaryCalculator calculator = new SalaryCalculator();
        System.out.println("Зарплата без бонуса: "
                + calculator.calculate(20000));
        System.out.println("Зарплата с фиксированным бонусом: "
                + calculator.calculate(20000, 3000));
        System.out.println("Зарплата с бонусом 10% без налога: "
                + calculator.calculate(20000, 10, false));
        System.out.println("Зарплата с бонусом 10% и налогом: "
                + calculator.calculate(20000, 10, true));

    }
    public static void task24(){
        ArrayFilter filter = new ArrayFilter();
        int[] numbers = {12, 5, 8, 19, 24, 3, 16};
        System.out.println("Більше за 10: "
                + Arrays.toString(filter.filter(numbers, 10)));
        System.out.println("Діапазон від 5 до 16: "
                + Arrays.toString(filter.filter(numbers, 5, 16)));
        System.out.println("Парні числа: "
                + Arrays.toString(filter.filter(numbers, true)));
        System.out.println("Непарні числа: "
                + Arrays.toString(filter.filter(numbers, false)));

    }
    public static void task25(){
        UserAccount user1 = new UserAccount("Alex", "alex@gmail.com");
        UserAccount user2 = new UserAccount("Max", "max@gmail.com");
        UserAccount user3 = new UserAccount("Anna", "anna@gmail.com");
        System.out.println(user1.getId());
        System.out.println(user2.getId());
        System.out.println(user3.getId());

    }
    public static void task26(){
        ServerConfig.connect();
        ServerConfig.connect();
        ServerConfig.connect();
        ServerConfig.printServerStatus();
        ServerConfig.disconnect();
        ServerConfig.printServerStatus();

    }
    public static void task27(){
        System.out.println("PI = " + MathUtils.PI);
        System.out.println("E = " + MathUtils.E);
        System.out.println("Факторіал 5 = " + MathUtils.factorial(5));
        System.out.println("Степінь 2^3 = " + MathUtils.power(2, 3));
        System.out.println("Степінь 2^-2 = " + MathUtils.power(2, -2));
        System.out.println("НСД чисел 24 і 18 = " + MathUtils.gcd(24, 18));
        System.out.println("Обмеження числа 15 у діапазоні 1–10 = " + MathUtils.clamp(15, 1, 10));
    }
    public static void task28(){

        System.out.println("1000 грн у доларах: " + CurrencyExchange.uahToUsd(1000));
        System.out.println("100 доларів у гривнях: " + CurrencyExchange.usdToUah(100));
        System.out.println("100 євро у гривнях: " + CurrencyExchange.eurToUah(100));

        CurrencyExchange.updateRates(42.0, 46.0);

        System.out.println("\nПісля оновлення курсів:");
        System.out.println("1000 грн у доларах: " + CurrencyExchange.uahToUsd(1000));
        System.out.println("100 доларів у гривнях: " + CurrencyExchange.usdToUah(100));
        System.out.println("100 євро у гривнях: " + CurrencyExchange.eurToUah(100));

    }
    public static void task29(){
        FleetCar car1 = new FleetCar("VIN001", 10000);
        FleetCar car2 = new FleetCar("VIN002", 20000);
        FleetCar car3 = new FleetCar("VIN003", 15000);
        car1.addTrip(250);
        car2.addTrip(400);
        car3.addTrip(350);
        FleetCar.printFleetSummary();

    }
    public static void task30(){
        System.out.println(StringUtils.isPalindrome("А роза упала на лапу Азора"));
        System.out.println(StringUtils.reverse("Hello"));
        System.out.println(StringUtils.countVowels("Привіт, Hello"));
        System.out.println(StringUtils.maskCardNumber("1234 5678 9012 3456"));

    }
    public static void task31(){
        GameSession session1 = GameSession.createSession("Player1");
        GameSession session2 = GameSession.createSession("Player2");
        GameSession session3 = GameSession.createSession("Player3");
        GameSession session4 = GameSession.createSession("Player4");
        System.out.println("Сесія 1: " + (session1 != null));
        System.out.println("Сесія 2: " + (session2 != null));
        System.out.println("Сесія 3: " + (session3 != null));
        System.out.println("Сесія 4: " + (session4 != null));
        if (session1 != null) {
            session1.terminate();
        }
        GameSession session5 = GameSession.createSession("Player5");
        System.out.println("Сесія 5: " + (session5 != null));
    }
    public static void task32(){
        System.out.println("Відстань падіння за 5 секунд: "
                + PhysicsEngine.freeFallDistance(5) + " м");
        System.out.println("Кінетична енергія (маса 2 кг, швидкість 10 м/с): "
                + PhysicsEngine.kineticEnergy(2, 10) + " Дж");
        System.out.println("Енергія спокою 1 грама матерії: "
                + PhysicsEngine.restEnergy(0.001) + " Дж");

    }
    public static void task33(){
        LineSegment line = new LineSegment(1, 2, 5, 6);
        line.printSegment();
    }
    public static void task34(){
            ClientAccount ivan = new ClientAccount("UA001", "Іван", 10000);
            ClientAccount maria = new ClientAccount("UA002", "Марія", 2000);
            boolean result = ivan.transferTo(maria, 3500);
            System.out.println("Переказ успішний: " + result);
            System.out.println("Після переказу:");
            ivan.printAccount();
            System.out.println();
            maria.printAccount();

    }
    public static void task35(){
        Engine engine = new Engine("ENG001", 200);
        CarWithEngine car = new CarWithEngine("Toyota", "Camry", engine);
        car.printSpecs();
        car.startCar();
        System.out.println("Двигун працює: " + engine.isRunning());
        car.turnOff();
        System.out.println("Двигун працює: " + engine.isRunning());

    }
    public static void task36(){
        Processor cpu = new Processor("Intel Core i5", 3.5, 8000);
        Memory ram = new Memory(16, 3200, 2000);
        Computer computer = new Computer("Gaming PC", cpu, ram, 3000);
        System.out.println("До апгрейду:");
        computer.printSpecs();
        Memory newRam = new Memory(32, 3600, 3500);
        computer.upgradeMemory(newRam);
        System.out.println("\nПісля апгрейду:");
        computer.printSpecs();

    }
    public static void task37(){
        Hero knight = new Hero("Лицар", 100, 25, 10);
        Hero orc = new Hero("Орк", 120, 20, 5);
        System.out.println("Дуель між " + knight.getName() + " та " + orc.getName() + "!");
        while (knight.isAlive() && orc.isAlive()) {
            knight.attack(orc);
            if (orc.isAlive()) {
                orc.attack(knight);
            }
        }
        if (knight.isAlive()) {
            System.out.println("Переможець: " + "Лицар!");
        } else {
            System.out.println("Переможець: " + "Орк!");
        }
    }
    public static void task38() {
        Product1 mouse = new Product1(1, "Мишка", 500);
        Product1 keyboard = new Product1(2, "Клавіатура", 1200);
        Product1 monitor = new Product1(3, "Монітор", 5000);
        Customer customer1 = new Customer("Віталій", 10000);
        Order order1 = new Order(customer1, 5);
        order1.addProduct(mouse);
        order1.addProduct(keyboard);
        order1.addProduct(monitor);
        System.out.println("Покупка Віталія:");
        order1.checkout();
        Customer customer2 = new Customer("Анастасія", 2000);
        Order order2 = new Order(customer2, 5);
        order2.addProduct(mouse);
        order2.addProduct(keyboard);
        order2.addProduct(monitor);
        System.out.println("Покупка Анастасії: ");
        order2.checkout();
    }
    public static void task39(){ Vector3D v1 = new Vector3D(1, 2, 3);
        Vector3D v2 = new Vector3D(4, 5, 6);
        System.out.println("Перший вектор:");
        v1.printVector();
        System.out.println("Другий вектор:");
        v2.printVector();
        System.out.println("Сума векторів:");
        v1.add(v2).printVector();
        System.out.println("Скалярний добуток: " + v1.dotProduct(v2));
        System.out.println("Векторний добуток:");
        v1.crossProduct(v2).printVector();
        System.out.println("Вектори ортогональні: " + v1.isOrthogonalTo(v2));
        Vector3D v3 = new Vector3D(1, 0, 0);
        Vector3D v4 = new Vector3D(0, 1, 0);
        System.out.println("Інші вектори ортогональні: " + v3.isOrthogonalTo(v4));

    }
    public static void task40(){
        LibraryCatalog library = new LibraryCatalog(5);
        BookItem book1 = new BookItem("111", "Кобзар", "Тарас Шевченко");
        BookItem book2 = new BookItem("222", "Лісова пісня", "Леся Українка");
        BookItem book3 = new BookItem("333", "Тигролови", "Іван Багряний");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.printCatalog();
        System.out.println("Перша спроба взяти книгу:");
        library.borrowBook("Кобзар");
        library.printCatalog();
        System.out.println("Друга спроба взяти ту саму книгу:");
        library.borrowBook("Кобзар");
        library.printCatalog();

    }

}
