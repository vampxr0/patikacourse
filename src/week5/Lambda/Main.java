package week5.Lambda;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(1);

        numbers.add(2);

        numbers.add(3);

        numbers.add(4);

        numbers.add(5);

        // Lambda kullanarak sayıları iki katına çıkarma
        numbers.replaceAll(n->n*2);

        // Lambda kullanarak yazdırma
        numbers.forEach(number -> System.out.println(number));

    }

}