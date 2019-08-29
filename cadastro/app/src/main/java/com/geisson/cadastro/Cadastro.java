package com.geisson.cadastro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.geisson.cadastro.models.Usuario;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Cadastro extends AppCompatActivity {

    private TextInputLayout editNome;
    private TextInputLayout editEmail;
    private TextInputLayout editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        this.editEmail = findViewById(R.id.txtEmail);
        this.editNome = findViewById(R.id.txtNome);
        this.editSenha = findViewById(R.id.txtSenha);

        Button btn = findViewById(R.id.btn_salvar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar(view);
            }
        });
    }

    public void salvar(View v){
        Usuario usuario = new Usuario();
        usuario.setNome(this.editNome.getEditText().getText().toString());
        usuario.setEmail(this.editEmail.getEditText().getText().toString());
        usuario.setSenha(this.editSenha.getEditText().getText().toString());

        Snackbar bar = Snackbar.make(v, "clicou em salvar", 3);
        bar.show();
    }
}
