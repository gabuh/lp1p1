package br.edu.ifsp.lp1p1.repository;

import br.edu.ifsp.lp1p1.model.Book;
import br.edu.ifsp.lp1p1.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    void deleteAllByBook(Book book);

}
