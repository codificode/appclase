package com.example.appclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PonerNumero extends AppCompatActivity {

    private Spinner spinnerGruposPonerNumero;
    private Spinner spinnerAlumnosPonerNumero;
    String grupo;
    ArrayList<String> grupos;
    ArrayList<String> listaAlumnos;
    Map<String, ObjetoAlumnoExamenPractico> mapa = new HashMap<>();


    EditText editTextPonerNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ponernumero);
        editTextPonerNumero = findViewById(R.id.editTextNumeroPonerNumero);
        spinnerGruposPonerNumero = findViewById(R.id.spinnerGruposPonerNumero);
        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        miAplicacion.setArrayListGrupos();
        grupos = miAplicacion.getArrayListGrupos();
        listaAlumnos = new ArrayList<>();

        //Crear un adapter para el Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, grupos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGruposPonerNumero.setAdapter(adapter);

        //Asignar el adapter al spinner
        Spinner spinner = findViewById(R.id.spinnerGruposPonerNumero);
        spinner.setAdapter(adapter);

        if (grupos!=null) {
            for (String i: grupos) {
                spinnerGruposPonerNumero.setAdapter(adapter);
            }
        }

        spinnerGruposPonerNumero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                grupo = grupos.get(position); // Obtener el grupo seleccionado
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Acción a realizar cuando no se selecciona nada en el Spinner
            }
        });
        grupo = grupos.get(0);
        miAplicacion.setGrupoActual(grupo);
        spinnerAlumnosPonerNumero = findViewById(R.id.spinnerAlumnosPonerNumero);
    }

    public void elegirGrupo(View view) {

        //CAMBIAR EL GRUPOACTUAL POR EL VALOR ELEGIDO EN EL SPINNER
        MiAplicacion miAplicacion = (MiAplicacion) getApplication();


        // Obtener el grupo seleccionado del Spinner
        String grupoSeleccionado = (String) spinnerGruposPonerNumero.getSelectedItem();

        // Verificar si se seleccionó un grupo válido
        if (grupoSeleccionado != null && !grupoSeleccionado.isEmpty()) {
            miAplicacion.setGrupoActual(grupoSeleccionado);
        } else {
            Toast.makeText(this, "Debes seleccionar un grupo", Toast.LENGTH_SHORT).show();
        }

        //Consulta a la base de datos para tener los alumnos del grupoActual
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, miAplicacion.getBaseDatosActual(), null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Cursor cursor = BaseDeDatos.query("alumnos", new String[]{"id", "numero", "nombre"}, null, null, null, null, "numero");

        listaAlumnos.clear();
        if (cursor != null) {
            int numColumns = cursor.getColumnCount();
            while (cursor.moveToNext()) {
                ObjetoAlumnoExamenPractico objetoAlumnoExamenPractico = new ObjetoAlumnoExamenPractico(cursor.getString(0), cursor.getString(1), cursor.getString(2));
                listaAlumnos.add(objetoAlumnoExamenPractico.toString());
                mapa.put(objetoAlumnoExamenPractico.toString(),objetoAlumnoExamenPractico);
            }
            cursor.close();
            BaseDeDatos.close();

        } else {
            Toast.makeText(this, "No hay resultados", Toast.LENGTH_SHORT).show();
            cursor.close();
            BaseDeDatos.close();
        }

        if (spinnerAlumnosPonerNumero != null) {
            //RELLENAR EL SPINNER DE ALUMNOS CON LOS OBJETOS DE listaAlumnos
            //Crear un adapter para el Spinner
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaAlumnos);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerAlumnosPonerNumero.setAdapter(adapter);

            //Asignar el adapter al spinner
            spinnerAlumnosPonerNumero.setAdapter(adapter);

        } else {
            Log.d("A", "El spinner es null");
        }
    }


    public void elegirAlumno(View view) {
        //CAMBIAR EL ALUMNOACTUAL POR EL VALOR ELEGIDO EN EL SPINNER
        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        ObjetoAlumnoExamenPractico alumnoSeleccionado = new ObjetoAlumnoExamenPractico("", "", "");

        // Obtener el grupo seleccionado del Spinner
        String stringAlumnoSeleccionado = (String) spinnerAlumnosPonerNumero.getSelectedItem().toString();
        alumnoSeleccionado = mapa.get(stringAlumnoSeleccionado);

        // Verificar si se seleccionó un grupo válido
        if (alumnoSeleccionado != null) {
            miAplicacion.setObjetoAlumnoActual(alumnoSeleccionado);
        } else {
            Toast.makeText(this, "alumnoSeleccionado es null otra vez cojones", Toast.LENGTH_SHORT).show();
        }
    }















    public void ponerNumero(View view){

        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        ObjetoAlumnoExamenPractico alumno = miAplicacion.getObjetoAlumnoActual();
        String id = alumno.getId();

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, miAplicacion.getBaseDatosActual(), null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String numero = editTextPonerNumero.getText().toString();

        if(!numero.isEmpty()){

            String sqlInsert = "update alumnos set numero = ? where id = ?";
            Object[] bindArgs = { numero, id };
            BaseDeDatos.execSQL(sqlInsert, bindArgs);

            BaseDeDatos.close();
            editTextPonerNumero.setText("");

            Toast.makeText(this,"Registro exitoso", Toast.LENGTH_SHORT).show();

        } else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void volver(View view){
        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
