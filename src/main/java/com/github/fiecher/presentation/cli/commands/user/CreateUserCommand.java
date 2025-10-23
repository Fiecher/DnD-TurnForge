package com.github.fiecher.presentation.cli.commands.user;


import com.github.fiecher.app.dtos.CreateUserRequest;
import com.github.fiecher.app.usecase.CreateUserUseCase;
import com.github.fiecher.presentation.cli.Input.InputReader;
import com.github.fiecher.presentation.cli.View;
import com.github.fiecher.presentation.cli.commands.Command;

import java.util.Objects;

public class CreateUserCommand implements Command {
    private final CreateUserUseCase createUserUseCase;
    private final View view;
    private final InputReader reader;

    public CreateUserCommand(CreateUserUseCase createUserUseCase, View view, InputReader reader) {
        this.createUserUseCase = Objects.requireNonNull(createUserUseCase);
        this.view = Objects.requireNonNull(view);
        this.reader = Objects.requireNonNull(reader);
    }

    @Override
    public String getName() {
        return "Register";
    }

    @Override
    public void execute() {
        try {
            view.showMessage("\n--- Registration ---");
            String login = reader.readLine("Enter login: ");
            String password = reader.readLine("Enter password: ");

            Long userId = createUserUseCase.execute(
                    new CreateUserRequest(login, password)
            );

            view.showSuccess("User registered successfully with ID: " + userId);
        } catch (Exception e) {
            view.showError("Registration failed: " + e.getMessage());
        }
    }
}