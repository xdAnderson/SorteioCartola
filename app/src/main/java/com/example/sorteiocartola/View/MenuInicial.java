package com.example.sorteiocartola.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sorteiocartola.R;

public class MenuInicial extends AppCompatActivity {
    Button btSortearTim;
    Button btCombinacoes;
    Intent intent;
    int sair = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);
        btSortearTim = findViewById(R.id.bt_sortear_time);
        btCombinacoes = findViewById(R.id.bt_combinacoes);

        btSortearTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Chave.class);
                startActivity(intent);
            }
        });

        btCombinacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), SortearTimes.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(sair == 1){
            finishAffinity();
        }else{
            Toast.makeText(getApplicationContext(),"Pressione novamente para sair...", Toast.LENGTH_LONG).show();
        }
        sair=1;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                sair=0;
            }
        }, 3000);
    }
}