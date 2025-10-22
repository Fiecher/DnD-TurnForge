package com.github.fiecher.app.usecase;

import com.github.fiecher.app.dtos.CreateUserRequest;
import com.github.fiecher.domain.services.UserService;

public class CreateUserUseCase implements UseCase<CreateUserRequest, Long> {

    private final UserService userService;

    public CreateUserUseCase(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Long execute(CreateUserRequest input) {
        return userService.registerUser(input.login(), input.password());
    }

}