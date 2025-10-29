package week2.passwordchecker;

import java.util.Scanner;

public class PasswordChecker {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan parola oluşturması istenir
        System.out.println("Uygun bir parola oluşturunuz : ");
        String password = scanner.nextLine();

        // Parola kontrolü için tanımlanmıştır tüm koşullarda geçerse true kalacaktır.
        boolean check = true;

        /* Bir if koşulunun değilini almak istiyorsak aşağıda göründüğü gibi !'i  kullanmalıyız.
        /* Burda istenilen şartları yerine getiren metotlar if şartlarına sokuluyor ve olumsuz bir dönüşte uyarı cevabını yazdırıyor.
        /* Eğer if koşulları iç içe yazılırsa hatalı parola girişinde sadece ilk hata mesajını döndürüp programı kapatırdı.
        /* Fakat şartlar ayrı ayrı yazılırsa hepsini kontrol edip tüm hata mesajlarını döndürür.
         */

        if(!passwordLength(password)){

            System.out.println("Parola en az 8 karakteri olmalıdır!");
            check = false;
        }

        if(!isFirstStringUpperCase(password)){

            System.out.println("Parolanızdaki ilk harf büyük değil !");
            check = false;
        }

        if(haveSpace(password)){

            System.out.println("Parolanızda boşluk olamaz !");
            check = false;
        }

        if(!haveLastCase(password)){

            System.out.println("Parolanızın son karakteri ? olmalı !");
            check = false;
        }

        // Tüm Şartlardan geçerse parolanız geçerli, geçmez ise Parolanız geçersizi yazdırıyor
        if(check){
            System.out.println("Parolanız geçerli !");
        }else {
            System.out.println("Parolanız geçersiz !");
        }

        scanner.close();

    }

   // Parola şartlarını kontrol eden statick boolean metotlar
    static boolean passwordLength(String password){

        return password.length() >= 8;
    }

    static boolean isFirstStringUpperCase(String password) {

        for (int i = 0; i < password.length(); i++) {

            if (Character.isLetter(password.charAt(i))) {

                return Character.isUpperCase(password.charAt(i));
            }
        }return false;
    }

    static boolean haveSpace (String password){
        return password.contains(" ");
    }

    static boolean haveLastCase(String password) {

        return password.charAt(password.length() - 1) == '?';
        }
}
