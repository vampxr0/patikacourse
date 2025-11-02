import Classes.Global;
import Interfaces.MenuConfig;

import java.util.Scanner;

public class BookServices implements MenuConfig {


    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while(running){


            Global.printMenuHeader("Book Services");
            int bs;
            System.out.println("*************   *********   *************" +
                    "\n1)Search And Display\n2)Check Out and Retrun a book\n3)Back to Library Menu");
            if (sc.hasNextInt()  ) {
                bs = sc.nextInt();
                sc.nextLine(); // newline temizle

                if (bs == 1 || bs == 2 || bs == 3 ) {
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
        switch (selection) {
            case 1:
                SearchAndDisplay sad = new SearchAndDisplay();
                sad.showMenu();
                break;
            case 2:
                CheckOutAndReturn coar = new CheckOutAndReturn();
                coar.showMenu();

            case 3:
                System.out.println("Logging out and returning to main menu...");
                return false;  //



        }
        return true;
    }




}
