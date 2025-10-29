package week2.multiplicationtable;

import java.util.Scanner;

public class MultiplicationTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan bir üst sınır ister.
        System.out.print("Üst sınırı giriniz (1‑10): ");
        int input = scanner.nextInt();

        // İstenilen Üst sınırın dışına çıkılırsa verilecek hata mesajını yazdırır.
        if(input<1 || input>10){
            System.out.println("1-10 aralığında olmayan bir üst sınır değeri girdiniz!");
        }else {

            // İç içe iki döngü istenilen sırada çarpma işlemlerini yazdırır.
            for (int i = 1; i <=input; i++) {
                for (int j = 1; j <=input ; j++) {
                    System.out.printf("%-4d", i*j);
                }

                // Alt satıra geçirmek için boş bir println satırı.
                System.out.println();
            }
        }

        scanner.close();
    }
}