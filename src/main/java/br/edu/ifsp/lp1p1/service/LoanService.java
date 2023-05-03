package br.edu.ifsp.lp1p1.service;


import br.edu.ifsp.lp1p1.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
}
