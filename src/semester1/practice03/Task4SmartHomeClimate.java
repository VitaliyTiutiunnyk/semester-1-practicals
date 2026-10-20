package semester1.practice03;

import java.util.Scanner;

public class Task4SmartHomeClimate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ПАНЕЛЬ КЛІМАТ-КОНТРОЛЮ SMART HOME ===");
        System.out.print("Поточна температура (°C): ");
        double currentTemp = scanner.nextDouble();
        System.out.print("Бажана температура (°C): ");
        double desiredTemp = scanner.nextDouble();
        System.out.print("Вологість повітря (%): ");
        int humidity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Сезон (зима/літо/міжсезоння): ");
        String season = scanner.nextLine();
        System.out.print("Режим будинку (1-Standby, 2-Eco, 3-Party, 4-Night, 5-Vacation): ");
        int mode = scanner.nextInt();
        System.out.print("Чи відчинені вікна? (true/false): ");
        boolean isWindowOpen = scanner.nextBoolean();
        if (isWindowOpen && (mode != 5)) {
            System.out.println("ПОПЕРЕДЖЕННЯ: Відчинені вікна!");
            System.out.println("Обігрів та кондиціонування примусово заблоковано!");
        }
        double effectiveTargetTemp = switch (mode) {
            case 1 -> desiredTemp;
            case 2 -> {
                if (season.equalsIgnoreCase("зима")) {
                    yield desiredTemp - 2.0;
                } else if (season.equalsIgnoreCase("літо")) {
                    yield desiredTemp + 2.0;
                } else {
                    yield desiredTemp;
                }
            }
            case 3 -> desiredTemp - 1.5;
            case 4 -> 19.0;
            case 5 -> {
                if (season.equalsIgnoreCase("зима")) {
                    yield 12.0;
                } else {
                    yield 28.0;
                }
            }
            default -> desiredTemp;
        };
        String climateStatus;
        if (isWindowOpen && (mode != 5)) {
            climateStatus = "Кліматичні прилади ВИМКНЕНО";
        } else if ((currentTemp - effectiveTargetTemp) > 0.5) {
            climateStatus = "Кондиціонер УВІМКНЕНО (Охолодження)";
        } else if ((effectiveTargetTemp - currentTemp) > 0.5) {
            climateStatus = "Опалення УВІМКНЕНО (Обігрів)";
        } else {
            climateStatus = "Температура в зоні комфорту";
        }
        String humidityStatus = humidity < 40
                ? "Зволожувач УВІМКНЕНО"
                : humidity > 65
                ? "Осушувач УВІМКНЕНО"
                : "Вологість оптимальна";
        String modeName;
        if (mode == 1) {
            modeName = "Standby (Звичайний)";
        } else if (mode == 2) {
            modeName = "Eco (Енергозбереження)";
        } else if (mode == 3) {
            modeName = "Party (Гості)";
        } else if (mode == 4) {
            modeName = "Night (Ніч)";
        } else if (mode == 5) {
            modeName = "Vacation (Відпустка)";
        } else {
            modeName = "Невідомий режим";
        }
        System.out.println();
        System.out.println("------------- СТАТУС СИСТЕМИ -------------");
        System.out.println("Режим роботи:              " + modeName);
        System.out.printf("Цільова температура:       %.2f°C%n", effectiveTargetTemp);
        System.out.printf("Поточна температура:       %.2f°C%n", currentTemp);
        System.out.println("Стан терморегуляції:       " + climateStatus);
        System.out.println("Стан мікроклімату:         " + humidityStatus);
        System.out.println("Вологість:                 " + humidity + "%");
        System.out.println("Вікна відчинені:           " + isWindowOpen);
        System.out.println("==========================================");
        scanner.close();
    }
}