package week1.ArtıkYıl;

import java.util.Scanner;

public class ArtikYil {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Kullanıcıdan yıl girmesini istiyoruz.
        System.out.println("Yılı giriniz : ");
        int yıl = scan.nextInt();

        if ((yıl % 400) == 0) {
            System.out.println(yıl + " artık yıldır.");
        } else {

            if ((yıl % 100) != 0 && (yıl % 4) == 0) {
                System.out.println(yıl + " artık yıldır.");
            } else {
                System.out.println(yıl + " artık bir yıl değildir.");
            }

        }
        //Scannerı kapatıyoruz.
        scan.close();
    }
}

