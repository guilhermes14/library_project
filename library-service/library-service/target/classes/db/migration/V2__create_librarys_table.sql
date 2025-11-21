CREATE TABLE library (
                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         address VARCHAR(255),
                         email VARCHAR(100),
                         phone VARCHAR(20)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE librarysbook (
                              id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                              library_id INT NOT NULL,
                              book_id_external INT NOT NULL,
                              FOREIGN KEY (library_id) REFERENCES library(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO library (name, address, email, phone) VALUES
                                                      ('Biblioteca Nacional', 'Av. Rio Branco, 219', 'bnb@bnb.gov.br', '11111-1111'),
                                                      ('Biblioteca de Sao Paulo', 'Av. Cruzeiro do Sul, 2630', 'bibliotecasp@bsp.gov.br', '11111-2222');

INSERT INTO librarysbook (library_id, book_id_external) VALUES
                                                            (1, 1),
                                                            (1, 2),
                                                            (1, 3),
                                                            (2, 4),
                                                            (2, 5);