package semester1.practice08;

public class Block5 {
    public static void task33(){
        ArithmeticProgression arithmetic =
                new ArithmeticProgression(2, 3);
        GeometricProgression geometric =
                new GeometricProgression(2, 3);

        System.out.println(arithmetic);
        System.out.println();
        System.out.println(geometric);
    }
    public static void task34(){
        int[] grades = {90, 75, 60, 85};
        double[] weights = {0.4, 0.2, 0.3, 0.1};
        GradeSheet regular = new GradeSheet("Віталій", grades);
        WeightedGradeSheet weighted = new WeightedGradeSheet("Віталій", grades, weights);
        System.out.println("=== ЗВИЧАЙНИЙ РЕЙТИНГ ===");
        System.out.println(regular);
        System.out.println();
        System.out.println("=== ЗВАЖЕНИЙ РЕЙТИНГ ===");
        System.out.println(weighted);
    }
    public static void task35(){
        LinearFunction linear = new LinearFunction(2, 3);
        QuadraticFunction quadratic = new QuadraticFunction(1, -4, 3);
        System.out.println("=== ЛІНІЙНА ФУНКЦІЯ ===");
        System.out.println(linear);
        System.out.println("f(2) = " + linear.evaluate(2));
        System.out.println();
        System.out.println("=== КВАДРАТНА ФУНКЦІЯ ===");
        System.out.println(quadratic);
        System.out.println("f(2) = " + quadratic.evaluate(2));
        double[] vertex = quadratic.findVertex();
        System.out.println("Вершина параболи: (" +
                vertex[0] + ", " + vertex[1] + ")");
    }
    public static void task36(){
        double[] prices = {500, 450, 550, 400};
        WarehouseItem item = new WarehouseItem("Клавіатура", 20, prices);
        DiscountedWarehouseItem discountedItem =
                new DiscountedWarehouseItem(
                        "Миша Logitech",
                        15,
                        new double[]{800, 750, 850, 800},
                        "Пошкоджена упаковка",
                        20
                );
        System.out.println("=== ЗВИЧАЙНИЙ ТОВАР ===");
        System.out.println(item);
        System.out.println();
        System.out.println("=== УЦІНЕНИЙ ТОВАР ===");
        System.out.println(discountedItem);
    }
    public static void task37(){
        VipCinemaHall hall = new VipCinemaHall("VIP Hall", 4, 5, 200, 50);
        hall.bookSeat(0, 1);
        hall.bookSeat(1, 2);
        hall.bookSeat(2, 3);
        hall.bookSeat(3, 0);
        hall.bookSeat(3, 1);
        System.out.println(hall);
        System.out.println("Зайнято місць: " + hall.getOccupiedCount());
        System.out.println("Дохід кінотеатру: " + hall.calculateRevenue() + " грн");
    }
    public static void task38(){
        TeamLead lead = new TeamLead("Віталій", 50000, "Java", 3);
        Developer dev1 = new Developer("Олексій", 30000, "Java");
        Developer dev2 = new Developer("Андрій", 35000, "Python");
        Developer dev3 = new Developer("Максим", 32000, "C++");
        lead.addTeamMember(dev1);
        lead.addTeamMember(dev2);
        lead.addTeamMember(dev3);
        System.out.println(lead);
    }
    public static void task39(){
        ShieldedPaladin paladin = new ShieldedPaladin("Артур", 100, 10, 40);
        System.out.println(paladin);
        System.out.println("\nОтримав 25 шкоди:");
        paladin.takeDamage(25);
        System.out.println(paladin);
        System.out.println("\nОтримав 50 шкоди:");
        paladin.takeDamage(50);
        System.out.println(paladin);

    }
}
class Progression {
    protected double firstTerm;
    protected double step;

    Progression(double firstTerm, double step) {
        this.firstTerm = firstTerm;
        this.step = step;
    }

    public double getTerm(int index) {
        return 0;
    }

    public double[] generateFirstN(int n) {
        double[] array = new double[n];

        for (int i = 0; i < n; i++) {
            array[i] = getTerm(i);
        }

        return array;
    }

    @Override
    public String toString() {
        return "Перший член: " + firstTerm;
    }
}

class ArithmeticProgression extends Progression {

    ArithmeticProgression(double firstTerm, double step) {
        super(firstTerm, step);
    }

    @Override
    public double getTerm(int n) {
        return firstTerm + n * step;
    }

