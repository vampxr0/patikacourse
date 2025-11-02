import Global;
import Auth;
import Interfaces.Management;
import User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;



import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager implements Management<User>  {




    private final List<User> userList ;



    public List<User> getUserList() {
        return userList;
    }
    private final Gson gson;
    public UserManager() {
        gson = new GsonBuilder().setPrettyPrinting().create();// pretty paint icin
        userList = load();

    }
    public User check(String user, String passwd) {
        return userList.stream()
                .filter(u -> u.getUserName().equalsIgnoreCase(user) &&
                        u.getPassWord().equals(passwd))
                .findFirst()
                .map(matchedUser -> {
                    Global.activeUser = matchedUser;
                    return matchedUser;
                })
                .orElse(null);
    }


    @Override
    public List<User> load() {
        try (FileReader reader = new FileReader(Global.JSON_FILE_user)) {
            Type userListType = new TypeToken<ArrayList<User>>(){}.getType();
            List<User> users = gson.fromJson(reader, userListType);
            return users != null ? users : new ArrayList<>();
        } catch (IOException e) {
            // Dosya yoksa veya okunamazsa boş liste dön
            return new ArrayList<>();
        }
    }

    @Override
    public void save() {
        try (FileWriter writer = new FileWriter(Global.JSON_FILE_user)) {
            gson.toJson(userList, writer);


        } catch (IOException e) {
            System.out.println("New user not created : " + e.getMessage());
        }

    }

    @Override
    public boolean exists(User item) {
        return userList.stream()
                .anyMatch(user -> user.getUserName().equalsIgnoreCase(item.getUserName()));
    }



    @Override
    public void add(User newUser) {
        if (exists(newUser)) {
            System.out.println("This username already exists!");

        }else{
            userList.add(newUser);
            save();
            if(!newUser.getUserName().equals("admin"))
                System.out.println("New user has been created.");
        }


    }
    public  void displayUsers(List<User> users) {
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        for (User user : users) {
            System.out.println("-----");
            System.out.println(user);
            System.out.println("-----");
        }
    }
    public List<User> searchUser(String query) {
        if (userList.isEmpty()) {
            System.out.println("No users found.");
            return new ArrayList<>();
        }

        return  userList.stream()
                .filter(user -> user.getUserName().toLowerCase().contains(query.toLowerCase()))
                .toList();


    }
    public void editUser(String username) {
        Scanner sc = new Scanner(System.in);

        // Kullanıcıyı bul
        User existingUser = userList.stream()
                .filter(user -> user.getUserName().equalsIgnoreCase(username))
                .findFirst()
                .orElse(null);

        if (existingUser == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Editing user: " + existingUser.getUserName());

        // Yeni kullanıcı adını al
        System.out.print("Enter new username (leave blank to keep current): ");
        String newUsername = sc.nextLine().trim();
        if (!newUsername.isEmpty()) {
            existingUser.setUserName(newUsername);
        }

        // Yeni şifreyi al
        System.out.print("Enter new password (leave blank to keep current): ");
        String newPassword = sc.nextLine().trim();
        if (!newPassword.isEmpty()) {
            existingUser.setPassWord(newPassword);
        }

        // Yeni rolü seç (Auth)
        System.out.println("Select new role:");
        System.out.println("1 - ADMIN");
        System.out.println("2 - EMPLOYEE");
        System.out.println("3 - USER");
        System.out.println("Leave blank to keep current.");

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

        if (selectedAuth != null) {
            existingUser.setAuth(selectedAuth);
        }

        save(); // Güncellenmiş kullanıcıyı JSON dosyasına kaydet
        System.out.println("User updated successfully.");
    }
}
