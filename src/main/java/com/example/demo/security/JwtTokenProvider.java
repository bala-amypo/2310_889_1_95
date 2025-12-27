package com.example.demo.security;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import java.util.Date;
import javax.crypto.SecretKey;

public class JwtTokenProvider {
    private final SecretKey key;
    private final long validityInMs;

    public JwtTokenProvider(String secret, long validityInMs) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.validityInMs = validityInMs;
    }

    public String generateToken(Authentication auth, Long userId, String email, String role) {
        return Jwts.builder()
                .setSubject(userId.toString())
                .claim("email", email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityInMs))
                .signWith(key)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) { return false; }
    }

    public Long getUserIdFromToken(String t) {
        String sub = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(t).getBody().getSubject();
        return Long.parseLong(sub);
    }
    
    public String getEmailFromToken(String t) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(t).getBody().get("email", String.class);
    }
    
    public String getRoleFromToken(String t) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(t).getBody().get("role", String.class);
    }
}