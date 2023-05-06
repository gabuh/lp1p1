package br.edu.ifsp.lp1p1.exception.book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long id){
        super("book: "+id+" not found");
    }
}
