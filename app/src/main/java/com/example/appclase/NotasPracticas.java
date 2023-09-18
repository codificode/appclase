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

public class NotasPracticas extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ObjetoNotasPracticas> listaNotasPracticas = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notaspracticas);
        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, miAplicacion.getBaseDatosActual(), null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String[] selectionArgs = {miAplicacion.getGrupoActual()};

        Cursor cursor = BaseDeDatos.query("alumnos", new String[]{"id", "numero", "nombre"}, "grupo = ?", selectionArgs, null, null, "numero");

        if (cursor != null) {
            int numColumns = cursor.getColumnCount();
            while (cursor.moveToNext()) {
                ObjetoNotasPracticas objetoNotasPracticas = new ObjetoNotasPracticas(cursor.getInt(0), cursor.getInt(1), cursor.getString(2));
                listaNotasPracticas.add(objetoNotasPracticas);
            }
            cursor.close();
            BaseDeDatos.close();

        } else {
            Toast.makeText(this, "No hay resultados", Toast.LENGTH_SHORT).show();
            cursor.close();
            BaseDeDatos.close();
        }
        // Obtén una referencia al RecyclerView desde el archivo XML de diseño
        recyclerView = findViewById(R.id.filanotaspracticas);

        // Configura un LinearLayoutManager (u otro tipo de LayoutManager según tus necesidades)
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Crea una instancia de tu adaptador personalizado y configúralo en el RecyclerView
        NotasPracticasAdapter adapter = new NotasPracticasAdapter(listaNotasPracticas); // Suponiendo que tengas una lista de NotasPracticas
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
                for (int fila = 0; fila < listaNotasPracticas.size(); fila++) {

                    if (!String.valueOf(listaNotasPracticas.get(fila).getPra1()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaNotasPracticas.get(fila).getPra1());
                        String sqlInsert = "update practicas set notapractica1 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaNotasPracticas.get(fila).getPra2()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaNotasPracticas.get(fila).getPra2());
                        String sqlInsert = "update practicas set notapractica2 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaNotasPracticas.get(fila).getPra3()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaNotasPracticas.get(fila).getPra3());
                        String sqlInsert = "update practicas set notapractica3 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaNotasPracticas.get(fila).getPra4()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaNotasPracticas.get(fila).getPra4());
                        String sqlInsert = "update practicas set notapractica4 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaNotasPracticas.get(fila).getPra5()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaNotasPracticas.get(fila).getPra5());
                        String sqlInsert = "update practicas set notapractica5 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaNotasPracticas.get(fila).getPra6()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaNotasPracticas.get(fila).getPra6());
                        String sqlInsert = "update practicas set notapractica6 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaNotasPracticas.get(fila).getPra7()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaNotasPracticas.get(fila).getPra7());
                        String sqlInsert = "update practicas set notapractica7 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaNotasPracticas.get(fila).getPra8()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaNotasPracticas.get(fila).getPra8());
                        String sqlInsert = "update practicas set notapractica8 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaNotasPracticas.get(fila).getPra9()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaNotasPracticas.get(fila).getPra9());
                        String sqlInsert = "update practicas set notapractica9 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaNotasPracticas.get(fila).getPra10()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaNotasPracticas.get(fila).getPra10());
                        String sqlInsert = "update practicas set notapractica10 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaNotasPracticas.get(fila).getPra11()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaNotasPracticas.get(fila).getPra11());
                        String sqlInsert = "update practicas set notapractica11 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaNotasPracticas.get(fila).getPra12()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaNotasPracticas.get(fila).getPra12());
                        String sqlInsert = "update practicas set notapractica12 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaNotasPracticas.get(fila).getPra13()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaNotasPracticas.get(fila).getPra13());
                        String sqlInsert = "update practicas set notapractica13 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }

                    if (!String.valueOf(listaNotasPracticas.get(fila).getPra14()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaNotasPracticas.get(fila).getPra14());
                        String sqlInsert = "update practicas set notapractica14 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                }

                // Confirma la transacción
                BaseDeDatos.setTransactionSuccessful();
                Toast.makeText(this, "Update exitoso", Toast.LENGTH_SHORT).show();
            } finally {
                // Finaliza la transacción y cierra la base de datos
                BaseDeDatos.endTransaction();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Esto mostrará la excepción en el Logcat
            Toast.makeText(this, "Error al insertar en la base de datos", Toast.LENGTH_SHORT).show();
        }
    }

    public void volver(View view) {
        Intent i = new Intent(this, OpcionesGrupo.class);
        startActivity(i);

    }
}