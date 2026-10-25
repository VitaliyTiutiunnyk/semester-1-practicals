package semester1.practice07;

public class Memory {
    int sizeGB; int frequencyMHz; double price;
    public Memory(int sizeGB, int frequencyMHz, double price){
        this.sizeGB=sizeGB; this.frequencyMHz=frequencyMHz; this.price=price;
    }

    public double getPrice() {
        return price;
    }
}
