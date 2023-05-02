package br.edu.ifsp.lp1p1.repository;

import br.edu.ifsp.lp1p1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
