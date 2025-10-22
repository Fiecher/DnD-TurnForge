package com.github.fiecher.domain.repository;

import com.github.fiecher.domain.models.Skill;

import java.util.List;
import java.util.Optional;

public interface SkillsRepository {

    Skill save(Skill skill);

    Optional<Skill> findByID(int skillID);

    Optional<Skill> findByName(int skillName);

    Skill update(Skill skill);

    void deleteByID(int skillID);

    void deleteByName(int skillName);

    List<Skill> findAll();
}
