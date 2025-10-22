package com.github.fiecher.app.usecase;

public interface UseCase<Input, Output> {
    Output execute(Input input);
}
