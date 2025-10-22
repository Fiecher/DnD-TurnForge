package com.github.fiecher.cli.commands;

public interface Command {
    String getName();

    void execute();
}