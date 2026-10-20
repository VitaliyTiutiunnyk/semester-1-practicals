package semester1.practice06;

public class ArrayStats {
    private int[] numbers;
    public void setData(int[] n){
        numbers=n;
    }
    public int countEvens(){
        int count=0;
        for (int i=0;i<numbers.length;i++){
            if (numbers[i]%2==0){
                count++;
            }

        }
        return count;
    }
    public int countOdds(){
        int count_=0;
        for (int i=0;i< numbers.length;i++){
            if (numbers[i]%2!=0){
                count_++;
            }
        }
        return count_;
    }
    public int calculateSum(){
        int sum=0;
        for (int i=0;i<numbers.length;i++){
            sum+=numbers[i];
        }
        return sum;
    }
}
