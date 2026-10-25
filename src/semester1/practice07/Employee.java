package semester1.practice07;

public class Employee {
    private int id;
 private    String fullName;
  private   String position;
   private double monthlySalary;
    public Employee(int id,String fullName, String position, double monthlySalary ){
        this.id=id;
        this.fullName=fullName;
        this.position=position;
        this.monthlySalary=monthlySalary;
    }
    public void raiseSalary(double percent){
        if (percent <= 0) {
            return;
        }
        monthlySalary = monthlySalary + monthlySalary * percent / 100;
    }
    public double getAnnualSalary(){
        return monthlySalary*12;
    }
    public void printBadge(){
        System.out.println("___________КАРТКА ПРАЦІВНИКА_____________");
        System.out.println("Працівник: "+fullName+" ID: "+id);
        System.out.println("Посада: "+position+" |");
        System.out.println("Місячна зарплата: "+monthlySalary+" грн");
        System.out.println("Річний дохід: "+getAnnualSalary()+" грн");
        System.out.println("__________________________________________");
    }

}
