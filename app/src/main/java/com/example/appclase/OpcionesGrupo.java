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

    public void examenes(View view){
        Intent i = new Intent(this, Examenes.class);
        startActivity(i);
    }

    public void practicas(View view){
        Intent i = new Intent(this, NotasPracticas.class);
        startActivity(i);
    }

    public void examenPractico(View view){
        Intent i = new Intent(this, ExamenPractico.class);
        startActivity(i);
    }

    public void negativos(View view){
        Intent i = new Intent(this, Negativos.class);
        startActivity(i);
    }


    public void positivos(View view){
        Intent i = new Intent(this, Positivos2.class);
        startActivity(i);
    }

    public void consultas(View view){
        Intent i = new Intent(this, Consultas.class);
        startActivity(i);
    }

    public void faltas(View view){
        Intent i = new Intent(this, CalendarioFaltas.class);
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