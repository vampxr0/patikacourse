import Classes.Global;
import Interfaces.MenuConfig;
import Managers.BookManager;

import java.util.Scanner;

public class EmployeeLibraryPage implements MenuConfig {


    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            Global.printMenuHeader("Library Menu");

            int libM;
            System.out.println("*************   *********   *************" +
                    "\n1)Add a new book\n2)Book Services" +
                    "\n3)Log out");
            if (sc.hasNextInt()) {
                libM = sc.nextInt();
                sc.nextLine(); // newline temizle

                if (libM == 1 || libM == 2 || libM == 3) {
                    running = menuPages(libM);

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

        switch (selection) {
            case 1://new book menu
                AddNewBook anb = new AddNewBook();
                anb.showMenu();
                break;


            case 2://book services
                BookServices bs = new BookServices();
                bs.showMenu();

                break;
            case 3:

                System.out.println("Logging out and returning to main menu...");
                return false;
        }
        return true;
    }
}

