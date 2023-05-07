package br.edu.ifsp.lp1p1.repository;

import br.edu.ifsp.lp1p1.model.User;
import br.edu.ifsp.lp1p1.model.enums.user.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByCpf(String cpf);

    List<User> findAllByRole(UserRoles role);

//    @Query(value = "select u1_0.id,u1_0.address,u1_0.cpf,u1_0.email,u1_0.name,u1_0.password,u1_0.role from User u1_0 where u1_0.name=:name")
    List<User> findAllByName(String name);

}
