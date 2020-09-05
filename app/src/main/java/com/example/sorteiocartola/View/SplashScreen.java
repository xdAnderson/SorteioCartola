package com.example.sorteiocartola.View;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.sorteiocartola.Controller.SorteioController;
import com.example.sorteiocartola.DataSource.DataSource;
import com.example.sorteiocartola.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        DataSource ds = new DataSource((getBaseContext()));

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                SorteioController sorteioController= new SorteioController(getBaseContext());
                if(sorteioController.tabelaEstaVazia("times")&&sorteioController.tabelaEstaVazia("times_sorteados")){
                    String[] stringNome = getResources().getStringArray(R.array.nomes);
                    sorteioController.alimentarTabela(stringNome);
                }
                Intent i = new Intent(getApplication(), MenuInicial.class);
                startActivity(i);
                finish();
            }
        }, 1500);



    }

    @Override
    public void onBackPressed() {

    }

}