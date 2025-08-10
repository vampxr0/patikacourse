package proje1.Library;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Kütüphane Yönetim Sistemi için konsol arayüzü.
 */
public class ConsoleUI {
    private LibraryManager libraryManager;
    private Scanner scanner;

    public ConsoleUI() {
        libraryManager = new LibraryManager();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        // Menü için ana döngü
        while (running) {
            printMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> libraryManager.displayBooks();
                case 3 -> searchBook();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> {
                    System.out.println("Sistemden çıkılıyor. Hoşça kalın!");
                    running = false;
                }
                default -> System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }

        // Bellek sızıntılarını önlemek için scanner kaynağını kapatın.
        scanner.close();
    }

    private void printMenu() {
        System.out.println("\n--- Kütüphane Menüsü ---");
        System.out.println("1. Kitap Ekle");
        System.out.println("2. Tüm Kitaplara Bak");
        System.out.println("3. Kitabı Başlığa Göre Ara");
        System.out.println("4. Kitap Ödünç Al");
        System.out.println("5. Kitabı iade et");
        System.out.println("6. Çıkış");
        System.out.print("Bir seçenek seçin: ");
    }

    private int getUserChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // geçersiz girişi temizle
            return -1; // geçersiz seçim
        }
    }

    private void addBook() {
        System.out.print("Kitap başlığını girin: ");
        String title = scanner.nextLine();
        System.out.print("Yazar adını girin: ");
        String author = scanner.nextLine();
        libraryManager.addBook(title, author);
    }

    private void searchBook() {
        System.out.print("Arama yapmak için başlığı girin: ");
        String title = scanner.nextLine();
        Book book = libraryManager.findBookByTitle(title);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Kitap bulunamadı.");
        }
    }

    private void borrowBook() {
        System.out.print("Ödünç almak için başlığı girin: ");
        String title = scanner.nextLine();
        libraryManager.borrowBook(title);
    }

    private void returnBook() {
        System.out.print("Geri dönmek için başlığı girin: ");
        String title = scanner.nextLine();
        libraryManager.returnBook(title);
    }

    public static void main(String[] args) {
        new ConsoleUI().start();
    }
}

