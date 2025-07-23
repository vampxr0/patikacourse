package week1.PerfectNumber;

import java.util.Scanner;

public class PerfectNum {
    public static void main(String[] args) {

        Scanner scan= new Scanner(System.in);

        System.out.println("Bir sayı giriniz. :");
        int num = scan.nextInt();

        int sum = 0;

        /*
         * Mükemmel sayıyı kontrol edin:
         * Mükemmel sayı, kendi dışındaki tam bölenlerinin toplamına eşittir.
         * Bölenleri bulmak için 1'den num-1'e kadar tüm sayıları döngüye sokun.
         */

        for (int i = 1; i < num; i++) {

            if (num%i == 0){
                sum +=i;
            }
            
        }

        if (sum == num){
            System.out.println(num+ " bir mükemmel sayıdır!");
        }

        else{
            System.out.println(num+ " bir mükemmel sayı değildir!");
        }
        scan.close();
    }
}
