import User;

public class Global {
    public static User activeUser;
    public static final String JSON_FILE_user = "users.json";
    public static final String JSON_FILE_book = "books.json";
    public static final String JSON_FILE_storage = "storage.json";
    public static final String ZERO_DATE = "0000-00-00 00:00:00";
    public static void printMenuHeader(String title) {
        int width = 37; // Kutu genişliği (╔═════════32══════════╗)
        int paddingSize = (width - title.length()) / 2;
        String padding = " ".repeat(Math.max(0, paddingSize));
        String formattedTitle = padding + title + padding;

        // Genişlik tek sayıda ve title uzunluğu çiftse hizalama kayabilir, düzeltelim
        if (formattedTitle.length() < width) {
            formattedTitle += " ";
        }

        System.out.println("╔" + "═".repeat(width) + "╗");
        System.out.println("║" + formattedTitle + "║");
        System.out.println("╚" + "═".repeat(width) + "╝");
    }
}
