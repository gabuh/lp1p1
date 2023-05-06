package br.edu.ifsp.lp1p1.repository;

import br.edu.ifsp.lp1p1.model.Book;
import br.edu.ifsp.lp1p1.model.Loan;
import br.edu.ifsp.lp1p1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    void deleteAllByBook(Book book);

    void deleteAllByUser(User user);

    void deleteAllByClient(User user);

    List<Loan> findAllByBook(Book book);

}
