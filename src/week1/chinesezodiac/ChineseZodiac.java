package week1.chinesezodiac;

import java.util.Scanner;

public class ChineseZodiac {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);

        System.out.println("Doğum yılınızı giriniz :");
        int dogumYili = scan.nextInt();

        String[] burclar = {"Maymun", "Horoz", "Köpek", "Domuz", "Fare", "Öküz", "Kaplan", "Tavşan", "Ejderha", "Yılan", "At", "Koyun"};

        int kalan = dogumYili % 12;

        System.out.println("Çin Zodiac Burcunuz :" + burclar[kalan]);

        scan.close();
    }
}
