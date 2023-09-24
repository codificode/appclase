package com.example.appclase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.DialogInterface;
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

public class Faltas extends AppCompatActivity {
    
    private ArrayList<ObjetoFalta> listaFaltas = new ArrayList<>();

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.faltas);

        // Relleno la lista de datos listaPositivos
        listaFaltas = inicializarListaFaltas();

        // Obtén una referencia al contenedor donde colocarás las filas
        LinearLayout contenedorFilas = findViewById(R.id.linearLayoutFilasFaltas);

        // Itera sobre la lista de positivos y crea una vista para cada positivo
        for (ObjetoFalta falta : listaFaltas) {
            View filaView = crearFilaView(falta);
            contenedorFilas.addView(filaView);
        }
        
    }


    private ArrayList<ObjetoFalta> inicializarListaFaltas(){
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
        
        return listaFaltas;
    }

    private View crearFilaView(ObjetoFalta falta) {
        // Infla la vista de la fila desde el XML
        View filaView = LayoutInflater.from(this).inflate(R.layout.filafaltas, null);

        // Accede a las vistas dentro de la fila y configura sus valores
        TextView textViewNumero = filaView.findViewById(R.id.textViewNumeroFaltas);
        TextView textViewNombre = filaView.findViewById(R.id.textViewNombreFaltas);
        CheckBox checkBoxPrimera = filaView.findViewById(R.id.checkBoxPrimeraFaltas);
        CheckBox checkBoxSegunda = filaView.findViewById(R.id.checkBoxSegundaFaltas);
        CheckBox checkBoxTercera = filaView.findViewById(R.id.checkBoxTerceraFaltas);
        CheckBox checkBoxRetr1 = filaView.findViewById(R.id.checkBoxRetr1Faltas);
        CheckBox checkBoxRetr2 = filaView.findViewById(R.id.checkBoxRetr2Faltas);
        CheckBox checkBoxRetr3 = filaView.findViewById(R.id.checkBoxRetr3Faltas);

        textViewNumero.setText(String.valueOf(falta.getNumero()));
        textViewNombre.setText(falta.getNombre());
        checkBoxPrimera.setChecked(falta.getPrimera());
        checkBoxPrimera.setChecked(falta.getSegunda());
        checkBoxPrimera.setChecked(falta.getTercera());
        checkBoxPrimera.setChecked(falta.getRetr1());
        checkBoxPrimera.setChecked(falta.getRetr2());
        checkBoxPrimera.setChecked(falta.getRetr3());


        // Agrega listeners para manejar cambios en CheckBox y EditText
        checkBoxPrimera.setOnCheckedChangeListener((buttonView, isChecked) -> falta.setPrimera(isChecked));
        checkBoxSegunda.setOnCheckedChangeListener((buttonView, isChecked) -> falta.setSegunda(isChecked));
        checkBoxTercera.setOnCheckedChangeListener((buttonView, isChecked) -> falta.setTercera(isChecked));
        checkBoxRetr1.setOnCheckedChangeListener((buttonView, isChecked) -> falta.setRetr1(isChecked));
        checkBoxRetr2.setOnCheckedChangeListener((buttonView, isChecked) -> falta.setRetr2(isChecked));
        checkBoxRetr3.setOnCheckedChangeListener((buttonView, isChecked) -> falta.setRetr3(isChecked));

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
                for (int fila = 0; fila < listaFaltas.size(); fila++) {
                    String id = String.valueOf(listaFaltas.get(fila).getIdAlumno());
                    String numero = String.valueOf(listaFaltas.get(fila).getNumero());
                    String nombre = String.valueOf(listaFaltas.get(fila).getNombre());
                    String fecha = miAplicacion.getFechaActual();
                    Boolean primera = listaFaltas.get(fila).getPrimera();
                    Boolean segunda = listaFaltas.get(fila).getSegunda();
                    Boolean tercera = listaFaltas.get(fila).getTercera();
                    Boolean retr1 = listaFaltas.get(fila).getRetr1();
                    Boolean retr2 = listaFaltas.get(fila).getRetr2();
                    Boolean retr3 = listaFaltas.get(fila).getRetr3();

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
                    if (retr1==true) {
                        ContentValues registro = new ContentValues();

                        registro.put("numero", numero);
                        registro.put("grupo", grupo);
                        registro.put("idAlumno", id);
                        registro.put("nombreAlumno", nombre);
                        registro.put("fecha", fecha);
                        registro.put("hora", "Retraso1");

                        // Utiliza insert para realizar la inserción
                        BaseDeDatos.insert("faltas", null, registro);
                    } else {
                        numero = numero;
                    }
                    if (retr2==true) {
                        ContentValues registro = new ContentValues();

                        registro.put("numero", numero);
                        registro.put("grupo", grupo);
                        registro.put("idAlumno", id);
                        registro.put("nombreAlumno", nombre);
                        registro.put("fecha", fecha);
                        registro.put("hora", "Retraso2");

                        // Utiliza insert para realizar la inserción
                        BaseDeDatos.insert("faltas", null, registro);
                    } else {
                        numero = numero;
                    }
                    if (retr3==true) {
                        ContentValues registro = new ContentValues();

                        registro.put("numero", numero);
                        registro.put("grupo", grupo);
                        registro.put("idAlumno", id);
                        registro.put("nombreAlumno", nombre);
                        registro.put("fecha", fecha);
                        registro.put("hora", "Retraso3");

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

    private void quitar() {
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
                    Boolean retr1 = listaFaltas.get(fila).getRetr1();
                    Boolean retr2 = listaFaltas.get(fila).getRetr2();
                    Boolean retr3 = listaFaltas.get(fila).getRetr3();

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

                    if (retr1==true) {
                        ContentValues registro = new ContentValues();

                        String hora = "Retraso1";
                        String[] whereArgs = { fecha, hora, id };

                        // Utiliza insert para realizar la inserción
                        BaseDeDatos.delete("faltas", "fecha = ? AND hora = ? AND idAlumno = ?", whereArgs);
                    } else {
                        numero = numero;
                    }
                    if (retr2==true) {
                        ContentValues registro = new ContentValues();

                        String hora = "Retraso2";
                        String[] whereArgs = { fecha, hora, id };

                        // Utiliza insert para realizar la inserción
                        BaseDeDatos.delete("faltas", "fecha = ? AND hora = ? AND idAlumno = ?", whereArgs);
                    } else {
                        numero = numero;
                    }
                    if (retr3==true) {
                        ContentValues registro = new ContentValues();

                        String hora = "Retraso3";
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


    public void quitarFaltasAviso(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Confirmación")
                .setMessage("¿Estás seguro de que quieres quitar las faltas?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Aquí es donde llamarías a tu método si el usuario confirma
                        quitar();
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


    public void volver (View view){
        Intent i = new Intent(this, OpcionesGrupo.class);
        startActivity(i);
    }
}