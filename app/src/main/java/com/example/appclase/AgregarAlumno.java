package com.example.appclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class AgregarAlumno extends AppCompatActivity {

    private Spinner spinnerGruposAgregarAlumno;
    String grupoActual;
    ArrayList<String> grupos;
    EditText editTextAgregarAlumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregaralumno);
        editTextAgregarAlumno = findViewById(R.id.editTextAgregarAlumno);
        spinnerGruposAgregarAlumno = findViewById(R.id.spinnerGruposAgregarAlumno);
        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        miAplicacion.setArrayListGrupos();
        grupos = miAplicacion.getArrayListGrupos();
        grupoActual = miAplicacion.getGrupoActual();

        //Crear un adapter para el Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, grupos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGruposAgregarAlumno.setAdapter(adapter);

        //Asignar el adapter al spinner
        Spinner spinner = findViewById(R.id.spinnerGruposAgregarAlumno);
        spinner.setAdapter(adapter);

        if (grupos!=null) {
            for (String i: grupos) {
                spinnerGruposAgregarAlumno.setAdapter(adapter);
            }
        }
    }

    public void agregar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion2", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String nombre = editTextAgregarAlumno.getText().toString();


        if(!nombre.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("grupo", grupoActual);
            registro.put("nombre", nombre);

            BaseDeDatos.insert("alumnos", null, registro);

            BaseDeDatos.close();
            editTextAgregarAlumno.setText("");

            Toast.makeText(this,"Registro exitoso", Toast.LENGTH_SHORT).show();

        } else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
    public void volver(View view){
        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}