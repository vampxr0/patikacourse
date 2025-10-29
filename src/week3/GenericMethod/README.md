# Ödev - Generic Metot Yazımı
Bir generic metot (printArray) yazınız ve bu metot, verilen farklı veri türlerinden (Integer, String, Double vs.) oluşan dizileri ekrana yazdırsın.

Örnek Kullanım:

    Integer[] intArray = {1, 2, 3, 4, 5};
    
    String[] strArray = {"Java", "Generics", "Ödev"};
    
    printArray(intArray);
    
    printArray(strArray);

Beklenen Çıktı:

    1 2 3 4 5
    
    Java Generics Ödev

# Cevap:

    public static <T> void printArray( T[] array){
        for (T index : array){
            System.out.print(index + " ");
        }
        System.out.println();
    }

Girdiler:

    Integer[] intArray = {1, 2, 3, 4, 5};

    String[] strArray = {"Java", "Generics", "Ödev"};

    Character[] charArray = {'a','b','c'};

    Book[] bookArray = new Book[3];

    bookArray[0] = new Book("clean code", "mark zuckerberg");
    bookArray[1] = new Book("Electronic Car", "elon musk");
    bookArray[2] = new Book("Amazon", "Jeff Bezos");

Çıktı:

    1 2 3 4 5
    Java Generics Ödev
    Book{name='clean code', author='mark zuckerberg'} Book{name='Electronic Car', author='elon musk'} Book{name='Amazon', author='Jeff Bezos'} # Ödev - Generic Metot Yazımı
Bir generic metot (printArray) yazınız ve bu metot, verilen farklı veri türlerinden (Integer, String, Double vs.) oluşan dizileri ekrana yazdırsın.

Örnek Kullanım:

    Integer[] intArray = {1, 2, 3, 4, 5};
    
    String[] strArray = {"Java", "Generics", "Ödev"};
    
    printArray(intArray);
    
    printArray(strArray);

Beklenen Çıktı:

    1 2 3 4 5
    
    Java Generics Ödev

# Cevap:

    public static <T> void printArray( T[] array){
        for (T index : array){
            System.out.print(index + " ");
        }
        System.out.println();
    }

Girdiler:

    Integer[] intArray = {1, 2, 3, 4, 5};

    String[] strArray = {"Java", "Generics", "Ödev"};

    Character[] charArray = {'a','b','c'};

    Book[] bookArray = new Book[3];

    bookArray[0] = new Book("clean code", "mark zuckerberg");
    bookArray[1] = new Book("Electronic Car", "elon musk");
    bookArray[2] = new Book("Amazon", "Jeff Bezos");

Çıktı:

    1 2 3 4 5
    Java Generics Ödev
    Book{name='clean code', author='mark zuckerberg'} Book{name='Electronic Car', author='elon musk'} Book{name='Amazon', author='Jeff Bezos'} 