package br.edu.ifsp.lp1p1.repository;

import br.edu.ifsp.lp1p1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitle(String title);

}
