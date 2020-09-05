package com.example.sorteiocartola.DataModel;

import android.content.Context;

import com.example.sorteiocartola.R;
import com.example.sorteiocartola.View.SplashScreen;

public class TimesDataModel {

    private final static String TABELA_TIMES = "times";
    private final static String TABELA_TIMES_SORTEADOS = "times_sorteados";

    private final static String id = "id";
    private final static String nome = "nome";
    private final static String pt = "pt";

    private static String queryCriarTabela1 = "";
    private static String queryCriarTabela2 = "";

    public static String criarTabelaTimes(){
        queryCriarTabela1 = "CREATE TABLE "+ TABELA_TIMES;
        queryCriarTabela1 += " (";
        queryCriarTabela1 += id + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela1 += nome + " TEXT, ";
        queryCriarTabela1 += pt + " REAL";
        queryCriarTabela1 += ")";
        return queryCriarTabela1;
    }

    public static String criarTabelaTimesSorteados(){
        queryCriarTabela2 = "CREATE TABLE "+ TABELA_TIMES_SORTEADOS;
        queryCriarTabela2 += " (";
        queryCriarTabela2 += id + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela2 += nome + " TEXT, ";
        queryCriarTabela2 += pt + " REAL";
        queryCriarTabela2 += ")";
        return queryCriarTabela2;
    }

    public static String getTabelaTimes() {
        return TABELA_TIMES;
    }

    public static String getTabelaTimesSorteados() {
        return TABELA_TIMES_SORTEADOS;
    }

    public static String getId() {
        return id;
    }

    public static String getNome() {
        return nome;
    }

    public static String getPt() {
        return pt;
    }

    public static String getQueryCriarTabela1() {
        return queryCriarTabela1;
    }

    public static void setQueryCriarTabela1(String queryCriarTabela1) {
        TimesDataModel.queryCriarTabela1 = queryCriarTabela1;
    }

    public static String getQueryCriarTabela2() {
        return queryCriarTabela2;
    }

    public static void setQueryCriarTabela2(String queryCriarTabela2) {
        TimesDataModel.queryCriarTabela2 = queryCriarTabela2;
    }
}
