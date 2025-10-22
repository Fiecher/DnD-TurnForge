package com.github.fiecher.app.usecase;

import com.github.fiecher.app.dtos.LoginRequest;
import com.github.fiecher.domain.models.User;
import com.github.fiecher.domain.services.UserService;

import java.util.Objects;
import java.util.Optional;

public class LoginUserUseCase {
    private final UserService userService;

    public LoginUserUseCase(UserService userService) {
        this.userService = Objects.requireNonNull(userService);
    }

    public Optional<User> execute(LoginRequest request) {
        return userService.authenticateUser(request.login(), request.password());
    }
}
