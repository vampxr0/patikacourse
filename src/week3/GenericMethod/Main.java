package week3.GenericMethod;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};

        String[] strArray = {"Java", "Generics", "Ödev"};

        Character[] charArray = {'a','b','c'};

        Book[] bookArray = new Book[3];

        bookArray[0] = new Book("clean code", "mark zuckerberg");
        bookArray[1] = new Book("Electronic Car", "elon musk");
        bookArray[2] = new Book("Amazon", "Jeff Bezos");

        printArray(intArray);

        printArray(strArray);

        printArray(charArray);

        printArray(bookArray);
    }

    public static <T> void printArray( T[] array){
        for (T index : array){
            System.out.print(index + " ");
        }
        System.out.println();
    }
}