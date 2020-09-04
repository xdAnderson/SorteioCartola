package com.example.sorteiocartola.View;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

                /*TimeModel obj = new TimeModel();
                obj.setId("1234");
                obj.setNome("Teste");
                obj.setNome_cartola("Teste FC");
                obj.setSlug("teste_fc");
                obj.setSorteado(0);
                obj.setPonto_rodada1("5");

                obj.setPonto_rodada3("32.3");
                SorteioController sorteioController= new SorteioController(getBaseContext());
                //sorteioController.salvar(obj);
                sorteioController.alterar(obj);*/
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