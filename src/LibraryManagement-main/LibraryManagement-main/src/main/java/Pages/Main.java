import Classes.Global;
import Auth;
import Status;
import Managers.BookManager;
import Managers.StorageManager;
import Managers.UserManager;
import Models.Book;
import Models.User;

import java.io.File;
import java.util.Scanner;

import static Classes.Global.*;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        File uFile = new File(JSON_FILE_user);

        if (!uFile.exists()) {//user.json dosyasi yoksa olusturulacak
            newUserJson();
            System.out.println("users.json oluşturuldu.");
        }




        File sFile = new File(JSON_FILE_storage);
        if (!sFile.exists()) {//storage.json dosyasi yoksa olusturulacak

            StorageManager sm = new StorageManager();

            sm.save(); // StorageManager constructor zaten boş Storage yüklüyor, direkt kaydet yeterli
            System.out.println("storage.json oluşturuldu.");
        }
        File bFile = new File(JSON_FILE_book);
        if (!bFile.exists()) {//book.json dosyasi yoksa olusturulacak
            newBookJson();
            System.out.println("books.json oluşturuldu.");
        }



        System.out.println(
                " _    _      _                            _                  \n" +
                        "| |  | |    | |                          | |                 \n" +
                        "| |  | | ___| | ___ ___  _ __ ___   ___  | |_ ___            \n" +
                        "| |/\\| |/ _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\           \n" +
                        "\\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) |          \n" +
                        " \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/           \n" +
                        "                                                              \n" +
                        " _   _       _                 _      ______                   \n" +
                        "| | | |     | |               ( )     |  ___|                  \n" +
                        "| | | |_   _| | ___ __ _ _ __ |/ ___  | |_ ___  _ __ __ _  ___ \n" +
                        "| | | | | | | |/ __/ _` | '_ \\  / __| |  _/ _ \\| '__/ _` |/ _ \\\n" +
                        "\\ \\_/ / |_| | | (_| (_| | | | | \\__ \\ | || (_) | | | (_| |  __/\n" +
                        " \\___/ \\__,_|_|\\___\\__,_|_| |_| |___/ \\_| \\___/|_|  \\__, |\\___|\n" +
                        "                                                     __/ |     \n" +
                        "                                                    |___/      "
        );
        System.out.println("01110100 01101000 01100101  01101100 01101001 01100010 01110010 01100001 01110010 01111001  01110111 01101000 01100101 01110010 01100101");
        System.out.println("01101011 01101110 01101111 01110111 01101100 01100101 01100100 01100111 01100101  01101001 01110011  01100110 01101111 01110010 01100111 01100101 01100100");


        while (true) {
            printMenuHeader("Main Menu");

            System.out.println("1)Log In\n2)Sign Up\n3)Exit");
            if (sc.hasNextInt()) {
                UserManager um = new UserManager();
                int mainM = sc.nextInt();
                sc.nextLine(); // newline temizle

                if (mainM == 1 || mainM == 2|| mainM == 3) {
                    MainMenu(mainM, um);
                }
                 else {
                    System.out.println("Only insert a value from the menu.");
                }
            } else {
                System.out.println("Only insert a digit and a value from the menu.");
                sc.nextLine(); //  hatalı input'u geç
            }

        }


    }

    public static void MainMenu(int mainM, UserManager um) {
        switch (mainM) {
            case 1:
                if (LoginMet(um)) {

                    switch (activeUser.getAuth()) {
                        case Auth.ADMIN:
                            LibraryMainPage lmp = new LibraryMainPage();
                            lmp.showMenu();


                            break;
                        case Auth.EMPLOYEE:
                            EmployeeLibraryPage plm = new EmployeeLibraryPage();
                            plm.showMenu();

                            break;
                        case Auth.USER:
                            BookServices bs = new BookServices();
                            bs.showMenu();
                            break;
                        default:
                            break;
                    }

                }
                break;
            case 2:
                NewUser n = new NewUser();
                n.showMenu();
                break;
            case 3:
                System.out.println("Exiting program...");
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public static boolean LoginMet(UserManager um) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("UserName:");
            String usr = sc.nextLine();
            System.out.println("Password:");
            String passwd = sc.nextLine();

            User u = um.check(usr, passwd);

            if (u != null) {
                activeUser = u;

                return true;


            } else {
                System.out.println("Invalid username or password ! ");
                // Döngü devam edecek ve tekrar input alınacak
            }
        }
    }



    public static void newBookJson() {

        for (int i = 0; i < 10; i++) {
            BookManager bm = new BookManager();
            StorageManager sm = new StorageManager();
            Book b = new Book();
            b.setTitle("Kitap"+(i+1));
            b.setAuthor("Yazar"+(i+1));
            b.setISBN();
            b.setStatus(Status.ACTIVE);
            b.setRentBy("-");
            b.setRentAt(Global.ZERO_DATE);

//            int bcIndex = (i % 5) + 1; // 0→BC1, 1→BC2 ... 4→BC5, sonra tekrar BC1
//            bm.generateSpecifiedStorageLocation("BC" + bcIndex, "S" + bcIndex)
            b.setStorageLocation(bm.generateNewStorageLocation());

            bm.add(b);
            sm.add(b);

        }




    }
    public static void newUserJson() {
        UserManager um = new UserManager();

        User u = new User();
        u.setPassWord("1234");
        u.setUserName("admin1");
        u.setAuth(Auth.ADMIN);
        um.add(u);
        u = new User();
        u.setPassWord("qwer");
        u.setUserName("employee1");
        u.setAuth(Auth.EMPLOYEE);
        um.add(u);
        u = new User();
        u.setPassWord("asdf");
        u.setUserName("user1");
        u.setAuth(Auth.USER);
        um.add(u);




    }
}
