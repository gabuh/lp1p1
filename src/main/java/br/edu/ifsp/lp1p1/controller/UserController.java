package br.edu.ifsp.lp1p1.controller;

import br.edu.ifsp.lp1p1.dto.book.UserLoginDTO;
import br.edu.ifsp.lp1p1.model.User;
import br.edu.ifsp.lp1p1.service.TokenService;
import br.edu.ifsp.lp1p1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/login")
public class UserController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    @PostMapping
    public String login(@RequestBody UserLoginDTO userLoginDTO){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userLoginDTO.email(), userLoginDTO.password());

        Authentication authenticate = this.authenticationManager
                .authenticate(usernamePasswordAuthenticationToken);

        User user = (User) authenticate.getPrincipal();

        return tokenService.generateToken(user);

    }
}
