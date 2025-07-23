package week1.aritmetiksayilar;

import java.util.Scanner;

public class AritmetikSayi {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        System.out.println("İlk sayıyı giriniz :");
        int a= scan.nextInt();

        System.out.println("İkinci sayıyı giriniz :");
        int b = scan.nextInt();

        System.out.println("Üçüncü sayıyı giriniz :");
        int c = scan.nextInt();

        int sonuc = a + (b * c) - b ;

        System.out.println("İşlem sonucu :" + sonuc);

        scan.close();
    }
}
