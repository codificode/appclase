package com.example.appclase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;

public class Faltas extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ObjetoFalta> listaFaltas = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faltas);
        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, miAplicacion.getBaseDatosActual(), null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String[] selectionArgs = {miAplicacion.getGrupoActual()};

        Cursor cursor = BaseDeDatos.query("alumnos", new String[]{"id", "numero", "nombre"}, "grupo = ?", selectionArgs, null, null, "numero");

        if (cursor != null) {
            int numColumns = cursor.getColumnCount();
            while (cursor.moveToNext()) {
                ObjetoFalta Falta = new ObjetoFalta(cursor.getInt(0), cursor.getInt(1), cursor.getString(2));
                listaFaltas.add(Falta);
            }
            cursor.close();
            BaseDeDatos.close();

        } else {
            Toast.makeText(this, "No hay resultados", Toast.LENGTH_SHORT).show();
            cursor.close();
            BaseDeDatos.close();
        }

        String registro1="";
        for (ObjetoFalta objetoFalta: listaFaltas){
            registro1+=objetoFalta.toString()+", ";
        }

        Log.d("PRINCIPAL AL CARGAR PÁGINA", "PRINCIPAL AL CARGAR PÁGINA" + registro1);


        // Obtén una referencia al RecyclerView desde el archivo XML de diseño
        recyclerView = findViewById(R.id.filafaltas);

        // Configura un LinearLayoutManager (u otro tipo de LayoutManager según tus necesidades)
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Crea una instancia de tu adaptador personalizado y configúralo en el RecyclerView
        FaltasAdapter adapter = new FaltasAdapter(listaFaltas); // Suponiendo que tengas una lista de Faltas
        recyclerView.setAdapter(adapter);
    }

    public void enviar(View view) {
        try {
            String registro2="";
            for (ObjetoFalta objetoFalta: listaFaltas){
                registro2+=objetoFalta.toString()+", ";
            }

            MiAplicacion miAplicacion = (MiAplicacion) getApplication();
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, miAplicacion.getBaseDatosActual(), null, 1);
            SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
            String grupo = miAplicacion.getGrupoActual();

            BaseDeDatos.beginTransaction(); // Comienza una transacción

            try {
                for (int fila = 0; fila < listaFaltas.size(); fila++) {
                    String id = String.valueOf(listaFaltas.get(fila).getIdAlumno());
                    String numero = String.valueOf(listaFaltas.get(fila).getNumero());
                    String nombre = String.valueOf(listaFaltas.get(fila).getNombre());
                    String fecha = miAplicacion.getFechaActual();
                    Boolean primera = listaFaltas.get(fila).getPrimera();
                    Boolean segunda = listaFaltas.get(fila).getSegunda();
                    Boolean tercera = listaFaltas.get(fila).getTercera();

                    if (primera==true) {
                        ContentValues registro = new ContentValues();

                        registro.put("numero", numero);
                        registro.put("grupo", grupo);
                        registro.put("idAlumno", id);
                        registro.put("nombreAlumno", nombre);
                        registro.put("fecha", fecha);
                        registro.put("hora", "Primera");

                        // Utiliza insert para realizar la inserción
                        BaseDeDatos.insert("faltas", null, registro);
                    } else {
                        numero = numero;
                    }

                    if (segunda==true) {
                        ContentValues registro = new ContentValues();

                        registro.put("numero", numero);
                        registro.put("grupo", grupo);
                        registro.put("idAlumno", id);
                        registro.put("nombreAlumno", nombre);
                        registro.put("fecha", fecha);
                        registro.put("hora", "Segunda");

                        // Utiliza insert para realizar la inserción
                        BaseDeDatos.insert("faltas", null, registro);
                    } else {
                        numero = numero;
                    }

                    if (tercera==true) {
                        ContentValues registro = new ContentValues();

                        registro.put("numero", numero);
                        registro.put("grupo", grupo);
                        registro.put("idAlumno", id);
                        registro.put("nombreAlumno", nombre);
                        registro.put("fecha", fecha);
                        registro.put("hora", "Tercera");

                        // Utiliza insert para realizar la inserción
                        BaseDeDatos.insert("faltas", null, registro);
                    } else {
                        numero = numero;
                    }
                }

                // Confirma la transacción
                BaseDeDatos.setTransactionSuccessful();
            } finally {
                // Finaliza la transacción y cierra la base de datos
                BaseDeDatos.endTransaction();
                Toast.makeText(this, "Faltas puestas", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Esto mostrará la excepción en el Logcat
            Toast.makeText(this, "Error al insertar en la base de datos", Toast.LENGTH_SHORT).show();
        }
    }

    public void quitar(View view) {
        try {
            MiAplicacion miAplicacion = (MiAplicacion) getApplication();
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, miAplicacion.getBaseDatosActual(), null, 1);
            SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
            String grupo = miAplicacion.getGrupoActual();

            BaseDeDatos.beginTransaction(); // Comienza una transacción

            try {
                for (int fila = 0; fila < listaFaltas.size(); fila++) {
                    String id = String.valueOf(listaFaltas.get(fila).getIdAlumno());
                    String numero = String.valueOf(listaFaltas.get(fila).getNumero());
                    String nombre = String.valueOf(listaFaltas.get(fila).getNombre());
                    String fecha = miAplicacion.getFechaActual();
                    Boolean primera = listaFaltas.get(fila).getPrimera();
                    Boolean segunda = listaFaltas.get(fila).getSegunda();
                    Boolean tercera = listaFaltas.get(fila).getTercera();

                    if (primera==true) {
                        ContentValues registro = new ContentValues();

                        String hora = "Primera";
                        String[] whereArgs = { fecha, hora, id };

                        // Utiliza insert para realizar la inserción
                        BaseDeDatos.delete("faltas", "fecha = ? AND hora = ? AND idAlumno = ?", whereArgs);


                    } else {
                        numero = numero;
                    }

                    if (segunda==true) {
                        ContentValues registro = new ContentValues();

                        String hora = "Segunda";
                        String[] whereArgs = { fecha, hora, id };

                        // Utiliza insert para realizar la inserción
                        BaseDeDatos.delete("faltas", "fecha = ? AND hora = ? AND idAlumno = ?", whereArgs);


                    } else {
                        numero = numero;
                    }

                    if (tercera==true) {
                        ContentValues registro = new ContentValues();

                        String hora = "Tercera";
                        String[] whereArgs = { fecha, hora, id };

                        // Utiliza insert para realizar la inserción
                        BaseDeDatos.delete("faltas", "fecha = ? AND hora = ? AND idAlumno = ?", whereArgs);
                    } else {
                        numero = numero;
                    }
                }

                // Confirma la transacción
                BaseDeDatos.setTransactionSuccessful();
            } finally {
                // Finaliza la transacción y cierra la base de datos
                BaseDeDatos.endTransaction();
                Toast.makeText(this, "Faltas quitadas", Toast.LENGTH_SHORT).show();
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