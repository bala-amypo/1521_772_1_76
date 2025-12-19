package com.example.demo.security;

public class JwtTokenProvider {

    private final String secret;
    private final long validity;

    public JwtTokenProvider(String secret, long validity) {
        this.secret = secret;
        this.validity = validity;
    }
}
