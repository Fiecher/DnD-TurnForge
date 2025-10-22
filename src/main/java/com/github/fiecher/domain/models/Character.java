package com.github.fiecher.domain.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Character {
    private Long id;
    private String login;
    private int level;

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    private String description;
    private String image;

    private String characterClass;
    private String subclass;
    private String background;
    private String race;
    private int age;
    private String size;
    private String spellcastingAbility;

    private int money;

    private List<String> skills = new ArrayList<>();
    private List<String> abilities = new ArrayList<>();
    private List<String> weapons = new ArrayList<>();
    private List<String> items = new ArrayList<>();
    private List<String> armor = new ArrayList<>();
    private List<String> traits = new ArrayList<>();
    private List<String> specialItems = new ArrayList<>();

    public Character(Long id, String login) {
        this.id = id;
        this.login = login;
        this.level = 1;
        this.money = 0;
    }

    public Character() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getlogin() { return login; }
    public void setlogin(String login) { this.login = login; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public int getStrength() { return strength; }
    public void setStrength(int strength) { this.strength = strength; }

    public int getDexterity() { return dexterity; }
    public void setDexterity(int dexterity) { this.dexterity = dexterity; }

    public int getConstitution() { return constitution; }
    public void setConstitution(int constitution) { this.constitution = constitution; }

    public int getIntelligence() { return intelligence; }
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }

    public int getWisdom() { return wisdom; }
    public void setWisdom(int wisdom) { this.wisdom = wisdom; }

    public int getCharisma() { return charisma; }
    public void setCharisma(int charisma) { this.charisma = charisma; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getCharacterClass() { return characterClass; }
    public void setCharacterClass(String characterClass) { this.characterClass = characterClass; }

    public String getSubclass() { return subclass; }
    public void setSubclass(String subclass) { this.subclass = subclass; }

    public String getBackground() { return background; }
    public void setBackground(String background) { this.background = background; }

    public String getRace() { return race; }
    public void setRace(String race) { this.race = race; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getSpellcastingAbility() { return spellcastingAbility; }
    public void setSpellcastingAbility(String spellcastingAbility) { this.spellcastingAbility = spellcastingAbility; }

    public int getMoney() { return money; }
    public void setMoney(int money) { this.money = money; }

    public List<String> getSkills() { return skills; }
    public List<String> getAbilities() { return abilities; }
    public List<String> getWeapons() { return weapons; }
    public List<String> getItems() { return items; }
    public List<String> getArmor() { return armor; }
    public List<String> getTraits() { return traits; }
    public List<String> getSpecialItems() { return specialItems; }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", level=" + level +
                ", class=" + characterClass +
                ", race=" + race +
                ", str=" + strength +
                ", dex=" + dexterity +
                ", con=" + constitution +
                ", int=" + intelligence +
                ", wis=" + wisdom +
                ", cha=" + charisma +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Character character)) return false;
        return Objects.equals(id, character.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
