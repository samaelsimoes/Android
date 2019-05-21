package com.example.starwars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PlanetaActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ApiInterface        apiInterface;
    ListView listView;
    List<Planeta> planetasRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_models);

        apiInterface = ApiStarWars.getClient().create(ApiInterface.class);
        listView     = findViewById(R.id.listViewModel);

        Bundle data = getIntent().getExtras();
        String type = data.getString("type");

        planetasRepository = (List<Planeta>) data.getSerializable("planetas");

        if (type.equals("planetas")) {
            planetasRepository = (List<Planeta>) data.getSerializable("planetas");
            List<String> planets = new ArrayList<>();
            for (Planeta planet: planetasRepository) {
                planets.add( planet.getName() );
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    planets
            );

            listView.setAdapter(adapter);//new ArrayAdapter<String>(this,R.layout.drawer_list_item, mServices)
            listView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Planeta planeta = planetasRepository.get(position);

                    Intent planetaIntent = new Intent(
                            getApplicationContext(),
                            PlanetasDetails.class
                    );
                    planetaIntent.putExtra("planeta", planeta);
                    startActivity(planetaIntent);
                }
            } );
        }
    }
}
