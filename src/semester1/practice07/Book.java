package semester1.practice07;

public class Book {
    private String title;
    private String author;
    private int year;
    private double price;
    public Book(){
        title="Невідомо";
        author="Невідомо";
        year=2000;
        price=0.0;
    }
  public   Book(String title, String author, int year, double price){
        this.title=title;
        this.author=author;
        this.year=year;
        this.price=price;
        if (this.year<0){
            this.year=2000;
        }
        if (this.price<0.0){
            this.price=0.0;
        }

  }
    public void printInfo(){
        System.out.println("Автор |"+author+"| Назва книги |"+title+"| Рік випуску |"+year+"| Ціна |"+price+"|");
    }

}
