package com.github.fiecher.app.dtos;

public class CreateUser {

    public record CreateUserRequest(String login, String password) {
    }

}
