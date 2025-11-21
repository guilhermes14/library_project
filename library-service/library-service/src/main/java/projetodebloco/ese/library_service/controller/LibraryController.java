package projetodebloco.ese.library_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetodebloco.ese.library_service.model.Library;
import projetodebloco.ese.library_service.model.dto.LibraryDetailsDTO;
import projetodebloco.ese.library_service.service.LibraryService;


@RestController
@RequestMapping("library-service")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/library/{id}")
    public ResponseEntity<LibraryDetailsDTO> getLibraryDetails(@PathVariable Integer id) {
        try {
            LibraryDetailsDTO details = libraryService.getLibraryDetails(id);
            return ResponseEntity.ok(details);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/library/create")
    public ResponseEntity<Library> createLibrary(@RequestBody Library library) {
        Library createdLibrary = libraryService.createLibrary(library);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLibrary);
    }

    @PostMapping("/library/{libraryId}/books/{bookId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBookToLibrary(
            @PathVariable Integer libraryId,
            @PathVariable Integer bookId) {

        libraryService.addBookToLibrary(libraryId, bookId);
    }

    @DeleteMapping("/library/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        try {
            libraryService.deleteLibrary(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/library/{libraryId}/books/{bookId}")
    public ResponseEntity<Void> removeBookFromLibrary(
            @PathVariable Integer libraryId,
            @PathVariable Integer bookId) {

        try {
            libraryService.removeBookFromLibrary(libraryId, bookId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
