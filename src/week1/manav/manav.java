package week1.manav;

import java.util.Scanner;

public class manav {
    public static void main(String[] args) {
        double armut = 2.14;
        double elma = 3.67;
        double domates = 1.11;
        double muz = 0.95;
        double patlıcan = 5.00;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Armut kaç kilogram ? :");
        double armut_kilo = scanner.nextDouble();

        System.out.println("Elma kaç kilogram ? :");
        double elma_kilo = scanner.nextDouble();

        System.out.println("Domates kaç kilogram ? :");
        double domates_kilo = scanner.nextDouble();

        System.out.println("Muz kaç kilogram ? :");
        double muz_kilo = scanner.nextDouble();

        System.out.println("Patlıcan kaç kilogram ? :");
        double patlıcan_kilo = scanner.nextDouble();

        double toplam_tutar = armut*armut_kilo + elma*elma_kilo + domates*domates_kilo + muz*muz_kilo + patlıcan*patlıcan_kilo;

        System.out.print("Toplam Tutar:" +toplam_tutar+"tl");

        scanner.close();
    }
}
