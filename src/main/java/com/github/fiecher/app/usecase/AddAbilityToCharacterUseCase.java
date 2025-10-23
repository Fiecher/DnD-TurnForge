package com.github.fiecher.app.usecase;

import com.github.fiecher.app.dtos.AddAbilityRequest;
import com.github.fiecher.app.dtos.AddAbilityResponse;
import com.github.fiecher.domain.services.CharacterService;

import java.util.Objects;

public class AddAbilityToCharacterUseCase implements UseCase<AddAbilityRequest, AddAbilityResponse> {

    private final CharacterService characterService;

    public AddAbilityToCharacterUseCase(CharacterService characterService) {
        this.characterService = Objects.requireNonNull(characterService);
    }

    @Override
    public AddAbilityResponse execute(AddAbilityRequest input) {
        characterService.addAbilityToCharacter(
                input.characterID(),
                input.abilityID()
        );

        return new AddAbilityResponse(input.characterID());
    }
}