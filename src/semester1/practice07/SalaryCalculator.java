package semester1.practice07;

public class SalaryCalculator {
    public double calculate(double baseRate){
        return baseRate;
    }
    public double calculate(double baseRate, double fixedBonus){
        return baseRate+fixedBonus;
    }
    public double calculate(double baseRate, double bonusPercent, boolean isTaxDeducted){
        double result=baseRate+baseRate*bonusPercent/100;
        if (isTaxDeducted){
            result=result*0.805;
        }
        return result;
    }
}
