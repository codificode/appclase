package com.example.appclase;

import android.app.Application;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class MiAplicacion extends Application {
    private String grupoActual;
    private String alumnoActual;
    private String alumnoActualId;
    private String alumnoActualNombre;
    private String fechaActual;

    private ArrayList<String> grupos = new ArrayList<>();


public void setArrayListGrupos() {
    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion2", null, 1);
    SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

    Cursor consulta = BaseDeDatos.rawQuery("select grupo from grupos", null);

    // Verifica si el cursor tiene datos antes de intentar acceder a ellos
    if (consulta.moveToFirst()) {
        grupos.clear();
        do {
            try {
                int columnIndex = consulta.getColumnIndex("grupo");
                grupos.add(consulta.getString(columnIndex));
            } catch (IllegalArgumentException e) {
                // La columna "grupo" no existe en el cursor, maneja la excepción de manera apropiada
            }
        } while (consulta.moveToNext());
    } else {
        Toast.makeText(this, "No se encontraron grupos en la base de datos", Toast.LENGTH_SHORT).show();
    }

    consulta.close();
    BaseDeDatos.close();
}
    public ArrayList<String> getArrayListGrupos() {
        return this.grupos;
    }

    public String getGrupoActual() {
        return grupoActual;
    }

    public void setGrupoActual(String grupoActual) {
        this.grupoActual = grupoActual;
    }

    public String getAlumnoActual() {
        return alumnoActual;
    }

    public void setAlumnoActual(String alumnoActual) {
        this.alumnoActual = alumnoActual;
    }

    public String getAlumnoActualId() {
        return alumnoActualId;
    }

    public void setAlumnoActualId(String alumnoActualId) {
        this.alumnoActualId = alumnoActualId;
    }

    public String getAlumnoActualNombre() {
        return alumnoActualNombre;
    }

    public void setAlumnoActualNombre(String alumnoActualNombre) {
        this.alumnoActualNombre = alumnoActualNombre;
    }

    public String getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(String fechaActual) {
        this.fechaActual = fechaActual;
    }

    public ArrayList<String> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<String> grupos) {
        this.grupos = grupos;
    }
}
