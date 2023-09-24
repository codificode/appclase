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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;

public class Negativos extends AppCompatActivity {

    private ArrayList<ObjetoNegativo> listaNegativos = new ArrayList<>();
    private ArrayList<ObjetoViewNegativo> listaViewNegativos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.negativos);

        // Relleno la lista de datos listaNegativos
        listaNegativos = inicializarListaNegativos();

        // Obtén una referencia al contenedor donde colocarás las filas
        LinearLayout contenedorFilas = findViewById(R.id.linearLayoutFilasNegativos);

        // Itera sobre la lista de negativos y crea una vista para cada negativo
        for (ObjetoNegativo negativo : listaNegativos) {
            View filaView = crearFilaView(negativo);
            contenedorFilas.addView(filaView);
        }
    }

    private ArrayList<ObjetoNegativo> inicializarListaNegativos() {
        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, miAplicacion.getBaseDatosActual(), null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String[] selectionArgs = {miAplicacion.getGrupoActual()};

        Cursor cursor = BaseDeDatos.query("alumnos", new String[]{"id", "numero", "nombre"}, "grupo = ?", selectionArgs, null, null, "numero");

        if (cursor != null) {
            int numColumns = cursor.getColumnCount();
            while (cursor.moveToNext()) {
                ObjetoNegativo negativo = new ObjetoNegativo(cursor.getInt(0), cursor.getInt(1), cursor.getString(2));
                listaNegativos.add(negativo);
            }
            cursor.close();
            BaseDeDatos.close();

        } else {
            Toast.makeText(this, "No hay resultados", Toast.LENGTH_SHORT).show();
            cursor.close();
            BaseDeDatos.close();
        }
        return listaNegativos;
    }
    

    private View crearFilaView(ObjetoNegativo negativo) {
        View filaView = LayoutInflater.from(this).inflate(R.layout.filanegativos, null);

        TextView textViewNumero = filaView.findViewById(R.id.textViewNumeroNegativos);
        TextView textViewNombre = filaView.findViewById(R.id.textViewNombreNegativos);
        RadioGroup radioGroup = filaView.findViewById(R.id.radioGroupNegativos);
        RadioButton radioButton1 = filaView.findViewById(R.id.radioButton1Negativos);
        RadioButton radioButton2 = filaView.findViewById(R.id.radioButton2Negativos);
        RadioButton radioButton3 = filaView.findViewById(R.id.radioButton3Negativos);
        RadioButton radioButton4 = filaView.findViewById(R.id.radioButton4Negativos);
        RadioButton radioButton5 = filaView.findViewById(R.id.radioButton5Negativos);
        RadioButton radioButton6 = filaView.findViewById(R.id.radioButton6Negativos);
        EditText editTextComentario = filaView.findViewById(R.id.editTextComentarioNegativos);

        textViewNumero.setText(String.valueOf(negativo.getNumero()));
        textViewNombre.setText(negativo.getNombre());
        editTextComentario.setText(negativo.getComentario());

        ObjetoViewNegativo objetoViewNegativo = new ObjetoViewNegativo(textViewNumero, textViewNombre, radioGroup, radioButton1,
                radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, editTextComentario);
        listaViewNegativos.add(objetoViewNegativo);

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
                for (int fila = 0; fila < listaNegativos.size(); fila++) {
                    String causa;
                    if (listaViewNegativos.get(fila).radioGroup.getCheckedRadioButtonId() == listaViewNegativos.get(fila).getRadioButton1().getId()){
                        causa = "para/lava/cambia antes de tiempo";
                    } else if (listaViewNegativos.get(fila).radioGroup.getCheckedRadioButtonId() == listaViewNegativos.get(fila).getRadioButton2().getId()){
                        causa = "no epis";
                    } else if (listaViewNegativos.get(fila).radioGroup.getCheckedRadioButtonId() == listaViewNegativos.get(fila).getRadioButton3().getId()){
                        causa = "no recoge";
                    } else if (listaViewNegativos.get(fila).radioGroup.getCheckedRadioButtonId() == listaViewNegativos.get(fila).getRadioButton4().getId()){
                        causa = "juega/molesta";
                    } else if (listaViewNegativos.get(fila).radioGroup.getCheckedRadioButtonId() == listaViewNegativos.get(fila).getRadioButton5().getId()){
                        causa = "no trabaja";
                    } else if (listaViewNegativos.get(fila).radioGroup.getCheckedRadioButtonId() == listaViewNegativos.get(fila).getRadioButton6().getId()){
                        causa = "otros";
                    } else {
                        causa = "";
                    }

                    String id = String.valueOf(listaNegativos.get(fila).getIdAlumno());
                    String numero = String.valueOf(listaNegativos.get(fila).getNumero());
                    String nombre = String.valueOf(listaNegativos.get(fila).getNombre());
                    String comentario = String.valueOf(listaViewNegativos.get(fila).getEditTextComentario().getText());
                    String fechayhora = LocalDate.now().toString();

                    if (!causa.equals("")) {
                        ContentValues registro = new ContentValues();

                        registro.put("numero", numero);
                        registro.put("grupo", grupo);
                        registro.put("idAlumno", id);
                        registro.put("nombreAlumno", nombre);
                        registro.put("causa", causa);
                        registro.put("comentario", comentario);
                        registro.put("fechayhora", fechayhora);

                        // Utiliza insert para realizar la inserción
                        BaseDeDatos.insert("negativos", null, registro);

                        Toast.makeText(this, "Registro exitoso" + String.valueOf(numero) + grupo + String.valueOf(id) + nombre + comentario + fechayhora, Toast.LENGTH_SHORT).show();
                    } else {
                        causa = "";
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