package semester1.practice06;

public class ArraySearcher {
    private int[] data;
    public void setData(int[] data){
        this.data = data;
    }
    public boolean contains(int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return true;
            }
        }
        return false;
    }
    public int findIndex(int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
