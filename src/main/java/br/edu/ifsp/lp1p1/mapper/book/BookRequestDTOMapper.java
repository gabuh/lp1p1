package br.edu.ifsp.lp1p1.mapper.book;

import br.edu.ifsp.lp1p1.dto.book.BookRequestDTO;
import br.edu.ifsp.lp1p1.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class BookRequestDTOMapper {

    public static BookRequestDTOMapper INSTANCE = Mappers.getMapper(BookRequestDTOMapper.class);

    public abstract BookRequestDTO toBookResponseDTO(Book book);
}
