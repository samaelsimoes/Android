package com.example.starwars;

import java.io.Serializable;
import java.util.List;

public class PersonagemRepository implements Serializable {
    private List<Personagem> personagens;

    public Personagem getPersonagem(Integer id){
        return this.personagens.get(id);
    }

    public List<Personagem> getPersonagens() {
        return this.personagens;
    }

    public void setPersonagens(List<Personagem> personagens) {
        this.personagens = personagens;
    }
}
