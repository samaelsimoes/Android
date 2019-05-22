package com.example.starwars;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("people/")
    abstract Call<PersonagemResponse> getPersonagens();

    @GET("planets/")
    abstract Call<PlanetasResponse> getPlanetas();

    @GET("vehicles/")
    abstract Call<VeiculoResponse> getVeiculos();
}
