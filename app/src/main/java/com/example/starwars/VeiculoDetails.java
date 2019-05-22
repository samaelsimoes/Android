package com.example.starwars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class VeiculoDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_veiculo_detail );

        TextView name = findViewById(R.id.textViewName);
        TextView model          = findViewById(R.id.textViewModel);
        TextView manufacturer   = findViewById(R.id.textViewManufacturer);
        TextView credits        = findViewById(R.id.textViewCost_in_credits);
        TextView length         = findViewById(R.id.textViewLength);
        TextView atmosphering   = findViewById(R.id.textViewMax_atmosphering_speed);
        TextView crew           = findViewById(R.id.textViewCrew);
        TextView passagers      = findViewById(R.id.textViewPassengers);
        TextView cargo_capacity = findViewById(R.id.textViewCargo_capacity);
        TextView consumable     = findViewById(R.id.textViewConsumablesmonths);
        TextView vehicle        = findViewById(R.id.textViewVehicle_class);
        TextView pilots         = findViewById(R.id.textViewPilots);
        TextView films          = findViewById(R.id.textViewFilms);
        TextView edited         = findViewById(R.id.textViewEdited);
        TextView url            = findViewById(R.id.textViewUrl);
        TextView created        = findViewById( R.id.textViewCreated2 );

        Bundle data = getIntent().getExtras();
        Veiculo veiculo = (Veiculo) data.getSerializable("veiculo");

        name.setText("Nome:"+ veiculo.getVehicle_class());
        model.setText("Modelo:"+ veiculo.getModel());
        manufacturer.setText("Fabricante:"+ veiculo.getManufacturer());
        credits.setText("Custo:"+ veiculo.getCost_in_credits());
        length.setText("Comprimento:"+ veiculo.getLength());
        atmosphering.setText("Velocidade atmosferica:"+ veiculo.getMax_atmosphering_speed());
        crew.setText("Equipe tecnica:"+ veiculo.getCrew());
        passagers.setText("passageiros:"+ veiculo.getPassengers());
        cargo_capacity.setText("Capacidade de carga: "+ veiculo.getCargo_capacity());
        consumable.setText("Consuiveis:"+ veiculo.getConsumablesmonths());
        vehicle.setText("Classe veicular:"+ veiculo.getVehicle_class());
        pilots.setText("Piloto:"+ veiculo.getPilots());
        films.setText("Filmes:"+ veiculo.getFilms());
        created.setText("Criado:"+ veiculo.getCreated());
        edited.setText("Editado:"+ veiculo.getEdited());
        url.setText("Url"+ veiculo.getEdited());
    }
}
