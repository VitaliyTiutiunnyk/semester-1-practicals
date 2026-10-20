package semester1.practice05;
import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;
public class Practice05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // task1();
        // task2();
        // task3();
        // task4(scanner);
        // task5();
        // task6();
        // task7();
        // task8();
        // task9();
        // task10();
        // task11();
        // task12(scanner);
        // task13(scanner);
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
        scanner.close();

    }

    public static void task1() {
        //Завдання 1
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        numbers[0] = 10;
        numbers[2] = 30;
        numbers[4] = 50;
        System.out.println(Arrays.toString(numbers));

    }

    public static void task2() {
        //Завдання 2
        String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця", "Субота", "Неділя"};
        // System.out.println(days[0]);
        // System.out.println(days[days.length-1]);
        days[5] = "Вихідний (Сб)";
        days[6] = "Вихідний (Нд)";
        System.out.println(Arrays.toString(days));

    }

    public static void task3() {
        //Завдання 3
        double[] prices = {120.50, 45.00, 890.99, 15.30, 420.00};
        System.out.println(Arrays.toString(prices));
        prices[2] = prices[2] * 0.8;
        System.out.println(Arrays.toString(prices));
    }

    public static void task4(Scanner scanner) {
        //Завдання 4
        System.out.printf("Введіть число N: ");
        int userN = scanner.nextInt();
        int[] numbers = new int[userN];
        for (int i = 0; i < userN; i++) {
            numbers[i] = i + 1;
            System.out.print(numbers[i] + " ");
        }
    }

    public static void task5() {
        //Завдання 5
        int[] numbers = {4, 8, 15, 16, 23, 42};
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + ", ");
        }

    }

    public static void task6() {
        //Завдання 6
        int[] numbers = new int[10];
        numbers[0] = 1;
        System.out.print(numbers[0] + ", ");
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] * 2;
            System.out.print(numbers[i] + ", ");

        }

    }

    public static void task7() {
        //Завдання 7
        int[] original = {3, 7, 1, 9, 4};
        int[] copy = new int[5];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];


        }
        copy[0] = 999;
        System.out.print("Скопійований: ");
        for (int i = 0; i < copy.length; i++) {
            System.out.print(copy[i] + ", ");
        }
        System.out.println();
        System.out.print("Оригінал: ");
        for (int i = 0; i < original.length; i++) {
            System.out.print(original[i] + ", ");
        }
    }

    public static void task8() {
        //Завдання 8
        int[] grades = {95, 84, 70, 99, 65, 88, 92};
        int sum = 0;
        for (int gra : grades) {
            sum = sum + gra;

        }
        System.out.println("Сума оцінок: " + sum);
        double average = 0;
        for (int gra : grades) {
            average = (double) sum / grades.length;

        }

        System.out.println("Середній бал: " + average);
    }

    public static void task9() {
        //Завдання 9
        String[] days = {"Понеділок", "Вівторок", "Середа",
                "Четвер", "П'ятниця", "Субота", "Неділя"};
        int[] temps = {18, 21, 15, 24, 13, 27, 20};
        int max = temps[0];
        int min = temps[0];
        int minIndex = 0;
        int maxIndex = 0;
        int i = 0;
        for (int tem : temps) {
            if (tem < min) {
                min = tem;
                minIndex = i;
            }
            if (tem > max) {
                max = tem;
                maxIndex = i;
            }
            i++;

        }
        System.out.println("Мінімум: " + min + ", день: " + days[minIndex]);
        System.out.println("Максимум: " + max + ", день: " + days[maxIndex]);


    }

    public static void task10() {
        //Завдання 10
        int[] data = {12, -5, 0, 43, -19, 0, -2, 8, 0, 15};
        int count0 = 0;
        int count_ = 0;
        int count1 = 0;
        for (int dat : data) {
            if (dat > 0) {
                count1++;
            } else if (dat < 0) {
                count_++;
            } else {
                count0++;

            }

        }
        System.out.println("Кількість додатних елементів " + count1);
        System.out.println("Кількість від'ємних елементів " + count_);
        System.out.println("Кількість нульових значень " + count0);


    }

    public static void task11() {
        //Завдання 11
        int[] numbers = {25, 20, 29, 4526, 3213, 32, 4214, 4214, 421, 212};
        int sumEveNumber = 0;
        int sumOddNumber = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                sumEveNumber += num;
            }
            if (num % 2 != 0) {
                sumOddNumber += num;
            }
        }
        System.out.println("Сума парних чисел: " + sumEveNumber);
        System.out.println("Сума непарних чисел: " + sumOddNumber);

    }

    public static void task12(Scanner scanner) {
        //Завдання 12
        int[] students = {1042, 2031, 3055, 4018, 5099};
        boolean found = false;
        int i = 0;
        System.out.printf("Введіть номер залікової книги: ");
        int num = scanner.nextInt();
        for (int stud : students) {

            if (stud == num) {
                System.out.println("Позиція номера " + (i + 1));
                found = true;
                break;

            }
            i++;
        }
        if (!found) {
            System.out.println("Студента з таким номером не знайдено");
        }
    }

    public static void task13(Scanner scanner) {
        //Завдання 13
        int[] rolls = {3, 6, 2, 6, 1, 4, 6, 5, 2, 6};
        System.out.printf("Введіть число N(1-6)");
        int count = 0;
        int n = scanner.nextInt();
        for (int rol : rolls) {
            if (n == rol) {
                count++;

            }

        }
        System.out.println("Число " + n + " випало: " + count + " раз");


    }

    public static void task14() {
        //Завдання 14
        int[] salary = {18000, 25000, 32000, 15000, 41000, 29000};
        int sum = 0;
        double average = 0;

        for (int sal : salary) {
            sum += sal;
        }
        average += (double) sum / salary.length;
        System.out.println("Середня зарплата: " + average);
        System.out.print("Зарплати більше середнього показника: ");
        for (int sal : salary) {
            if (sal > average) {
                System.out.print(sal + "; ");


            }
        }


    }

    public static void task15() {
        //Завдання 15
        double[] prices = {42.5, 41.8, 44.1, 40.9, 43.6, 45.0};
        double max = prices[0];
        double min = prices[0];
        for (double pri : prices) {
            if (pri > max) {
                max = pri;
            }
            if (pri < min) {
                min = pri;
            }
        }
        double range = max - min;
        System.out.printf("Розмах цін: " + "%.2f", range);


    }

    public static void task16() {
        //Завдання 16
        String[] city = {"Київ", "Львів", "Харків", "Одеса", "Дніпро"};
        for (String cit : city) {
            System.out.println("Ласкаво просимо до міста " + cit + "!");


        }

    }

    public static void task17() {
        //Завдання 17
        double[] salaries = {20000.0, 25000.0, 18000.0, 30000.0};
        for (int i = 0; i < salaries.length; i++) {
            salaries[i] *= 1.10;
        }
        System.out.println(Arrays.toString(salaries));
    }

    public static void task18() {
        //Завдання 18
        int[] arr = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;

        }
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }

    public static void task19() {
        //Завдання 19
        int[] base = {2, 4, 6, 8, 10};
        int[] squares = new int[base.length];
        for (int i = 0; i < base.length; i++) {
            squares[i] = base[i] * base[i];

        }
        System.out.print("Початковий массив: ");
        for (int bas : base) {
            System.out.print(bas + ", ");

        }
        System.out.println();
        System.out.print("Массив квадратів чисел початкового: ");
        for (int squ : squares) {
            System.out.print(squ + ", ");
        }
    }

    public static void task20() {
        //Завдання 20
        boolean isSorted = true;
        int[] numbers = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] >= numbers[i + 1]) {
                isSorted = false;
                System.out.println("Числа невпорядковані за зростанням");
                break;
            }


        }
        if (isSorted) {
            System.out.println("Числа впорядковані за зростанням");
        }


    }

    public static void task21() {
        //Завдання 21
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6, 7};
        int[] c = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];


        }
        for (int i = 0; i < b.length; i++) {
            c[a.length + i] = b[i];
        }
        System.out.println(Arrays.toString(c));


    }

    public static void task22() {
        //Завдання 22
        int[] test = {45, 12, 89, 3, 27};
        System.out.println(Arrays.toString(test));
        Arrays.sort(test);
        System.out.println(Arrays.toString(test));
        Arrays.fill(test, -1);
        System.out.println(Arrays.toString(test));

    }

    public static void task23() {
        //Завдання 23
        int[][] table = new int[3][3];
        table[0][0] = 10;
        table[0][2] = 10;
        table[1][1] = 10;
        table[2][0] = 10;
        table[2][2] = 10;
        table[0][1] = 10;
        table[1][0] = 10;
        table[1][2] = 10;
        table[2][1] = 10;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }


    }

    public static void task24() {
        //Завдання 24
        int[][] matrix = {
                {10, 20, 30, 40},
                {50, 60, 70, 80}
        };
        System.out.println("Кількість рядків матриці: " + matrix.length);
        System.out.println("Кількість стовпчиків: " + matrix[0].length);
        System.out.println("Кутові елементи: " + matrix[0][0] + ", " + matrix[0][3] + ", " + matrix[1][0] + ", " + matrix[1][3] + ";");

    }

    public static void task25() {
        //Завдання 25
        int[][] grid = new int[3][4];
        int counter = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = counter;
                counter++;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }


    }

    public static void task26() {
        //Завдання 26
        int[][] randomGrid = new int[4][3];
        for (int i = 0; i < randomGrid.length; i++) {
            for (int j = 0; j < randomGrid[i].length; j++) {
                randomGrid[i][j] = (int) (Math.random() * 90) + 10;

            }
        }
        for (int i = 0; i < randomGrid.length; i++) {
            for (int j = 0; j < randomGrid[i].length; j++) {
                System.out.print(randomGrid[i][j] + "\t");

            }
            System.out.println();

        }
    }

    public static void task27() {
        //Завдання 27
        int[][] multTable = new int[9][9];
        for (int i = 0; i < multTable.length; i++) {
            for (int j = 0; j < multTable[i].length; j++) {
                multTable[i][j] = (i + 1) * (j + 1);

            }
        }
        for (int i = 0; i < multTable.length; i++) {
            for (int j = 0; j < multTable[i].length; j++) {
                System.out.print(multTable[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static void task28() {
        //Завдання 28
        int[][] matrix = new int[5][5];
        for (int row = 0; row < matrix.length; row++) {
            for (int cow = 0; cow < matrix.length; cow++) {
                if (row == cow) {
                    matrix[row][cow] = 1;
                }
            }

        }
        for (int row = 0; row < matrix.length; row++) {
            for (int cow = 0; cow < matrix.length; cow++) {
                System.out.print(matrix[row][cow] + "\t");

            }
            System.out.println();

        }

    }

    public static void task29() {
        //Завдання 29
        int[][] matrix = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[1][j] = 0;

            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][2] = 7;

            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static void task30() {
        //Завдання 30
        int[][] matrix = {
                {4, 10, 5},
                {1, 6, 8},
                {27, 5, 3},
        };
        int sum = 0;
        int count = 0;
        double average;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
                count++;


            }
        }
        average = (double) sum / count;
        System.out.println("Сума всіх чисел: " + sum);
        System.out.println("Кількість елементів: " + count);
        System.out.println("Cереднє арифметичне матриці: " + average);

    }

    public static void task31() {
        //Завдання 31
        int[][] matrix = {
                {4, 10, 5, 2},
                {1, 6, 8, 3},
                {27, 5, 3, 1}
        };

        int[] rowSums = new int[3];
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
            rowSums[i] = sum;
        }
        for (int i = 0; i < rowSums.length; i++) {
            System.out.println("Рядок " + i + ": сума = " + rowSums[i]);
        }

    }

    public static void task32() {
        //Завдання 32
        int[][] matrix = {
                {4, 10, 5},
                {1, 6, 8},
                {27, 5, 3},

        };
        for (int j=0;j<matrix[0].length;j++){
            int sum=0;
            for (int i=0;i< matrix.length;i++){
                sum+=matrix[i][j];


            }

            System.out.println("Загальна сума стовпчика "+j+": "+sum);
        }


    }
    public static void task33(){
        //Завдання 33
        int[][] matrix = {
                {4, -10, 5, -2},
                {-1, 6, -8, 3},
                {27, -5, 3, -11}
        };
        int maxElement=matrix[0][0]; int row=0; int col=0;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (maxElement < matrix[i][j]) {
                    maxElement=matrix[i][j];
                    row=i; col=j;

                }
            }

        }
        System.out.println("Максимальний елемент: "+maxElement);
        System.out.println("Рядок: "+row);
        System.out.println("Стовпчик: "+col);

    }
    public static void task34(){
        //Завдання 34
        int[][] matrix = {
                {1, 1, 1, 1},
                {1, 2, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        }; int sum=0; int sum2=0;
        for (int i=0;i< matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (i == j){
                    sum+=matrix[i][j];
                }
                if (i + j == matrix.length - 1){
                    sum2+=matrix[i][j];
                }
            }
        }
        System.out.println("Сума головної діагоналі: " + sum);
        System.out.println("Сума побічної діагоналі: " + sum2);
        if (sum>sum2){
            System.out.println("Головна діагональ більша!");
        }else if (sum<sum2){
            System.out.println("Побічна діагональ більша!");
        }else {
            System.out.println("Суми діагоналей рівні!");
        }

    }
    public static void task35(){
        //Завдання 35
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] transposed = new int[3][3];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                transposed[j][i] = matrix[i][j];
            }
        }
        System.out.println("Початкова матриця\t\tТранспонована матриця");
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + "\t");
            }

            System.out.print("\t");

            for (int j = 0; j < transposed[i].length; j++){
                System.out.print(transposed[i][j] + "\t");
            }

            System.out.println();
        }
    }
    public static void task36(){
        //Завдання 36
        int[][] ladder = new int[4][];
        for (int i = 0; i < ladder.length; i++){
            ladder[i] = new int[i + 1];
        }
        for (int i = 0; i < ladder.length; i++){
            for (int j = 0; j < ladder[i].length; j++){
                ladder[i][j] = i;
            }
        }
        for (int i = 0; i < ladder.length; i++){
            for (int j = 0; j < ladder[i].length; j++){
                System.out.print(ladder[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void task37(){
        //Завдання 37
        String[][] weekSchedule = new String[5][];
        weekSchedule[0] = new String[]{
                "Вища математика",
                "Основи програмування",
                "Фізика"
        };
        weekSchedule[1] = new String[]{
                "Англійська мова",
                "Історія України"
        };
        weekSchedule[2] = new String[]{
                "Основи програмування",
                "Основи програмування",
                "Бази даних",
                "Фізвиховання"
        };
        weekSchedule[3] = new String[]{
                "Дискретна математика"
        };
        weekSchedule[4] = new String[]{
                "Філософія",
                "Основи алгоритмізації",
                "Практикум"
        };
        String[] days = {
                "Понеділок",
                "Вівторок",
                "Середа",
                "Четвер",
                "П'ятниця"
        };
        for (int i = 0; i < weekSchedule.length; i++){
            System.out.println(days[i] + ":");
            for (int j = 0; j < weekSchedule[i].length; j++){
                System.out.println("  " + (j + 1) + ". " + weekSchedule[i][j]);
            }
            System.out.println();
        }
    }
    public static void task38(){
        //Завдання 38
        int[][] pascal = new int[5][];
        for (int i = 0; i < pascal.length; i++){
            pascal[i] = new int[i + 1];
            for (int j = 0; j < pascal[i].length; j++){
                if (j == 0 || j == pascal[i].length - 1){
                    pascal[i][j] = 1;
                } else {
                    pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
                }
            }
        }
        for (int i = 0; i < pascal.length; i++){
            for (int j = 0; j < pascal[i].length; j++){
                System.out.print(pascal[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void task39(){
        //Завдання 39
        int[][][] cube = new int[3][3][3];
        for (int x = 0; x < cube.length; x++){
            for (int y = 0; y < cube[x].length; y++){
                for (int z = 0; z < cube[x][y].length; z++){
                    cube[x][y][z] = x + y + z;
                }
            }
        }
        for (int x = 0; x < cube.length; x++){
            System.out.println("  Шар " + x + "   ");
            for (int y = 0; y < cube[x].length; y++){
                for (int z = 0; z < cube[x][y].length; z++){
                    System.out.print(cube[x][y][z] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void task40(){
        //Завдання 40
        double[][][] weather = new double[3][7][2];
        String[] cities = {"Київ", "Львів", "Одеса"};
        String[] days = {
                "Понеділок", "Вівторок", "Середа",
                "Четвер", "П'ятниця", "Субота", "Неділя"
        };
        double[][] kyiv = {
                {15, 8}, {17, 9}, {16, 7}, {18, 10},
                {19, 11}, {20, 12}, {17, 9}
        };
        double[][] lviv = {
                {13, 6}, {14, 7}, {15, 5}, {16, 8},
                {14, 6}, {17, 9}, {15, 7}
        };
        double[][] odesa = {
                {19, 12}, {20, 13}, {21, 14}, {22, 15},
                {20, 13}, {23, 16}, {21, 14}
        };
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 2; j++){
                weather[0][i][j] = kyiv[i][j];
                weather[1][i][j] = lviv[i][j];
                weather[2][i][j] = odesa[i][j];
            }
        }
        for (int i = 0; i < weather.length; i++){
            double sum = 0;
            for (int j = 0; j < weather[i].length; j++){
                sum += weather[i][j][0];
            }
            double average = sum / 7;
            System.out.printf("Середня денна температура у місті %s: %.2f°C%n",
                    cities[i], average);
        }
        double minNight = weather[0][0][1];
        int minCity = 0;
        int minDay = 0;
        for (int i = 0; i < weather.length; i++){
            for (int j = 0; j < weather[i].length; j++){
                if (weather[i][j][1] < minNight){
                    minNight = weather[i][j][1];
                    minCity = i;
                    minDay = j;
                }
            }
        }
        System.out.printf("Найхолодніша ніч: %.1f°C, місто %s, день тижня — %s%n",
                minNight, cities[minCity], days[minDay]);
    }



}