    @Override
    public String toString() {
        return "Арифметична прогресія: a(n) = " +
                firstTerm + " + n * " + step +
                "\nПерші 5 членів: " +
                java.util.Arrays.toString(generateFirstN(5));
    }
}

class GeometricProgression extends Progression {

    GeometricProgression(double firstTerm, double step) {
        super(firstTerm, step);
    }

    @Override
    public double getTerm(int n) {
        return firstTerm * Math.pow(step, n);
    }

    @Override
    public String toString() {
        return "Геометрична прогресія: a(n) = " +
                firstTerm + " * " + step + "^n" +
                "\nПерші 5 членів: " +
                java.util.Arrays.toString(generateFirstN(5));
    }
}
class GradeSheet {
    private String studentName;
    protected int[] grades;

    GradeSheet(String studentName, int[] grades) {
        this.studentName = studentName;
        this.grades = grades;
    }

    public double calculateScore() {
        if (grades.length == 0) {
            return 0;
        }

        double sum = 0;

        for (int grade : grades) {
            sum += grade;
        }

        return sum / grades.length;
    }

    @Override
    public String toString() {
        return "Студент: " + studentName +
                ", оцінки: " + java.util.Arrays.toString(grades) +
                ", середній бал: " + calculateScore();
    }
}

class WeightedGradeSheet extends GradeSheet {
    private double[] weights;

    WeightedGradeSheet(String studentName, int[] grades, double[] weights) {
        super(studentName, grades);
        this.weights = weights;
    }

    @Override
    public double calculateScore() {
        if (grades.length == 0 || grades.length != weights.length) {
            return 0;
        }

        double sum = 0;
        double totalWeight = 0;

        for (int i = 0; i < grades.length; i++) {
            sum += grades[i] * weights[i];
            totalWeight += weights[i];
        }

        if (totalWeight == 0) {
            return 0;
        }

        return sum / totalWeight;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", вагові коефіцієнти: " +
                java.util.Arrays.toString(weights) +
                ", зважений рейтинг: " + calculateScore();
    }
}
class LinearFunction {
    protected double k;
    protected double b;

    LinearFunction(double k, double b) {
        this.k = k;
        this.b = b;
    }

    public double evaluate(double x) {
        return k * x + b;
    }

    @Override
    public String toString() {
        return "f(x) = " + k + "x + " + b;
    }
}

class QuadraticFunction extends LinearFunction {
    private double a;

    QuadraticFunction(double a, double k, double b) {
        super(k, b);
        this.a = a;
    }

    @Override
    public double evaluate(double x) {
        return a * x * x + super.evaluate(x);
    }

    public double[] findVertex() {
        double x = -k / (2 * a);
        double y = evaluate(x);

        return new double[]{x, y};
    }

    @Override
    public String toString() {
        return "f(x) = " + a + "x^2 + " + k + "x + " + b;
    }
}
class WarehouseItem {
    protected String name;
    protected int quantity;
    protected double[] priceHistory;

    WarehouseItem(String name, int quantity, double[] priceHistory) {
        this.name = name;
        this.quantity = quantity;
        this.priceHistory = priceHistory;
    }

    public double getAveragePurchasePrice() {
        if (priceHistory.length == 0) {
            return 0;
        }

        double sum = 0;

        for (double price : priceHistory) {
            sum += price;
        }

        return sum / priceHistory.length;
    }

    @Override
    public String toString() {
        return "Товар: " + name +
                ", кількість: " + quantity +
                ", історія цін: " +
                java.util.Arrays.toString(priceHistory) +
                ", середня закупівельна ціна: " +
                String.format("%.2f", getAveragePurchasePrice());
    }
}

class DiscountedWarehouseItem extends WarehouseItem {
    private String markdownReason;
    private double discountPercent;

    DiscountedWarehouseItem(String name, int quantity,
                            double[] priceHistory,
                            String markdownReason,
                            double discountPercent) {
        super(name, quantity, priceHistory);
        this.markdownReason = markdownReason;
        this.discountPercent = discountPercent;
    }

    public double getSalePrice() {
        return getAveragePurchasePrice() *
                (1 - discountPercent / 100);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", причина уцінки: " + markdownReason +
                ", знижка: " + discountPercent + "%" +
                ", ціна розпродажу: " +
                String.format("%.2f", getSalePrice());
    }
}
class CinemaHall {
    protected String hallName;
    protected boolean[][] seats;
    protected double baseTicketPrice;

