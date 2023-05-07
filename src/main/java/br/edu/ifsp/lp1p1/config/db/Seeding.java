package br.edu.ifsp.lp1p1.config.db;

import br.edu.ifsp.lp1p1.model.Book;
import br.edu.ifsp.lp1p1.model.User;
import br.edu.ifsp.lp1p1.model.enums.user.UserRoles;
import br.edu.ifsp.lp1p1.repository.BookRepository;
import br.edu.ifsp.lp1p1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@Log4j2
public class Seeding implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        Book book1 = new Book(
                null,
                "Moby Dick",
                "Herman Melville",
                "Harper and Brothers",
                "1851",
                10,
                10);

        Book book2 = new Book(
                null,
                "To Kill a Mockingbird",
                "Harper Lee",
                "J. B. Lippincott & Co.",
                "1960",
                10,
                10);

        Book book3 = new Book(
                null,
                "1984",
                "George Orwell",
                "Secker & Warburg",
                "1949",
                10,
                10);

        Book book4 = new Book(
                null,
                "The Great Gatsby",
                "F. Scott Fitzgerald",
                "Charles Scribner's Sons",
                "1925",
                10,
                10);

        Book book5 = new Book(
                null,
                "Pride and Prejudice",
                "Jane Austen",
                "T. Egerton, Whitehall",
                "1813",
                10,
                10);

        Book book6 = new Book(
                null,
                "The Catcher in the Rye",
                "J. D. Salinger",
                "Little, Brown and Company",
                "1951",
                10,
                10);

        Book book7 = new Book(
                null,
                "To the Lighthouse",
                "Virginia Woolf",
                "Hogarth Press",
                "1927",
                10,
                10);

        Book book8 = new Book(
                null,
                "Brave New World",
                "Aldous Huxley",
                "Chatto & Windus",
                "1932",
                10,
                10);

        Book book9 = new Book(
                null,
                "The Hobbit",
                "J. R. R. Tolkien",
                "George Allen & Unwin",
                "1937",
                10,
                10);

        Book book10 = new Book(
                null,
                "Crime and Punishment",
                "Fyodor Dostoevsky",
                "The Russian Messenger",
                "1866",
                10,
                10);

        User admin = new User().builder()
                .id(null)
                .name("admin")
                .cpf("000.000.000-00")
                .address("address")
                .email("adminemail")
                .password("$2a$12$XUhben5hiPAykE3ueATgKeAJeN7iobGb0NyqtDsi4RGbhE5sxbV1S")
                .role(UserRoles.ADMIN).build();

        User employee = new User().builder()
                .id(null)
                .name("employee")
                .cpf("123.123.123-12")
                .address("address")
                .email("employeeemail")
                .password("$2a$12$XUhben5hiPAykE3ueATgKeAJeN7iobGb0NyqtDsi4RGbhE5sxbV1S")
                .role(UserRoles.EMPLOYEE).build();

        User client = new User().builder()
                .id(null)
                .name("client")
                .cpf("321.321.321-32")
                .address("address")
                .email("clientemail")
                .password("$2a$12$XUhben5hiPAykE3ueATgKeAJeN7iobGb0NyqtDsi4RGbhE5sxbV1S")
                .role(UserRoles.CLIENT).build();



        this.bookRepository.saveAll(List.of(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10));
        this.userRepository.saveAll(List.of(admin, employee, client));
    }
}
