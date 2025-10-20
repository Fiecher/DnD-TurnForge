package com.github.fiecher.domain.repository;

import com.github.fiecher.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Integer save(User user);

    Optional<User> findByID(int userID);

    Optional<User> findByLogin(String login);

    List<User> findAll();

    User update(User user);

    void deleteByID(int userID);

    void deleteByLogin(int login);

    boolean existByLogin(String login);
}
