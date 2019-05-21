package com.example.starwars;

import java.io.Serializable;
import java.util.List;

public class Planeta implements Serializable {

    private String orbital_period;
    private String surface_water;
    private String population;

    private String diameter;
    private String rotation_period;

    private List<String> residents;
    private List<String> films;

    private String name;
    private String created;
    private String edited;
    private String url;
    private String climate;
    private String gravity;
    private String terrain;


    public Planeta(String orbital_period, String surface_water, String population, String diameter, String rotation_period, List<String> residents, List<String> films, String name, String created, String edited, String url, String climate, String gravity, String terrain) {
        this.orbital_period = orbital_period;
        this.surface_water = surface_water;
        this.population = population;
        this.diameter = diameter;
        this.rotation_period = rotation_period;
        this.residents = residents;
        this.films = films;
        this.name = name;
        this.created = created;
        this.edited = edited;
        this.url = url;
        this.climate = climate;
        this.gravity = gravity;
        this.terrain = terrain;
    }

    public String getOrbital_period() {
        return orbital_period;
    }

    public void setOrbital_period(String orbital_period) {
        this.orbital_period = orbital_period;
    }

    public String getSurface_water() {
        return surface_water;
    }

    public void setSurface_water(String surface_water) {
        this.surface_water = surface_water;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getRotation_period() {
        return rotation_period;
    }

    public void setRotation_period(String rotation_period) {
        this.rotation_period = rotation_period;
    }

    public List<String> getResidents() {
        return residents;
    }

    public void setResidents(List<String> residents) {
        this.residents = residents;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }
}

