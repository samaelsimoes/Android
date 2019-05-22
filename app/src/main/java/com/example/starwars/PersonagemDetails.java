package com.example.starwars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PersonagemDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_personagem_details );
        TextView name         = findViewById(R.id.textViewName);
        TextView height       = findViewById(R.id.textViewModel );
        TextView mass         = findViewById(R.id.textViewManufacturer );
        TextView hair_color   = findViewById(R.id.textViewCost_in_credits );
        TextView skin_color   = findViewById(R.id.textViewLength );
        TextView eye_color    = findViewById(R.id.textViewEyeColor);
        TextView birth_year   = findViewById(R.id.textViewBirthYear);
        TextView gender       = findViewById(R.id.textViewGender);
        Bundle data           = getIntent().getExtras();
        Personagem personagem = (Personagem) data.getSerializable("personagem");

        name.setText("Name: "+ personagem.getName());
        height.setText("Height: " + personagem.getHeight());
        mass.setText("Mass: " + personagem.getMass());
        hair_color.setText("Hair color: " + personagem.getHair_color());
        skin_color.setText("Skin color: "+ personagem.getSkin_color());
        eye_color.setText("Eye color: " + personagem.getEye_color());
        birth_year.setText("Birth year: " + personagem.getBirth_year());
        gender.setText("Gender: " + personagem.getGender());
    }
}
