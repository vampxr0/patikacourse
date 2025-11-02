import Managers.BookManager;
import Classes.Global;
import Interfaces.MenuConfig;

import java.util.Scanner;

public class SearchAndDisplay implements MenuConfig {


    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {


            Global.printMenuHeader("Search & Display Menu");
            int sd;
            System.out.println("*************   *********   *************" +
                    "\n1)Search a book\n2)Show all \n3)Book Services");
            if (sc.hasNextInt()) {
                sd = sc.nextInt();
                sc.nextLine(); // newline temizle

                if (sd == 1 || sd == 2 || sd == 3) {
                    running = menuPages(sd);

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
        BookManager bm = new BookManager();
        Scanner sc = new Scanner(System.in);
        switch (selection) {
            case 1:
                boolean running = true;
                int selection2;
                while (running) {
                    Global.printMenuHeader("Chose for search by ...");
                    System.out.println("\n1)Search by title\n2)Search by isbn\nReturn to 'Search & Display Menu' ");

                    if (sc.hasNextInt()) {
                        selection2 = sc.nextInt();
                        sc.nextLine(); // newline temizle

                        if (selection2 == 1 || selection2 == 2 || selection2 == 3) {
                            running = searchPage(selection2, bm, sc);

                        } else {
                            System.out.println("Only insert a value from the menu.");
                        }
                    } else {
                        System.out.println("Only insert a digit and a value from the menu.");
                        sc.nextLine(); //  hatalı input'u geç
                    }
                }


                break;
            case 2:
                bm.displayBooks(bm.getBookList());
                break;

            case 3:
                System.out.println("Logging out and returning to book services menu...");
                return false;

        }
        return true;
    }

    public boolean searchPage(int selection1, BookManager bm, Scanner sc) {
        switch (selection1) {
            case 1://by title
                System.out.println("Write title for search :");
                bm.displayBooks(bm.searchBook(sc.nextLine(), 1));
                break;
            case 2:// by isbn
                System.out.println("Write title for search :");
                bm.displayBooks(bm.searchBook(sc.nextLine(), 2));
                break;

        }
        return true;
    }

}
