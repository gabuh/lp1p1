package br.edu.ifsp.lp1p1.service;


import br.edu.ifsp.lp1p1.model.Book;
import br.edu.ifsp.lp1p1.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
