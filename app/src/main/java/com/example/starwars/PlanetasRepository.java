package com.example.starwars;

import java.io.Serializable;
import java.util.List;

class PlanetasRepository implements Serializable {

    private List<Planeta> planetas;

    public Planeta getPlanetas(Integer id){
        return this.planetas.get(id);
    }

    public List<Planeta> getPlanetas() {
        return this.planetas;
    }

    public void setPlanetas(List<Planeta> Planetas) {
        this.planetas = planetas;
    }
}
