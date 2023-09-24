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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;

public class NotasPracticas extends AppCompatActivity {
    
    ArrayList<ObjetoNotasPracticas> listaNotasPracticas = new ArrayList<>();
    ArrayList<ObjetoViewsNotasPracticas> listaViews = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notaspracticas);

        // Relleno la lista de datos listaNotasPracticas
        listaNotasPracticas = inicializarListaNotasPracticas();

        // Obtén una referencia al contenedor donde colocarás las filas
        LinearLayout contenedorFilas = findViewById(R.id.linearLayoutFilasNotasPracticas);

        // Itera sobre la lista de notasPracticas y crea una vista para cada notapractica
        for (ObjetoNotasPracticas objetoNotasPracticas : listaNotasPracticas) {
            View filaView = crearFilaView(objetoNotasPracticas);
            contenedorFilas.addView(filaView);
        }
    }

    private ArrayList<ObjetoNotasPracticas> inicializarListaNotasPracticas() {
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
        return listaNotasPracticas;
    }

    private View crearFilaView(ObjetoNotasPracticas objetoNotasPracticas) {
        // Infla la vista de la fila desde el XML
        View filaView = LayoutInflater.from(this).inflate(R.layout.filanotaspracticas, null);

        // Accede a las vistas dentro de la fila y configura sus valores
        TextView textViewNumero = filaView.findViewById(R.id.textViewNumeroNotasPracticas);
        TextView textViewNombre = filaView.findViewById(R.id.textViewNombreNotasPracticas);
        EditText editTextPra1NotasPracticas = filaView.findViewById(R.id.editTextPra1NotasPracticas);
        EditText editTextPra2NotasPracticas = filaView.findViewById(R.id.editTextPra2NotasPracticas);
        EditText editTextPra3NotasPracticas = filaView.findViewById(R.id.editTextPra3NotasPracticas);
        EditText editTextPra4NotasPracticas = filaView.findViewById(R.id.editTextPra4NotasPracticas);
        EditText editTextPra5NotasPracticas = filaView.findViewById(R.id.editTextPra5NotasPracticas);
        EditText editTextPra6NotasPracticas = filaView.findViewById(R.id.editTextPra6NotasPracticas);
        EditText editTextPra7NotasPracticas = filaView.findViewById(R.id.editTextPra7NotasPracticas);
        EditText editTextPra8NotasPracticas = filaView.findViewById(R.id.editTextPra8NotasPracticas);
        EditText editTextPra9NotasPracticas = filaView.findViewById(R.id.editTextPra9NotasPracticas);
        EditText editTextPra10NotasPracticas = filaView.findViewById(R.id.editTextPra10NotasPracticas);
        EditText editTextPra11NotasPracticas = filaView.findViewById(R.id.editTextPra11NotasPracticas);
        EditText editTextPra12NotasPracticas = filaView.findViewById(R.id.editTextPra12NotasPracticas);
        EditText editTextPra13NotasPracticas = filaView.findViewById(R.id.editTextPra13NotasPracticas);
        EditText editTextPra14NotasPracticas = filaView.findViewById(R.id.editTextPra14NotasPracticas);


        textViewNumero.setText(String.valueOf(objetoNotasPracticas.getNumero()));
        textViewNombre.setText(objetoNotasPracticas.getNombre());
        editTextPra1NotasPracticas.setText(objetoNotasPracticas.getPra1());
        editTextPra2NotasPracticas.setText(objetoNotasPracticas.getPra2());
        editTextPra3NotasPracticas.setText(objetoNotasPracticas.getPra3());
        editTextPra4NotasPracticas.setText(objetoNotasPracticas.getPra4());
        editTextPra5NotasPracticas.setText(objetoNotasPracticas.getPra5());
        editTextPra6NotasPracticas.setText(objetoNotasPracticas.getPra6());
        editTextPra7NotasPracticas.setText(objetoNotasPracticas.getPra7());
        editTextPra8NotasPracticas.setText(objetoNotasPracticas.getPra8());
        editTextPra9NotasPracticas.setText(objetoNotasPracticas.getPra9());
        editTextPra10NotasPracticas.setText(objetoNotasPracticas.getPra10());
        editTextPra11NotasPracticas.setText(objetoNotasPracticas.getPra11());
        editTextPra12NotasPracticas.setText(objetoNotasPracticas.getPra12());
        editTextPra13NotasPracticas.setText(objetoNotasPracticas.getPra13());
        editTextPra14NotasPracticas.setText(objetoNotasPracticas.getPra14());

        ObjetoViewsNotasPracticas objetoViewNotasPracticas = new ObjetoViewsNotasPracticas(textViewNumero, textViewNombre, editTextPra1NotasPracticas,
                editTextPra2NotasPracticas, editTextPra3NotasPracticas, editTextPra4NotasPracticas, editTextPra5NotasPracticas,
                editTextPra6NotasPracticas, editTextPra7NotasPracticas, editTextPra8NotasPracticas, editTextPra9NotasPracticas,
                editTextPra10NotasPracticas, editTextPra11NotasPracticas, editTextPra12NotasPracticas, editTextPra13NotasPracticas,
                editTextPra14NotasPracticas);

        listaViews.add(objetoViewNotasPracticas);

        return filaView;
    }

    public void enviar(View view) {
        for (int fila = 0; fila < listaNotasPracticas.size(); fila++){
            Log.d("REGISTROMIO", String.valueOf(listaNotasPracticas.get(fila).getPra1()));
        }
        try {
            MiAplicacion miAplicacion = (MiAplicacion) getApplication();
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, miAplicacion.getBaseDatosActual(), null, 1);
            SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

            BaseDeDatos.beginTransaction(); // Comienza una transacción


            try {
                for (int fila = 0; fila < listaNotasPracticas.size(); fila++) {

                    if (!String.valueOf(listaViews.get(fila).getEditTextPra1NotasPracticas()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViews.get(fila).getEditTextPra1NotasPracticas().getText());
                        String sqlInsert = "update practicas set notapractica1 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                        Log.d("eoiieie", "REGISTROMIO LA NOTA ES " + nota);
                        Log.d("eoiievvie", "REGISTROMIO EL ID ES " + id);
                    }
                    if (!String.valueOf(listaViews.get(fila).getEditTextPra2NotasPracticas()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViews.get(fila).getEditTextPra2NotasPracticas().getText());
                        String sqlInsert = "update practicas set notapractica2 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViews.get(fila).getEditTextPra3NotasPracticas()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViews.get(fila).getEditTextPra3NotasPracticas().getText());
                        String sqlInsert = "update practicas set notapractica3 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViews.get(fila).getEditTextPra4NotasPracticas()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViews.get(fila).getEditTextPra4NotasPracticas().getText());
                        String sqlInsert = "update practicas set notapractica4 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViews.get(fila).getEditTextPra5NotasPracticas()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViews.get(fila).getEditTextPra5NotasPracticas().getText());
                        String sqlInsert = "update practicas set notapractica5 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViews.get(fila).getEditTextPra6NotasPracticas()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViews.get(fila).getEditTextPra6NotasPracticas().getText());
                        String sqlInsert = "update practicas set notapractica6 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViews.get(fila).getEditTextPra7NotasPracticas()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViews.get(fila).getEditTextPra7NotasPracticas().getText());
                        String sqlInsert = "update practicas set notapractica7 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViews.get(fila).getEditTextPra8NotasPracticas()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViews.get(fila).getEditTextPra8NotasPracticas().getText());
                        String sqlInsert = "update practicas set notapractica8 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViews.get(fila).getEditTextPra9NotasPracticas()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViews.get(fila).getEditTextPra9NotasPracticas().getText());
                        String sqlInsert = "update practicas set notapractica9 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViews.get(fila).getEditTextPra10NotasPracticas()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViews.get(fila).getEditTextPra10NotasPracticas().getText());
                        String sqlInsert = "update practicas set notapractica10 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViews.get(fila).getEditTextPra11NotasPracticas()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViews.get(fila).getEditTextPra11NotasPracticas().getText());
                        String sqlInsert = "update practicas set notapractica11 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViews.get(fila).getEditTextPra12NotasPracticas()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViews.get(fila).getEditTextPra12NotasPracticas().getText());
                        String sqlInsert = "update practicas set notapractica12 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }
                    if (!String.valueOf(listaViews.get(fila).getEditTextPra13NotasPracticas()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViews.get(fila).getEditTextPra13NotasPracticas().getText());
                        String sqlInsert = "update practicas set notapractica13 = ? where id_alumno = ?";
                        Object[] bindArgs = { nota, id };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    }

                    if (!String.valueOf(listaViews.get(fila).getEditTextPra14NotasPracticas()).equals("".trim())){
                        String id = String.valueOf(listaNotasPracticas.get(fila).getIdAlumno());
                        String nota = String.valueOf(listaViews.get(fila).getEditTextPra14NotasPracticas().getText());
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