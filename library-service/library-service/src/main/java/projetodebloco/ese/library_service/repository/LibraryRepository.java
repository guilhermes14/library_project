package projetodebloco.ese.library_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetodebloco.ese.library_service.model.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer> {
}
