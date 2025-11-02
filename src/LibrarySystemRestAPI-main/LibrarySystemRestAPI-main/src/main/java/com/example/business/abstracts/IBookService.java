import BookSaveRequest;
import BookUpdateRequest;
import com.example.entities.Book;
import org.springframework.data.domain.Page;

public interface IBookService {
    Book save(BookSaveRequest request);
    Book get(int id);
    Book update(BookUpdateRequest request);
    boolean delete(int id);
    Page<Book> cursor(int page, int pageSize);
}
