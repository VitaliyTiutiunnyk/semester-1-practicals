package semester1.practice02.homework;

public class Task2NumberAnalysis {
    public static void main(String[] args) {
        // Вхідні дані
        int number = 742;
        // Математичне виділення розрядів
        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int units = number % 10;
        // Обчислення
        int sum = hundreds + tens + units;
        int product = hundreds * tens * units;
        int reversedNumber = units * 100 + tens * 10 + hundreds;
        boolean isSumEven = sum % 2 == 0;
        // Вивід
        System.out.println("Початкове число:            " + number);
        System.out.println("Розряди:                    Сотні = " + hundreds + ", Десятки = " + tens + ", Одиниці = " + units);
        System.out.println("Сума цифр:                  " + sum);
        System.out.println("Добуток цифр:               " + product);
        System.out.println("Перевернуте число:          " + reversedNumber);
        System.out.println("Чи є сума цифр парною?      " + isSumEven);
    }
}

