package com.example.sorteiocartola.DataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sorteiocartola.DataModel.TimesDataModel;
import com.example.sorteiocartola.Model.TimeModel;
import java.util.ArrayList;

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
        }catch (Exception e){

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public boolean insert(String tabela, String nome){
        String querySalvarTime;
        querySalvarTime = "INSERT INTO times_sorteados VALUES";
        querySalvarTime += "(NULL,'"+nome+"',0.0)";
        db.execSQL(querySalvarTime);
        return true;
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

    public ArrayList<TimeModel> getAllTimesModel(String tabela){
        TimeModel obj;
        ArrayList<TimeModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM "+ tabela;
        cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                obj = new TimeModel();
                obj.setId(cursor.getString(cursor.getColumnIndex(TimesDataModel.getId())));
                obj.setNome(cursor.getString(cursor.getColumnIndex(TimesDataModel.getNome())));
                obj.setPt((float) cursor.getDouble(cursor.getColumnIndex(TimesDataModel.getPt())));
                lista.add(obj);

            }while(cursor.moveToNext());
        }
        cursor.close();
        return lista;
    }

    public boolean tabelaVazia(String tabela){
        String sql = "SELECT * FROM "+ tabela;
        cursor = db.rawQuery(sql, null);
        boolean vazia;

        if(cursor.moveToFirst()){
            vazia=false;
        }else
            vazia=true;
        return vazia;
    }

    public void insertTimes(String[] str){
        String queryInserirTimes;
        int tamanhoString = str.length;
        queryInserirTimes = "INSERT INTO times VALUES";

        for(int i=0; i<tamanhoString;i++){
            queryInserirTimes += "(NULL, '"+str[i]+"', 0.0)";
            if(i<tamanhoString-1){
                queryInserirTimes += ", ";
            }
        }
        db.execSQL(queryInserirTimes);
    }
}
