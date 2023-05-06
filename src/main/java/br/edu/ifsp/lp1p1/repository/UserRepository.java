package br.edu.ifsp.lp1p1.repository;

import br.edu.ifsp.lp1p1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByCpf(String cpf);

}
