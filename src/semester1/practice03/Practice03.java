package semester1.practice03;

import java.util.Scanner;

public class Practice03 {
    public static void main(String[] args) {
        //Завдання 1
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.print("Введіть ім'я: ");
        String name=scanner.nextLine();
        System.out.print("Введіть прізвище: ");
        String surname= scanner.nextLine();
        System.out.print("Введіть вік: ");
        int age= scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введіть місце проживання: ");
        String sity= scanner.nextLine();
        System.out.println("=== ВХІДНІ ДАНІ ===");
        System.out.println("Ім'я: "+name);
        System.out.println("Прізвище: "+surname);
        System.out.println("Вік: "+age);
        System.out.println("Місто: "+sity);
        System.out.println("-------------------");
        System.out.println("Привіт, "+name+" "+surname+" з міста "+sity+"! "+"Твій вік: "+age+" р.");

         */


        //Завдання 2
        /*
        System.out.print("Введіть перше число: ");
        Scanner scanner=new Scanner(System.in);
        int a = scanner.nextInt();

        System.out.print("Введіть друге число: ");
        int b = scanner.nextInt();

        System.out.println("Сума: " + (a + b));
        System.out.println("Різниця: " + (a - b));
        System.out.println("Добуток: " + (a * b));
        System.out.println("Остача від ділення: " + (a % b));
         */
        //Завдання 3
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.print("Введіть суму в гривнях (UAH): ");
        double Uah= scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Введіть курс USD: ");
        double Usd= scanner.nextDouble();
        scanner.nextLine();
        double dollars=Math.round(Uah/Usd);
        System.out.printf("Сума до видачі: "+dollars+" Usd");
        */
        //Завдання 4
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.print("Введіть номер студентського квитка: ");
        int id=scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введіть повне ім'я студента: ");
        String name=scanner.nextLine();
        System.out.print("Введіть спціальність: ");
        String speciality= scanner.nextLine();
        System.out.println("Студент: "+name+", квиток №"+id+", спеціальність: "+speciality);
         */
        //Завдання 5
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Ваш зріст (м): ");
        double height=scanner.nextDouble();
        System.out.printf("Ваша вага (кг): ");
        double weight= scanner.nextDouble();
        double index =weight/Math.pow(height,2);
        System.out.println("Розрахований BMI: "+index);
         */
        //Завдання 6
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Ваша улюблена літера: ");
        char ch= scanner.next().charAt(0);
        System.out.println("Символ: " + ch + " | Код символу: " + (int) ch);
        */
        //Завдання 7
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Катет A: ");
        double A= scanner.nextDouble();
        System.out.printf("Катет B: ");
        double B= scanner.nextDouble();
        double C=Math.sqrt(Math.pow(A,2)+Math.pow(B,2));
        System.out.println("Гіпотенуза: "+C);
        double perimeter=A+B+C;
        System.out.println("Периметр: "+perimeter);
        double area=(A+B)/2;
        System.out.println("Площа: "+area);
         */
        //Завдання 8
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Товар: ");
        String item=scanner.nextLine();
        System.out.printf("Ціна: ");
        double price= scanner.nextDouble();
        System.out.printf("Кількість: ");
        int number= scanner.nextInt();
        double total=number*price;
        double vat =total*0.20;
        System.out.println("Загальна сума: "+total+" грн"+"( з них ПДВ 20%: "+vat+" грн)");
         */
        //Завдання 9
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введіть число: ");
        int number = scanner.nextInt();
        if (number > 0) {
            System.out.println("Число додатне.");
        } else if (number < 0) {
            System.out.println("Число від'ємне.");
        } else if (number == 0) ;
        System.out.println("Число рівне нулю");}
    */
        /*
        //Завдання 10
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введіь число: ");
        int number = scanner.nextInt();
        if (number == 0) {
            System.out.println("Число є нулем");
        } else if (number % 2 == 0){
        System.out.println("Число " + number + " є додатнім");
        } else if (number%2 !=0);{
            System.out.println("Число "+number+" є непарним");
        }
        */
        //Завдання 11
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Введіть вік користувача: ");
        int age= scanner.nextInt();
        if (age>120 && age<0){
            System.out.println("Некоректний вік");
        }else if (age>0&&age<=12){
            System.out.println("Дитина");
        }else if (age>=13&&age<=17){
            System.out.println("Підліток");
        }else if (age>=18&&age<=64){
            System.out.println("Дорослий");
        }else if(age>=65){
            System.out.println("Пенсіонер");
        }
         */
        //Завдання 12
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Введіть підсумковий бал: ");
        int score= scanner.nextInt();
        if (score < 0 || score > 100) {
            System.out.println("Помилка: некоректний бал!");
        } else if (score <= 59) {
            System.out.println("Незадовільно (F)");
        } else if (score <= 63) {
            System.out.println("Достатньо (E)");
        } else if (score <= 73) {
            System.out.println("Задовільно (D)");
        } else if (score <= 81) {
            System.out.println("Добре (C)");
        } else if (score <= 89) {
            System.out.println("Дуже добре (B)");
        } else {
            System.out.println("Відмінно (A)");
        }
         */
        /*
        //Завдання 13
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введіть три цілих числа: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int max = a;
        int min = a;
        if (b > max) {
            max = b;
        }
        if (b < min) {
            min = b;
        } if (c > max) {
                max = c;
            }
            if (c < min) {
                min = c;
            }
        System.out.println("Максимум: "+max);
        System.out.println("Мінімум: "+min);
         */
        //Завдання 14
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введіть X: ");
        double X= scanner.nextDouble();
        System.out.printf("Введіть Y: ");
        double Y= scanner.nextDouble();
        if (X == 0 && Y == 0) {
            System.out.println("Точка (" + X + "; " + Y + ") знаходиться на початку координат");
        } else if (X == 0) {
            System.out.println("Точка (" + X + "; " + Y + ") знаходиться на осі Y");
        } else if (Y == 0) {
            System.out.println("Точка (" + X + "; " + Y + ") знаходиться на осі X");
        } else if (X > 0 && Y > 0) {
            System.out.println("Точка (" + X + "; " + Y + ") знаходиться у I чверті");
        } else if (X < 0 && Y > 0) {
            System.out.println("Точка (" + X + "; " + Y + ") знаходиться у II чверті");
        } else if (X < 0 && Y < 0) {
            System.out.println("Точка (" + X + "; " + Y + ") знаходиться у III чверті");
        } else if (X > 0 && Y < 0) {
            System.out.println("Точка (" + X + "; " + Y + ") знаходиться у IV чверті");
        }
        */
        //Завдання 15
        /*
        int x = 5;
        int y = 20;
        // Без {} else прив'язується до найближчого if — if (y > 10)
        // if (x > 10)
        //     if (y > 10)
        //         System.out.println("x > 10 і y > 10");
        //     else
        //         System.out.println("y <= 10");
        // {} дозволяють явно прив'язати else до зовнішнього if
        if (x > 10) {
            if (y > 10) {
                System.out.println("x > 10 і y > 10");
            }
        } else {
            System.out.println("x <= 10");
        }
         */
        //Задвання 16
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введіть обсяг спожитої електроенергії (в кВт·год):");
        double consumption = scanner.nextInt();
        double tariff;
        if (consumption <= 100) {
            tariff = consumption * 2.64;
        } else {
            tariff = 100 * 2.64 + (consumption - 100) * 4.32;
        }

