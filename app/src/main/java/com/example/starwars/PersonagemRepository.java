package com.example.starwars;

import java.io.Serializable;
import java.util.List;

public class PersonagemRepository implements Serializable {
    private List<Character> getPersonagens;

    public Character getCharacter(Integer id){
        return this.getPersonagens.get(id);
    }

    public List<Character> getCharacters() {
        return this.getPersonagens;
    }

    public void setCharacters(List<Character> characters) {
        this.getPersonagens = characters;
    }
}
