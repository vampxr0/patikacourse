package week3.filmfiltering;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Film listesi oluşturuluyor
        List<Film> films = new ArrayList<>();

        // Örnek filmler ekleniyor
        films.add(new Film("Esaretin Bedeli",new String[]{"Gerilim","Gizem","Polisiye","Dram"},1994,9.3));
        films.add(new Film("Baba",new String[]{"Dram","Mafya","Suç","Aksiyon"},1972,9.2));
        films.add(new Film("Kara Şövalye",new String[]{"Dram","Aksiyon","Bilim Kurgu","Gizem"},2008,9.1));
        films.add(new Film("12 Öfkeli Adam",new String[]{"Dram","Gerilim","Suç","Polisiye"},1994,9.3));

        System.out.println();
        // IMDb puanına göre azalan sıralama
        filtering("IMDb sıralaması: ", films, Comparator.comparingDouble(Film::getImdb).reversed());
        System.out.println();

        // Yıla göre artan sıralama
        filtering("Yıla göre sıralaması: ", films, Comparator.comparingInt(Film::getFilmYear));
        System.out.println();

        // Tür bazlı film filtreleme
        System.out.println("Türe Göre Filtreleme: ");
        findingFilmType(films,"GeriLim","dram");

    }

    // Filmleri belirli kritere göre sıralayıp yazdıran metot
    private static void filtering(String x, List<Film> films, Comparator<Film> reversed) {
        System.out.println(x);

        films.sort(reversed);

        for (Film film : films) {
            System.out.println(film.getFilmName());
        }
    }

    // Tür bazlı film filtreleme metotu
    private static void findingFilmType(List<Film> films, String... filmTypes) {

        // Aynı filmi tekrar yazdırmamak için set
        Set<Film> printedFilms = new HashSet<>();

        // Aranan türleri küçük harfe çevir
        Set<String> searchTypes = new HashSet<>();
        for (String type : filmTypes) {
            searchTypes.add(type.toLowerCase());
        }

        // Filmleri ve türlerini kontrol et
        for (Film film : films) {
            for (String g : film.getFilmType()) {
                // Tür eşleşirse ve daha önce yazdırılmadıysa yazdır
                if (searchTypes.contains(g.toLowerCase()) && !printedFilms.contains(film)) {
                    System.out.println("Film isimi= " + film.getFilmName() + ", Diğer Türleri: " + Arrays.toString(film.getFilmType()));
                    printedFilms.add(film);
                    break; // Yazdırdıktan sonra diğer türlere bakmaya gerek yok
                }
            }
        }
    }
}