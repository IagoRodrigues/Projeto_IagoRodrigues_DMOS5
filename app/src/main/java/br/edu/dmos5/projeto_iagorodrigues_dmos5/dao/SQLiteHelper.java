package br.edu.dmos5.projeto_iagorodrigues_dmos5.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    //Constantes do banco de dados
    public static final String DATABASE_NAME = "meusEstados_db";
    public static final int DATABASE_VERSION = 1;

    //Constantes da tabela
    public static final String TABLE_NAME = "dados";
    public static final String COLUMN_NOME = "datas";
    public static final String COLUMN_UF = "casos";

    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (";
        sql += COLUMN_NOME + " TEXT NOT NULL, ";
        sql += COLUMN_UF + " TEXT NOT NULL ";
        sql += ")";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
