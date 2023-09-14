package com.example.appclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Consultas extends AppCompatActivity {

    TextView textViewConsultas;
    EditText editTextConsultas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultas);
        textViewConsultas = findViewById(R.id.textViewConsultas);
        editTextConsultas = findViewById(R.id.editTextConsultas);

    }

    public void consultar(View view) {

        try {
            MiAplicacion miAplicacion = (MiAplicacion) getApplication();
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion2", null, 1);
            SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

            String textoConsulta = editTextConsultas.getText().toString();

            Cursor cursor = BaseDeDatos.rawQuery(textoConsulta, null);

            // Verifica si el cursor tiene datos antes de intentar acceder a ellos

            if (cursor != null) {
                int numColumns = cursor.getColumnCount();
                StringBuilder resultText = new StringBuilder();
                for (int i = 0; i < numColumns; i++) {
                    String columnName = cursor.getColumnName(i);
                    resultText.append(columnName + ", ");
                }
                resultText.append("\n");
                while (cursor.moveToNext()) {
                    for (int i = 0; i < numColumns; i++) {
                        String columnValue = cursor.getString(i);

                        // Hacer algo con el nombre y valor de la columna, por ejemplo, agregarlos al resultado
                        resultText.append(columnValue).append(", ");
                    }
                    resultText.append("\n");
                }
                cursor.close();

                // Mostrar el resultado en un TextView
                textViewConsultas.setText(resultText.toString());
            } else {
                Toast.makeText(this, "No hay resultados", Toast.LENGTH_SHORT).show();
            }
        } catch (SQLiteException e) {
            String mensajeError = e.getMessage();
            // Ahora puedes mostrar el mensaje de error en un log o en un Toast
            Log.e("MiApp", "Error de SQLite: " + mensajeError);
            // O mostrarlo en un Toast si prefieres
            Toast.makeText(this, "Error de SQLite: " + mensajeError, Toast.LENGTH_SHORT).show();
        }
    }


    public void volver(View view){
        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        Intent i = new Intent(this, OpcionesGrupo.class);
        startActivity(i);
    }
}