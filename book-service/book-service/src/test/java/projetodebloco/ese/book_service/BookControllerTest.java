package projetodebloco.ese.book_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import projetodebloco.ese.book_service.controller.BookController;
import projetodebloco.ese.book_service.service.BookService;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BookService bookService;

    @Test
    void deveRetornarNotFoundQuandoLivroNaoExistir() throws Exception {
        given(bookService.findBookById(anyInt())).willReturn(null);

        mockMvc.perform(get("/book-service/book/{id}", 99))
                .andExpect(status().isNotFound());
    }
}
