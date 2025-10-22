package com.github.fiecher;

import com.github.fiecher.app.usecase.CreateCharacterUseCase;
import com.github.fiecher.app.usecase.CreateUserUseCase;
import com.github.fiecher.app.usecase.GetCharactersUseCase;
import com.github.fiecher.app.usecase.LoginUserUseCase;
import com.github.fiecher.presentation.cli.ApplicationContext;
import com.github.fiecher.presentation.cli.Input.InputReader;
import com.github.fiecher.presentation.cli.Menu;
import com.github.fiecher.presentation.cli.commands.character.CreateCharacterCommand;
import com.github.fiecher.presentation.cli.commands.character.GetCharactersCommand;
import com.github.fiecher.presentation.cli.commands.user.CreateUserCommand;
import com.github.fiecher.presentation.cli.View;
import com.github.fiecher.presentation.cli.commands.user.LoginUserCommand;
import com.github.fiecher.domain.repositories.*;
import com.github.fiecher.domain.services.*;
import com.github.fiecher.infrastructure.db.inmemory.*;

public class Main {

    public static void main(String[] args) {
        PasswordGenerator.init(readSalt());

        AbilityRepository abilityRepository = new InMemoryAbilityRepository();
        ArmorRepository armorRepository = new InMemoryArmorRepository();
        CharacterRepository characterRepository = new InMemoryCharacterRepository();
        ItemRepository itemRepository = new InMemoryItemRepository();
        SkillRepository skillRepository = new InMemorySkillRepository();
        TraitRepository traitRepository = new InMemoryTraitRepository();
        UserRepository userRepository = new InMemoryUserRepository();
        WeaponRepository weaponRepository = new InMemoryWeaponRepository();

        CharacterService characterService = new CharacterService(characterRepository, abilityRepository, weaponRepository, armorRepository, itemRepository, traitRepository, skillRepository);
        UserService userService = new UserService(userRepository);


        ApplicationContext applicationContext = new ApplicationContext();
        View view = new View();
        InputReader reader = new InputReader();
        Menu menu = new Menu(view, reader,applicationContext);


        CreateUserUseCase createUserUseCase = new CreateUserUseCase(userService);
        LoginUserUseCase loginUserUseCase = new LoginUserUseCase(userService);
        CreateCharacterUseCase createCharacterUseCase = new CreateCharacterUseCase(characterService);
        GetCharactersUseCase getCharactersUseCase = new GetCharactersUseCase(characterRepository, abilityRepository, skillRepository, weaponRepository, armorRepository, itemRepository);


        menu.registerCommand(new CreateUserCommand(createUserUseCase, view, reader), true);
        menu.registerCommand(new LoginUserCommand(loginUserUseCase, applicationContext, view, reader), true);
        menu.registerCommand(new CreateCharacterCommand(createCharacterUseCase, applicationContext, view, reader), false);
        menu.registerCommand(new GetCharactersCommand(getCharactersUseCase, applicationContext, view), false);

        menu.start();
    }

    private static String readSalt() {
        String salt = System.getenv("SALT");
        if (salt == null){
            throw new IllegalArgumentException("No Salt set in env");
        }
        return salt;
    }
}

