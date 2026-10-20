package semester1.practice06;

public class Counter {
    int count;
    public void increment(){
        count+=1;
    }
    public void decrement(){
        count-=1;
    }
    public void reset(){
        count*=0;
    }
    public void printCount(){
        System.out.println("Результат:"+count);
    }
}
