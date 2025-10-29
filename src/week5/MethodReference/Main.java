package week5.MethodReference;


import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Ahmet");

        names.add("Ayşe");

        names.add("Mehmet");

        names.add("Zeynep");

        // Method reference kullanarak liste elemanlarını yazdırma
        names.forEach(System.out::println);

    }

}