    CinemaHall(String hallName, int rows, int cols, double baseTicketPrice) {
        this.hallName = hallName;
        this.seats = new boolean[rows][cols];
        this.baseTicketPrice = baseTicketPrice;
    }

    public boolean bookSeat(int row, int col) {
        if (row < 0 || row >= seats.length ||
                col < 0 || col >= seats[row].length) {
            return false;
        }

        if (seats[row][col]) {
            return false;
        }

        seats[row][col] = true;
        return true;
    }

    public int getOccupiedCount() {
        int count = 0;

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public double calculateRevenue() {
        return getOccupiedCount() * baseTicketPrice;
    }

    @Override
    public String toString() {
        String result = "Кінозал: " + hallName + "\n";

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j]) {
                    result += "[X] ";
                } else {
                    result += "[O] ";
                }
            }
            result += "\n";
        }

        return result;
    }
}

class VipCinemaHall extends CinemaHall {
    private double complimentaryBarCost;

    VipCinemaHall(String hallName, int rows, int cols,
                  double baseTicketPrice, double complimentaryBarCost) {
        super(hallName, rows, cols, baseTicketPrice);
        this.complimentaryBarCost = complimentaryBarCost;
    }

    @Override
    public double calculateRevenue() {
        double revenue = 0;

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j]) {
                    if (i == seats.length - 1) {
                        revenue += baseTicketPrice + complimentaryBarCost;
                    } else {
                        revenue += baseTicketPrice;
                    }
                }
            }
        }

        return revenue;
    }
}
class TeamLead extends Developer {
    private Developer[] teamMembers;
    private int memberCount;

    TeamLead(String name, double salary, String programmingLanguage, int teamSize) {
        super(name, salary, programmingLanguage);
        teamMembers = new Developer[teamSize];
        memberCount = 0;
    }

    public void addTeamMember(Developer dev) {
        if (memberCount < teamMembers.length) {
            teamMembers[memberCount] = dev;
            memberCount++;
        } else {
            System.out.println("Команда вже заповнена!");
        }
    }

    public double getTotalTeamBudget() {
        double total = getSalary();

        for (int i = 0; i < memberCount; i++) {
            total += teamMembers[i].getSalary();
        }

        return total;
    }

    @Override
    public String toString() {
        String result = "=== ТІМЛІД ===\n";
        result += super.toString();
        result += "\nЗагальний бюджет команди: " + getTotalTeamBudget();
        result += "\nУчасники команди:\n";

        for (int i = 0; i < memberCount; i++) {
            result += (i + 1) + ". " + teamMembers[i] + "\n";
        }

        return result;
    }
}
class CharacterUnit {
    private String name;
    protected int hp;
    protected int maxHp;
    protected int armor;

    CharacterUnit(String name, int hp, int armor) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.armor = armor;
    }
    public void takeDamage(int rawDamage) {
        int damage = Math.max(1, rawDamage - armor);
        hp = Math.max(0, hp - damage);
    }
    @Override
    public String toString() {
        int filled = (int) ((double) hp / maxHp * 10);

        String bar = "[";
        for (int i = 0; i < 10; i++) {
            if (i < filled) {
                bar += "█";
            } else {
                bar += "░";
            }
        }
        bar += "]";

        return "Персонаж: " + name
                + "\nHP: " + bar + " " + hp + "/" + maxHp
                + "\nБроня: " + armor;
    }
}
class ShieldedPaladin extends CharacterUnit {
    private int shieldPoints;

    ShieldedPaladin(String name, int hp, int armor, int shieldPoints) {
        super(name, hp, armor);
        this.shieldPoints = shieldPoints;
    }
    @Override
    public void takeDamage(int rawDamage) {
        if (shieldPoints > 0) {
            if (rawDamage <= shieldPoints) {
                shieldPoints -= rawDamage;
                return;
            } else {
                int remainingDamage = rawDamage - shieldPoints;
                shieldPoints = 0;
                super.takeDamage(remainingDamage);
            }
        } else {
            super.takeDamage(rawDamage);
        }
    }

    @Override
    public String toString() {
        return "=== SHIELDED PALADIN ===\n"
                + super.toString()
                + "\nМагічний щит: " + shieldPoints;
    }
}





