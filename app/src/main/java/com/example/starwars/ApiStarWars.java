package com.example.starwars;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiStarWars {

    private static final String BASE_URL = "https://swapi.co/api/";
    private static Retrofit retro        = null;

    public static Retrofit getClient() {
        if (retro == null) {
            retro = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory( GsonConverterFactory.create())
                    .build();
        }
        return retro;
    }
}
