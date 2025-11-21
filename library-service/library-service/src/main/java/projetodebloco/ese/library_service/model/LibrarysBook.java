package projetodebloco.ese.library_service.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "librarysbook")
public class LibrarysBook implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id", nullable = false)
    private Library library;

    @Column(name = "book_id_external", nullable = false)
    private Integer bookId;

    public LibrarysBook() {}

    public LibrarysBook(Integer id, Integer bookId, Library library) {
        this.id = id;
        this.bookId = bookId;
        this.library = library;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
