package projetodebloco.ese.library_service.model.dto;
import java.io.Serializable;

public record BookDTO (int id,
         String title,
         String author,
         String publisher,
         String genre) {
}
