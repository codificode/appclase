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

public class Comentarios extends AppCompatActivity {
    ArrayList<ObjetoComentario> listaComentarios = new ArrayList<>();
    ArrayList<ObjetoViewComentarios> listaViewComentarios = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comentarios);

        // Relleno la lista de datos listaComentarios
        listaComentarios = inicializarListaComentarios();

        // Obtén una referencia al contenedor donde colocarás las filas
        LinearLayout contenedorFilas = findViewById(R.id.linearLayoutFilasComentarios);

        // Itera sobre la lista de comentarios y crea una vista para cada comentario
        for (ObjetoComentario comentario : listaComentarios) {
            View filaView = crearFilaView(comentario);
            contenedorFilas.addView(filaView);
        }
    }

    private ArrayList<ObjetoComentario> inicializarListaComentarios() {
        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, miAplicacion.getBaseDatosActual(), null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String[] selectionArgs = {miAplicacion.getGrupoActual()};

        Cursor cursor = BaseDeDatos.query("alumnos", new String[]{"id", "numero", "nombre"}, "grupo = ?", selectionArgs, null, null, "numero");

        if (cursor != null) {
            int numColumns = cursor.getColumnCount();
            while (cursor.moveToNext()) {
                ObjetoComentario comentario = new ObjetoComentario(cursor.getInt(0), cursor.getInt(1), cursor.getString(2));
                listaComentarios.add(comentario);
            }
            cursor.close();
            BaseDeDatos.close();

        } else {
            Toast.makeText(this, "No hay resultados", Toast.LENGTH_SHORT).show();
            cursor.close();
            BaseDeDatos.close();
        }
        return listaComentarios;
    }

    private View crearFilaView(ObjetoComentario comentario) {
        // Infla la vista de la fila desde el XML
        View filaView = LayoutInflater.from(this).inflate(R.layout.filacomentarios, null);

        // Accede a las vistas dentro de la fila y configura sus valores
        TextView textViewNumero = filaView.findViewById(R.id.textViewNumeroComentarios);
        TextView textViewNombre = filaView.findViewById(R.id.textViewNombreComentarios);
        EditText editTextComentario = filaView.findViewById(R.id.editTextComentarioComentarios);

        textViewNumero.setText(String.valueOf(comentario.getNumero()));
        textViewNombre.setText(comentario.getNombre());
        editTextComentario.setText(comentario.getComentario());

        ObjetoViewComentarios objetoViewComentarios = new ObjetoViewComentarios(textViewNumero, textViewNombre, editTextComentario);
        listaViewComentarios.add(objetoViewComentarios);

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
                for (int fila = 0; fila < listaComentarios.size(); fila++) {
                    String id = String.valueOf(listaComentarios.get(fila).getIdAlumno());
                    String numero = String.valueOf(listaComentarios.get(fila).getNumero());
                    String nombre = String.valueOf(listaComentarios.get(fila).getNombre());
                    String comentario = String.valueOf(listaViewComentarios.get(fila).getEditTextComentario());
                    String fechayhora = LocalDate.now().toString();

                    if (!comentario.equals("")) {
                        ContentValues registro = new ContentValues();

                        registro.put("numero", numero);
                        registro.put("grupo", grupo);
                        registro.put("idAlumno", id);
                        registro.put("nombreAlumno", nombre);
                        registro.put("comentario", comentario);
                        registro.put("fechayhora", fechayhora);

                        // Utiliza insert para realizar la inserción
                        BaseDeDatos.insert("comentarios", null, registro);

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
