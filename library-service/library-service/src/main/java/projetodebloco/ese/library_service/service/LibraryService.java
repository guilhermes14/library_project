package projetodebloco.ese.library_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import projetodebloco.ese.library_service.client.BookClientComponent;
import projetodebloco.ese.library_service.model.Library;
import projetodebloco.ese.library_service.model.LibrarysBook;
import projetodebloco.ese.library_service.model.dto.BookDTO;
import projetodebloco.ese.library_service.model.dto.LibraryDetailsDTO;
import projetodebloco.ese.library_service.repository.LibraryRepository;
import projetodebloco.ese.library_service.repository.LibrarysBookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final LibrarysBookRepository librarysBookRepository;
    @Autowired
    private RestTemplate restTemplate;
    private final BookClientComponent bookClient;

    public LibraryService(LibraryRepository libraryRepository,
                          LibrarysBookRepository librarysBookRepository,
                          BookClientComponent bookClient) {
        this.libraryRepository = libraryRepository;
        this.librarysBookRepository = librarysBookRepository;
        this.bookClient = bookClient;
    }

    public Library createLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public LibrarysBook addBookToLibrary(Integer libraryId, Integer bookId) {
        Library library = libraryRepository.findById(libraryId)
                .orElseThrow(() -> new RuntimeException("Biblioteca não encontrada com ID: " + libraryId));

        LibrarysBook link = new LibrarysBook();
        link.setLibrary(library);
        link.setBookId(bookId);

        return librarysBookRepository.save(link);
    }

    @Transactional(readOnly = true)
    public LibraryDetailsDTO getLibraryDetails(Integer libraryId) {
        Library library = libraryRepository.findById(libraryId)
                .orElseThrow(() -> new RuntimeException("Biblioteca não encontrada"));

        List<BookDTO> booksList = new ArrayList<>();

        for (LibrarysBook link : library.getLibrarysBookList()) {
            BookDTO book = bookClient.getBookById(link.getBookId());

            if (book != null) {
                booksList.add(book);
            }
        }

        return new LibraryDetailsDTO(
                library.getId(),
                library.getName(),
                library.getAddress(),
                library.getEmail(),
                library.getPhone(),
                booksList
        );
    }

    public void deleteLibrary(Integer id) {
        libraryRepository.deleteById(id);
    }

    @Transactional
    public void removeBookFromLibrary(Integer libraryId, Integer bookId) {
        Library library = libraryRepository.findById(libraryId)
                .orElseThrow(() -> new RuntimeException("Biblioteca não encontrada"));

        boolean removed = library.getLibrarysBookList()
                .removeIf(link -> link.getBookId().equals(bookId));

        if (!removed) {
            throw new RuntimeException("Este livro não foi encontrado nesta biblioteca");
        }

        libraryRepository.save(library);
    }
}
