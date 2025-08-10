package proje1.Library;



/**
 * Kütüphanedeki tek bir kitabı temsil eder.
 */
public class Book {
    private String title;
    private String author;
    private boolean borrowed;

    public Book(String title, String author) {
        this.title = title.trim();
        this.author = author.trim();
        this.borrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void borrow() {
        borrowed = true;
    }

    public void returnBook() {
        borrowed = false;
    }

    @Override
    public String toString() {
        return String.format("%s by %s %s", title, author, borrowed ? "(Borrowed)" : "(Available)");
    }
}
