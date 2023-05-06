package br.edu.ifsp.lp1p1.service;


import br.edu.ifsp.lp1p1.dto.book.BookResponseDTO;
import br.edu.ifsp.lp1p1.exception.book.BookNotFoundException;
import br.edu.ifsp.lp1p1.mapper.book.BookMapper;
import br.edu.ifsp.lp1p1.mapper.book.BookResponseDTOMapper;
import br.edu.ifsp.lp1p1.model.Book;
import br.edu.ifsp.lp1p1.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book findById(Long id){
        return this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    public void save(BookResponseDTO bookResponseDTO){
        Book book = BookMapper.INSTANCE.toBook(bookResponseDTO);
        this.bookRepository.save(book);
    }

    public List<BookResponseDTO> findAll(){
        List<Book> books = this.bookRepository.findAll();
        List<BookResponseDTO> bookResponseDTOs = books.stream()
                .map(BookResponseDTOMapper.INSTANCE::toBookResponseDTO).toList();
        return bookResponseDTOs;
    }

    public void deleteById(Long id){
        this.bookRepository.deleteById(findById(id).getId());
    }

}
