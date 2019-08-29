package com.geisson.calculadora_notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final Double prcProva = 0.7D;
    public final Double prcTrabalho = 0.3D;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnCalcular);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtProva1 = findViewById(R.id.txtProvaN1);
                EditText txtTrabalho1 = findViewById(R.id.txtTrabalho1);
                EditText txtProva2 = findViewById(R.id.txtProva2);
                EditText txtTrabalho2 = findViewById(R.id.txtTrabalho2);

                Double prova1 = Double.parseDouble(txtProva1.getText().toString());
                Double prova2 = Double.parseDouble(txtProva2.getText().toString());
                Double trabalho1 = Double.parseDouble(txtTrabalho1.getText().toString());
                Double trabalho2 = Double.parseDouble(txtTrabalho2.getText().toString());

                Double media = (prova1 * prcProva) + (trabalho1 * prcTrabalho);
                media += (prova2 * prcProva) + (trabalho2 * prcTrabalho);
                media /= 2;

                String res = "";

                if(media < 4){
                    res = "Reprovou vacilão " + media;
                }else if(media < 7){
                    res = "Ta em exame otário " + media;
                }else {
                    res = "Passou bicho " + media;
                }

                abrirRes(res);
            }
        });
    }

    public void abrirRes(String res){
        Intent intent = new Intent(this, resultado.class);
        intent.putExtra("res", res);
        startActivityForResult(intent, 0);
    }
}
