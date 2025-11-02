import Classes.Global;
import Interfaces.MenuConfig;
import Managers.StorageManager;
import Managers.UserManager;

import java.util.Scanner;

public class StorageManagement implements MenuConfig {
    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {


            Global.printMenuHeader("Storage Management");
            int bs;
            System.out.println("*************   *********   *************" +

                    "\n1)Show storage \n2)Add bookcase" +
                    "\n3)Back to Library Menu");

            //add bookcase

            if (sc.hasNextInt()) {
                bs = sc.nextInt();
                sc.nextLine(); // newline temizle

                if (bs == 1 || bs == 2 || bs == 3) {
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

        StorageManager sm = new StorageManager();

        switch (selection) {

            case 1:
                sm.printStorage();
                break;
            case 2:
                sm.addBookCase();
                break;
            case 3:
                System.out.println("Logging out and returning to book services menu...");
                return false;

        }
        return true;
    }
}