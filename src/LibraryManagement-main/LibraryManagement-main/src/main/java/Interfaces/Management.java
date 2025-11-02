import java.util.ArrayList;
import java.util.List;

public interface Management <T> {
    List<T>  load();
    void save();
    boolean exists(T item);
    void add(T item);

}
