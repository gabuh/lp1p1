package br.edu.ifsp.lp1p1.config.db;

import br.edu.ifsp.lp1p1.model.Book;
import br.edu.ifsp.lp1p1.model.Loan;
import br.edu.ifsp.lp1p1.model.User;
import br.edu.ifsp.lp1p1.repository.BookRepository;
import br.edu.ifsp.lp1p1.repository.LoanRepository;
import br.edu.ifsp.lp1p1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class Seeding implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final LoanRepository loanRepository;


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

        User user1 = new User().builder()
                .id(null)
                .name("user")
                .cpf("123.123.123-12")
                .address("address")
                .email("email")
                .password("password").build();

        Loan loan1 = new Loan(
                null,
                book1,
                user1,
                user1,
                Instant.parse("2019-06-20T19:53:07Z"),
                Instant.parse("2019-07-20T19:53:07Z"));



        this.bookRepository.saveAll(List.of(book1));
        this.userRepository.saveAll(List.of(user1));
        this.loanRepository.saveAll(List.of(loan1));
    }
}
