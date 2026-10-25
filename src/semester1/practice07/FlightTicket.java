package semester1.practice07;

public class FlightTicket {
    String ticketNumber;
    String passengerName;
    String flightNumber;
    String departureCity;
    String arrivalCity;
    String seatNumber;
    boolean hasBaggage;
    public FlightTicket(String ticketNumber, String passengerName, String flightNumber,
                        String departureCity, String arrivalCity, String seatNumber, boolean hasBaggage){
        this.ticketNumber = ticketNumber;
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.seatNumber = seatNumber;
        this.hasBaggage = hasBaggage;
    }
    public FlightTicket(String ticketNumber, String passengerName, String flightNumber, String departureCity, String arrivalCity){
        this(ticketNumber, passengerName, flightNumber, departureCity, arrivalCity, "UNASSIGNED",  false);

    }
    public void assignSeat(String seat){
        this.seatNumber=seat;
    }public void printBoardingPass(){
        System.out.println("---------ПАСАЖИРСЬКИЙ КВИТОК---------");
        System.out.println(" Номер квитка - "+ticketNumber);
        System.out.println(" Ім'я пасж. - "+passengerName);
        System.out.println(" Номер польоту - "+flightNumber);
        System.out.println(" Місто відправлення - "+departureCity);
        System.out.println(" Місто прибуття - "+arrivalCity);
        System.out.println(" Номер місця - "+seatNumber);
        System.out.println(" Чи має багаж - "+hasBaggage);
        System.out.println(" ГАРНОЇ ПОДОРОЖІ!)))");
        System.out.println("______________________________________");
    }


}
