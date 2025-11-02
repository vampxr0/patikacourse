import Status;

import java.util.Random;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private String StorageLocation;
    private Status status;
    private String rentBy;
    private String rentAt;

    public String getRentAt() {
        return rentAt;
    }

    public void setRentAt(String rentAt) {
        this.rentAt = rentAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStorageLocation() {
        return StorageLocation;
    }

    public void setStorageLocation(String StorageLocation) {
        this.StorageLocation = StorageLocation;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getRentBy() {
        return rentBy;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN() {
        this.ISBN = generateRandomISBN13();
    }

    private String generateRandomISBN13() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        // İlk 3 hane (prefix), genelde 978 veya 979
        sb.append("978");
        sb.append("-");

        // Sonraki 10 hane rastgele sayı (0-9)
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }

        return sb.toString();
    }

    public void setRentBy(String rentBy) {
        this.rentBy = rentBy;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "StorageLocation: " + StorageLocation + "\n" +
                "Status: " + status + "\n" +
                "Rent By: " + rentBy + "\n" +
                "Rent At: " + rentAt;
    }


}
