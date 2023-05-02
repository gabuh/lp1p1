package br.edu.ifsp.lp1p1.service;


import br.edu.ifsp.lp1p1.model.Book;
import br.edu.ifsp.lp1p1.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void save(Book book){
        this.bookRepository.save(book);
    }
}
