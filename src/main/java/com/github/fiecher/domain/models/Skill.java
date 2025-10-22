package com.github.fiecher.domain.models;

public class Skill {
    private Long id;
    private String name;
    private boolean isProficient;
    private boolean isExpertise;

    public Skill() {
    }

    public Skill(Long id, String name, boolean isProficient, boolean isExpertise) {
        this.id = id;
        this.name = name;
        this.isProficient = isProficient;
        this.isExpertise = isExpertise;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isProficient() {
        return isProficient;
    }

    public void setProficient(boolean proficient) {
        isProficient = proficient;
    }

    public boolean isExpertise() {
        return isExpertise;
    }

    public void setExpertise(boolean expertise) {
        isExpertise = expertise;
    }
}
