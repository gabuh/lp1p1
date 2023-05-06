package br.edu.ifsp.lp1p1.model;

import br.edu.ifsp.lp1p1.model.enums.user.UserRoles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cpf;

    private String address;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRoles role;

    @Transient
    @JsonIgnore
    @OneToMany(targetEntity = Loan.class, mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Loan> clientLoans = new ArrayList<>();

    @Transient
    @JsonIgnore
    @OneToMany(targetEntity = Loan.class, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Loan> userLoans = new ArrayList<>();

    public User() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.toString()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
