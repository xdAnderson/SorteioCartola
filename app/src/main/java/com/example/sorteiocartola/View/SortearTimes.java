package com.example.sorteiocartola.View;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
    DataSource ds;
    SorteioController sorteioController;
    ArrayList<TimeModel> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sortear_times);
        btSortear = findViewById(R.id.bt_sortear);
        tvTime1 = findViewById(R.id.tv_time1);
        tvTime2 = findViewById(R.id.tv_time2);
        ds = new DataSource((getBaseContext()));
        sorteioController = new SorteioController(getBaseContext());
        lista = new ArrayList<TimeModel>();

        btSortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeModel time1;
                TimeModel time2;
                lista = sorteioController.getAllTimesModel();
                time1 = sorteioAleatorio(lista);
                sorteioController.salvar(TimesDataModel.getTabelaTimesSorteados(),time1);
                sorteioController.deletar(TimesDataModel.getTabelaTimes(),time1);

                lista = sorteioController.getAllTimesModel();
                time2 = sorteioAleatorio(lista);
                sorteioController.salvar(TimesDataModel.getTabelaTimesSorteados(),time2);
                sorteioController.deletar(TimesDataModel.getTabelaTimes(),time2);

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