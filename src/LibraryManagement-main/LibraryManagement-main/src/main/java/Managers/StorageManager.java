import Global;
import Book;
import Storage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import java.util.HashMap;
import java.util.Map;

public class StorageManager {

    private final Storage storage;

    private final Gson gson;

    public StorageManager() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        storage = load();
    }

    public Storage load() {
        try (FileReader reader = new FileReader(Global.JSON_FILE_storage)) {
            Storage loadedStorage = gson.fromJson(reader, Storage.class);
            return loadedStorage != null ? loadedStorage : createDefaultStorage();
        } catch (IOException e) {
            return createDefaultStorage(); // Dosya yoksa default oluştur
        }
    }
    private Storage createDefaultStorage() {
        Storage defaultStorage = new Storage();
        // Burada Storage içine default 5x5 yapı oluşturulur
        Map<String, Map<String, Integer>> storageMap = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            String bookCaseName = "BC" + i;
            Map<String, Integer> shelves = new HashMap<>();
            for (int j = 1; j <= 5; j++) {
                shelves.put("S" + j, 0);
            }
            storageMap.put(bookCaseName, shelves);
        }
        defaultStorage.setStorage(storageMap);

        saveStorage(defaultStorage); // JSON'a kaydet
        return defaultStorage;
    }

    private void saveStorage(Storage storageToSave) {
        try (FileWriter writer = new FileWriter(Global.JSON_FILE_storage)) {
            gson.toJson(storageToSave, writer);
        } catch (IOException e) {
            System.out.println("Storage data could not be saved: " + e.getMessage());
        }
    }

    public void save() {
        saveStorage(storage);
    }



    public void add(Book newBook) {
        String[] parts = newBook.getStorageLocation().split("_");
        String bookCase = parts[0];
        String shelf = parts[1];

        Map<String, Integer> shelfMap = storage.getStorage().get(bookCase);
        int currentCount = shelfMap.get(shelf);

        if (currentCount < 5) {
            shelfMap.put(shelf, currentCount + 1); // 1 artir
            save(); // Güncel storage'ı kaydet
        } else {
            System.out.println("Error: Shelf count is already 0. Cannot check out.");
        }



    }

    public void remove(Book newBook) {
        String[] parts = newBook.getStorageLocation().split("_");
        String bookCase = parts[0];
        String shelf = parts[1];

        Map<String, Integer> shelfMap = storage.getStorage().get(bookCase);
        int currentCount = shelfMap.get(shelf);

        if (currentCount >0) {
            shelfMap.put(shelf, currentCount - 1); // 1 azalt
            save(); // Güncel storage'ı kaydet
        } else {
            System.out.println("Error: Shelf count is already 0. Cannot check out.");
        }

    }


    public int getNextIdForSpot(String bookCase, String shelf) {
        Map<String, Integer> map = storage.getStorage().get(bookCase);
        int shelves = map.get(shelf);
        if (!(shelves < 5)) {
            System.out.println("Error: Shelf " + shelf + " in " + bookCase + " is full.");
            return 9;
        }

        return shelves + 1;


    }
    public void addBookCase() {
        // Mevcut en yüksek BC numarasını bul
        int maxNumber = storage.getStorage().keySet().stream()
                .map(key -> key.replace("BC", "")) // "BC1" → "1"
                .mapToInt(Integer::parseInt)
                .max()
                .orElse(0); // hiç yoksa 0

        String newBookCaseName = "BC" + (maxNumber + 1);

        Map<String, Integer> shelves = new HashMap<>();
        for (int j = 1; j <= 5; j++) { // sabit 5 raf
            shelves.put("S" + j, 0);
        }

        storage.getStorage().put(newBookCaseName, shelves);
        save();
        System.out.println("Bookcase " + newBookCaseName + " added with 5 shelves.");
    }
    public void printStorage() {
        Map<String, Map<String, Integer>> storageMap = storage.getStorage();

        for (String bookCase : storageMap.keySet()) {
            System.out.println("=====");
            System.out.println(bookCase + ":");
            Map<String, Integer> shelves = storageMap.get(bookCase);
            for (String shelf : shelves.keySet()) {
                System.out.println("    " + shelf + " = " + shelves.get(shelf));
            }
        }
        System.out.println("=====");
    }




    public Storage getStorage() {
        return storage;
    }
}
