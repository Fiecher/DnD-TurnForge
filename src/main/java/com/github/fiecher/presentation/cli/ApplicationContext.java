package com.github.fiecher.presentation.cli;

import com.github.fiecher.domain.models.User;

public class ApplicationContext {
    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void login(User user) {
        this.currentUser = user;
    }

    public void logout() {
        this.currentUser = null;
    }

    public boolean isAuthenticated() {
        return currentUser != null;
    }
}
