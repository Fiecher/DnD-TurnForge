package com.github.fiecher.app.usecase;

import com.github.fiecher.app.dtos.CharacterDetails;
import com.github.fiecher.app.dtos.GetCharacterRequest;
import com.github.fiecher.app.dtos.GetCharacterResponse;
import com.github.fiecher.domain.models.*;
import com.github.fiecher.domain.models.Character;
import com.github.fiecher.domain.services.CharacterService;
import com.github.fiecher.domain.repositories.*;


import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class GetCharacterUseCase implements UseCase<GetCharacterRequest, GetCharacterResponse> {

    private final CharacterService characterService;
    private final AbilityRepository abilityRepository;
    private final SkillRepository skillRepository;
    private final WeaponRepository weaponRepository;
    private final ArmorRepository armorRepository;
    private final ItemRepository itemRepository;

    public GetCharacterUseCase(CharacterService characterService, AbilityRepository abilityRepository, SkillRepository skillRepository, WeaponRepository weaponRepository, ArmorRepository armorRepository, ItemRepository itemRepository) {
        this.characterService = Objects.requireNonNull(characterService);
        this.abilityRepository = Objects.requireNonNull(abilityRepository);
        this.skillRepository = Objects.requireNonNull(skillRepository);
        this.weaponRepository = Objects.requireNonNull(weaponRepository);
        this.armorRepository = Objects.requireNonNull(armorRepository);
        this.itemRepository = Objects.requireNonNull(itemRepository);
    }

    @Override
    public GetCharacterResponse execute(GetCharacterRequest input) {
        Optional<Character> characterOptional = characterService.getCharacterByID(input.characterID());

        Optional<CharacterDetails> detailsOptional = characterOptional.map(this::mapToDetails);

        return new GetCharacterResponse(detailsOptional);
    }

    private CharacterDetails mapToDetails(Character character) {
        List<String> abilityNames = character.getAbilityIDs().stream()
                .map(abilityRepository::findByID)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(Ability::getName)
                .collect(Collectors.toList());

        List<String> skillNames = character.getSkillIDs().stream()
                .map(skillRepository::findByID)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(Skill::getName)
                .collect(Collectors.toList());

        List<String> weaponNames = character.getWeaponIDs().stream()
                .map(weaponRepository::findByID)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(Weapon::getName)
                .collect(Collectors.toList());

        List<String> armorNames = character.getArmorIDs().stream()
                .map(armorRepository::findByID)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(Armor::getName)
                .collect(Collectors.toList());

        List<String> itemNames = character.getItemIDs().stream()
                .map(itemRepository::findByID)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(Item::getName)
                .collect(Collectors.toList());


        return new CharacterDetails(
                character.getID(),
                character.getName(),
                character.getClass_(),
                character.getLevel(),

                character.getStrength(),
                character.getDexterity(),
                character.getConstitution(),
                character.getIntelligence(),
                character.getWisdom(),
                character.getCharisma(),

                character.getDescription(),
                character.getImage(),
                character.getRace(),

                abilityNames,
                skillNames,
                weaponNames,
                armorNames,
                itemNames
        );
    }
}