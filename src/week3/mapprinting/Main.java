package week3.mapprinting;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {


        // HashMap Nesnesi
        Map<String,Integer> inputs = new HashMap<>();

        // Key-Value değerleri giriş sırasına göre listeler
        inputs.put("Atatürk Orman Çiftliği Sade Dondurma 1 KG ",100);
        inputs.put("Algida Cornetto Disk ",55);
        inputs.put("Karpuz Çekirdeksiz KG ",20);
        inputs.put("Üzüm Çekirdeksiz KG ",90);
        inputs.put("Domates KG ",37);
        inputs.put("Soğan Kuru KG ",10);
        inputs.put("Mango Adet ",50);
        inputs.put("Uludağ Doğal Maden Suyu 6'lı ",50);
        inputs.put("Uludağ Ayran 1 L ",33);


        // getKey-getValue kullanılarak yazdırma
        for (Map.Entry<String,Integer> entry : inputs.entrySet()){
            System.out.println(entry.getKey() + ", Fiyat : " + entry.getValue() + " TL");

        }

        System.out.println();




        //LinkedHashMap Nesnesi
        Map<String,Integer> inputs1 = new LinkedHashMap<>();

        // Key-Value değerleri giriş sırasına göre listeler
        inputs1.put("Atatürk Orman Çiftliği Sade Dondurma 1 KG ",100);
        inputs1.put("Algida Cornetto Disk ",55);
        inputs1.put("Karpuz Çekirdeksiz KG ",20);
        inputs1.put("Üzüm Çekirdeksiz KG ",90);
        inputs1.put("Domates KG ",37);
        inputs1.put("Soğan Kuru KG ",10);
        inputs1.put("Mango Adet ",50);
        inputs1.put("Uludağ Doğal Maden Suyu 6'lı ",50);
        inputs1.put("Uludağ Ayran 1 L ",33);


        // getKey-getValue kullanılarak yazdırma
        for (Map.Entry<String,Integer> entry : inputs1.entrySet()){
            System.out.println(entry.getKey() + ", Fiyat : " + entry.getValue() + " TL");

        }

        System.out.println();



        // TreeMap nesnesi String Key değerini Alfabedik Olarak Sıralar Sıralamayı girdilerin sırasına göre yapmaz!
        Map<String,Integer> inputs2 = new TreeMap<>();

        // Key-Value değerleri
        inputs2.put("Atatürk Orman Çiftliği Sade Dondurma 1 KG ",100);
        inputs2.put("Algida Cornetto Disk ",55);
        inputs2.put("Karpuz Çekirdeksiz KG ",20);
        inputs2.put("Üzüm Çekirdeksiz KG ",90);
        inputs2.put("Domates KG ",37);
        inputs2.put("Soğan Kuru KG ",10);
        inputs2.put("Mango Adet ",50);
        inputs2.put("Uludağ Doğal Maden Suyu 6'lı ",50);
        inputs2.put("Uludağ Ayran 1 L ",33);


        // getKey-getValue kullanılarak yazdırma
        for (Map.Entry<String,Integer> entry : inputs2.entrySet()){
            System.out.println(entry.getKey() + ", Fiyat : " + entry.getValue() + " TL");
        }
    }
}