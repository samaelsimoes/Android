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

    ListView    listViewTodos;
    ProgressBar progressBar;
    Button buttonCharacters;

    ApiInterface        apiInterface;
    CharacterRepository characterRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_bastidores );

        apiInterface        = ApiClient.getClient().create(ApiInterface.class);
        buttonCharacters    = findViewById(R.id.buttonPersonagens);
        characterRepository = new CharacterRepository();
        progressBar         = findViewById(R.id.progressBar);

        buttonCharacters.setVisibility(View.INVISIBLE);

    }

    @Override
    protected void onStart() {
        super.onStart();

        GetPersonagemAsyncTask task = new GetPersonagemAsyncTask();
        task.execute();

        buttonCharacters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("StarCharacters", characterRepository.getCharacters().toString());
                Intent intent = new Intent(
                        getApplicationContext(),
                        ViewModels.class
                );

                intent.putExtra("type", "characters");
                intent.putExtra("characters", characterRepository);

                startActivity(intent);
            }
        });

    }

    class GetPersonagemAsyncTask extends AsyncTask<String, Integer, String> {

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
            getCharacters(listViewTodos);
            return null;
        }
    }

    public void getCharacters(View view){
        Call<CharacterResponse> call = apiInterface.getCharacters();
        call.enqueue(new Callback<CharacterResponse>() {
            @Override
            public void onResponse(Call<CharacterResponse> call, Response<CharacterResponse> response) {
                characterRepository.setCharacters(response.body().getResults());
            }

            @Override
            public void onFailure(Call<CharacterResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),
                        "Ocorreu uma falha ao buscar os personagens",
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }
}
