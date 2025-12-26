package com.example.demo.security;

import java.util.*;
import java.util.stream.Collectors;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

import org.springframework.security.core.GrantedAuthority;

public class JwtTokenProvider {

    private final SecretKey key;
    private final long validityInMs;

    public JwtTokenProvider(String secret, long validityInMs) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.validityInMs = validityInMs;
    }

    public String generateToken(UserPrincipal user) {

        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMs);

        List<String> roles = user.getAuthorities()
                .stream()
                .map(a -> a.getAuthority())
                .toList();

        return Jwts.builder()
                .setSubject(user.getName())
                .claim("roles", roles)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }


    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // 🔴 REQUIRED BY TEST
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public List<String> getRoles(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.get("roles", List.class);
    }
}