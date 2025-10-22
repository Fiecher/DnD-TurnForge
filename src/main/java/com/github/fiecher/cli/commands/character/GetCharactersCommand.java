package com.github.fiecher.cli.commands.character;

import com.github.fiecher.app.dtos.CharacterDetails;
import com.github.fiecher.app.dtos.GetCharactersRequest;
import com.github.fiecher.app.dtos.GetCharactersResponse;
import com.github.fiecher.app.usecase.GetCharactersUseCase;
import com.github.fiecher.cli.ApplicationContext;
import com.github.fiecher.cli.View;
import com.github.fiecher.cli.commands.Command;
import com.github.fiecher.domain.models.User;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class GetCharactersCommand implements Command {

    private final GetCharactersUseCase getCharactersUseCase;
    private final ApplicationContext context;
    private final View view;

    public GetCharactersCommand(
            GetCharactersUseCase getCharactersUseCase,
            ApplicationContext context,
            View view) {

        this.getCharactersUseCase = Objects.requireNonNull(getCharactersUseCase);
        this.context = Objects.requireNonNull(context);
        this.view = Objects.requireNonNull(view);
    }

    @Override
    public String getName() {
        return "View My Characters";
    }

    @Override
    public void execute() {
        try {
            Optional<User> userOptional = context.getCurrentUser();
            if (userOptional.isEmpty()) {
                view.showError("Authentication required to view characters.");
                return;
            }

            Long userID = userOptional.get().getID();

            view.showMessage("\n --- Viewing Characters for User ID: " + userID + " ---");

            GetCharactersResponse response = getCharactersUseCase.execute(
                    new GetCharactersRequest(userID)
            );

            List<CharacterDetails> characters = response.characters();

            if (characters.isEmpty()) {
                view.showMessage("You have no characters yet. Use 'Create new Character' command.");
            } else {
                view.showMessage("Found " + characters.size() + " characters:");
                characters.forEach(c ->
                        view.showMessage("  ID: " + c.getID() + ", Name: " + c.getName() + ", Class: " + c.getCharacterClass())
                );
            }

        } catch (Exception e) {
            view.showError("Failed to retrieve characters: " + e.getMessage());
        }
    }
}