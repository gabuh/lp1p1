package br.edu.ifsp.lp1p1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cpf;

    private String address;

    private String email;

    private String password;

    @Transient
    @JsonIgnore
    @OneToMany(targetEntity = Loan.class)
    private final List<Loan> clientLoans = new ArrayList<>();

    @Transient
    @JsonIgnore
    @OneToMany(targetEntity = Loan.class)
    private final List<Loan> userLoans = new ArrayList<>();

    public User() {

    }
}
