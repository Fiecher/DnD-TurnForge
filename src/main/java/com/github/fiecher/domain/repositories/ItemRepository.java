package com.github.fiecher.domain.repositories;

import com.github.fiecher.domain.models.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    Long save(Item item);

    Optional<Item> findByID(Long itemID);

    Optional<Item> findByName(String name);

    List<Item> findAll();

    Item update(Item item);

    void deleteByID(Long itemID);

    void deleteByName(String name);

    boolean existsByName(String name);
}