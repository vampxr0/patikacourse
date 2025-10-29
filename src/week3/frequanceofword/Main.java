package week3.frequanceofword;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("İstediğiniz bir kelimeyi giriniz: ");
        String input = scanner.nextLine();

        // Büyük/küçük farkını kaldırır ve sadece harfleri alır
        input = input.toLowerCase().replaceAll("[^a-z]", "");

        // Harfleri tutacak Map
        Map<Character, Integer> harfFrekansi = new HashMap<>();


        // Harfleri ekledikten sonra tekrar eden varsa value değerlerini bir bir artırır
        for (char c : input.toCharArray()) {
            harfFrekansi.put(c, harfFrekansi.getOrDefault(c, 0) + 1);
        }

        // Sonuçları ekrana yazdır
        for (Map.Entry<Character, Integer> entry : harfFrekansi.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}