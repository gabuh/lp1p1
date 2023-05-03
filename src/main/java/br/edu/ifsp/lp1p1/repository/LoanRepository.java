package br.edu.ifsp.lp1p1.repository;

import br.edu.ifsp.lp1p1.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
