package semester1.practice09;

public class Task19 {
    public static void run(){
        Bookshelf shelf = new Bookshelf("Фантастика", 5);
        shelf.putBook(new BookItem("Дюна", "Френк Герберт", 500));
        shelf.putBook(new BookItem("1984", "Джордж Орвелл", 328));
        System.out.println(shelf);
    }
}
class BookItem{
    private final String title;
    private final String author;
    private final int pages;
    BookItem(String title, String author, int pages){
        this.title=title;
        this.author=author;
        this.pages=pages;
    }
    public int getPages() {
        return pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    @Override
    public String toString() {
        return "\nНазва: " + title +
                "\nАвтор: " + author +
                "\nКількість сторінок: " + pages;
    }
}
class Bookshelf{
    private final String genre;
    private final BookItem[] books;
    private int bookCount;
    Bookshelf(String genre,  int capacity){
        this.genre=genre;
        books=new BookItem[capacity];
    }
    public boolean putBook(BookItem book){
        if (book!=null && bookCount<books.length ){
            books[bookCount] = book;  bookCount++;
            return true;

        }
        return false;
    }
    public BookItem findLongestBook(){
        if (bookCount == 0) {
            return null;
        }
        BookItem longest = books[0];
        for (int i = 1; i < bookCount; i++) {
            if (books[i].getPages() > longest.getPages()) {
                longest = books[i];
            }
        }
        return longest;
    }
    public int getTotalPagesOnShelf(){
       int total=0;
       for (int i=0; i<bookCount; i++){
           total+=books[i].getPages();
       }
       return total;
    }
    @Override
    public String toString() {
        String result = "=== КНИЖКОВА ПОЛИЦЯ ===\n";
        result += "Жанр: " + genre ;
        for (int i = 0; i < bookCount; i++) {
            result += "" + books[i].toString() + "\n";
        }
        result += "Усього сторінок: " + getTotalPagesOnShelf()
        +"\n_________________________";
        return result;
    }
}