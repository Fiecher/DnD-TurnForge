package com.github.fiecher.domain.models;

import java.util.Objects;


enum UserRole {
    USER,
    ADMIN
}

public final class User {

    private Long id;
    private final String login;
    private String passwordHash;
    private UserRole role;

    public User(String login, String passwordHash) {
        if (login == null || login.trim().isEmpty()) {
            throw new IllegalArgumentException("Login cannot be empty");
        }
        if (passwordHash == null || passwordHash.trim().isEmpty()) {
            throw new IllegalArgumentException("Password hash cannot be empty");
        }
        this.login = login;
        this.passwordHash = passwordHash;
    }

    public User(Long id, String login, String passwordHash, UserRole role) {
        Objects.requireNonNull(login, "Login cannot be null");
        Objects.requireNonNull(passwordHash, "Password hash cannot be null");
        Objects.requireNonNull(role, "Role cannot be null");
        this.id = id;
        this.login = login;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public UserRole getRole() {
        return role;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public User assignRole(UserRole newRole) {
        if (this.role.equals(newRole)) {
            return this;
        }
        return new User(this.id, this.login, this.passwordHash, newRole);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() || id == null) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
