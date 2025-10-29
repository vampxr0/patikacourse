package week3;


import java.util.ArrayList;
import java.util.List;


public class NearestNumbers {

    private List<Integer> numbers;        // Kullanıcıdan alınan sayılar
    private List<Integer> closestPairs;   // En yakın sayı çiftleri
    private int minDifference;            // En küçük fark

    public NearestNumbers() {
        numbers = new ArrayList<>();
        closestPairs = new ArrayList<>();
        minDifference = Integer.MAX_VALUE; // İlk farkı çok büyük bir değerle başlat
    }

    public void findNearestPairs() {
        closestPairs.clear(); // Önceki verileri temizle

        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                int diff = Math.abs(numbers.get(i) - numbers.get(j));

                if (diff < minDifference) {
                    minDifference = diff;
                    closestPairs.clear();
                    closestPairs.add(numbers.get(i));
                    closestPairs.add(numbers.get(j));
                } else if (diff == minDifference) {
                    closestPairs.add(numbers.get(i));
                    closestPairs.add(numbers.get(j));
                }
            }
        }
    }

    public void setNumbers(List<Integer> numbers) {
        // Negatif sayı veya tekrar eden sayı kontrolü
        for (Integer num : numbers) {
            if (num < 0) {
                throw new IllegalArgumentException("Negatif sayı girilemez.");
            }
            if (this.numbers.contains(num)) {
                throw new IllegalArgumentException("Eş sayılar girilemez.");
            }
            this.numbers.add(num);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Girdi: ").append(numbers).append("\n");
        sb.append("En yakın çift(ler):\n");

        for (int i = 0; i < closestPairs.size(); i += 2) {
            sb.append("[").append(closestPairs.get(i)).append(", ").append(closestPairs.get(i + 1)).append("]\n");
        }
        return sb.toString();
    }
}