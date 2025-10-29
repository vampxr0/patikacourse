package week3.findingletters;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Belirlenmiş harfler.
        List<String> letters = new ArrayList<>();
        letters.add("a");
        letters.add("b");
        letters.add("c");
        letters.add("d");

        // Kullanıcıdan veri alma
        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            System.out.print((i + 1) + ". tahmininizi giriniz: ");
            String input = scanner.nextLine();
            inputs.add(input.toLowerCase()); // Küçük harfe çevirir
        }

        System.out.println(letters);
        // Yeni harf ekleme işlemi ve Found ile değiştirme
        for (int i = 0; i < inputs.size(); i++) {
            String guess = inputs.get(i);
            boolean matched = false;

            for (int j = 0; j < letters.size(); j++) {
                if (letters.get(j).equalsIgnoreCase(guess)) {
                    letters.set(j, "Found");
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                letters.add(guess);
            }
        }

        // Ekrana Yazdırma
        System.out.println(letters);

        scanner.close();

    }
}