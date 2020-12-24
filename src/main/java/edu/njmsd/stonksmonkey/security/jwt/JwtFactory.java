package edu.njmsd.stonksmonkey.security.jwt;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class JwtFactory {

    private final JwtSettings jwtSettings;

    public JwtFactory(JwtSettings jwtSettings) {
        this.jwtSettings = jwtSettings;
    }

    public String createAccessToken(String username) {
        var expiration = LocalDateTime.now()
                .plusSeconds(jwtSettings.getExpirationTime())
                .atZone(ZoneId.systemDefault())
                .toInstant();
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(Date.from(expiration))
                .signWith(jwtSettings.getSigningKey())
                .compact();
    }
}
