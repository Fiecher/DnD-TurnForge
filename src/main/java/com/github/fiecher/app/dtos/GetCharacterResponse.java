package com.github.fiecher.app.dtos;

import java.util.Optional;

public record GetCharacterResponse(Optional<CharacterDetails> character) {
}
