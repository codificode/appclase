package com.example.appclase;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AgregarGrupo extends AppCompatActivity {

    private EditText editTextAgregarGrupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregargrupo);
        editTextAgregarGrupo = findViewById(R.id.editTextAgregarGrupo);
    }

    public void agregarGrupo(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion2", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String grupo = editTextAgregarGrupo.getText().toString();

        if(!grupo.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("grupo", grupo);

            BaseDeDatos.insert("grupos", null, registro);

            BaseDeDatos.close();
            editTextAgregarGrupo.setText("");

            Toast.makeText(this,"Registro exitoso", Toast.LENGTH_SHORT).show();

        } else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void volver(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    }