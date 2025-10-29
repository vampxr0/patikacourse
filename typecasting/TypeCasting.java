import java.util.Scanner;

public class TypeCasting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir tam sayı giriniz: ");
        int tamSayi = scanner.nextInt();

        System.out.print("Bir ondalıklı sayı (double) giriniz: ");
        double ondalikliSayi = scanner.nextDouble();

        // int -> double (genişletme.)
        double tamSayiDouble = (double) tamSayi; // yazmasanız da otomatik genişler

        // double -> int (daraltma, kesir kısmı atılır)
        int ondalikliInt = (int) ondalikliSayi;

        System.out.println("Tam sayının double'a dönüştürülmüş hali: " + tamSayiDouble);
        System.out.println("Ondalıklı sayının int'e dönüştürülmüş hali: " + ondalikliInt);

        scanner.close();
    }
}