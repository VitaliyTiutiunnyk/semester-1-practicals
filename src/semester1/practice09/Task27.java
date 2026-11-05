package semester1.practice09;

public class Task27 {
    public static void run(){
        SalariedEmployee employee = new SalariedEmployee(1, "Віталій", 0.195, 30000, 5000);
        HourlyContractor contractor = new HourlyContractor(2, "Дмитро", 0.195, 180, 200);
        System.out.println(employee);
        System.out.println(contractor);
    }

}
abstract class AbstractEmployee {
    private final int id;
    private final String name;
    protected double taxRate;

    AbstractEmployee(int id, String name, double taxRate) {
        this.id = id;
        this.name = name;
        this.taxRate = taxRate;
    }

    public abstract double calculateGrossSalary();

    public final double calculateNetSalary() {
        return calculateGrossSalary() * (1.0 - taxRate);
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", ім'я: " + name +
                ", зарплата брутто: " + calculateGrossSalary() +
                ", зарплата нетто: " + calculateNetSalary();
    }
}

class SalariedEmployee extends AbstractEmployee {
    private double monthlySalary;
    private double bonus;

    SalariedEmployee(int id, String name, double taxRate, double monthlySalary, double bonus) {
        super(id, name, taxRate);
        this.monthlySalary = monthlySalary;
        this.bonus = bonus;
    }

    @Override
    public double calculateGrossSalary() {
        return monthlySalary + bonus;
    }
}

class HourlyContractor extends AbstractEmployee {
    private int hoursWorked;
    private double hourlyRate;

    HourlyContractor(int id, String name, double taxRate, int hoursWorked, double hourlyRate) {
        super(id, name, taxRate);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateGrossSalary() {
        if (hoursWorked <= 160) {
            return hoursWorked * hourlyRate;
        } else {
            return 160 * hourlyRate + (hoursWorked - 160) * hourlyRate * 1.5;
        }
    }
}
