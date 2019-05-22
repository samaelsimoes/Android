package com.example.starwars;

import java.io.Serializable;
import java.util.List;

class VeiculosRepository implements Serializable {
    private List<Veiculo> veiculos;

    public Veiculo getVeiculos(Integer id){
        return this.veiculos.get(id);
    }

    public List<Veiculo> getVeiculos() {
        return this.veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
