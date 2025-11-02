import Classes.Global;
import Managers.StorageManager;
import Managers.UserManager;
import Interfaces.MenuConfig;

import java.util.Scanner;

public class UserManagement implements MenuConfig {
    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {


            Global.printMenuHeader("User Management");
            int bs;
            System.out.println("*************   *********   *************" +
                    "\n1)Search a user\n2)List all users" +
                    "\n3)Add a user\n4)Edit a users" +
                    "\n5)Back to Library Menu");

            //add bookcase

            if (sc.hasNextInt()) {
                bs = sc.nextInt();
                sc.nextLine(); // newline temizle

                if (bs == 1 || bs == 2 || bs == 3 || bs == 4 || bs == 5 ) {
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
        UserManager um = new UserManager();
        StorageManager sm = new StorageManager();
        Scanner sc = new Scanner(System.in);
        switch (selection) {
            case 1:
                System.out.println("Write title for search :");
                um.displayUsers(um.searchUser(sc.nextLine()));
                break;
            case 2:
                um.displayUsers(um.getUserList());
                break;

            case 3:
                NewUser nu = new NewUser();
                nu.showMenu();
                break;
            case 4:
                System.out.println("Write username for edit :");
                um.editUser(sc.nextLine());
                break;

            case 5:
                System.out.println("Logging out and returning to book services menu...");
                return false;

        }
        return true;
    }
}
