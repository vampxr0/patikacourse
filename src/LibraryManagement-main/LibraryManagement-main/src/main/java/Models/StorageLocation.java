public class StorageLocation {// bu classda StorageLocation numarasi olusturulacak

    private String bookCase;
    private String shelf;
    private int id;

    @Override
    public String toString() {
        return "StorageLocation{" +
                "StorageLocationNum='" + StorageLocationNum + '\'' +
                ", bookCase='" + bookCase + '\'' +
                ", shelf='" + shelf + '\'' +
                ", id=" + id +
                '}';
    }

    // kitaplik-raf-numara
    private String StorageLocationNum;





}
