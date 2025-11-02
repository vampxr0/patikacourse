import Classes.*;
import Status;
import Interfaces.MenuConfig;
import Managers.BookManager;
import Managers.StorageManager;
import Models.Book;

import java.util.Scanner;

public class AddNewBook implements MenuConfig {

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while(running){


            Global.printMenuHeader("Book Services");
            int bs;
            System.out.println("*************   *********   *************" +
                    "\n1)Auto add a new book\n2)Add a new book as specified" +
                    "\n3)Back to Library Menu");
            if (sc.hasNextInt()  ) {
                bs = sc.nextInt();
                sc.nextLine(); // newline temizle

                if (bs == 1 || bs == 2|| bs == 3 ) {
                    running = menuPages(bs);

                } else {
                    System.out.println("Only insert a value from the menu.");
                }
            } else {
                System.out.println("Only insert a digit and a value from the menu.");
                sc.nextLine(); //  hatalı input'u geç
            }

        }

    }

    @Override
    public boolean menuPages(int selection) {
        Scanner sc = new Scanner(System.in);
        BookManager bm = new BookManager();
        Book b = new Book();
        StorageManager sm = new StorageManager();
        switch (selection) {
            case 1:

                Global.printMenuHeader("Add a new book");
                System.out.print("Enter new books title: ");
                String title = sc.next();
                System.out.print("=====\nEnter new books author: ");
                String author = sc.next();

                b.setTitle(title);
                b.setAuthor(author);
                b.setISBN();
                b.setStatus(Status.ACTIVE);
                b.setRentBy("-");
                b.setRentAt(Global.ZERO_DATE);
                b.setStorageLocation(bm.generateNewStorageLocation());

                bm.add(b);
                sm.add(b);
                break;
            case 2:

                Global.printMenuHeader("Add a new book");
                System.out.print("Enter new books title: ");
                String title2 = sc.next();
                System.out.print("=====\nEnter new books author: ");
                String author2 = sc.next();
                System.out.print("=====\nEnter a book case name : ");
                String bookCase = sc.next();
                System.out.print("=====\nEnter a shelf name: ");
                String shelf = sc.next();

                b.setTitle(title2);
                b.setAuthor(author2);
                b.setISBN();
                b.setStatus(Status.ACTIVE);
                b.setRentBy("-");
                b.setRentAt(Global.ZERO_DATE);
                b.setStorageLocation(bm.generateSpecifiedStorageLocation(bookCase,shelf));
                bm.add(b);
                sm.add(b);
                break;


            case 3:
                System.out.println("Logging out and returning to main menu...");
                return false;  //



        }

        return true;
    }



}

