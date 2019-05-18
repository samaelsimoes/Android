package com.example.starwars;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BastidoresActivity extends AppCompatActivity {

    private ListView    listViewPersonagens;
    //private ProgressBar progressBar;
    private Button      buttonPersonagem;
    private Button      buttonPlanetas;
    private Button      buttonFilmes;
    private Button      buttonEspecies;
    private Button      buttonVeiculos;
    private Button      buttonNaves;

    private ApiInterface          apiInterface;
    private PlanetasRepository    PlanetasRepository;
    private FilmesRepository      FilmesRepository;
    private EspeciesRepository    EspeciesRepository;
    private VeiculosRepository    VeiculosRepository;
    private com.example.starwars.NavesRepository NavesRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_bastidores );

        apiInterface         = ApiClient.getClient().create(ApiInterface.class);
        buttonPersonagem     = findViewById(R.id.buttonPersonagens);
        buttonPlanetas  = findViewById(R.id.buttonPlanetas);
        buttonFilmes    = findViewById(R.id.buttonFilmes);
        buttonEspecies  = findViewById(R.id.buttonEspecies);
        buttonVeiculos  = findViewById(R.id.buttonVeiculos);
        buttonNaves     = findViewById(R.id.buttonNaves);
        //progressBar     = findViewById( R.id.progressBarCircle);

       /* buttonPersonagem.setVisibility(View.INVISIBLE);
        buttonPlanetas.setVisibility(View.INVISIBLE);
        buttonFilmes.setVisibility(View.INVISIBLE);
        buttonEspecies.setVisibility(View.INVISIBLE);
        buttonVeiculos.setVisibility(View.INVISIBLE);
        buttonNaves.setVisibility(View.INVISIBLE);*/

    }

    @Override
    protected void onStart() {
        super.onStart();



        buttonPersonagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetPersonAsyncTask task = new GetPersonAsyncTask();
                task.execute();
            }
        });

    }

    class GetPersonAsyncTask extends AsyncTask<String, Integer, List<Personagem>> {

        @Override
        protected void onPreExecute() {
            //
        }

        @Override
        protected void onPostExecute(List<Personagem> result) {
            super.onPostExecute(result);

            Intent intent = new Intent(
                    getApplicationContext(),
                    ViewModels.class
            );

            intent.putExtra("type", "characters");
            intent.putExtra("characters", (Serializable) result );

            startActivity(intent);

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(List<Personagem> s) {
            super.onCancelled(s);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected List<Personagem> doInBackground(String... strings) {
            Call<PersonagemResponse> call = apiInterface.getPersonagens();
            Response<PersonagemResponse> response = null;
            try {
                response = call.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            PersonagemResponse res = response.body();

            System.out.println(res.getResults());
            return res.getResults();
        }
    }
}
