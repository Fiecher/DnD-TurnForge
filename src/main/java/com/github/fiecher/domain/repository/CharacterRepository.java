package com.github.fiecher.domain.repository;

import com.github.fiecher.domain.models.Character;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository {

    Character save(Character character);

    Optional<Character> findByID(Integer characterID);

    List<Character> findAll();

    Character update(Character character);

    void deleteByID(int characterID);
}