        System.out.println("Сума до сплати: " + tariff + " грн");
        */
         //Завдання 17
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введіть два цілих числа: ");
        int x=scanner.nextInt(); int y= scanner.nextInt();
        int max = (x > y) ? x : y;
        System.out.println(max+ "більше");
         */
        //Завдання 18
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введіть число для знаходження модуля: ");
        int n= scanner.nextInt();
        int abs = (n < 0) ? -n : n;
        System.out.println("Модуль="+abs);
         */
        //Завдання 19
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введіть число: ");
        int n=scanner.nextInt();
        String result=(n%2==0)?"Парне":"Непарне";
        System.out.println(result);
         */
        //Завдання 20
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введіть бал: ");
        int score= scanner.nextInt();
        String result=(score>=60)?"Зараховано":"Незараховано";
        System.out.println("Результат: "+result);
         */
        //Завдання 21
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введіть чило: ");
        int n= scanner.nextInt();
        String status = (n > 0) ? "Додатне" : (n < 0) ? "Від'ємне" : "Нуль";
        System.out.println("Число: "+status);
         */
        //Завдання 22
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введіть суму покупки: ");
        double price= scanner.nextInt();
        double finalPrice=(price>=1000)?price-(price*0.1):price-(price*0.02);
        System.out.println("Сума покупки: "+price+" грн");
        System.out.println("До сплати зі знижкою: "+finalPrice);
         */
        //Завдання 23
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введіть ділене: ");
        double a= scanner.nextDouble();
        System.out.printf("Введіть дільник: ");
        double b= scanner.nextDouble();
        String result = b != 0 ? String.valueOf(a / b) : "Помилка: ділення на нуль неможливе!";
        System.out.println(result);
         */
        //Завдання 24
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введіть кількість помилок: ");
        int count= scanner.nextInt();
        String result = (count == 1) ? "Знайдено 1 помилку" : "Знайдено " + count + " помилок";
        System.out.println(result);
         */
        //Завдання 25
        /*
        int x = 10; int divisor = 0;
        if (divisor != 0 && (x / divisor > 1)) {
            System.out.println("Успішне ділення");
        } else {
            System.out.println("Ділення безпечно пропущено завдяки short-circuit!");
        }
        // && використовує short-circuit: якщо divisor != 0 — false,
        // друга умова (x / divisor > 1) взагалі не перевіряється,
        // тому ділення на 0 не виконується і ArithmeticException не виникає.
         */
        //Завдання 26
        /*
        int counter1=0; int counter2=0;
        boolean b1 = false && (++counter1 > 0);
        boolean b2 = false & (++counter2 > 0);
        System.out.println("counter1 = " + counter1);
        System.out.println("counter2 = " + counter2);
        // && використовує short-circuit
        // оскільки перша частина false, друга частина (++counter1 > 0)
        // взагалі не виконується. Тому counter1 залишається 0.
        // & не використовує short-circuit:
        // навіть якщо перша частина false, друга частина все одно виконується.
        // Тому ++counter2 збільшує counter2 до 1.
         */
        //Завдання 27
        /*
        int number = 5;
        if (number > 0 || (10 / 0 == 0)) {
            System.out.println("Умова виконана, аварійне ділення не викликалося!");
        }
        // || працює так, якщо перша умова правильна, друга взагалі не перевіряється
         */
        //Завдання 28
        /*
        int counterA = 0; int counterB = 0;
        boolean test1 = true || (++counterA > 0);
        boolean test2 = true | (++counterB > 0);
        // | він перевіряє обидві частини, навіть якщо перша вже true.
         */
        //Завдання 29
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть години: ");
        int hours = scanner.nextInt();
        System.out.print("Введіть хвилини: ");
        int minutes = scanner.nextInt();
        boolean isValidTime = (hours >= 0 && hours <= 23)
                && (minutes >= 0 && minutes <= 59);
        if (isValidTime) {
            System.out.printf("Час: %02d:%02d%n", hours, minutes);
        } else {
            System.out.println("Помилка: некоректний час!");
        }

