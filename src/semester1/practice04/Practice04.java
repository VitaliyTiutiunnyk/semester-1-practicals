package semester1.practice04;

import java.util.Scanner;

public class Practice04 {
    public static void main(String[] args) {
        //Завдання 1
        /*
        for (int i=0; i<7;i++){
            System.out.println("Java - надійна та кросплатформна мова!");

        */
        //Завдання 2
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Введіть текст: ");
        String text= scanner.nextLine();
        System.out.printf("Введіть ціле число(>1): ");
        int number= scanner.nextInt();
        scanner.nextLine();
        for (int i=1; i<=number;i++ ){
            System.out.print("["+i+"]"+text);
            if(i<number){
                System.out.print(", ");

            }else {
                System.out.print(".");
            }
        }
         */
        //Завдання 3
        /*
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        for (int i = 1; i <= 12; i++) {
            a = a + 500;
            System.out.print("Місяць " + i + ": " + a + " грн");
            if (i < 12) {
                System.out.print(", ");
            } else {
                System.out.print(".");

            }

        }
        */
        //Завдання 4
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Введіть поточний курс євро до гривні(0.00): ");
        double rate= scanner.nextDouble();
        for (int i=10; i<=100; i=i+10){
            double result=i*rate;
            System.out.println(i+" євро = "+result+" грн ");


         */
        //Завдання 5
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Введіть ширину рамки W(>0): ");
        int a= scanner.nextInt();
        for (int i=1; i<=a; i++ ){
            System.out.print("=");

        }
         */
        //Завдання 6
        /*
        int i=10;
        while (i>=1){
            System.out.println(i);
            i--;
            if (i<1) {
                System.out.println("Поїхали! Ракета запущена!");
            }
            }
        */
        //Завдання 7
        /*
        Scanner scanner = new Scanner(System.in);
        int number;
        int sum = 0;
        while (true) {
            number = scanner.nextInt();
            scanner.nextLine();
            if (number == 0) {
                break;
            }
            sum += number;
        }
        System.out.println("Сума: " + sum);

         */
        //Завдання 8
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введіть число(>1): ");
        int a= scanner.nextInt();
        int i=2;
        while (i<=a){
            System.out.println(i);
            i*=2;


        }

         */
        //Завдання 9
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число: ");
        int number = scanner.nextInt();
        int count = 0;
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            count++;
            number = number / 10;
        }
        System.out.println("Кількість цифр: " + count);
        System.out.println("Сума цифр: " + sum);

         */
        //Завдання 10
        /*
       int a =12345;
       int reversed=0;
       while (a>0){
           int b=a%10;
            reversed=reversed*10+b;
           a/=10;
       }
        System.out.println(reversed);

         */
        //Завдання 11
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Введіть суму депозиту: ");
        double money = scanner.nextDouble();
        System.out.printf("Введіть річний відсоток P: ");
        double p = scanner.nextDouble();
        int years = 0;
        double money2=money;
        if (p <= 0) {
            System.out.println("Відсоток має бути додатним");
        } else {
            while (money < money2 * 2) {
                money = money + money * p / 100;
                years++;
            }
            System.out.println("Через " + years + " років");
            System.out.println("Сума депозиту збільшиться вдвічі " + money);
        }

         */
        //Завдання 12
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Введіть число N(>1)");
        int number= scanner.nextInt();
        int determinate=2;
        while (number%determinate!=0){
            determinate++;
        }
        System.out.println("Найменший дільник: "+determinate);

         */
        //Завдання 13
        /*
        Scanner scanner=new Scanner(System.in);
        int gift= (int)(Math.random() * 100) + 1;
        int attempts=0;
        int number;
        System.out.printf("Вгадайте число(від 1 до 100): ");
        number= scanner.nextInt();
        attempts++;
        while (number!=gift){
            if (number<gift){
                System.out.println("Більше!");
            }else {
                System.out.println("Менше!");
            }
            System.out.printf("Спробуйте ще раз: ");
            number=scanner.nextInt();
            attempts++;
        }
        System.out.println("Ви вгадали число: "+gift);
        System.out.println("Кількість спроб: "+attempts);

         */
        //Завдання 14
        /*
        Scanner scanner=new Scanner(System.in);
        int a;
        do {
            System.out.println("1. Розпочати нову гру");
            System.out.println("2. Завантажити збереження");
            System.out.println("3. Налаштування");
            System.out.println("0. Вихід");

            System.out.printf("Зробіть вибір: ");
            a= scanner.nextInt();
            if (a==1){

                System.out.println("Гри немає сорі");
            } else if (a==2) {

                System.out.println("На що ти надіялась?)");

            }else if (a==3){

                System.out.println("Мда...");
            } else if (a==0) {

                System.out.println("Вихід з програми");
                
            }else {

                System.out.println("Неправльний вибір");
            }

        }while (a!=0);

         */
        //Завдання 15
        /*
        Scanner scanner=new Scanner(System.in);
        int age;
        do {
            System.out.printf("Введіть вік для підтвердження: ");
            age= scanner.nextInt();
            if (age<1){
                System.out.println("Некоректний вік");
            } else if (age>120) {
                System.out.println("Некоректний вік");
            }else {
                System.out.println("Вік підтверджено: "+age);
            }
        }while (age < 1 || age > 120);

         */
        //Завдання 16
        /*
        Scanner scanner=new Scanner(System.in);
        int password=12345;
        int password1;
        int attempts=3;
        do {
            System.out.printf("Введіть пінкод карти, кількість спроб обмежена: ");
         password1 = scanner.nextInt();
            attempts--;
            if (password1!=password){
                System.out.println("Пароль неправильний, спробуйте ще раз:");
            }else {
                System.out.println("Доступ надано");
            }
        }while (attempts>0&&password1!=password);
        if (password1 != password) {
            System.out.println("Карту заблоковано!");
        }
         */
        /*
        Scanner scanner = new Scanner(System.in);
        char answer;
        do {
           System.out.printf("Введіть перше число: ");
           double a = scanner.nextDouble();
           System.out.printf("Введіть друге число: ");
           double b = scanner.nextDouble();
           System.out.println("Сума: " + (a + b));
           System.out.println("Різниця: " + (a - b));
           System.out.println("Добуток: " + (a * b));
           if (b != 0) {
              System.out.println("Ділення: " + (a / b));
            } else {
               System.out.println("На нуль ділити не можна!");
           }
           System.out.printf("Бажаєте продовжити? (y/n): ");
           answer = scanner.next().charAt(0);
           } while (answer == 'y');

         */
          //Завдання 18
        /*
        Scanner scanner = new Scanner(System.in);
        int cube1;
        int cube2;
        String history="";
        int count=0;
        do {
            cube1= (int) (Math.random() * 6 + 1);
            cube2= (int) (Math.random() * 6 + 1);
            count++;
            history = history + "Кидок №" + count + ": "
                    + cube1 + " і " + cube2+"\n";
            System.out.printf("Впишіть 1 щоб підкинути гральні куби: ");
            int Play = scanner.nextInt();
            if (Play != 1) {
                System.out.println("Перечитайте будь ласка умову гри!!");
            } else if (cube1 == cube2) {
                System.out.println("Дубль");
                System.out.println("Куб1: " + cube1);
                System.out.println("Куб2: " + cube2);
            } else { System.out.println("Куб1: " + cube1);
                System.out.println("Куб2: " + cube2);
                System.out.println("Дубля немає, кидаємо ще раз!");
            }
        }  while (cube1 != cube2) ;
        System.out.println("Історія кидків:");
        System.out.println(history);
        System.out.println("Кількість спроб: " + count);

         */
        //Завдання 19
        /*
        Scanner scanner=new Scanner(System.in);
        double a;
        double b;
        do {
            System.out.printf("Введіть чисельник: ");
            a= scanner.nextInt();
            System.out.printf("Введіть знаменник: ");
            b= scanner.nextInt();
            if (b==0){
                System.out.println("Ділення на нуль неможливе");
            }else {
                System.out.println("Результат: "+a/b);
            }
        }while (b==0);

         */
        //Завдання 20
        /*
        Scanner scanner=new Scanner(System.in);
        int score;
        int sum=0;
        int count=0;
        do {
            System.out.printf("Введіть бал за тест (від 0 до 100): ");
            score= scanner.nextInt();
            if (score>=0 && score<=100){
                sum=sum+score;
                count++;
            }else if (score>100){
                System.out.println("Введіть коректний балл!!");
            }
        }while (score>=0);
        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("Середній бал: " + average);
        } else {
            System.out.println("Бали не були введені.");
        }

         */
        //Завдання 21
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Введіть число A: ");
        int A= scanner.nextInt();
        System.out.printf("Введіть число B(>=A): ");
        int B= scanner.nextInt();
        for (int i=A;i<=B;i++){
            if (i%2==0){
                System.out.print(i + " ");
            }
        }

         */

        //Завдання 22
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Введіть число N(0<=N<=20): ");
        int N= scanner.nextInt();
        long factorial=1;
        for (int i=1;i<=N;i++){
            factorial = factorial * i;
        }
        System.out.println("Факторіал числа " + N + " = " + factorial);

         */

        //Завдання 23
        /*
       for (int i=1;i<=10;i++){
           System.out.printf("%-5d%-5d %-5d%n", i, i * i, i * i * i);
       }

         */
        //Завдання 24
        /*
        for (int i=1;i<=50;i++){
            if (i%3==0||i%5==0){
                continue;
            }
            System.out.print(i+ " ");
        }

         */

        //Завдання 25
        /*
        for (int i=100;i<=200;i++) {
            if (i % 13 != 0 || i % 7 != 0) {
                continue;
            } else {
                System.out.println("Ось же воно:" + i);
                break;
            }
        }

         */
        //Завдання 26
        /*
        for (char i='A';i <='Z';i++){
            System.out.println(i+"-"+(int)i);
        }

         */

        //Завдання 27
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Введіть число N");
        int N= scanner.nextInt();
        int sum=0;
        for (int i=1;i<=N;i++){
            if (i%2==0){
                sum=sum-i;
            }else {
                sum=sum+i;
            }
        }
        System.out.println("Сума: "+sum);

         */
        //Завдання 28
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Введіть a1: ");
        int a1= scanner.nextInt();
        System.out.printf("Введіть d: ");
        int d= scanner.nextInt();
        System.out.printf("Введіть n: ");
        int n= scanner.nextInt();
        int sum=0;
        for (int i=0;i<n;i++){
            int number = a1 + i * d;
            System.out.print(number + " ");
            sum = sum + number;
        } System.out.println();
        System.out.println("Сума: " + sum);

         */
        //Завдання 29
        /*
        byte b = 125;
        for (int i = 1; i <= 6; i++) {
            b = (byte)(b + 1);
            System.out.print(b+" ");
        }

         */
        //126 127 -128 -127 -126 -125 - результат ітерації
        // Так відбувається через те, що діапазон byte від -128 доо 127
        // тому коли ми до 127 додаємо ще один, повинно бути 128 але в тип даних byte це значення не поміщається
        // і через переповнення(overflow значення переходить на початок діапазону(-128)

        //Завдання 30
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Введіть 3 цілих числа : ");
        int n=3;
        int a= scanner.nextInt();
        int b= scanner.nextInt();
        int c= scanner.nextInt();
        int sum=a+b+c;
        double x=(double)sum / n;
        double y = sum / n;
        System.out.println("Сума: "+sum);
        System.out.println("Середнє арифметичне з приведенням: "+x);
        System.out.println("Середнє арифметичне без приведенням: "+y);
        //Введіть 3 цілих числа : 14 17 19
        //Сума: 50
        //Середнє арифметичне з приведенням: 16.666666666666668
        //Середнє арифметичне без приведенням: 16.0 -Результат
        //Без приведення типів виконується цілочисельне ділення(int)(дробова частина відкидається)а
        //З приведенням до double виконується точне ділення

         */
        //Завдання 31
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введіть слово з 5 символів: ");
        String word = scanner.nextLine();
        String result = "";
        for (int i = 0; i < 5; i++) {
            char ch = word.charAt(i);
            ch = (char)(ch + 1);
            result = result + ch;
        }
        System.out.println("Зашифрований рядок: " + result);

         */
        //Завдання 32
        /*
        double[]numbers={19.99, 45.50, 12.10, 99.95, 3.40};
        int sum=0;
        double sum2=0;
        for (int i=0;i<numbers.length;i++){
            sum+=(int)numbers[i];
            sum2 += numbers[i] - (int)numbers[i];
        }
        System.out.println("Сума цілих гривень: " + sum);
        System.out.println("Сума копійок: " + sum2);

         */
        //Завдання 33
        /*
        for (int i=1;i<=50;i++){
            int percent = (int) (((double) i / 50) * 100);
            System.out.println("Завантажено: " + percent + "%");
        }

         */
        //Завдання 34
        /*
        long bigNumber = 3_000_000_000L;
        int bigNumber1=(int)bigNumber;
        System.out.println(bigNumber);
        System.out.println(bigNumber1);
        //3000000000
        //-1294967296 -Результат
        // int має діапазон від -2147483648 до 2147483647
        // 3000000000 не поміщається в int
        // тому після приведення виникає переповнення

         */
        //Завдання 35
        /*
        for (double d = 0.0; d <= 1.0; d += 0.1){
            System.out.println(d);
        }
        for (int i = 0; i <= 10; i++){
            double val = i / 10.0;
            System.out.println(val);
        }

         */
        //Завдання 36
        /*
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }

         */
        //Завдання 37
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введіть висоту рамки H: ");
        int H= scanner.nextInt();
        System.out.printf("Введіть ширину рамки W: ");
        int W= scanner.nextInt();
        for (int i=1;i<=H;i++){
            for (int j=1;j<=W;j++){
                if (i == 1 || i == H || j == 1 || j == W) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }System.out.println();
            }

         */
        //Завдання 38
        /*
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Введіть висоту трикутника: ");
        int height= scanner.nextInt();
        for (int i=1;i<=height;i++){
            for (int j=1;j<=i;j++){
                System.out.print("*");


            }
            System.out.println();

        }

         */
        //Завдання 39
        /*

        Scanner scanner=new Scanner(System.in);
        System.out.printf("Введіть число N: ");
        int n= scanner.nextInt();
        for (int i=2;i<=n;i++){
            int count=0;
            for (int j=1;j<=i;j++){
              if (i%j==0){
                  count++;
              }
            }
            if (count == 2) {
                System.out.print(i + " ");
            }
        }

         */


        //Завдання 40


            Scanner scanner = new Scanner(System.in);
            System.out.printf("Введіть розмір дошки N: ");
            int n = scanner.nextInt();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if ((i + j) % 2 == 0) {
                        System.out.print("# ");
                    } else {
                        System.out.print("_ ");
                    }
                }
                System.out.println();
            }
            scanner.close();

























    }
}








