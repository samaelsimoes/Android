package com.example.starwars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar progress;
    ProgressBar progressColor;
    Timer       timer;
    View        view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.main);
        view.setBackgroundColor(getResources().getColor(android.R.color.black));

        progressBarCircle();
    }

    public void progressBarCircle() {

        progress = (ProgressBar)findViewById(R.id.progressBarCircle );

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timer.cancel();
                Intent intent = new Intent(MainActivity.this, Bastidores.class );
                startActivity( intent );
                finish();
            }
        },5000);
    }
}
