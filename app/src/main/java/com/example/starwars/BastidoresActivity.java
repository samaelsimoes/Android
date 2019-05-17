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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BastidoresActivity extends AppCompatActivity {

    ListView    listViewPersonagens;
    ProgressBar progressBar;
    Button      buttonPersonagem;

    ApiInterface        apiInterface;
    PersonagemRepository personagemRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_bastidores );

        apiInterface         = ApiClient.getClient().create(ApiInterface.class);
        buttonPersonagem     = findViewById(R.id.buttonPersonagens);
        personagemRepository = new PersonagemRepository();
        progressBar          = findViewById(R.id.progressBar);

        buttonPersonagem.setVisibility(View.INVISIBLE);

    }

    @Override
    protected void onStart() {
        super.onStart();

        GetPersonAsyncTask task = new GetPersonAsyncTask();
        task.execute();

        buttonPersonagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("StarCharacters", personagemRepository.getCharacters().toString());
                Intent intent = new Intent(
                        getApplicationContext(),
                        ViewModels.class
                );

                intent.putExtra("type", "characters");
                intent.putExtra("characters", personagemRepository );

                startActivity(intent);
            }
        });

    }

    class GetPersonAsyncTask extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            //
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(String s) {
            super.onCancelled(s);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected String doInBackground(String... strings) {
            getCharacters(listViewPersonagens);
            return null;
        }
    }

    public void getCharacters(View view){
        Call<PersonagemResponse> call = apiInterface.getCharacters();
        call.enqueue(new Callback<PersonagemResponse>() {
            @Override
            public void onResponse(Call<PersonagemResponse> call, Response<PersonagemResponse> response) {
                personagemRepository.setCharacters(response.body().getResults());
            }

            @Override
            public void onFailure(Call<PersonagemResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),
                        "Ocorreu uma falha ao buscar os personagens",
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }
}
