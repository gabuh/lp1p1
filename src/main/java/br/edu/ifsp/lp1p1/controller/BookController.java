package br.edu.ifsp.lp1p1.controller;

import br.edu.ifsp.lp1p1.dto.book.BookResponseDTO;
import br.edu.ifsp.lp1p1.model.Book;
import br.edu.ifsp.lp1p1.model.enums.user.UserRoles;
import br.edu.ifsp.lp1p1.service.BookService;
import br.edu.ifsp.lp1p1.service.LoanService;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
@Log4j2
public class BookController {

    private final BookService bookService;
    private final LoanService loanService;

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> findAll(){
        List<BookResponseDTO> books = this.bookService.findAll();
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        Book book = this.bookService.findById(id);
        this.loanService.deleteAllByBook(book);
        this.bookService.deleteById(book.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
