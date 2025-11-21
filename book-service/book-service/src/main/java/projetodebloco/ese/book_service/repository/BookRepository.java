package projetodebloco.ese.book_service.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import projetodebloco.ese.book_service.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
