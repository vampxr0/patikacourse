package week2.primenumbertester;

import java.util.Scanner;

public class PrimeNumberTester {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        // Kullanıcıdan bir tam sayı girmesini ister.
        System.out.println("Bir Tam Sayı giriniz: ");
        int input = scanner.nextInt();

        // Asal olup olmadığına göre uygun cevaplar verir ve metotumuz burada çalışır.
        if (isPrime(input,2)){
            System.out.println(input + " sayısı asaldır. ");

        }else {
            System.out.println(input + " sayısı asal değildir. ");
        }

        scanner.close();

    }

    // Deneme bölümü test metotu: bir sayı kendisinin karakökünün tam kısmına kadar olan asal sayılar ile aralarında asal iseler sayı asaldır.
    private static boolean isPrime(int input,int divisor){

        // ikiden küçük hiç bir tam sayı asal değildir.
        if (input<2) return false;

        // Recursive metotunu durdurma şartı.
        if(divisor*divisor>input) return true;

        if (input%divisor==0) return false;

        // Asal olmayan sayıları mod işlemine fazladan almamak için her bölenin asal olduğunu kontrol ediliyor.
        int primeDivisor = divisor + 1;

        while (!isPrime(primeDivisor,2)){
            primeDivisor++;
        }
        // Recursive metot.
        return isPrime(input,primeDivisor);
    }
}