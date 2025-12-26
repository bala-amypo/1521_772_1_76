package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public boolean validateToken(String token) {
        // dummy validation for now
        return true;
    }

    public String getUsernameFromToken(String token) {
        // dummy username
        return "user";
    }
}
