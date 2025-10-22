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

    }

}