         */

        //Завдання 30
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Введіть сторону трикутника a: ");
        int a= scanner.nextInt();
        System.out.printf("Введіть сторону трикутника b: ");
        int b= scanner.nextInt();
        System.out.printf("Введіть сторону трикутника с: ");
        int c= scanner.nextInt();
        boolean exists = (a + b > c) && (a + c > b) && (b + c > a);
        System.out.println("Трикутник існує: " + exists);
         */
        //Завдання 31
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Введіть число: ");
        int n= scanner.nextInt();
        boolean isEvenBitwise = (n & 1) == 0;
        boolean isEvenNormal = n % 2 == 0;
        System.out.println(isEvenBitwise);
        System.out.println(isEvenNormal);
        // Оператор & порівнює біти числа з 1.
        // Число 1 у двійковій системі: 0001.
        // Тому n & 1 залишає тільки молодший (останній) біт.
        //
        // Якщо останній біт 0 → число парне.
        // Якщо останній біт 1 → число непарне.
         */
        /*
        //Завдання 32
        boolean isPinCorrect = true;
        boolean isCardActive = true;
        boolean hasSufficientBalance = true;
        boolean isDailyLimitExceeded = false;
        boolean transactionAllowed = isPinCorrect && isCardActive && hasSufficientBalance && !isDailyLimitExceeded;
        System.out.println("Транзакція дозволена: " + transactionAllowed);
         */
        //Завдання 33
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.print("Введіть число тижня (1-7): ");
        int day = scanner.nextInt();
        switch (day){
            case 1:
                System.out.println("Понеділок");
                break;
            case 2:
                System.out.println("Вівторок");
                break;
            case 3:
                System.out.println("Середа");
                break;
            case 4:
                System.out.println("Четверг");
                break;
            case 5:
                System.out.println("П'ятниця");
                break;
            case 6:
                System.out.println("Субота");
                break;
            case 7:
                System.out.println("Неділя");
                break;
            default:
                System.out.println("Некоректний номер дня");
        }

