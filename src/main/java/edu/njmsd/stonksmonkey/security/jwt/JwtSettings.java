package edu.njmsd.stonksmonkey.security.jwt;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;

@Component
public class JwtSettings {

    private final Key signingKey;
    private final int expirationTime;

    public JwtSettings(
            @Value("${app.security.jwt.secret}") String secret,
            @Value("${app.security.jwt.expiration-time}") int expirationTime) {
        this.signingKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expirationTime = expirationTime;
    }

    public Key getSigningKey() {
        return signingKey;
    }

    public int getExpirationTime() {
        return expirationTime;
    }
}
