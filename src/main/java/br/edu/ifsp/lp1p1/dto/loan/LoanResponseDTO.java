package br.edu.ifsp.lp1p1.dto.loan;

import br.edu.ifsp.lp1p1.model.Book;

import java.time.Instant;

public record LoanResponseDTO(Long id,
                              Book book,
                              Long clientId,
                              Long userId,
                              Instant loanDate,
                              Instant returnDate) {
}
