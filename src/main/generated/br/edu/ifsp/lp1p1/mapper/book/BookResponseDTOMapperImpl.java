package br.edu.ifsp.lp1p1.mapper.book;

import br.edu.ifsp.lp1p1.dto.book.BookResponseDTO;
import br.edu.ifsp.lp1p1.model.Book;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-06T14:41:19-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class BookResponseDTOMapperImpl extends BookResponseDTOMapper {

    @Override
    public BookResponseDTO toBookResponseDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String author = null;
        String publisher = null;
        String publicationYear = null;
        Integer numberOfCopies = null;
        Integer numberOfCopiesAvailable = null;

        id = book.getId();
        title = book.getTitle();
        author = book.getAuthor();
        publisher = book.getPublisher();
        publicationYear = book.getPublicationYear();
        numberOfCopies = book.getNumberOfCopies();
        numberOfCopiesAvailable = book.getNumberOfCopiesAvailable();

        BookResponseDTO bookResponseDTO = new BookResponseDTO( id, title, author, publisher, publicationYear, numberOfCopies, numberOfCopiesAvailable );

        return bookResponseDTO;
    }
}
