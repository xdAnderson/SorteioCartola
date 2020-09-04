package com.example.sorteiocartola.DataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sorteiocartola.DataModel.TimesDataModel;
import com.example.sorteiocartola.Model.TimeModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DataSource extends SQLiteOpenHelper {
    Cursor cursor;
    private static final String DB_NAME = "sorteio_times.sqlite";
    private static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public DataSource(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{

            sqLiteDatabase.execSQL(TimesDataModel.criarTabelaTimes());
            sqLiteDatabase.execSQL(TimesDataModel.criarTabelaTimesSorteados());
            sqLiteDatabase.execSQL(TimesDataModel.inserirTimes());
        }catch (Exception e){

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public boolean insert(String tabela, ContentValues dados){
        boolean sucesso = true;
        try{
            sucesso = db.insert(tabela, null, dados)>0;
        }catch (Exception e){
            sucesso = false;

        }
        return sucesso;
    }

    public boolean deletar(String tabela, String id){
        boolean sucesso = true;
        sucesso = db.delete(tabela,"id=?", new String[]{id})>0;

        return sucesso;
    }

    public boolean alterar(String tabela, ContentValues dados){
        boolean sucesso=true;
        String id = dados.getAsString("id");

        sucesso = db.update(tabela, dados,"id=?", new String[]{id})>0;

        return sucesso;
    }

    public ArrayList<TimeModel> getAllTimesModel(){
        TimeModel obj;
        ArrayList<TimeModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM "+ TimesDataModel.getTabelaTimesSorteados();
        cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                obj = new TimeModel();
                obj.setId(cursor.getString(cursor.getColumnIndex(TimesDataModel.getId())));
                obj.setNome(cursor.getString(cursor.getColumnIndex(TimesDataModel.getNome())));

                lista.add(obj);

            }while(cursor.moveToNext());
        }
        cursor.close();
        return lista;
    }
}
