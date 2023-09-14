package com.example.appclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OpcionesGrupo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opcionesgrupo);
    }


    public void consultas(View view){
        Intent i = new Intent(this, Consultas.class);
        startActivity(i);
    }

    public void comentarios(View view){
        Intent i = new Intent(this, Comentarios.class);
        startActivity(i);
    }

    public void volver(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}