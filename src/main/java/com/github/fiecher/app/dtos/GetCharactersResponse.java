package com.github.fiecher.app.dtos;

import java.util.List;

public record GetCharactersResponse(List<CharacterDetails> characters) {}