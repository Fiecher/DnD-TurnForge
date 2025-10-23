package com.github.fiecher.app.dtos;

public record CreateCharacterRequest(Long userID, String name, String characterClass) {
}
