package br.edu.ifsp.lp1p1.service;


import br.edu.ifsp.lp1p1.dto.loan.LoanRequestDTO;
import br.edu.ifsp.lp1p1.mapper.loan.LoanMapper;
import br.edu.ifsp.lp1p1.model.Book;
import br.edu.ifsp.lp1p1.model.Loan;
import br.edu.ifsp.lp1p1.model.User;
import br.edu.ifsp.lp1p1.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    public void deleteById(Long id){
        this.loanRepository.deleteById(id);
    }

    public void deleteAllByBook(Book book){
        this.loanRepository.deleteAllByBook(book);
    }

    public void deleteAllByUser(User user){
        this.loanRepository.deleteAllByUser(user);
    }

    public void deleteAllByClient(User user){
        this.loanRepository.deleteAllByClient(user);
    }

    public void save(LoanRequestDTO loanRequestDTO){
        Loan loan = LoanMapper.INSTANCE.toLoan(loanRequestDTO);
        this.loanRepository.save(loan);
    }

    public void save(Loan loan){
        this.loanRepository.save(loan);
    }

    public List<Loan> findAllByBook(Book book){
        return this.loanRepository.findAllByBook(book);
    }
}
