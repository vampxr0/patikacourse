package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        NearestNumbers nearest = new NearestNumbers();

        System.out.print("Kaç sayı gireceksiniz? ");
        int count = scanner.nextInt();

        List<Integer> input = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            System.out.print((i + 1) + ". sayıyı giriniz: ");
            input.add(scanner.nextInt());
        }

        try {
            nearest.setNumbers(input);
            nearest.findNearestPairs();
            System.out.println(nearest);
        } catch (IllegalArgumentException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}