package com.github.fiecher.app.usecase;

import com.github.fiecher.app.dtos.CharacterCreationResponse;
import com.github.fiecher.app.dtos.CreateCharacterRequest;
import com.github.fiecher.domain.services.CharacterService;

import java.util.Objects;

public class CreateCharacterUseCase implements UseCase<CreateCharacterRequest, CharacterCreationResponse> {

    private final CharacterService characterService;

    public CreateCharacterUseCase(CharacterService characterService) {
        this.characterService = Objects.requireNonNull(characterService);
    }

    @Override
    public CharacterCreationResponse execute(CreateCharacterRequest input) {
        Long newID = characterService.createNewCharacter(
                input.userID(),
                input.name(),
                input.characterClass()
        );

        return new CharacterCreationResponse(newID);
    }
}