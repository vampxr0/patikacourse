package week1.MinMax;

import java.util.Scanner;

public class MinMaxNumber {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Kaç tane sayı gireceksiniz: ");
        int numara = scan.nextInt();

        if (numara<0){
            System.out.println("Lütfen pozitif bir sayı giriniz.");
        }
        else {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for(int i=1;i<=numara;i++){
                System.out.println(i+".rakamı giriniz: ");
                int enterValue = scan.nextInt();

                if(enterValue>max){
                    max = enterValue;
                }

                if(enterValue<min){
                    min = enterValue;
                }
            }

            System.out.println("En büyük rakam: "+ max);
            System.out.println("En küçük rakam: " + min);
        }

        scan.close();
    }
}