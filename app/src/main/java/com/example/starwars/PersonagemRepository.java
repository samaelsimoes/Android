package com.example.starwars;

import java.io.Serializable;
import java.util.List;

public class CharacterRepository implements Serializable {
    private List<Character> characters;

    public Character getCharacter(Integer id){
        return this.characters.get(id);
    }

    public List<Character> getCharacters() {
        return this.characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
