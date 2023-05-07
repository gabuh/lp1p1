package br.edu.ifsp.lp1p1.repository;

import br.edu.ifsp.lp1p1.model.Book;
import br.edu.ifsp.lp1p1.model.Loan;
import br.edu.ifsp.lp1p1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    void deleteAllByBook(Book book);

    void deleteAllByUser(User user);

    void deleteAllByClient(User user);

    List<Loan> findAllByBook(Book book);

    List<Loan> findAllByClientId(Long clientId);

    List<Loan> findAllByClient(User client);

//    @Query(value = "SELECT l.id, l.book, l.client, l.user, l.loanDate, l.returnDate FROM Loan l WHERE CAST(l.loanDate AT TIME ZONE 'America/Sao_Paulo' AS DATE) = :date")
//    List<Loan> findAllByLoanDate(Instant date);

}
