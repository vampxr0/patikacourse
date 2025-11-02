import Global;
import Status;
import Interfaces.Management;
import Book;
import Storage;
import StorageLocation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class BookManager implements Management<Book> {


    public List<Book> getBookList() {
        return bookList;
    }

    private final List<Book> bookList ;
    private final Gson gson;



    public BookManager() {

        this.gson = new GsonBuilder().setPrettyPrinting().create();
        bookList = load();

    }
    @Override
    public List<Book> load() {
        try (FileReader reader = new FileReader(Global.JSON_FILE_book)) {
            Type bookListType = new TypeToken<ArrayList<Book>>(){}.getType();
            List<Book> books = gson.fromJson(reader, bookListType);
            return books != null ? books : new ArrayList<>();
        } catch (IOException e) {
            // Dosya yoksa veya okunamazsa boş liste dön
            return new ArrayList<>();
        }
    }

    @Override
    public void save() {// Listeyi JSON'a kaydet
        try (FileWriter writer = new FileWriter(Global.JSON_FILE_book)) {
            gson.toJson(bookList, writer);




        } catch (IOException e) {
            System.out.println("New book not added: " + e.getMessage());
        }

    }

    @Override
    public boolean exists(Book item) {
        return bookList.stream()
                .anyMatch(book -> book.getTitle().equalsIgnoreCase(item.getTitle()));
    }

    @Override
    public void add(Book newBook) {
        if (exists(newBook)) {
            System.out.println("This bookname already exists!");


        }else{
            bookList.add(newBook);

            save();

            System.out.println("New book has been created.");
        }

    }
    public  void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        for (Book book : books) {
            System.out.println("-----");
            System.out.println(book);
            System.out.println("-----");
        }
    }
    public List<Book> searchBook(String query,int searchType) {
        if (bookList.isEmpty()) {
            //System.out.println("No books found.");
            return new ArrayList<>();
        }
        if (searchType == 1) {
            return  bookList.stream()
                    .filter(book -> book.getTitle().toLowerCase().contains(query.toLowerCase()))
                    .toList();
        }else{
            return  bookList.stream()
                    .filter(book -> book.getISBN().toLowerCase().contains(query.toLowerCase()))
                    .toList();
        }



    }
    public void checkOut(String StorageLocation){
        List<Book> matchedBook = bookList.stream()
                .filter(book -> book.getStorageLocation().equalsIgnoreCase(StorageLocation))
                //.filter(book -> book.getStatus() == Status.ACTIVE)
                .toList();

        if (matchedBook.isEmpty()) {
            System.out.println("Book not found.");
            return;
        }


        Book book = matchedBook.getFirst();

        if (book.getStatus() == Status.INACTIVE) {
            System.out.println("This book is already checked out.");
            return;
        }

        //kiralanmak isteyen kitabin ilgili alanlarinin guncellemesi yapilir

        book.setStatus(Status.INACTIVE);
        book.setRentAt(new Date().toString());
        book.setRentBy(Global.activeUser.getUserName());

        save();
        StorageManager sm = new StorageManager();
        sm.remove(book);
        System.out.println("Book has been checked out.");
    }
    public void returnBook(String StorageLocation){
        List<Book> matchedBook = bookList.stream()
                .filter(book -> book.getStorageLocation().equalsIgnoreCase(StorageLocation))
                //.filter(book -> book.getStatus() == Status.INACTIVE)
                .toList();

        if (matchedBook.isEmpty()) {
            System.out.println("Book not found.");
            return;
        }

        Book book = matchedBook.getFirst();

        if (book.getStatus() == Status.ACTIVE) {
            System.out.println("This book looks like in library already.");
            return;
        }

        //kiralanmak isteyen kitabin ilgili alanlarinin guncellemesi yapilir

        book.setStatus(Status.ACTIVE);
        book.setRentAt(Global.ZERO_DATE);
        book.setRentBy("-");

        save();
        StorageManager sm = new StorageManager();
        sm.add(book);
        System.out.println("Book has been returned.");
    }
    public String generateNewStorageLocation() {

        // 1. Storage'dan ilk boş yeri al


        for (int i = 1; i <= 5; i++) {
            StorageManager sm = new StorageManager();
            Storage storage = sm.getStorage();
            Map<String, Map<String, Integer>> map = storage.getStorage();
            String bookCase = "BC" + i;
            Map<String, Integer> shelves = map.get(bookCase);

            for (int j = 1; j <= 5; j++) {
                String shelf = "S" + j;
                int count = shelves.get(shelf);

                if (count < 5) {
                    // 2. ID'yi belirle (count + 1)
                    int id = sm.getNextIdForSpot(bookCase, shelf);


                    // 3. StorageLocation'i oluştur
                    return bookCase + "_" + shelf + "_" + id;
                }

            }
        }

        // Eğer boş yer yoksa null ya da uygun mesaj dön
        return null;
    }
    public String generateSpecifiedStorageLocation(String bookCase,String shelf){
        int id;
        while(true){
            StorageManager sm = new StorageManager();
            id= sm.getNextIdForSpot(bookCase, shelf);
            if (id <= 5) {
                break;
            }
            else{
                Scanner sc = new Scanner(System.in);
                System.out.println("This shelf is full in this bookcase. Select another bookcase or shelf.");

                System.out.print("Enter new bookcase (e.g., BC1): ");
                bookCase = sc.nextLine().trim();

                System.out.print("Enter new shelf (e.g., S1): ");
                shelf = sc.nextLine().trim();
            }
        }



        return bookCase + "_" + shelf + "_" + id;
    }



}
