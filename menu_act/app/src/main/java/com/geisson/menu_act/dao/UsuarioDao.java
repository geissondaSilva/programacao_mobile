package com.geisson.menu_act.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.geisson.menu_act.models.Usuario;

public class UsuarioDao extends DBManager {

    private static final String TABLE_NAME = "usuario";
    private static final String COL_ID = "_id";
    private static final String COL_NOME = "nome";
    private static final String COL_EMAIL = "email";
    private static final String COL_SENHA = "senha";

    private SQLiteDatabase db;

    public UsuarioDao(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, factory);
    }

    public static String getSqlCreateTable(){
        StringBuilder sql = new StringBuilder();
        sql.append("create table " + TABLE_NAME + "(");
        sql.append(COL_ID + " integer primary key, ");
        sql.append(COL_NOME + " text, ");
        sql.append(COL_EMAIL + " text, ");
        sql.append(COL_SENHA + " text)");
        return sql.toString();
    }

    public void salvar(Usuario usuario){
        db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NOME, usuario.getNome());
        values.put(COL_EMAIL, usuario.getEmail());
        values.put(COL_SENHA, usuario.getSenha());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Cursor listar(){
        db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null,
                null, null, null, null);

        return cursor;
    }


}
