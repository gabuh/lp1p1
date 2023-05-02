package br.edu.ifsp.lp1p1.config.db;

import br.edu.ifsp.lp1p1.model.Book;
import br.edu.ifsp.lp1p1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Seeding implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book(
                null,
                "Moby Dick",
                "Herman Melville",
                "Harper and Brothers",
                "1851",
                10,
                5);



        this.bookRepository.saveAll(List.of(book1));
    }
}
