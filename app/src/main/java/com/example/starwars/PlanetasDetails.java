package com.example.starwars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PlanetasDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_planetas_details );

        TextView name       = findViewById(R.id.textViewNamePlanetas );
        TextView rotation   = findViewById( R.id.textViewRotation_period );
        TextView orbital    = findViewById( R.id.textViewOrbital_period );
        TextView climate    = findViewById( R.id.textViewClimate );
        TextView surface    = findViewById( R.id.textViewSurfaceWater );
        TextView population = findViewById( R.id.textViewPopulation );
        TextView created    = findViewById( R.id.textViewCreated );
        TextView edited     = findViewById( R.id.textViewEdited );
        TextView url        = findViewById( R.id.textViewUrl);

        Bundle data = getIntent().getExtras();
        Planeta planetas = (Planeta) data.getSerializable("planeta");

        name.setText("Name: "+ planetas.getName());
        rotation.setText("Rotation: " + planetas.getRotation_period());
        orbital.setText( "Orbital:" + planetas.getOrbital_period());
        climate.setText( "Climate:" + planetas.getClimate() );
        surface.setText( "Population:" + planetas.getSurface_water() );
        population.setText( "Population:" + planetas.getPopulation() );
        created.setText( "Created:" + planetas.getCreated() );
        edited.setText( "Edited:" + planetas.getEdited() );
        url.setText( "Url:" + planetas.getUrl() );

    }
}
