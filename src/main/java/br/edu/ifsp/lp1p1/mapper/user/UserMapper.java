package br.edu.ifsp.lp1p1.mapper.user;

import br.edu.ifsp.lp1p1.dto.user.UserRequestDTO;
import br.edu.ifsp.lp1p1.dto.user.UserResponseDTO;
import br.edu.ifsp.lp1p1.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    public abstract User toUser(UserRequestDTO userRequestDTO);

    @Mapping(target = "id", ignore = true)
    public abstract User toUser(UserResponseDTO userResponseDTO);
}
