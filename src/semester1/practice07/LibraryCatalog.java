package semester1.practice07;

public class LibraryCatalog {
    private BookItem[] books;
    private int size;
    public LibraryCatalog(int capacity) {
        books = new BookItem[capacity];
        size = 0;
    }
    public void addBook(BookItem book) {
        if (book == null) {
            System.out.println("Не можна додати порожню книгу!");
            return;
        }
        if (size < books.length) {
            books[size] = book;
            size++;
            System.out.println("Книгу додано до каталогу.");
        } else {
            System.out.println("Каталог заповнений!");
        }
    }
    public BookItem findBookByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }

        return null;
    }
    public boolean borrowBook(String title) {
        BookItem book = findBookByTitle(title);
        if (book != null && book.isAvailable()) {
            book.borrowBook();
            return true;
        }
        System.out.println("Книга \"" + title + "\" відсутня або вже видана.");
        return false;
    }
    public void printCatalog() {
        System.out.println("\n=== БІБЛІОТЕЧНИЙ КАТАЛОГ ===");

        for (int i = 0; i < size; i++) {
            books[i].printBook();
        }
    }
}
