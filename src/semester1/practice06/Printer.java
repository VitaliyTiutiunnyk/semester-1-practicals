package semester1.practice06;

public class Printer {
    String model;
    int paperCount;
    public void printDocument(String title, int pages){
        if (paperCount>=pages){
            paperCount-=pages;
            System.out.println("Друк" +title+ "успішний!");
        }
        else {
            System.out.println("Помилка: Недостатньо паперу в принтері " +model+"!");
        }

    }
}
