package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserAccount {
    @Id
    @GeneratedValue
    private long id;
    private String username, password;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<GrantedAuthority> authorities = new ArrayList<>();

    protected UserAccount() {
    }

    public UserAccount(String _Username, String _Password, String... _Authorities) {
        this.username = _Username;
        this.password = _Password;
        this.authorities = Arrays.stream(_Authorities)
                .map(SimpleGrantedAuthority::new)
                .map(GrantedAuthority.class::cast)
                .toList();
    }

    public UserDetails asUser() {
        return User.withDefaultPasswordEncoder()
                .username(getUsername())
                .password(getPassword())
                .authorities(getAuthorities())
                .build();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, authorities);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        UserAccount other = (UserAccount) obj;
        return (Objects.equals(id, other.id)
                && Objects.equals(username, other.username)
                && Objects.equals(password, other.password)
                && Objects.equals(authorities, other.authorities));
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserAccount [id=" + id + ", username=" + username + ", password=" + password + ", authorities="
                + authorities + "]";
    }

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}