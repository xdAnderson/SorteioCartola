package com.example.sorteiocartola.Controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.example.sorteiocartola.DataModel.TimesDataModel;
import com.example.sorteiocartola.DataSource.DataSource;
import com.example.sorteiocartola.Model.TimeModel;

import java.util.List;

import static java.sql.Types.NULL;

public class SorteioController extends DataSource {
    ContentValues dados;
    public SorteioController(@Nullable Context context) {
        super(context);
    }

    public boolean salvar (String tabela, String nome){
        boolean sucesso;

        sucesso = insert(tabela, nome);

        return sucesso;
    }

    public void alimentarTabela(String [] str){
        insertTimes(str);
    }


    public boolean deletar(String tabela, TimeModel obj){
        boolean sucesso = true;
        sucesso = deletar(tabela, obj.getId());

        return sucesso;
    }

    public boolean alterar (TimeModel obj){
        boolean sucesso;
        dados = new ContentValues();
        dados.put(TimesDataModel.getId(), obj.getId());
        dados.put(TimesDataModel.getNome(), obj.getNome());
        dados.put(TimesDataModel.getPt(), obj.getPt());
        sucesso = alterar(TimesDataModel.getTabelaTimesSorteados(), dados);

        return sucesso;
    }

    public List<TimeModel> listar(String tabela){
        return getAllTimesModel(tabela);
    }
    public boolean tabelaEstaVazia(String tabela){
        return tabelaVazia(tabela);
    }
}
