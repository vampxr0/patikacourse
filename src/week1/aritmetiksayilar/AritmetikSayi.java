package week1.aritmetiksayilar;

import java.util.Scanner;

public class AritmetikSayi {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        System.out.println("İlk sayıyı giriniz :");
        double a= scan.nextDouble();

        System.out.println("İkinci sayıyı giriniz :");
        double b = scan.nextDouble();

        System.out.println("Üçüncü sayıyı giriniz :");
        double c = scan.nextDouble();

        double process = a + (b * c) - b ;

        System.out.println("İşlem sonucu :" + process);

        scan.close();
    }
}
