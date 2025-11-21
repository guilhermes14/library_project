package projetodebloco.ese.library_service.model;
import jakarta.persistence.*;
import java.util.List;
import java.io.Serializable;

@Entity
@Table(name = "library")
public class Library implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LibrarysBook> librarysBookList;

    public Library() {}

    public Library(int id, String name, String address, String email, String phone, List<LibrarysBook> librarysBookList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.librarysBookList = librarysBookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<LibrarysBook> getLibrarysBookList() {
        return librarysBookList;
    }

    public void setLibrarysBookList(List<LibrarysBook> librarysBookList) {
        this.librarysBookList = librarysBookList;
    }
}
