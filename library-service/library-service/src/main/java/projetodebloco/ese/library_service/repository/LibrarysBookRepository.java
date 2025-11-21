package projetodebloco.ese.library_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetodebloco.ese.library_service.model.Library;
import projetodebloco.ese.library_service.model.LibrarysBook;

public interface LibrarysBookRepository extends JpaRepository<LibrarysBook, Integer> {
}
