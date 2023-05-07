package br.edu.ifsp.lp1p1.mapper.user;

import br.edu.ifsp.lp1p1.dto.user.UserRequestDTO;
import br.edu.ifsp.lp1p1.dto.user.UserResponseDTO;
import br.edu.ifsp.lp1p1.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserRequestDTOMapper {

    public static final UserRequestDTOMapper INSTANCE = Mappers.getMapper(UserRequestDTOMapper.class);

    public abstract UserRequestDTO toUserRequestDTO(User user);
}
