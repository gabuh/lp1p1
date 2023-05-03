package br.edu.ifsp.lp1p1.mapper.book;

import br.edu.ifsp.lp1p1.dto.book.BookResponseDTO;
import br.edu.ifsp.lp1p1.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class BookResponseDTOMapper {

    public static BookResponseDTOMapper INSTANCE = Mappers.getMapper(BookResponseDTOMapper.class);

    public abstract BookResponseDTO toBookResponseDTO(Book book);
}
