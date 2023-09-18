package com.example.appclase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ExamenPractico extends AppCompatActivity {

    Spinner spinner;

    ArrayList<ObjetoAlumnoExamenPractico> alumnos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examenpractico);
        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        String grupo = miAplicacion.getGrupoActual();

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, miAplicacion.getBaseDatosActual(), null, 1);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

        Cursor consulta = BaseDeDatos.rawQuery("select id, numero, nombre from alumnos where grupo = " + "'" + grupo + "'" + ";", null);

        // Verifica si el cursor tiene datos antes de intentar acceder a ellos
        if (consulta.moveToFirst()) {
            alumnos.clear();
            do {
                try {
                    int columnIndex = consulta.getColumnIndex("id");
                    int columnIndex2 = consulta.getColumnIndex("numero");
                    int columnIndex3 = consulta.getColumnIndex("nombre");

                    alumnos.add(new ObjetoAlumnoExamenPractico(consulta.getString(columnIndex), consulta.getString(columnIndex2), consulta.getString(columnIndex3)));
                } catch (IllegalArgumentException e) {
                    // La columna no existe en el cursor, maneja la excepción de manera apropiada
                }
            } while (consulta.moveToNext());
        } else {
            Toast.makeText(this, "No se encontraron alumnos en la base de datos", Toast.LENGTH_SHORT).show();
        }
        consulta.close();
        BaseDeDatos.close();


        spinner = findViewById(R.id.spinnerAlumnosExamenPractico);
        //Crear un adapter para el Spinner
        ArrayAdapter<ObjetoAlumnoExamenPractico> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, alumnos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        /*
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.grupos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        */

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Aquí obtienes el objeto alumno seleccionado
                ObjetoAlumnoExamenPractico alumnoSeleccionado = (ObjetoAlumnoExamenPractico) parent.getItemAtPosition(position);
                // Puedes hacer lo que necesites con el objeto alumnoSeleccionado

                miAplicacion.setAlumnoActualId(alumnoSeleccionado.getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Implementa esto si necesitas hacer algo cuando no se ha seleccionado nada
            }
        });

        if (alumnos!=null) {
            for (ObjetoAlumnoExamenPractico i: alumnos) {
                spinner.setAdapter(adapter);
            }
        }
    }

    public void examenPracticoPorAlumno(View view){
            MiAplicacion miAplicacion = (MiAplicacion) getApplication();
            Intent i = new Intent(this, ExamenPracticoPorAlumno.class);
            startActivity(i);
    }

    public void volver (View view){
        Intent i = new Intent(this, OpcionesGrupo.class);
        startActivity(i);
    }
}