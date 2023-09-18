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

public class Examenes extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ObjetoExamen> listaExamenes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examenes);

        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, miAplicacion.getBaseDatosActual(), null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String[] selectionArgs = {miAplicacion.getGrupoActual()};

        Cursor cursor = BaseDeDatos.query("alumnos", new String[]{"id", "numero", "nombre"}, "grupo = ?", selectionArgs, null, null, "numero");

        if (cursor != null) {
            int numColumns = cursor.getColumnCount();
            while (cursor.moveToNext()) {
                ObjetoExamen examen = new ObjetoExamen(cursor.getInt(0), cursor.getInt(1), cursor.getString(2));
                listaExamenes.add(examen);
            }
            cursor.close();
            BaseDeDatos.close();

        } else {
            Toast.makeText(this, "No hay resultados", Toast.LENGTH_SHORT).show();
            cursor.close();
            BaseDeDatos.close();
        }
        // Obtén una referencia al RecyclerView desde el archivo XML de diseño
        recyclerView = findViewById(R.id.filaexamenes);

        // Configura un LinearLayoutManager (u otro tipo de LayoutManager según tus necesidades)
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Crea una instancia de tu adaptador personalizado y configúralo en el RecyclerView
        ExamenesAdapter adapter = new ExamenesAdapter(listaExamenes); // Suponiendo que tengas una lista de Examenes
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
                for (int fila = 0; fila < listaExamenes.size(); fila++) {
                    
                    if (!String.valueOf(listaExamenes.get(fila).getPar1()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaExamenes.get(fila).getPar1());
                        String sqlInsert = "update alumnos set notaparcial1 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaExamenes.get(fila).getPar2()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaExamenes.get(fila).getPar2());
                        String sqlInsert = "update alumnos set notaparcial2 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaExamenes.get(fila).getPar3()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaExamenes.get(fila).getPar3());
                        String sqlInsert = "update alumnos set notaparcial3 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaExamenes.get(fila).getPar4()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaExamenes.get(fila).getPar4());
                        String sqlInsert = "update alumnos set notaparcial4 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaExamenes.get(fila).getPar5()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaExamenes.get(fila).getPar5());
                        String sqlInsert = "update alumnos set notaparcial5 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaExamenes.get(fila).getPar6()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaExamenes.get(fila).getPar6());
                        String sqlInsert = "update alumnos set notaparcial6 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaExamenes.get(fila).getRec1()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaExamenes.get(fila).getRec1());
                        String sqlInsert = "update alumnos set notarecuperacion1parcial1 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaExamenes.get(fila).getRec2()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaExamenes.get(fila).getRec2());
                        String sqlInsert = "update alumnos set notarecuperacion1parcial2 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaExamenes.get(fila).getRec3()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaExamenes.get(fila).getRec3());
                        String sqlInsert = "update alumnos set notarecuperacion1parcial3 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaExamenes.get(fila).getRec4()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaExamenes.get(fila).getRec4());
                        String sqlInsert = "update alumnos set notarecuperacion1parcial4 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaExamenes.get(fila).getRec5()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaExamenes.get(fila).getRec5());
                        String sqlInsert = "update alumnos set notarecuperacion1parcial5 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaExamenes.get(fila).getRec6()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaExamenes.get(fila).getRec6());
                        String sqlInsert = "update alumnos set notarecuperacion1parcial6 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaExamenes.get(fila).getRec21()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaExamenes.get(fila).getRec21());
                        String sqlInsert = "update alumnos set notarecuperacion2parcial1 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }

                    if (!String.valueOf(listaExamenes.get(fila).getRec22()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaExamenes.get(fila).getRec22());
                        String sqlInsert = "update alumnos set notarecuperacion2parcial2 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }

                    if (!String.valueOf(listaExamenes.get(fila).getRec23()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaExamenes.get(fila).getRec23());
                        String sqlInsert = "update alumnos set notarecuperacion2parcial3 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }

                    if (!String.valueOf(listaExamenes.get(fila).getRec24()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaExamenes.get(fila).getRec24());
                        String sqlInsert = "update alumnos set notarecuperacion2parcial4 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }

                    if (!String.valueOf(listaExamenes.get(fila).getRec25()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaExamenes.get(fila).getRec25());
                        String sqlInsert = "update alumnos set notarecuperacion2parcial5 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }

                    if (!String.valueOf(listaExamenes.get(fila).getRec26()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaExamenes.get(fila).getRec26());
                        String sqlInsert = "update alumnos set notarecuperacion2parcial6 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }

                    if (!String.valueOf(listaExamenes.get(fila).getExfinal()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaExamenes.get(fila).getExfinal());
                        String sqlInsert = "update alumnos set notaglobal = ? where id = ?";
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