         */
        //Завдання 34
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер дня тижня (1-7): ");
        int day = scanner.nextInt();
        switch (day) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Будній (робочий) день");
                break;
                case 6:
                    case 7:
                System.out.println("Вихідний день");
                break;
                default:
                System.out.println("Помилка: введіть число від 1 до 7");
        }
         */
        //Завдання 35
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер місяця (1-12): ");
        int month = scanner.nextInt();
        int days = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;
            default -> 0;
        };
        if (days == 0) {
            System.out.println("Помилка: такого місяця немає");
        } else {
            System.out.println("Кількість днів: " + days);
        }
         */
        //Завдання 36
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть місяць: ");
        String month = scanner.nextLine();
        String season = switch (month) {
            case "грудень", "січень", "лютий" -> "Зима";
            case "березень", "квітень", "травень" -> "Весна";
            case "червень", "липень", "серпень" -> "Літо";
            case "вересень", "жовтень", "листопад" -> "Осінь";
            default -> "Некоректна назва місяця";
        };
        System.out.println("Пора року: " + season);
         */
        //Завдання 37
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Оберіть спосіб доставки (1 - Самовивіз, 2 - Кур'єр, 3 - Поштомат): ");
        int delivery = scanner.nextInt();
        System.out.print("Введіть вагу товару (кг): ");
        double weight = scanner.nextDouble();
        int price = switch (delivery) {
            case 1 -> 0;
            case 2 -> {
                if (weight > 5) {
                    yield 150;
                } else {
                    yield 90;
                }
            }
            case 3 -> 60;
            default -> -1;
        };
        if (price == -1) {
            System.out.println("Некоректний вибір способу доставки");
        } else {
            System.out.println("Вартість доставки: " + price + " грн.");
        }
        */
        //Завдання 38
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Число 1: ");
        double a = scanner.nextDouble();
        System.out.print("Оберіть операцію (+, -, *, /): ");
        char op = scanner.next().charAt(0);
        System.out.print("Число 2: ");
        double b = scanner.nextDouble();
        double result = switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) {
                    System.out.println("Помилка: ділення на нуль!");
                    yield 0;
                } else {
                    yield a / b;
                }
            }
            default -> {
                System.out.println("Помилка: невідома операція!");
                yield 0;
            }
        };
        System.out.println("Результат: " + result);
         */
        //Завдання 39
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть команду: ");
        String command = scanner.nextLine();
        // == порівнює посилання на об'єкти String,
        // а не сам текст, тому command == "start" може дати false,
        // навіть якщо command містить текст "start".
        if (command == "start") {
            System.out.println("Команда start через == ");
        }
        // Безпечна перевірка тексту без врахування регістру
        if (command.equalsIgnoreCase("start")) {
            System.out.println("Система успішно запущена!");
        }
        // Обробка всіх команд через modern switch
        switch (command.toLowerCase()) {
            case "start" -> System.out.println("Система успішно запущена!");
            case "pause" -> System.out.println("Система призупинена!");
            case "stop" -> System.out.println("Система зупинена!");
            case "exit" -> System.out.println("Вихід із системи...");
            default -> System.out.println("Невідома команда!");
        }
         */
        //Завдання 40
        Scanner scanner = new Scanner(System.in);
        System.out.println("================ БАНКОМАТ ================");
        System.out.print("Введіть PIN: ");
        int pin = scanner.nextInt();
        if (pin == 1234) {
            System.out.println("Авторизація успішна!");
            double balance = 5000.0;
            boolean running = true;
            while (running) {
                System.out.println();
                System.out.println("Оберіть дію:");
                System.out.println("1 - Баланс");
                System.out.println("2 - Поповнення");
                System.out.println("3 - Зняття");
                System.out.println("4 - Вихід");
                System.out.print("Ваш вибір: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Ваш баланс: " + balance + " грн");
                    }
                    case 2 -> {
                        System.out.print("Введіть суму поповнення: ");
                        double amount = scanner.nextDouble();
                        if (amount > 0) {
                            balance += amount;
                            System.out.println("Рахунок поповнено!");
                            System.out.println("Новий баланс: " + balance + " грн");
                        } else {
                            System.out.println("Некоректна сума!");
                        }
                    }
                    case 3 -> {
                        System.out.print("Введіть суму зняття: ");
                        double amount = scanner.nextDouble();
                        // && — "лінива" перевірка:
                        // друга умова перевіряється тільки якщо amount > 0
                        if (amount > 0 && amount <= balance) {
                            // Якщо сума > 1000, комісія 1%, інакше 0
                            double commission = amount > 1000 ? amount * 0.01 : 0;
                            balance -= amount + commission;
                            System.out.println("Комісія операції: "
                                    + commission + " грн");
                            System.out.println("Видано: " + amount
                                    + " грн. Залишок на рахунку: "
                                    + balance + " грн");
                        } else {
                            System.out.println("Недостатньо коштів або некоректна сума!");
                        }
                    }
                    case 4 -> {
                        System.out.println("Дякуємо за використання банкомата!");
                        running = false;
                    }
                    default -> {
                        System.out.println("Некоректний вибір!");
                    }
                }
            }
        } else {
            System.out.println("Невірний PIN! Програма завершена.");
        }
        scanner.close();




































    }
    }

