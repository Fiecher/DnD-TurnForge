package com.github.fiecher.app.dtos;


public record UpdateStatsRequest(
        Long characterID,
        Short strength,
        Short dexterity,
        Short constitution,
        Short intelligence,
        Short wisdom,
        Short charisma
) {}