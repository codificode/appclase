package com.example.appclase;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerGruposInicioPrograma;
    ArrayList<String> grupos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerGruposInicioPrograma = findViewById(R.id.spinnerGruposInicioPrograma);
        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        miAplicacion.setArrayListGrupos();
        grupos = miAplicacion.getArrayListGrupos();

        //Crear un adapter para el Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, grupos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGruposInicioPrograma.setAdapter(adapter);
        /*
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.grupos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        */

        //Asignar el adapter al spinner
        Spinner spinner = findViewById(R.id.spinnerGruposInicioPrograma);
        spinner.setAdapter(adapter);

        if (grupos!=null) {
            for (String i: grupos) {
                spinnerGruposInicioPrograma.setAdapter(adapter);
            }
        }
    }

    public void agregarGrupo(View view){
        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        Intent i = new Intent(this, AgregarGrupo.class);
        startActivity(i);
    }

    public void agregarAlumno(View view){
        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        miAplicacion.setGrupoActual(spinnerGruposInicioPrograma.getSelectedItem().toString());
        Intent i = new Intent(this, AgregarAlumno.class);
        startActivity(i);
    }

    public void opcionesGrupo(View view){
        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        miAplicacion.setGrupoActual(spinnerGruposInicioPrograma.getSelectedItem().toString());
        Intent i = new Intent(this, OpcionesGrupo.class);
        startActivity(i);
    }
}