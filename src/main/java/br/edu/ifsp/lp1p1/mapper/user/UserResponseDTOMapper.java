package br.edu.ifsp.lp1p1.mapper.user;

import br.edu.ifsp.lp1p1.dto.user.UserResponseDTO;
import br.edu.ifsp.lp1p1.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserResponseDTOMapper {

    public static final UserResponseDTOMapper INSTANCE = Mappers.getMapper(UserResponseDTOMapper.class);

    public abstract UserResponseDTO toUserResponseDTO(User user);
}
