# 📂 Ödev - Lambdas
Aşağıda verilen geleneksel (normal yöntemle yazılmış) Java kodunu inceleyin. Bu kod, bir liste içindeki sayıları iki katına çıkarıp ekrana yazdırmaktadır.

Verilen Kod (Geleneksel Yöntemle Yazılmış)

    public class Main {
    
        public static void main(String[] args) {
        
            List<Integer> numbers = new ArrayList<>();
            
            numbers.add(1);
            
            numbers.add(2);
            
            numbers.add(3);
            
            numbers.add(4);
            
            numbers.add(5);
            
            // Sayıları iki katına çıkarma (Geleneksel yöntem)
            
            for (int i = 0; i < numbers.size(); i++) {
            
                numbers.set(i, numbers.get(i) * 2);
            
            }
            
            // Sonuçları yazdırma
            
            for (int number : numbers) {
            
                System.out.println(number);
            
            }
        
        }
    
    }

İstenilen Çıktı:

    2
    
    4
    
    6
    
    8
    
    10

🔹 Yukarıdaki kodda lambda ifadeleri kullanarak aynı işlemi nasıl daha kısa ve okunabilir hale getirebilirsiniz?

🔹 for döngülerini lambda kullanarak nasıl değiştirebilirsiniz?

Lambda kullanarak kodunuzu yeniden yazın!


# Lambda İle Kullanımı

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
        numbers.forEach(System.out::println);