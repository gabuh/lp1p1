package br.edu.ifsp.lp1p1.service;


import br.edu.ifsp.lp1p1.dto.book.BookRequestDTO;
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

    public void save(BookRequestDTO bookRequestDTO){
        Book book = BookMapper.INSTANCE.toBook(bookRequestDTO);
        this.bookRepository.save(book);
    }

    public void save(Book book){
        this.bookRepository.save(book);
    }

    public void update(BookRequestDTO bookRequestDTO){
        Book book = BookMapper.INSTANCE.toBook(bookRequestDTO);
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

    public List<BookResponseDTO> findAllByTitle(String title){
        List<Book> books = this.bookRepository.findAllByTitle(title);
        return books.stream().map(BookResponseDTOMapper.INSTANCE::toBookResponseDTO).toList();
    }

}
