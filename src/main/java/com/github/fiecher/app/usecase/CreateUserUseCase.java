package com.github.fiecher.app.usecase;

import com.github.fiecher.app.dtos.CreateUser;
import com.github.fiecher.domain.services.UserService;

public class CreateUserUseCase implements UseCase<CreateUser.CreateUserRequest, Integer> {

    private final UserService userService;

    public CreateUserUseCase(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Integer execute(CreateUser.CreateUserRequest input) {
        return userService.registerUser(input.login(), input.password());
    }

}