package semester1.practice07;

public class BookItem {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;
    public BookItem(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Книгу \"" + title + "\" видано.");
        } else {
            System.out.println("Книга \"" + title + "\" вже видана.");
        }
    }
    public void returnBook() {
        isAvailable = true;
        System.out.println("Книгу \"" + title + "\" повернуто.");
    }
    public void printBook() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Назва: " + title);
        System.out.println("Автор: " + author);

        if (isAvailable) {
            System.out.println("Статус: доступна");
        } else {
            System.out.println("Статус: видана");
        }

        System.out.println();
    }
    public String getTitle() {
        return title;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
}
