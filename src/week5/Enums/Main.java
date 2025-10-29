package week5.Enums;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean exit = true;
        Scanner scanner = new Scanner(System.in);

        while (exit){
            System.out.println("Gün seçiniz. Çıkış yapmak için 0'a basınız.");
            int selectedDay = scanner.nextInt();
            if (selectedDay==0){
                exit = false;
                continue;
            }
            if (selectedDay<1 || selectedDay>7){
                System.out.println("1 ile 7 arasında değer giriniz.");
                continue;
            }

            for (Day day: Day.values()){
                if (day.getDay()==selectedDay){
                    if (day.getStartTime().isEmpty() && day.getFinishTime().isEmpty())
                        System.out.println(day.name() + " tatil günüdür.");
                    else
                        System.out.println(day.name() +" için çalışma saati " +day.getStartTime() + " - " + day.getFinishTime());
                }
            }
        }
    }
}