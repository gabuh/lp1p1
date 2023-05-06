package br.edu.ifsp.lp1p1.dto.user;

import br.edu.ifsp.lp1p1.model.enums.user.UserRoles;

public record UserResponseDTO(
        Long id,
        String name,
        String cpf,
        String address,
        String email,
        UserRoles role) {
}
