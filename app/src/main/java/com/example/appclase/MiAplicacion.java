package com.example.appclase;

import android.app.Application;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class MiAplicacion extends Application {
    private String grupoActual;
    private String alumnoActual;
    private ObjetoAlumnoExamenPractico objetoAlumnoActual = new ObjetoAlumnoExamenPractico("cojones", "cojones","cojones");
    private String alumnoActualId;
    private String alumnoActualNombre;
    private String alumnoActualNumero;
    private String fechaActual;
        private String baseDatosActual = "curso.db";

    private ArrayList<String> grupos = new ArrayList<>();


public void setArrayListGrupos() {
    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, baseDatosActual, null, 1);
    SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

    Cursor consulta = BaseDeDatos.rawQuery("select grupo from grupos", null);

    grupos.clear();
    // Verifica si el cursor tiene datos antes de intentar acceder a ellos
    if (consulta.moveToFirst()) {
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
        this.actualizarAlumno();
    }

    public String getAlumnoActualNombre() {
        return alumnoActualNombre;
    }

    public void actualizarAlumno(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, baseDatosActual, null, 1);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

        Cursor consulta = BaseDeDatos.rawQuery("select numero, nombre from alumnos where id = " + this.alumnoActualId + ";", null);

        // Verifica si el cursor tiene datos antes de intentar acceder a ellos
        if (consulta.moveToFirst()) {
                try {
                    int columnIndex = consulta.getColumnIndex("numero");
                    int columnIndex2 = consulta.getColumnIndex("nombre");
                    this.alumnoActualNumero = consulta.getString(columnIndex);
                    this.alumnoActualNombre = consulta.getString(columnIndex2);
                } catch (IllegalArgumentException e) {
                    // La columna no existe en el cursor, maneja la excepción de manera apropiada
                }
        } else {
            Toast.makeText(this, "No se encontraron alumnos en la base de datos", Toast.LENGTH_SHORT).show();
        }
        consulta.close();
        BaseDeDatos.close();
    }

    public String getAlumnoActualNumero() {
        return alumnoActualNumero;
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

    public ObjetoAlumnoExamenPractico getObjetoAlumnoActual() {
        return objetoAlumnoActual;
    }

    public String getBaseDatosActual() {
        return baseDatosActual;
    }

    public void setObjetoAlumnoActual(ObjetoAlumnoExamenPractico objetoAlumnoActual) {
        this.objetoAlumnoActual = objetoAlumnoActual;


    }
}
