package proje1.Library;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Console interface for the Library Management System.
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

        // Main loop for menu
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
                    System.out.println("Exiting the system. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        // Close scanner resource to prevent memory leaks
        scanner.close();
    }

    private void printMenu() {
        System.out.println("\n--- Library Menu ---");
        System.out.println("1. Add Book");
        System.out.println("2. View All Books");
        System.out.println("3. Search Book by Title");
        System.out.println("4. Borrow Book");
        System.out.println("5. Return Book");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    private int getUserChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // clear invalid input
            return -1; // invalid choice
        }
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        libraryManager.addBook(title, author);
    }

    private void searchBook() {
        System.out.print("Enter title to search: ");
        String title = scanner.nextLine();
        Book book = libraryManager.findBookByTitle(title);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }
    }

    private void borrowBook() {
        System.out.print("Enter title to borrow: ");
        String title = scanner.nextLine();
        libraryManager.borrowBook(title);
    }

    private void returnBook() {
        System.out.print("Enter title to return: ");
        String title = scanner.nextLine();
        libraryManager.returnBook(title);
    }

    public static void main(String[] args) {
        new ConsoleUI().start();
    }
}

