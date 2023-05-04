package br.edu.ifsp.lp1p1.config.auth;

import br.edu.ifsp.lp1p1.model.User;
import br.edu.ifsp.lp1p1.repository.UserRepository;
import br.edu.ifsp.lp1p1.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class FilterToken extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token;
        var authorization = request.getHeader("Authorization");
        if(authorization != null){
            token = authorization.replace("Bearer ", "");
            String subject = this.tokenService.getSubject(token);

            User user = this.userRepository.findByEmail(subject);


            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
}
