package week3.filmfiltering;

import java.util.Arrays;


// Film sınıfı, bir filmi tanımlamak için gerekli bilgileri içerir

public class Film {

    // Film bilgileri

    private String filmName;
    private String[] filmType;
    private int filmYear;
    private double imdb;

    // Kurucu metot
    public Film(String filmName, String[] filmType, int filmYear, double imdb) {
        setFilmName(filmName);
        setFilmType(filmType);
        setFilmYear(filmYear);
        setImdb(imdb);
        this.filmName = filmName;
        this.filmType = filmType;
        this.filmYear = filmYear;
        this.imdb = imdb;
    }

    // Getter/setter
    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        if (filmName.isEmpty())
            throw new IllegalArgumentException("İsimsiz film olamaz! ");
        this.filmName = filmName;
    }

    public String[] getFilmType() {
        return filmType;
    }

    public void setFilmType(String[] filmType) {
        if (filmType.length==0)
            throw new IllegalArgumentException("Film Türü boş bırakılamaz!");
        this.filmType = filmType;
    }

    public int getFilmYear() {
        return filmYear;
    }

    public void setFilmYear(int filmYear) {
        if (filmYear<0)
            throw new IllegalArgumentException("Film yılı negatif olamaz!");

        this.filmYear = filmYear;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        if (imdb<0){
            throw new IllegalArgumentException("IMDb puanı negatif olamaz!");
        }
        this.imdb = imdb;
    }

    // Film bilgilerini yazdırmak için toString
    @Override
    public String toString() {
        return "Film Name='" + filmName + '\'' +
                ", Film Type=" + Arrays.toString(filmType) +
                ", Film Year=" + filmYear +
                ", IMDb=" + imdb;
    }
}