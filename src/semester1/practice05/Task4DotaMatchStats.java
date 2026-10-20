package semester1.practice05;

public class Task4DotaMatchStats {
    public static void main(String[] args){
        String[] heroes = {"Axe", "Lina", "Wraith King", "Lion", "Sniper"};
        int[] kills = {9, 11, 13, 3, 5};
        int[] deaths = {4, 2, 5, 8, 6};
        int[] assists = {12, 15, 7, 20, 14};
        int[] netWorth = {18000, 20500, 26000, 10500, 14200};
        double[] kdaRatios = new double[5];
        double[] kpPercent = new double[5];
        int totalTeamKills = 0;
        int totalNetWorth = 0;
        for (int i = 0; i < heroes.length; i++) {
            totalTeamKills += kills[i];
            totalNetWorth += netWorth[i];
        }
        for (int i = 0; i < heroes.length; i++) {
            kdaRatios[i] = (double) (kills[i] + assists[i])
                    / Math.max(1, deaths[i]);

            kpPercent[i] = (double) (kills[i] + assists[i])
                    / totalTeamKills * 100;
        }
        int mvp = 0;
        for (int i = 1; i < heroes.length; i++) {
            if (kdaRatios[i] > kdaRatios[mvp]) {
                mvp = i;
            }
        }
        // Виведення таблиці
        System.out.println("==========================================================================");
        System.out.println("                     DOTA 2: POST-MATCH REPORT");
        System.out.println("==========================================================================");
        System.out.printf("%-18s | %-11s | %-10s | %-9s | %-20s%n",
                "Hero", "K / D / A", "Net Worth", "KDA Ratio", "Kill Participation");
        System.out.println("--------------------------------------------------------------------------");
        for (int i = 0; i < heroes.length; i++) {
            System.out.printf("%-18s | %2d / %2d / %2d | %,9d | %9.2f | %8.2f%%%n",
                    heroes[i],
                    kills[i],
                    deaths[i],
                    assists[i],
                    netWorth[i],
                    kdaRatios[i],
                    kpPercent[i]);
        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Загальні вбивства команди: " + totalTeamKills);
        System.out.printf("Загальний Net Worth команди: %,d золота%n", totalNetWorth);

        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("MVP: %s (KDA: %.2f)%n", heroes[mvp], kdaRatios[mvp]);
        System.out.println("==========================================================================");






    }
}
