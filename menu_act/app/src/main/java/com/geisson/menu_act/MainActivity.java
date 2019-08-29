package com.geisson.menu_act;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.geisson.menu_act.adapter.UsuarioAdapter;
import com.geisson.menu_act.dao.UsuarioDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private UsuarioDao dao;
    private UsuarioAdapter adapter;
    private ListView listusuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastroUsuario.class);
                startActivity(intent);
            }
        });

        listusuarios = findViewById(R.id.listaUsuarios);
    }

    public void carregarUsuario(){
        try {
            dao = new UsuarioDao(this);
            Cursor cursor = dao.listar();
            adapter = new UsuarioAdapter(this, cursor);
            listusuarios = adapter.
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
