package semester1.practice06;

public class SimpleCalculator {
    public int add(int a, int b) {
        return a+b;

    }
    public int subtract(int a, int b){
        return a-b;
    }
    public int multiply(int a, int b){
        return a*b;
    }
    public double divide(int a, int b){
        if (b==0){
            System.out.println("Помилка ділення на нуль!");
            return 0.0;
        }
        else {
            return (double)a/b;
        }
    }
}