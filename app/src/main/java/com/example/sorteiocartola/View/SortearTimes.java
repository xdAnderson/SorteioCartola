package com.example.sorteiocartola.View;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sorteiocartola.Controller.SorteioController;
import com.example.sorteiocartola.DataModel.TimesDataModel;
import com.example.sorteiocartola.DataSource.DataSource;
import com.example.sorteiocartola.Model.TimeModel;
import com.example.sorteiocartola.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortearTimes extends AppCompatActivity {
    Button btSortear;
    TextView tvTime1;
    TextView tvTime2;
    TextView tvNumSorteados;
    DataSource ds;
    SorteioController sorteioController;
    ArrayList<TimeModel> lista1, lista2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sortear_times);
        btSortear = findViewById(R.id.bt_sortear);
        tvTime1 = findViewById(R.id.tv_time1);
        tvTime2 = findViewById(R.id.tv_time2);
        tvNumSorteados = findViewById(R.id.tv_num_sorteados);

        ds = new DataSource((getBaseContext()));
        sorteioController = new SorteioController(getBaseContext());
        lista1 = sorteioController.getAllTimesModel("times");
        lista2 = sorteioController.getAllTimesModel("times_sorteados");
        int restaSortear = lista1.size()+lista2.size();
        tvNumSorteados.setText(lista2.size()+"/"+restaSortear);

        btSortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lista1 = new ArrayList<TimeModel>();
                TimeModel time1;
                TimeModel time2;
                lista1 = sorteioController.getAllTimesModel("times");
                if(lista1.size()<2){
                    Toast.makeText(getApplicationContext(),"Todos os times foram sorteados, veja as Chaves.",Toast.LENGTH_LONG).show();
                }else {
                    time1 = sorteioAleatorio(lista1);
                    sorteioController.salvar(TimesDataModel.getTabelaTimesSorteados(), time1.getNome());
                    sorteioController.deletar(TimesDataModel.getTabelaTimes(), time1);

                    lista1 = sorteioController.getAllTimesModel("times");
                    time2 = sorteioAleatorio(lista1);
                    sorteioController.salvar(TimesDataModel.getTabelaTimesSorteados(), time2.getNome());
                    sorteioController.deletar(TimesDataModel.getTabelaTimes(), time2);

                    tvTime1.setText(time1.getNome());
                    tvTime2.setText(time2.getNome());

                    lista1 = sorteioController.getAllTimesModel("times");
                    lista2 = sorteioController.getAllTimesModel("times_sorteados");
                    int restaSortear = lista1.size() + lista2.size();
                    tvNumSorteados.setText(lista2.size() + "/" + restaSortear);
                }
            }
        });
    }

    public TimeModel sorteioAleatorio(ArrayList<TimeModel> list){
        Random aleatorio = new Random();
        int id = aleatorio.nextInt(list.size());
        TimeModel time = new TimeModel();
        time = list.get(id);

        return time;
    }
}