package com.example.sorteiocartola.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sorteiocartola.Adapter.TimeAdapter;
import com.example.sorteiocartola.Controller.SorteioController;
import com.example.sorteiocartola.DataSource.DataSource;
import com.example.sorteiocartola.Model.TimeModel;
import com.example.sorteiocartola.R;

import java.util.ArrayList;
import java.util.List;

public class Chave extends AppCompatActivity {
    SorteioController sorteioController;
    ArrayList<TimeModel> lista1;
    DataSource ds;
    List<TimeModel> timesSorteados;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chave);

        ds = new DataSource((getBaseContext()));
        sorteioController = new SorteioController(getBaseContext());
        timesSorteados = sorteioController.getAllTimesModel("times_sorteados");
        configurarRecycler(timesSorteados);
    }

    private void configurarRecycler(List<TimeModel> times) {
        // Configurando o gerenciador de layout para ser uma lista.
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Adiciona o adapter que irá anexar os objetos à lista.
        TimeAdapter adapter = new TimeAdapter(times);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}