package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import java.util.*;

public class UserPrincipal implements UserDetails {

    private final Long id;
    private final String username;
    private final String role;
    private final String password;

    public UserPrincipal(Long id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Long getId() { return id; }

    @Override public String getUsername() { return username; }
    @Override public String getPassword() { return password; }
    @Override public Collection<?> getAuthorities() { return List.of(); }
    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}
