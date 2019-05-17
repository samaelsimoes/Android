package com.example.starwars;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonApi {

    String BASE_URL = "https://swapi.co/api/people/";

    @GET("people")
    Call<List<Personagem>> getPersonagens();
}
