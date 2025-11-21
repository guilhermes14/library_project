CREATE TABLE book (
                      id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      author VARCHAR(100),
                      publisher VARCHAR(100),
                      genre VARCHAR(50)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;