package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class CustomUserDetailsService implements UserDetailsService {

    private final Map<String, UserPrincipal> users = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong();

    public UserPrincipal register(String email, String pass, String role) {
        UserPrincipal u =
                new UserPrincipal(idGen.incrementAndGet(), email, pass, role);
        users.put(email, u);
        return u;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return users.get(username);
    }
}
