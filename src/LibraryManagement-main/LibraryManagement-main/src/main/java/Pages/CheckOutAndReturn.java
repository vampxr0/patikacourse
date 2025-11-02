import Managers.BookManager;
import Classes.Global;
import Interfaces.MenuConfig;
import Models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckOutAndReturn implements MenuConfig {


    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while(running){


            Global.printMenuHeader("Borrow & Return Menu");
            int cor;
            System.out.println("*************   *********   *************" +
                    "\n1)Check Out a book\n2)Return a book\n3)Back to Library Menu");
            if (sc.hasNextInt()  ) {
                cor = sc.nextInt();
                sc.nextLine(); // newline temizle

                if (cor == 1 || cor == 2|| cor == 3 ) {
                    running = menuPages(cor);

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
        List<Book> list1 = new ArrayList<>();
        list1 = bm.searchBook(sc.nextLine(),2);
        switch (selection) {
            case 1:
                System.out.println("Write isbn for check out :");

                bm.checkOut(list1.getFirst().getStorageLocation());

                break;
            case 2:
                System.out.println("Write isbn for return :");

                bm.returnBook(list1.getFirst().getStorageLocation());
                break;

            case 3:
                System.out.println("Logging out and returning to main menu...");
                return false;  //



        }
        return true;
    }


}
