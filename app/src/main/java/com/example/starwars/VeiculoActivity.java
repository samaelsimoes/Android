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

public class VeiculoActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ApiInterface  apiInterface;
    ListView      listView;
    List<Veiculo> veiculoRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_models);

        apiInterface = ApiStarWars.getClient().create(ApiInterface.class);
        listView     = findViewById(R.id.listViewModel);

        Bundle data = getIntent().getExtras();
        String type = data.getString("type");

        veiculoRepository = (List<Veiculo>) data.getSerializable("veiculos");

        if (type.equals("veiculos")) {
            veiculoRepository = (List<Veiculo>) data.getSerializable("veiculos");
            List<String> veiculos = new ArrayList<>();
            for (Veiculo veiculo: veiculoRepository) {
                veiculos.add( veiculo.getName() );
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    veiculos
            );

            listView.setAdapter(adapter);//new ArrayAdapter<String>(this,R.layout.drawer_list_item, mServices)
            listView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Veiculo veiculo= veiculoRepository.get(position);

                    Intent veiculoIntent = new Intent(
                            getApplicationContext(),
                            VeiculoDetails.class
                    );
                    veiculoIntent.putExtra("veiculo", veiculo);
                    startActivity(veiculoIntent);
                }
            } );
        }
    }
}
