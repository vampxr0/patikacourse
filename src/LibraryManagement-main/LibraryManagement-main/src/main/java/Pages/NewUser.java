import Auth;
import Classes.Global;
import Models.User;
import Managers.UserManager;

import java.util.Scanner;

public class NewUser {
    public void showMenu() {

        Scanner sc = new Scanner(System.in);

        Global.printMenuHeader("Sign Up Menu");
        System.out.println("Username:");
        String userName = sc.nextLine();

        boolean match = false;

        while (!match) {
            System.out.println("Password:");
            String passwd = sc.nextLine();
            System.out.println("Password again:");
            String passwd2 = sc.nextLine();


            if (passwd.equals(passwd2)) {
                match = true;
                System.out.println("Your account is creating...");
                User u = new User();
                u.setUserName(userName);
                u.setPassWord(passwd);
                // eger active user admin ise burasini kullanici seck
                if (Global.activeUser != null && Global.activeUser.getAuth() == Auth.ADMIN  ) {
                    System.out.println("Select new role:");
                    System.out.println("1 - ADMIN");
                    System.out.println("2 - EMPLOYEE");
                    System.out.println("3 - USER");
                    Auth selectedAuth = null;
                    while (true) {
                        System.out.print("Enter choice: ");
                        String choice = sc.nextLine().trim();

                        if (choice.isEmpty()) {
                            break; // Mevcut rolü koru
                        }

                        switch (choice) {
                            case "1":
                                selectedAuth = Auth.ADMIN;
                                break;
                            case "2":
                                selectedAuth = Auth.EMPLOYEE;
                                break;
                            case "3":
                                selectedAuth = Auth.USER;
                                break;
                            default:
                                System.out.println("Invalid choice. Please enter 1, 2, 3 or leave blank.");
                                continue;
                        }
                        break; // Geçerli seçim yapıldıysa döngüyü kır
                    }
                    u.setAuth(selectedAuth);
                } else {
                    u.setAuth(Auth.USER);
                }

                UserManager um = new UserManager();
                um.add(u);


            } else {
                System.out.println("Passwords does not match !");
                // Döngü devam edecek ve tekrar input alınacak
            }
        }

    }


}
