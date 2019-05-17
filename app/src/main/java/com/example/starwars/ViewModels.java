package com.example.starwars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewModels extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    ApiInterface        apiInterface;
    ListView listView;
    PersonagemRepository personagemRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_models);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        listView     = findViewById(R.id.listViewModel);

        Bundle data = getIntent().getExtras();
        String type = data.getString("type");

        Log.e(TAG, type);

        if(type.equals("characters")){
            personagemRepository = (PersonagemRepository) data.getSerializable("characters");

            ArrayAdapter<Character> adapter = new ArrayAdapter<>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    personagemRepository.getCharacters()
            );

            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Character character = personagemRepository.getCharacter(position);

                    Intent characterIntent = new Intent(
                            getApplicationContext(),
                            CharacterDetails.class
                    );

                    characterIntent.putExtra("character", character);
                    startActivity(characterIntent);
                }
            });
        }
    }
}
