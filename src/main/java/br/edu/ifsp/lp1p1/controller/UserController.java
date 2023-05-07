package br.edu.ifsp.lp1p1.controller;

import br.edu.ifsp.lp1p1.dto.user.ClientRequestDTO;
import br.edu.ifsp.lp1p1.dto.user.UserLoginDTO;
import br.edu.ifsp.lp1p1.dto.user.UserRequestDTO;
import br.edu.ifsp.lp1p1.dto.user.UserResponseDTO;
import br.edu.ifsp.lp1p1.mapper.user.UserMapper;
import br.edu.ifsp.lp1p1.mapper.user.UserRequestDTOMapper;
import br.edu.ifsp.lp1p1.model.User;
import br.edu.ifsp.lp1p1.model.enums.user.UserRoles;
import br.edu.ifsp.lp1p1.service.LoanService;
import br.edu.ifsp.lp1p1.service.TokenService;
import br.edu.ifsp.lp1p1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;
    private final LoanService loanService;

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    @PostMapping("/login")
    public String login(@RequestBody UserLoginDTO userLoginDTO){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userLoginDTO.email(), userLoginDTO.password());

        Authentication authenticate = this.authenticationManager
                .authenticate(usernamePasswordAuthenticationToken);

        User user = (User) authenticate.getPrincipal();

        return tokenService.generateToken(user);

    }

    @PostMapping("/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO userRequestDTO){
        this.userService.save(userRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/users/client")
    public ResponseEntity<UserResponseDTO> registerClient(@RequestBody ClientRequestDTO clientRequestDTO){
        User user = UserMapper.INSTANCE.toUser(clientRequestDTO);
        user.setRole(UserRoles.CLIENT);
        UserRequestDTO userRequestDTO = UserRequestDTOMapper.INSTANCE.toUserRequestDTO(user);
        this.userService.save(userRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Object> deleteUserById(@PathVariable Long id){
        User user = this.userService.findById(id);
        this.loanService.deleteAllByUser(user);
        this.loanService.deleteAllByClient(user);
        this.userService.deleteById(user.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<UserResponseDTO>> findAll(){
        List<UserResponseDTO> users = this.userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/find")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<UserResponseDTO> findByCpf(@RequestParam String cpf){
        UserResponseDTO user = this.userService.findByCpf(cpf);
        return ResponseEntity.ok(user);
    }

}
