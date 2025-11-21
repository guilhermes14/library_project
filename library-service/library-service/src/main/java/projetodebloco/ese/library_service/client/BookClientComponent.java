package projetodebloco.ese.library_service.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import projetodebloco.ese.library_service.model.dto.BookDTO;


@Component
public class BookClientComponent {
    private final WebClient webClient;


    public BookClientComponent(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:7000/book-service").build();
    }

    @Retry(name = "bookService")
    @CircuitBreaker(name = "bookService", fallbackMethod = "fallbackGetBook")
    public BookDTO getBookById(Integer bookId) {
        return webClient.get()
                .uri("/book/" + bookId)
                .retrieve()
                .bodyToMono(BookDTO.class)
                .block(); // Chamada síncrona
    }


    public BookDTO fallbackGetBook(Integer bookId, Throwable t) {
        System.err.println("Book-Service indisponível para o ID " + bookId + ". Erro: " + t.getMessage());

        return null;
    }
}