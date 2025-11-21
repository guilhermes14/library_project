package projetodebloco.ese.book_service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import projetodebloco.ese.book_service.model.Book;
import projetodebloco.ese.book_service.repository.BookRepository;
import projetodebloco.ese.book_service.service.BookService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void deveRetornarNullQuandoLivroNaoExistir() {
        Integer id = 99;
        when(bookRepository.findById(id)).thenReturn(Optional.empty());

        Book resultado = bookService.findBookById(id);

        assertNull(resultado);
    }
}
