package com.github.fiecher.app.dtos;

public record CreateCharacterRequest(Long userId, String name, String characterClass) {
}
