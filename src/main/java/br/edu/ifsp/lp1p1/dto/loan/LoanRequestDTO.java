package br.edu.ifsp.lp1p1.dto.loan;

import java.time.Instant;

public record LoanRequestDTO(Long clientId,
                             String returnDate) {
}
