
package semester1.practice06;

import java.sql.SQLOutput;

public class Practice06 {
    public static void main(String[] args) {
       // task01();
       // task02();
       // task03();
       // task04();
       // task05();
       // task06();
       // task07():
       // task08();
       // task09();
       // task10();
       // task11();
       // task12();
       // task13();
       // task14();
       // task15();
       // task16();
       // task17();
       // task18();
       // task19();
       // task20();
       // task21();
       // task22();
       // task23();
       // task24();
       // task25();
       // task26();
       // task27();
       // task28();
       // task29();
       // task30();
       // task31();
       // task32();
       // task33();
       // task34();
       // task35();
       // task36();
       // task37();
       // task38();
       // task39();
        task40();





    }
    public static void task01(){
        Student s1=new Student();
        s1.name="Денис";
        s1.age=19;
        s1.gpa=4.75;
        System.out.println(s1.name+", "+s1.age+", "+s1.gpa);

    }
    public static void task02(){
        Car car1 = new Car();
        Car car2 = new Car();
        car1.brand="Toyota"; car2.brand="BMW";
        car1.model="Camry"; car2.model="M5";
        car1.year=2021; car2.year=2023;
        car1.speed=180; car2.speed=250;
        System.out.println("Перший автомобіль: " + car1.brand + ", " + car1.model + ", " + car1.year + ", " + car1.speed);
        System.out.println("Другий автомобіль: " + car2.brand + ", " + car2.model + ", " + car2.year + ", " + car2.speed);
        if (car1.year > car2.year) {
            System.out.println("Новіший автомобіль: " + car1.brand);
        } else if (car2.year > car1.year) {
            System.out.println("Новіший автомобіль: " + car2.brand);
        } else {
            System.out.println("Обидва автомобілі одного року випуску");
        }


    }
    public static void task03(){
        Book emptyBook = new Book();

        System.out.println(emptyBook.author);
        System.out.println(emptyBook.isRead);
        System.out.println(emptyBook.pages);
        System.out.println(emptyBook.title);

    }
    public static void task04(){
        Rectangle rectangle=new Rectangle();
        rectangle.width=7.5;
        rectangle.height=4.0;
        double area=rectangle.height*rectangle.width;
        double perimeter=2*(rectangle.height+rectangle.width);
        System.out.println("Площа="+area);
        System.out.println("Периметр="+perimeter);


    }
    public static void task05(){
        Product monitor=new Product();
        monitor.name="Монітор";
        monitor.price=6500.0;
        monitor.quantity=8;
        double totalPrice= monitor.price* monitor.quantity;
        System.out.println(monitor.name+"; ");
        System.out.println("Кількість: "+monitor.quantity);
        System.out.println("Ціна: "+monitor.price);
        System.out.println("Загальна вартість усієї партії: "+totalPrice+" грн");

    }
    public static void task06(){
        Smartphone smartphone=new Smartphone();
        smartphone.model="Xiaomi";
        smartphone.batteryLevel=100;
        smartphone.isTurnedOn=true;
        smartphone.batteryLevel=100-35;
        if (smartphone.batteryLevel==0){
            smartphone.isTurnedOn=false;
        }
        System.out.println("Модель: " + smartphone.model);
        System.out.println("Заряд батареї: " + smartphone.batteryLevel + "%");
        System.out.println("Телефон увімкнений: " + smartphone.isTurnedOn);


    }
    public static void task07(){
        Point2D A=new Point2D();
        Point2D B=new Point2D();
        A.x=0; B.x=3;
        A.y=0; B.y=4;
        double d=Math.sqrt(Math.pow(B.x - A.x,2)
                +Math.pow(B.y-A.y,2));
        System.out.println("Відстань між точками: "+d);

    }
    public static void task08(){
        Student first=new Student();
        first.name = "Іван";
        Student second = first;
        second.name = "Петро";
        System.out.println(first.name);
        // first і second посилаються на один об'єкт,
        // тому зміна імені через second змінює його і для first.


    }
    public static void task09(){
        Greeter greeter=new Greeter();
        greeter.sayHello();
        greeter.sayHelloTo(" Поліна ");
    }
    public static void task10(){
        Animal dog=new Animal();
        Animal cat=new Animal();
        dog.name="Лорд";
        dog.species="Бродяга";
        cat.name="Саня";
        cat.species="Пантера";
        dog.printInfo();
        dog.makeSound();
        System.out.println();
        cat.printInfo();
        cat.makeSound();


    }
    public static void task11(){
        Counter counter=new Counter();
        counter.increment();
        counter.increment();
        counter.increment();
        counter.decrement();
        counter.printCount();


    }
    public static void task12(){
        TrafficLight light=new TrafficLight();
        light.changeColor("Червоний");
        light.showSignal();
        light.changeColor("Жовтий");
        light.showSignal();
        light.changeColor("Зелений");
        light.showSignal();




    }
    public static void task13(){
        Player player=new Player();
        player.nickname="Fakumram";
        System.out.println("Початкове здоров'я: "+player.health);
        player.takeDamage(40);
        System.out.println("Здоров'я після шкоди: "+player.health);
        player.takeDamage(40);
        System.out.println("Здоров'я після шкоди: "+player.health);
        player.takeDamage(40);
        System.out.println("Здоров'я після шкоди: "+player.health);



    }
    public static void task14(){
        Lamp lamp=new Lamp();
        lamp.turnOn();
        lamp.status();
        lamp.toggle();
        lamp.status();


    }
    public static void task15(){
        Stopwatch stopwatch=new Stopwatch();
        stopwatch.addSeconds(100);
        stopwatch.tick();
        stopwatch.displayTime();

    }
    public static void task16(){
        Printer printer=new Printer();
        printer.model="Asus tuf Gaming";
        printer.paperCount=10;

        printer.printDocument(" Практична 6 ", 3 );
        System.out.println();
        printer.printDocument(" Код ", 6);
        System.out.println();
        printer.printDocument(" Презентація ", 4);
        System.out.println();

    }
    public static void task17(){
        SimpleCalculator calculator=new SimpleCalculator();
        int sum= calculator.add(15,10);
        int product= calculator.multiply(45,100);
        int subtract= calculator.subtract(10,15);
        double divide=calculator.divide(100,0);
        System.out.println("Сума: " + sum);
        System.out.println("Добуток: " + product);
        System.out.println("Різниця: " + subtract);
        System.out.println("Ділення: " + divide);

    }
    public static void task18(){
        Circle circle=new Circle();
        circle.radius=5.0;
        double area=circle.getArea();
        double length= circle.getCircumference();
        System.out.println("Площа кола: "+area);
        System.out.println("Довжина кола: "+length);

    }
    public static void task19(){
        TemperatureConverter converter=new TemperatureConverter();
        double fahrenheit = converter.celsiusToFahrenheit(25);
        double celsius = converter.fahrenheitToCelsius(fahrenheit);
        System.out.println("25 градусів Цельсія у Фаренгейтах: " + fahrenheit);
        System.out.println("Цельсії: " + celsius);

    }
    public static void task20(){
        NumberChecker checker = new NumberChecker();

        System.out.println("Число 7:");
        System.out.println("Парне: " + checker.isEven(7));
        System.out.println("Додатне: " + checker.isPositive(7));
        System.out.println("Просте: " + checker.isPrime(7));
        System.out.println();
        System.out.println("Число 12:");
        System.out.println("Парне: " + checker.isEven(12));
        System.out.println("Додатне: " + checker.isPositive(12));
        System.out.println("Просте: " + checker.isPrime(12));
        System.out.println();
        System.out.println("Число -5:");
        System.out.println("Парне: " + checker.isEven(-5));
        System.out.println("Додатне: " + checker.isPositive(-5));
        System.out.println("Просте: " + checker.isPrime(-5));

    }
    public static void task21(){
        CurrencyExchange exchange=new CurrencyExchange();
        double usd=exchange.toUSD(10000.0);
        System.out.printf("10.000 грн в доларах: "+usd);
        double uah=exchange.toUAH(usd);
        System.out.println("Назад в гривні: "+uah);

    }
    public static void task22(){
        Employee employee=new Employee();
        employee.name="Віталій";
        employee.baseSalary=30000.0;
        employee.bonusPercentage=15;
        System.out.println("Ім'я: " + employee.name);
        System.out.println("Базова зарплата: " + employee.baseSalary + " грн");
        System.out.println("Бонус: " + employee.bonusPercentage + "%");
        System.out.println("Повна зарплата: " + employee.calculateTotalSalary() + " грн");
        System.out.println("Податок: " + employee.calculateTax() + " грн");


    }
    public static void task23(){
        TextFormatter formatter = new TextFormatter();

        String text = "Факумрам";

        System.out.println(formatter.formatTitle(text));
        System.out.println("Кількість голосних: " + formatter.countVowels(text));

    }
    public static void task24(){
        Triangle triangle = new Triangle();
        triangle.a = 3;
        triangle.b = 4;
        triangle.c = 5;
        System.out.println("Трикутник існує: " + triangle.isValid());
        System.out.println("Периметр: " + triangle.getPerimeter());
        System.out.println("Площа: " + triangle.getArea());

    }
    public static void task25(){
        SecretVault vault=new SecretVault();
       // secretCode has private access in semester1.practice06.SecretVault
        System.out.println("Правильний код: " + vault.verifyCode("Pass123"));
        System.out.println("Неправильний код: " + vault.verifyCode("hacked"));
    }
    public static void task26(){
        UserAccount account = new UserAccount();

        account.setCredentials("student", "12345");

        System.out.println("Вхід: " + account.login("student", "12345"));
        System.out.println("Неправильний вхід: " + account.login("student", "11111"));

        account.changePassword("12345", "54321");

        System.out.println("Вхід з новим паролем: " + account.login("student", "54321"));

    }
    public static void task27(){
        BankAccount account=new BankAccount();
        account.deposit(20000);
        System.out.println("Баланс: "+account.getBalance()+" грн");
        boolean result= account.withdraw(20001);
        System.out.println("Зняття успішне: "+result);
        System.out.println("Поточний баланс: "+account.getBalance());


    }
    public static void task28(){
        Thermometer thermometer=new Thermometer();
        thermometer.setTemperature(35);
        System.out.println("Температура: "+thermometer.getTemperature());
        thermometer.setTemperature(-300);
        System.out.println("Температура: "+thermometer.getTemperature());

    }
    public static void task29(){
        CarSpeedometer speedometer=new CarSpeedometer();
        speedometer.accelerate(300);
        System.out.println("Після тапки в пол швидкість: "+speedometer.getSpeed()+" км/год");
        speedometer.brake(350);
        System.out.println("Після поцілунку стовба швидкість: "+speedometer.getSpeed()+" км/год");

    }
    public static void task30(){
        Person demyd=new Person();
        Person polina=new Person();
        demyd.setName("Демид");
        demyd.setAge(22);
        polina.setName("Поліна");
        polina.setAge(19);
        demyd.printSummary();
        System.out.println();
        polina.printSummary();

    }
    public static void task31(){
        DiscountCard card=new DiscountCard();
        card.setOwnerName("Віталій");
        card.addPurchase(3000);
        card.printCardInfo();
        System.out.println();
        card.addPurchase(4000);
        card.printCardInfo();

    }
    public static void task32(){
        SmartDoorLock lock=new SmartDoorLock();
        lock.enterPin(123);
        lock.enterPin(231);
        lock.enterPin(212);


    }
    public static void task33(){
        GradeBook book=new GradeBook();
        int[] grade={85, 92, 78, 96, 65};
        book.setData("Віталій",grade);
        System.out.println("Середній бал: "+book.getAverage());
        System.out.println("Максимальна оцінка: "+book.getHighestGrade());
        System.out.println("Мінімальна оцінка: "+book.getLowestGrade());

    }
    public static void task34(){
        ArrayStats stats=new ArrayStats();
        int[] numbers={10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        stats.setData(numbers);
        System.out.println("Кількість парних чисел: "+stats.countEvens());
        System.out.println("Кількість непарних чисел: "+stats.countOdds());
        System.out.println("Сума всіх елементів: "+stats.calculateSum());

    }
    public static void task35(){
        ShoppingCart cart=new ShoppingCart();
        cart.addItem(2000);
        cart.addItem(1350);
        cart.addItem(543);
        System.out.println("*****   Check   *****");
        System.out.println("Загальна сума: "+cart.getTotalCost());
        cart.applyDiscount(7);
        System.out.println("*****   Check   *****");
        System.out.println("Сума зі знижкою: "+cart.getTotalCost());

    }
    public static void task36(){
        TemperatureTracker tracker = new TemperatureTracker();
        double[] temps = {18.5, 21.0, 19.3, 24.5, 22.0, 26.1, 20};
        tracker.setTemps(temps);
        tracker.printWeeklyReport();
        System.out.println("Днів вище 20 °C: " + tracker.countDaysAbove(20));

    }
    public static void task37(){
        ArraySearcher searcher = new ArraySearcher();
        int[] numbers = {15, 67, 27, 43, 15};
        searcher.setData(numbers);
        System.out.println("Число 67 є в масиві: " + searcher.contains(67));
        System.out.println("Індекс числа 67: " + searcher.findIndex(67));
        System.out.println("Число 100 є в масиві: " + searcher.contains(100));
        System.out.println("Індекс числа 100: " + searcher.findIndex(100));

    }
    public static void task38(){
        Vector3D vector=new Vector3D();
        vector.setCoords(2,3,6 );
        System.out.println("Довжина вектора: "+vector.getMagnitude());
        vector.multiplyByScalar(2);
        System.out.print("Вектор після множення на 2: ");
        vector.printVector();

    }
    public static void task39(){
        Matrix2D matrix = new Matrix2D();
        int[][] numbers = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        matrix.setGrid(numbers);
        System.out.println("Матриця:");
        matrix.printMatrix();
        System.out.println("Сума всіх чисел: " + matrix.getTotalSum());
        System.out.println("Сума другого рядка: " + matrix.getRowSum(1));
    }
    public static void task40() {
        MatrixDiagonals matrix = new MatrixDiagonals();
        int[][] numbers = {
                {6, 7, 6},
                {7, 6, 7},
                {6, 7, 6}
        };
        matrix.setMatrix(numbers);
        System.out.println("Сума головної діагоналі: " + matrix.getMainDiagonalSum());
        System.out.println("Сума побічної діагоналі: " + matrix.getAntiDiagonalSum());
        System.out.println("Діагоналі симетричні за сумою: " + matrix.isDiagonalSymmetric());
    }
}
