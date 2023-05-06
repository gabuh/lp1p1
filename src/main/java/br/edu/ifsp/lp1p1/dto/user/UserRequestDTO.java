package br.edu.ifsp.lp1p1.dto.user;

import br.edu.ifsp.lp1p1.model.enums.user.UserRoles;

public record UserRequestDTO(
        String name,
        String cpf,
        String address,
        String email,
        String password,
        UserRoles role) {
}
