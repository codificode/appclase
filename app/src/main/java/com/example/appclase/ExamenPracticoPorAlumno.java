package com.example.appclase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;

public class ExamenPracticoPorAlumno extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ObjetoExamenPracticoPorAlumno> listaExamenPracticoPorAlumno = new ArrayList<>();

    MiAplicacion miAplicacion = (MiAplicacion) getApplication();
    TextView textViewNombreAlumnoExamenPracticoPorAlumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examenpracticoporalumno);
        MiAplicacion miAplicacion = (MiAplicacion) getApplication();

        for (int i = 1; i<=50; i++){
            listaExamenPracticoPorAlumno.add(new ObjetoExamenPracticoPorAlumno(String.valueOf(i)));
        }

        // Obtén una referencia al RecyclerView desde el archivo XML de diseño
        recyclerView = findViewById(R.id.filaexamenpracticoporalumno);

        // Configura un LinearLayoutManager (u otro tipo de LayoutManager según tus necesidades)
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Crea una instancia de tu adaptador personalizado y configúralo en el RecyclerView
        ExamenPracticoPorAlumnoAdapter adapter = new ExamenPracticoPorAlumnoAdapter(listaExamenPracticoPorAlumno); // Suponiendo que tengas una lista de ExamenPracticoPorAlumno
        recyclerView.setAdapter(adapter);

        textViewNombreAlumnoExamenPracticoPorAlumno = findViewById(R.id.textViewNombreAlumnoExamenPracticoPorAlumno);
        textViewNombreAlumnoExamenPracticoPorAlumno.setText(miAplicacion.getAlumnoActualNumero() + ", " + miAplicacion.getAlumnoActualNombre());


    }

    public void enviar(View view) {
        try {
            MiAplicacion miAplicacion = (MiAplicacion) getApplication();
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, miAplicacion.getBaseDatosActual(), null, 1);
            SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
            String grupo = miAplicacion.getGrupoActual();

            BaseDeDatos.beginTransaction(); // Comienza una transacción

            try {
                int fallos = 0;
                for (int i = 1; i <= 50; i++) {
                    String idalumno = miAplicacion.getAlumnoActualId();
                    String numero = miAplicacion.getAlumnoActualNumero();
                    String nombre = miAplicacion.getAlumnoActualNombre();
                    String acierta = String.valueOf(listaExamenPracticoPorAlumno.get(i-1).getAcierta());
                    if(acierta.equals("No")){
                        fallos+=1;
                    }

                    String fechayhora = LocalDate.now().toString();

                    if (!acierta.equals("")) {
                        // Utiliza insert para realizar la inserción
                        String sqlInsert = "update examen_practico set pregunta" + i + " = ? where id_alumno = ?";
                        Object[] bindArgs = { acierta, idalumno };
                        BaseDeDatos.execSQL(sqlInsert, bindArgs);
                    } else {
                        acierta = "";
                    }
                    String sqlInsert = "update examen_practico set total_fallos = ? where id_alumno = ?";
                    Object[] bindArgs = { fallos, idalumno };
                    BaseDeDatos.execSQL(sqlInsert, bindArgs);
                }

                // Confirma la transacción
                BaseDeDatos.setTransactionSuccessful();
                Toast.makeText(this, "Registro exitoso en examen_practico", Toast.LENGTH_SHORT).show();
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