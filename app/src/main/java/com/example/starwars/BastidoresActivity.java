package com.example.starwars;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import retrofit2.Call;
import retrofit2.Response;

public class BastidoresActivity extends AppCompatActivity {

    private ListView listViewPersonagens;
    private ListView listViewPlanetas;
    private Button buttonPersonagem;
    private Button buttonPlanetas;
    private Button buttonFilmes;
    private Button buttonEspecies;
    private Button buttonVeiculos;
    private Button buttonNaves;

    private ApiInterface apiInterface;
    private PlanetasRepository planetasRepository;
    private FilmesRepository filmesRepository;
    private EspeciesRepository especiesRepository;
    private VeiculosRepository veiculosRepository;
    private com.example.starwars.NavesRepository navesRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_bastidores );

        apiInterface        = ApiStarWars.getClient().create( ApiInterface.class );

        buttonPersonagem = findViewById( R.id.buttonPersonagens );
        buttonPlanetas   = findViewById( R.id.buttonPlanetas );
        buttonFilmes     = findViewById( R.id.buttonFilmes );
        buttonEspecies   = findViewById( R.id.buttonEspecies );
        buttonVeiculos   = findViewById( R.id.buttonVeiculos );
        buttonNaves      = findViewById( R.id.buttonNaves );
    }

    @Override
    protected void onStart() {
        super.onStart();

        buttonPersonagem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetPersonAsyncTask task = new GetPersonAsyncTask();
                task.execute();
            }
        } );

        buttonPlanetas.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetPlanetasAsyncTask taskPlanetas = new GetPlanetasAsyncTask();
                taskPlanetas.execute();
            }
        } );
    }

    class GetPlanetasAsyncTask extends AsyncTask<String, Integer, List<Planeta>> {
        @Override
        protected void onPreExecute() {
            //
        }

        @Override
        protected void onPostExecute(List<Planeta> result) {
            super.onPostExecute(result);

            Intent intent = new Intent(
                    getApplicationContext(),
                    PlanetaActivity.class
            );

            intent.putExtra("type", "planetas");
            intent.putExtra("planetas", (Serializable) result );

            startActivity(intent);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected List<Planeta> doInBackground(String... strings) {
            Call<PlanetasResponse> call         = apiInterface.getPlanetas();
            Response<PlanetasResponse> response = null;

            try {
                response = call.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            PlanetasResponse res = response.body();

            return res.getResults();
        }
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
                    PersonagemActivity.class
            );

            intent.putExtra("type", "personagens");
            intent.putExtra("personagens", (Serializable) result );

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
            Call<PersonagemResponse> call         = apiInterface.getPersonagens();
            Response<PersonagemResponse> response = null;
            try {
                response = call.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            PersonagemResponse res = response.body();

            return res.getResults();
        }
    }
}
