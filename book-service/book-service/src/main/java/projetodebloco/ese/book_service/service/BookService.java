package projetodebloco.ese.book_service.service;

import org.springframework.stereotype.Service;
import projetodebloco.ese.book_service.model.Book;
import projetodebloco.ese.book_service.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Integer id, Book bookDetails) {
        Book book = bookRepository.findById(id).orElse(null);

        if (book != null) {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPublisher(bookDetails.getPublisher());
            book.setGenre(bookDetails.getGenre());

            return bookRepository.save(book);
        }
        return null;
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}
