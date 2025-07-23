package week1.Ticket;

import java.util.Scanner;

public class Ticket {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Mesafeyi km türünden giriniz. :");
        int mesafe_km = scan.nextInt();

        System.out.println("Yaşınızı giriniz. :");
        int yas = scan.nextInt();

        System.out.println("Yolculuk tipini giriniz. :");
        int yolculuktipi = scan.nextInt();

        if (mesafe_km <= 0 || yas <= 0 || (yolculuktipi != 1 && yolculuktipi != 2) ){
            System.out.print("Hatalı veri girdiniz! ");
            return;
        }

        double biletÜcreti = mesafe_km*0.10;

        double yasİndirimi = 0.0;

        if (yas < 12){
            yasİndirimi = 0.50;
        }
        else if (yas >=12 && yas <= 24) {
            yasİndirimi = 0.10;
        }
        else if (yas> 65) {
            yasİndirimi = 0.30;
        }
        double indirimliFiyat = biletÜcreti*(1-yasİndirimi);

        if (yolculuktipi==2){
            double gidişDönüş = 0.20;
            indirimliFiyat = indirimliFiyat*(1-gidişDönüş)*2;
        }
        System.out.println("Toplam Tutar :" + indirimliFiyat);
        scan.close();

    }
}
