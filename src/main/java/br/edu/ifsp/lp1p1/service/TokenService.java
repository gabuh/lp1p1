package br.edu.ifsp.lp1p1.service;

import br.edu.ifsp.lp1p1.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    public String generateToken(User user) {
        return JWT.create()
                .withIssuer("System")
                .withSubject(user.getEmail())
                .withClaim("id", user.getId())
                .withExpiresAt(LocalDateTime.now().plusMinutes(60).toInstant(ZoneOffset.of("-03:00"))
                ).sign(Algorithm.HMAC256("secret"));
    }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256("secret"))
                .withIssuer("System")
                .build().verify(token).getSubject();
    }
}
