package projetodebloco.ese.library_service.model.dto;
import java.io.Serializable;
import java.util.List;

public record LibraryDetailsDTO (int id,
        String name,
        String address,
        String email,
        String phone,
        List<BookDTO> booksAvailable) {

}
