package proje1.Library;


import java.util.ArrayList;
import java.util.List;

/**
 * Manages library book operations (add, search, borrow, return).
 */
public class LibraryManager {
    private List<Book> books = new ArrayList<>();

    public void addBook(String title, String author) {
        if (title.isBlank() || author.isBlank()) {
            System.out.println("Book title and author cannot be empty.");
            return;
        }
        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBookByTitle(String title) {
        if (title.isBlank()) return null;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title.trim())) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String title) {
        Book book = findBookByTitle(title);
        if (book == null) {
            System.out.println("Book not found.");
        } else if (book.isBorrowed()) {
            System.out.println("This book is already borrowed.");
        } else {
            book.borrow();
            System.out.println("Book borrowed successfully!");
        }
    }

    public void returnBook(String title) {
        Book book = findBookByTitle(title);
        if (book == null) {
            System.out.println("Book not found.");
        } else if (!book.isBorrowed()) {
            System.out.println("This book was not borrowed.");
        } else {
            book.returnBook();
            System.out.println("Book returned successfully!");
        }
    }
}
