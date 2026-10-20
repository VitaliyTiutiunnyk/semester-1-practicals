package semester1.practice06;

public class Employee {
    String name;
    double baseSalary;
    double bonusPercentage;
    public double calculateTotalSalary(){
        return baseSalary*(1+bonusPercentage/100);
    }
    public double calculateTax(){
        return calculateTotalSalary()*0.195;

    }
}
