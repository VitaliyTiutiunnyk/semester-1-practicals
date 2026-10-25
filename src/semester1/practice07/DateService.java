package semester1.practice07;



public class DateService {
    int day;
    int month;
    int year;

    public DateService(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void add(int days) {
        day += days;
        normalize();
    }

    private void normalize() {
        while (day > 30) {
            day -= 30;
            month++;
        }

        while (month > 12) {
            month -= 12;
            year++;
        }
    }

    public void add(int days, int months) {
        day += days;
        month += months;
        normalize();
    }

    public void add(int days, int months, int years) {
        day += days;
        month += months;
        year += years;
        normalize();
    }

    public void printDate() {
        System.out.printf("%02d.%02d.%d%n", day, month, year);
    }
}