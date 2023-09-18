package com.example.appclase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;

public class Positivos extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ObjetoPositivo> listaPositivos = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.positivos);

        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, miAplicacion.getBaseDatosActual(), null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String[] selectionArgs = {miAplicacion.getGrupoActual()};

        Cursor cursor = BaseDeDatos.query("alumnos", new String[]{"id", "numero", "nombre"}, "grupo = ?", selectionArgs, null, null, "numero");

        if (cursor != null) {
            int numColumns = cursor.getColumnCount();
            while (cursor.moveToNext()) {
                ObjetoPositivo Positivo = new ObjetoPositivo(cursor.getInt(0), cursor.getInt(1), cursor.getString(2));
                listaPositivos.add(Positivo);
            }
            cursor.close();
            BaseDeDatos.close();

        } else {
            Toast.makeText(this, "No hay resultados", Toast.LENGTH_SHORT).show();
            cursor.close();
            BaseDeDatos.close();
        }

        // Obtén una referencia al RecyclerView desde el archivo XML de diseño
        recyclerView = findViewById(R.id.filaPositivos);

        // Configura un LinearLayoutManager (u otro tipo de LayoutManager según tus necesidades)
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Crea una instancia de tu adaptador personalizado y configúralo en el RecyclerView
        PositivosAdapter adapter = new PositivosAdapter(listaPositivos); // Suponiendo que tengas una lista de Positivos
        recyclerView.setAdapter(adapter);
    }


    public void enviar(View view) {
        try {
            MiAplicacion miAplicacion = (MiAplicacion) getApplication();
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, miAplicacion.getBaseDatosActual(), null, 1);
            SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
            String grupo = miAplicacion.getGrupoActual();

            BaseDeDatos.beginTransaction(); // Comienza una transacción

            try {
                for (int fila = 0; fila < listaPositivos.size(); fila++) {
                    String id = String.valueOf(listaPositivos.get(fila).getIdAlumno());
                    String numero = String.valueOf(listaPositivos.get(fila).getNumero());
                    String nombre = String.valueOf(listaPositivos.get(fila).getNombre());
                    Boolean bandera = listaPositivos.get(fila).getEstadoCheckBox();
                    String comentario = String.valueOf(listaPositivos.get(fila).getComentario());
                    String fechayhora = LocalDate.now().toString();

                    if (bandera==true) {
                        ContentValues registro = new ContentValues();

                        registro.put("numero", numero);
                        registro.put("grupo", grupo);
                        registro.put("idAlumno", id);
                        registro.put("nombreAlumno", nombre);
                        registro.put("comentario", comentario);
                        registro.put("fechayhora", fechayhora);

                        // Utiliza insert para realizar la inserción
                        BaseDeDatos.insert("positivos", null, registro);

                        Toast.makeText(this, "Registro exitoso" + String.valueOf(numero) + grupo + String.valueOf(id) + nombre + comentario + fechayhora, Toast.LENGTH_SHORT).show();
                    } else {
                        comentario = "";
                    }
                }

                // Confirma la transacción
                BaseDeDatos.setTransactionSuccessful();
            } finally {
                // Finaliza la transacción y cierra la base de datos
                BaseDeDatos.endTransaction();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Esto mostrará la excepción en el Logcat
            Toast.makeText(this, "Error al insertar en la base de datos", Toast.LENGTH_SHORT).show();
        }
    }

    public void volver (View view){
        Intent i = new Intent(this, OpcionesGrupo.class);
        startActivity(i);
    }

}