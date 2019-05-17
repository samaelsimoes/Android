package com.example.starwars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BastidoresActivity extends AppCompatActivity {

    Button btnPersonagens;
    Button btnPlaneta;
    Button btnFilmes;
    Button btnEspecies;
    Button btnVeiculos;
    Button btnNaves;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_bastidores );

        btnPersonagens = (Button)findViewById(R.id.buttonPersonagens);
        btnPersonagens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( BastidoresActivity.this, PersonagemActivity.class));
            }
        });
    }
}
