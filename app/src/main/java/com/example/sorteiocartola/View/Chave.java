package com.example.sorteiocartola.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sorteiocartola.Adapter.TimeAdapter;
import com.example.sorteiocartola.Controller.SorteioController;
import com.example.sorteiocartola.DataSource.DataSource;
import com.example.sorteiocartola.Model.TimeModel;
import com.example.sorteiocartola.R;
import java.util.List;

public class Chave extends AppCompatActivity {
    SorteioController sorteioController;
    DataSource ds;
    List<TimeModel> timesSorteados;
    EditText etFim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chave);
        ds = new DataSource((getBaseContext()));
        sorteioController = new SorteioController(getBaseContext());
        timesSorteados = sorteioController.getAllTimesModel("times_sorteados");
        configurarRecycler(timesSorteados);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_itens, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.limpar){
            //Toast.makeText(this,"Limpando combinações...",Toast.LENGTH_SHORT).show();
            AlertDialog alertDialog;
            //Cria o gerador do AlertDialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            //define o titulo
            builder.setTitle("Descartar combinações?");
            //define a mensagem
            builder.setMessage("Você está prestes a remover todas as combinações realizadas, tem certeza disso?");
            //define um botão como positivo
            builder.setPositiveButton("Sim, descartar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(Chave.this, "Limpando combinações...", Toast.LENGTH_SHORT).show();
                    ds.redefinirTabelas();
                    String[] stringNome = getResources().getStringArray(R.array.nomes);
                    sorteioController.alimentarTabela(stringNome);
                    timesSorteados = sorteioController.getAllTimesModel("times_sorteados");
                    configurarRecycler(timesSorteados);
                }
            });
            //define um botão como negativo.
            builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                }
            });
            //cria o AlertDialog
            alertDialog = builder.create();
            //Exibe
            alertDialog.show();



        }
        return super.onOptionsItemSelected(item);
    }

    private void configurarRecycler(List<TimeModel> times) {
        // Configurando o gerenciador de layout para ser uma lista.
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Adiciona o adapter que irá anexar os objetos à lista.
        TimeAdapter adapter = new TimeAdapter(times, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        //etFim.setFocusable(true);
        getWindow().getDecorView().clearFocus();
        super.onBackPressed();

    }
}