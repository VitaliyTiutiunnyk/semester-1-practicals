package semester1.practice09;

public class Task23 {
    public static void run(){
        PassengerTrain train = new PassengerTrain("Київ — Львів", 3);
        TrainCarriage c1 = new TrainCarriage(1, "Купе", 36, 20);
        TrainCarriage c2 = new TrainCarriage(2, "Плацкарт", 54, 40);
        TrainCarriage c3 = new TrainCarriage(3, "Інтерсіті", 40, 10);
        train.attachCarriage(c1);
        train.attachCarriage(c2);
        train.attachCarriage(c3);
        System.out.println(train);
        System.out.println("\n=== БРОНЮВАННЯ ===");
        System.out.println("Бронювання 10 місць у вагоні №1: " +
                train.bookTicketsInCarriage(1, 10));

        System.out.println("Бронювання 20 місць у вагоні №1: " +
                train.bookTicketsInCarriage(1, 20));

        System.out.println("Бронювання 5 місць у вагоні №2: " +
                train.bookTicketsInCarriage(2, 5));
        System.out.println("\n=== ПІСЛЯ БРОНЮВАННЯ ===");
        System.out.println(train);
    }


}
class TrainCarriage{
    private final int carriageNumber;
    private final String type;
    private final int totalSeats;
    private int occupiedSeats;
    TrainCarriage(int carriageNumber, String type, int totalSeats, int occupiedSeats){
        this.carriageNumber=carriageNumber;
        this.type=type;
        this.totalSeats=totalSeats;
        this.occupiedSeats=occupiedSeats;
    }
    public int getCarriageNumber() {
        return carriageNumber;
    }

    public String getType() {
        return type;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getOccupiedSeats() {
        return occupiedSeats;
    }
    public boolean bookSeats(int seats) {
        if (seats <= 0 || occupiedSeats + seats > totalSeats) {
            return false;
        }
        occupiedSeats += seats;
        return true;
    }
    @Override
    public String toString() {
        return "Вагон №" + carriageNumber +
                ", тип: " + type +
                ", всього місць: " + totalSeats +
                ", зайнято: " + occupiedSeats +
                ", вільно: " + (totalSeats - occupiedSeats);
    }
}
class PassengerTrain{
    private final String route;
    private final TrainCarriage[] carriages;
    private int carriageCount;
    PassengerTrain(String route, int capacity){
        this.route=route;
        carriages=new TrainCarriage[capacity];
    }
    public void attachCarriage(TrainCarriage c){
        if (c!=null && carriageCount<carriages.length){
            carriages[carriageCount]=c;
            carriageCount++;
        }
    }
    public int getTotalFreeSeats(){
        int total = 0;
        for (int i = 0; i < carriageCount; i++) {
            total += carriages[i].getTotalSeats() -
                    carriages[i].getOccupiedSeats();
        }
        return total;
    }
    public boolean bookTicketsInCarriage(int carriageNumber, int seatsToBook) {
        for (int i = 0; i < carriageCount; i++) {
            if (carriages[i].getCarriageNumber() == carriageNumber) {
                return carriages[i].bookSeats(seatsToBook);
            }
        }
        return false;
    }
    @Override
    public String toString() {
        String result = "=== ПОЇЗД: " + route + " ===\n";

        for (int i = 0; i < carriageCount; i++) {
            result += carriages[i].toString() + "\n";
        }

        result += "Кількість вагонів: " + carriageCount + "\n";
        result += "Загальна кількість вільних місць: " + getTotalFreeSeats();

        return result;
    }

}

