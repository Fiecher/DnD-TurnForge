package com.github.fiecher.presentation.cli.commands.user;

import com.github.fiecher.app.dtos.LoginRequest;
import com.github.fiecher.app.usecase.LoginUserUseCase;
import com.github.fiecher.presentation.cli.ApplicationContext;
import com.github.fiecher.presentation.cli.Input.InputReader;
import com.github.fiecher.presentation.cli.View;
import com.github.fiecher.presentation.cli.commands.Command;
import com.github.fiecher.domain.models.User;

import java.util.Objects;
import java.util.Optional;

public class LoginUserCommand implements Command {
    private final LoginUserUseCase authenticateUserUseCase;
    private final ApplicationContext context;
    private final View view;
    private final InputReader reader;

    public LoginUserCommand(
            LoginUserUseCase authenticateUserUseCase,
            ApplicationContext context,
            View view,
            InputReader reader
    ) {
        this.authenticateUserUseCase = Objects.requireNonNull(authenticateUserUseCase);
        this.context = Objects.requireNonNull(context);
        this.view = Objects.requireNonNull(view);
        this.reader = Objects.requireNonNull(reader);
    }

    @Override
    public String getName() {
        return "Login";
    }

    @Override
    public void execute() {
        try {
            view.showMessage("\n--- User Login ---");
            String login = reader.readLine("Enter login: ");
            String password = reader.readLine("Enter password: ");

            Optional<User> user = authenticateUserUseCase.execute(
                    new LoginRequest(login, password)
            );

            if (user.isPresent()) {
                User authenticatedUser = user.get();

                context.login(authenticatedUser);

                view.showSuccess("Login successful! Welcome, " + authenticatedUser.getLogin() + ".");
            } else {
                view.showError("Login failed: Invalid login or password.");
            }

        } catch (Exception e) {
            view.showError("An error occurred during login: " + e.getMessage());
        }
    }
}
