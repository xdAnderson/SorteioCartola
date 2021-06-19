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
    Button btCadastrarTimes;
    Button btLogo;
    Intent intent;
    int contador=0;
    int sair = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ;
        setContentView(R.layout.activity_menu_inicial);
        btSortearTim = findViewById(R.id.bt_sortear_time);
        btCombinacoes = findViewById(R.id.bt_combinacoes);
        btCadastrarTimes = findViewById(R.id.bt_cadastrar_times);

        btLogo = findViewById(R.id.bt_logo);
        btLogo.setStateListAnimator(null);

        btSortearTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), SortearTimes.class);
                startActivity(intent);
            }
        });

        btCombinacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Chave.class);
                startActivity(intent);
            }
        });

        btCadastrarTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), CadastroTimes.class);
                startActivity(intent);
            }
        });


        btLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contador==2){
                    Toast.makeText(MenuInicial.this, "Prestes a entrar na DEEP WEB...", Toast.LENGTH_SHORT).show();
                }else if(contador==4){
                    Toast.makeText(MenuInicial.this,"Desbloqueando imagens da DEEP WEB...", Toast.LENGTH_SHORT).show();
                }else if(contador==6){
                    Toast.makeText(MenuInicial.this,"POR SUA CONTA EM RISCO...", Toast.LENGTH_SHORT).show();
                } else if(contador==7){
                    btLogo.setBackgroundResource(R.drawable.junior);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            btLogo.setBackgroundResource(R.drawable.logo_cartola_belem);
                        }
                    }, 700);
                }else if(contador==9){
                    btLogo.setBackgroundResource(R.drawable.marcelo);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            btLogo.setBackgroundResource(R.drawable.logo_cartola_belem);
                        }
                    }, 700);
                }else if(contador==11){
                    btLogo.setBackgroundResource(R.drawable.madson);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            btLogo.setBackgroundResource(R.drawable.logo_cartola_belem);
                        }
                    }, 700);
                }else if(contador==13){
                    btLogo.setBackgroundResource(R.drawable.wiris);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            btLogo.setBackgroundResource(R.drawable.logo_cartola_belem);
                        }
                    }, 700);
                }else if(contador==15){
                    btLogo.setBackgroundResource(R.drawable.alex);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            btLogo.setBackgroundResource(R.drawable.logo_cartola_belem);
                        }
                    }, 700);
                }else if(contador==17){
                    btLogo.setBackgroundResource(R.drawable.nelma);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            btLogo.setBackgroundResource(R.drawable.logo_cartola_belem);
                        }
                    }, 700);
                }else if(contador>17){
                    btLogo.setBackgroundResource(R.drawable.cansada);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            btLogo.setBackgroundResource(R.drawable.logo_cartola_belem);
                        }
                    }, 700);
                }

                    contador++;
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