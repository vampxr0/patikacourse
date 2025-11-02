import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Map<String, Integer>> storage;
    public Storage() {
        storage = new HashMap<>();// aritmetik benim icin suanda onemli olmadigi icin tercih ettim
    }



    public Map<String, Map<String, Integer>> getStorage() {
        return storage;
    }
    public void setStorage(Map<String, Map<String, Integer>> storage) {
        this.storage = storage;
    }



}
