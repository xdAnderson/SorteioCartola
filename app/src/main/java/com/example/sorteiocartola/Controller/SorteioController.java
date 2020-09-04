package com.example.sorteiocartola.Controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.example.sorteiocartola.DataModel.TimesDataModel;
import com.example.sorteiocartola.DataSource.DataSource;
import com.example.sorteiocartola.Model.TimeModel;

import java.util.List;

public class SorteioController extends DataSource {
    ContentValues dados;
    public SorteioController(@Nullable Context context) {
        super(context);
    }

    public boolean salvar (String tabela, TimeModel obj){
        boolean sucesso;
        dados = new ContentValues();
        dados.put(TimesDataModel.getId(), obj.getId());
        dados.put(TimesDataModel.getNome(), obj.getNome());

        sucesso = insert(tabela, dados);

        return sucesso;
    }

    public boolean sortear(TimeModel obj){
        boolean sucesso = true;
        dados = new ContentValues();
        dados.put(TimesDataModel.getId(), obj.getId());



        return sucesso;
    }

    public boolean deletar(String tabela, TimeModel obj){
        boolean sucesso = true;
        sucesso = deletar(tabela, obj.getId());

        return sucesso;
    }

    public boolean alterar (TimeModel obj){
        boolean sucesso = true;
        dados = new ContentValues();
        dados.put(TimesDataModel.getId(), obj.getId());
        dados.put(TimesDataModel.getNome(), obj.getNome());

        sucesso = alterar(TimesDataModel.getTabelaTimesSorteados(), dados);

        return sucesso;
    }

    public List<TimeModel> listar(){
        return getAllTimesModel();
    }
}
