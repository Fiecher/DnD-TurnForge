package com.github.fiecher.presentation.cli.commands;

public interface Command {
    String getName();

    void execute();
}