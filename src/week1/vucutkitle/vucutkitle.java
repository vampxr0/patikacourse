package week1.vucutkitle;

import java.util.Scanner;

public class vucutkitle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kilonuzu Girin: ");
        double kilo = scanner.nextDouble();

        System.out.println("Boyunuzu Girin: ");
        double boy = scanner.nextDouble()/100;

        double result = result(kilo,boy);
        System.out.println("Vücut Kitle İndeksiniz: "+result);
    }
    private static double result(double kilo,double boy){
        return kilo/(boy*boy);
    }
}
