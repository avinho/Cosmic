package com.avinho.backend.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.avinho.backend.entities.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/*
TODO: melhorar os claims do JWT
*/
@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(User user) throws JWTCreationException {
        return JWT.create()
                .withIssuer("backend")
                .withClaim("id", user.getId())
                .withSubject(user.getUsername())
                .withClaim("role", user.getRole().getDescription())
                .withExpiresAt(LocalDateTime.now().plusMinutes(5).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256(secret));
    }

    public String getSubject(String token) throws JWTVerificationException {
        return JWT.require(Algorithm.HMAC256(secret)).withIssuer("backend").build().verify(token).getSubject();
    }
}
