package com.example.starwars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonagemActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_personagem );

        listView = (ListView) findViewById( R.id.listViewPersonagens );

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JsonApi.BASE_URL)
                .addConverterFactory( GsonConverterFactory.create() )
                .build();

        JsonApi api = retrofit.create(JsonApi.class);

        Call<List<Personagem>> call = api.getPersonagens();

        call.enqueue( new Callback<List<Personagem>>() {
            @Override
            public void onResponse(Call<List<Personagem>> call, Response<List<Personagem>> response) {
                List<Personagem> allPerson = response.body();

                String[] personagemName = new String[allPerson.size()];

                for (int i = 0; i < allPerson.size(); i++ ) {
                    personagemName[i] = allPerson.get(i).getName();
                }

                listView.setAdapter(
                        new ArrayAdapter<String>(
                            getApplicationContext(),
                            android.R.layout.simple_list_item_1,
                            personagemName
                ) );
            }

            @Override
            public void onFailure(Call<List<Personagem>> call, Throwable t) {
                Toast.makeText( getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT ).show();
            }
        } );
    }
}
