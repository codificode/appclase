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
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;

public class Examenes extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ObjetoExamen> listaExamenes = new ArrayList<>();
    ArrayList<ObjetoViewExamen> listaViewExamenes = new ArrayList<ObjetoViewExamen>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examenes);

        // Relleno la lista de datos listaExamenes
        listaExamenes = inicializarListaExamenes();

        // Obtén una referencia al contenedor donde colocarás las filas
        LinearLayout contenedorFilas = findViewById(R.id.linearLayoutFilasExamenes);

        // Itera sobre la lista de examenes y crea una vista para cada Examen
        for (ObjetoExamen objetoExamenes : listaExamenes) {
            View filaView = crearFilaView(objetoExamenes);
            contenedorFilas.addView(filaView);
        }
    }

    private ArrayList<ObjetoExamen> inicializarListaExamenes() {

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

        return listaExamenes;
    }

    private View crearFilaView(ObjetoExamen objetoExamen) {
        // Infla la vista de la fila desde el XML
        View filaView = LayoutInflater.from(this).inflate(R.layout.filaexamenes, null);

        // Accede a las vistas dentro de la fila y configura sus valores
        TextView textViewNumero = filaView.findViewById(R.id.textViewNumeroExamenes);
        TextView textViewNombre = filaView.findViewById(R.id.textViewNombreExamenes);
        EditText editTextPar1Examenes = filaView.findViewById(R.id.editTextPar1Examenes);
        EditText editTextPar2Examenes = filaView.findViewById(R.id.editTextPar2Examenes);
        EditText editTextPar3Examenes = filaView.findViewById(R.id.editTextPar3Examenes);
        EditText editTextPar4Examenes = filaView.findViewById(R.id.editTextPar4Examenes);
        EditText editTextPar5Examenes = filaView.findViewById(R.id.editTextPar5Examenes);
        EditText editTextPar6Examenes = filaView.findViewById(R.id.editTextPar6Examenes);
        EditText editTextRec1Examenes = filaView.findViewById(R.id.editTextRec1Examenes);
        EditText editTextRec2Examenes = filaView.findViewById(R.id.editTextRec2Examenes);
        EditText editTextRec3Examenes = filaView.findViewById(R.id.editTextRec3Examenes);
        EditText editTextRec4Examenes = filaView.findViewById(R.id.editTextRec4Examenes);
        EditText editTextRec5Examenes = filaView.findViewById(R.id.editTextRec5Examenes);
        EditText editTextRec6Examenes = filaView.findViewById(R.id.editTextRec6Examenes);
        EditText editTextRec21Examenes = filaView.findViewById(R.id.editTextRec21Examenes);
        EditText editTextRec22Examenes = filaView.findViewById(R.id.editTextRec22Examenes);
        EditText editTextRec23Examenes = filaView.findViewById(R.id.editTextRec23Examenes);
        EditText editTextRec24Examenes = filaView.findViewById(R.id.editTextRec24Examenes);
        EditText editTextRec25Examenes = filaView.findViewById(R.id.editTextRec25Examenes);
        EditText editTextRec26Examenes = filaView.findViewById(R.id.editTextRec26Examenes);
        EditText editTextFinalExamenes = filaView.findViewById(R.id.editTextFinalExamenes);


        textViewNumero.setText(String.valueOf(objetoExamen.getNumero()));
        textViewNombre.setText(objetoExamen.getNombre());
        editTextPar1Examenes.setText(objetoExamen.getPar1());
        editTextPar2Examenes.setText(objetoExamen.getPar2());
        editTextPar3Examenes.setText(objetoExamen.getPar3());
        editTextPar4Examenes.setText(objetoExamen.getPar4());
        editTextPar5Examenes.setText(objetoExamen.getPar5());
        editTextPar6Examenes.setText(objetoExamen.getPar6());
        editTextRec1Examenes.setText(objetoExamen.getRec1());
        editTextRec2Examenes.setText(objetoExamen.getRec2());
        editTextRec3Examenes.setText(objetoExamen.getRec3());
        editTextRec4Examenes.setText(objetoExamen.getRec4());
        editTextRec5Examenes.setText(objetoExamen.getRec5());
        editTextRec6Examenes.setText(objetoExamen.getRec6());
        editTextRec21Examenes.setText(objetoExamen.getRec21());
        editTextRec22Examenes.setText(objetoExamen.getRec22());
        editTextRec23Examenes.setText(objetoExamen.getRec23());
        editTextRec24Examenes.setText(objetoExamen.getRec24());
        editTextRec25Examenes.setText(objetoExamen.getRec25());
        editTextRec26Examenes.setText(objetoExamen.getRec26());
        editTextFinalExamenes.setText(objetoExamen.getExfinal());

        ObjetoViewExamen objetoViewExamen = new ObjetoViewExamen(textViewNumero, textViewNombre, editTextPar1Examenes,
                editTextPar2Examenes, editTextPar3Examenes, editTextPar4Examenes, editTextPar5Examenes,
                editTextPar6Examenes, editTextRec1Examenes, editTextRec2Examenes, editTextRec3Examenes,
                editTextRec4Examenes, editTextRec5Examenes, editTextRec6Examenes, editTextRec21Examenes,
                editTextRec22Examenes, editTextRec23Examenes, editTextRec24Examenes, editTextRec25Examenes,
                editTextRec26Examenes, editTextFinalExamenes);

        listaViewExamenes.add(objetoViewExamen);

        return filaView;
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
                    
                    if (!String.valueOf(listaViewExamenes.get(fila).getEditTextPar1Examen()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViewExamenes.get(fila).getEditTextPar1Examen().getText());
                        String sqlInsert = "update alumnos set notaparcial1 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViewExamenes.get(fila).getEditTextPar2Examen()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViewExamenes.get(fila).getEditTextPar2Examen().getText());
                        String sqlInsert = "update alumnos set notaparcial2 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViewExamenes.get(fila).getEditTextPar3Examen()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViewExamenes.get(fila).getEditTextPar3Examen().getText());
                        String sqlInsert = "update alumnos set notaparcial3 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViewExamenes.get(fila).getEditTextPar4Examen()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViewExamenes.get(fila).getEditTextPar4Examen().getText());
                        String sqlInsert = "update alumnos set notaparcial4 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViewExamenes.get(fila).getEditTextPar5Examen()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViewExamenes.get(fila).getEditTextPar5Examen().getText());
                        String sqlInsert = "update alumnos set notaparcial5 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViewExamenes.get(fila).getEditTextPar6Examen()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViewExamenes.get(fila).getEditTextPar6Examen().getText());
                        String sqlInsert = "update alumnos set notaparcial6 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViewExamenes.get(fila).getEditTextRec1Examen()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViewExamenes.get(fila).getEditTextRec1Examen().getText());
                        String sqlInsert = "update alumnos set notarecuperacion1parcial1 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViewExamenes.get(fila).getEditTextRec2Examen()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViewExamenes.get(fila).getEditTextRec2Examen().getText());
                        String sqlInsert = "update alumnos set notarecuperacion1parcial2 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViewExamenes.get(fila).getEditTextRec3Examen()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViewExamenes.get(fila).getEditTextRec3Examen().getText());
                        String sqlInsert = "update alumnos set notarecuperacion1parcial3 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViewExamenes.get(fila).getEditTextRec4Examen()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViewExamenes.get(fila).getEditTextRec4Examen().getText());
                        String sqlInsert = "update alumnos set notarecuperacion1parcial4 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViewExamenes.get(fila).getEditTextRec5Examen()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViewExamenes.get(fila).getEditTextRec5Examen().getText());
                        String sqlInsert = "update alumnos set notarecuperacion1parcial5 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViewExamenes.get(fila).getEditTextRec6Examen()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViewExamenes.get(fila).getEditTextRec6Examen().getText());
                        String sqlInsert = "update alumnos set notarecuperacion1parcial6 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViewExamenes.get(fila).getEditTextRec21Examen()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViewExamenes.get(fila).getEditTextRec21Examen().getText());
                        String sqlInsert = "update alumnos set notarecuperacion2parcial1 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }

                    if (!String.valueOf(listaViewExamenes.get(fila).getEditTextRec22Examen()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViewExamenes.get(fila).getEditTextRec22Examen().getText());
                        String sqlInsert = "update alumnos set notarecuperacion2parcial2 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }

                    if (!String.valueOf(listaViewExamenes.get(fila).getEditTextRec23Examen()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViewExamenes.get(fila).getEditTextRec23Examen().getText());
                        String sqlInsert = "update alumnos set notarecuperacion2parcial3 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }

                    if (!String.valueOf(listaViewExamenes.get(fila).getEditTextRec24Examen()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViewExamenes.get(fila).getEditTextRec24Examen().getText());
                        String sqlInsert = "update alumnos set notarecuperacion2parcial4 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }

                    if (!String.valueOf(listaViewExamenes.get(fila).getEditTextRec25Examen()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViewExamenes.get(fila).getEditTextRec25Examen().getText());
                        String sqlInsert = "update alumnos set notarecuperacion2parcial5 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }

                    if (!String.valueOf(listaViewExamenes.get(fila).getEditTextRec26Examen()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViewExamenes.get(fila).getEditTextRec26Examen().getText());
                        String sqlInsert = "update alumnos set notarecuperacion2parcial6 = ? where id = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }

                    if (!String.valueOf(listaViewExamenes.get(fila).getEditTextFinalExamen()).equals("".trim())){
                        String id = String.valueOf(listaExamenes.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViewExamenes.get(fila).getEditTextFinalExamen().getText());
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
