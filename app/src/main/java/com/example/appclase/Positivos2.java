package com.example.appclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;

public class Positivos2 extends AppCompatActivity {

    private ArrayList<ObjetoPositivos2> listaPositivos = new ArrayList<>();
    private ArrayList<ObjetoViewPositivos2> listaViewPositivos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.positivos2);

        // Relleno la lista de datos listaPositivos
        listaPositivos = inicializarListaPositivos();

        // Obtén una referencia al contenedor donde colocarás las filas
        LinearLayout contenedorFilas = findViewById(R.id.linearLayoutFilasPositivos2);

        // Itera sobre la lista de positivos y crea una vista para cada positivo
        for (ObjetoPositivos2 positivo : listaPositivos) {
            View filaView = crearFilaView(positivo);
            contenedorFilas.addView(filaView);
        }
    }

    private ArrayList<ObjetoPositivos2> inicializarListaPositivos() {
        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, miAplicacion.getBaseDatosActual(), null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String[] selectionArgs = {miAplicacion.getGrupoActual()};

        Cursor cursor = BaseDeDatos.query("alumnos", new String[]{"id", "numero", "nombre"}, "grupo = ?", selectionArgs, null, null, "numero");

        if (cursor != null) {
            int numColumns = cursor.getColumnCount();
            while (cursor.moveToNext()) {
                ObjetoPositivos2 positivo = new ObjetoPositivos2(cursor.getInt(0), cursor.getInt(1), cursor.getString(2));
                listaPositivos.add(positivo);
            }
            cursor.close();
            BaseDeDatos.close();

        } else {
            Toast.makeText(this, "No hay resultados", Toast.LENGTH_SHORT).show();
            cursor.close();
            BaseDeDatos.close();
        }
        return listaPositivos;
    }

    private View crearFilaView(ObjetoPositivos2 positivo) {
        // Infla la vista de la fila desde el XML
        View filaView = LayoutInflater.from(this).inflate(R.layout.filapositivos2, null);

        // Accede a las vistas dentro de la fila y configura sus valores
        TextView textViewNumero = filaView.findViewById(R.id.textViewNumeroPositivos2);
        TextView textViewNombre = filaView.findViewById(R.id.textViewNombrePositivos2);
        CheckBox checkBox = filaView.findViewById(R.id.checkBoxPositivos2);
        EditText editTextComentario = filaView.findViewById(R.id.editTextComentarioPositivos2);

        textViewNumero.setText(String.valueOf(positivo.getNumero()));
        textViewNombre.setText(positivo.getNombre());
        checkBox.setChecked(positivo.getSeleccionado());
        editTextComentario.setText(positivo.getComentario());

        ObjetoViewPositivos2 objetoViewPositivos2 = new ObjetoViewPositivos2(textViewNumero, textViewNombre, checkBox, editTextComentario);
        listaViewPositivos.add(objetoViewPositivos2);

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
                for (int fila = 0; fila < listaPositivos.size(); fila++) {
                    String id = String.valueOf(listaPositivos.get(fila).getIdAlumno());
                    String numero = String.valueOf(listaPositivos.get(fila).getNumero());
                    String nombre = String.valueOf(listaPositivos.get(fila).getNombre());
                    Boolean bandera = listaViewPositivos.get(fila).getCheckBox().isChecked();
                    String comentario = String.valueOf(listaViewPositivos.get(fila).getEditTextComentario().getText());
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
