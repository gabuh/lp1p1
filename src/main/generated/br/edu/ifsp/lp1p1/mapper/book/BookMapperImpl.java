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
public class BookMapperImpl extends BookMapper {

    @Override
    public Book toBook(BookResponseDTO bookResponseDTO) {
        if ( bookResponseDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookResponseDTO.id() );
        book.setTitle( bookResponseDTO.title() );
        book.setAuthor( bookResponseDTO.author() );
        book.setPublisher( bookResponseDTO.publisher() );
        book.setPublicationYear( bookResponseDTO.publicationYear() );
        book.setNumberOfCopies( bookResponseDTO.numberOfCopies() );
        book.setNumberOfCopiesAvailable( bookResponseDTO.numberOfCopiesAvailable() );

        return book;
    }
}
