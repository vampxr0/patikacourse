package proje1.Library;


import java.util.ArrayList;
import java.util.List;

/**
 * Kütüphane kitap işlemlerini yönetir (ekleme, arama, ödünç alma, iade).
 */
public class LibraryManager {
    private List<Book> books = new ArrayList<>();

    public void addBook(String title, String author) {
        if (title.isBlank() || author.isBlank()) {
            System.out.println("Kitap adı ve yazarı boş bırakılamaz.");
            return;
        }
        books.add(new Book(title, author));
        System.out.println("Kitap başarıyla eklendi!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Kütüphanede kitap yok.");
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
            System.out.println("Kitap bulunamadı.");
        } else if (book.isBorrowed()) {
            System.out.println("Bu kitap zaten ödünç alınmış.");
        } else {
            book.borrow();
            System.out.println("Kitap başarıyla ödünç alındı!");
        }
    }

    public void returnBook(String title) {
        Book book = findBookByTitle(title);
        if (book == null) {
            System.out.println("Kitap bulunamadı.");
        } else if (!book.isBorrowed()) {
            System.out.println("Bu kitap ödünç alınmamıştır.");
        } else {
            book.returnBook();
            System.out.println("Kitap başarıyla iade edildi!");
        }
    }
}
