package com.example.starwars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class PersonagemActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ApiInterface        apiInterface;
    ListView listView;
    List<Personagem> personagemRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_models);

        apiInterface = ApiStarWars.getClient().create(ApiInterface.class);
        listView     = findViewById(R.id.listViewModel);

        Bundle data = getIntent().getExtras();
        String type = data.getString("type");

        personagemRepository = (List<Personagem>) data.getSerializable("personagens");

        if(type.equals("personagens")){
            personagemRepository = (List<Personagem>) data.getSerializable("personagens");

            ArrayAdapter<Personagem> adapter = new ArrayAdapter<>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    personagemRepository
            );

            listView.setAdapter(adapter);//new ArrayAdapter<String>(this,R.layout.drawer_list_item, mServices)
            listView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Personagem personagem = personagemRepository.get(position);

                    Intent personagemIntent = new Intent(
                            getApplicationContext(),
                            PersonagemDetails.class
                    );
                    personagemIntent.putExtra("personagem", personagem);
                    startActivity(personagemIntent);
                }
            } );
        }
    }
}
