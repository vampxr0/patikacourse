package week1.invertedtriangle;

import java.util.Scanner;

public class InvertedTriangle {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in); // Konsoldan veri almak için
        System.out.println("Kaç satır istiyorsunuz? :");

        int numara = scan.nextInt();

        for (int i = numara; i >= 1; i--)
        {
            for (int j = 1; j <= i; j++) // İç içe for döngüleri tekrarlı işlemleri yapabilmek için
            {
                System.out.print("*");
            }
            System.out.println();  // Yan yana yazılan * ları üçgen halinde dizmek için alt satıra geçer
            
        }
        scan.close();
    }
}
