package edu.njmsd.stonksmonkey.api.security;

import io.jsonwebtoken.io.Decoders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTSettings {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration-time}")
    private int expirationTime;

    public byte[] getSecret() {
        return Decoders.BASE64.decode(secret);
    }

    public int getExpirationTime() {
        return expirationTime;
    }
}
