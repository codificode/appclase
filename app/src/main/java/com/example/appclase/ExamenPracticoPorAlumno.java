package com.example.appclase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;

public class ExamenPracticoPorAlumno extends AppCompatActivity {
    ArrayList<ObjetoExamenPracticoPorAlumno> listaExamenPracticoPorAlumno = new ArrayList<>();
    ArrayList<ObjetoViewExamenPracticoPorAlumno> listaViewExamenPracticoPorAlumno = new ArrayList<>();

    MiAplicacion miAplicacion = (MiAplicacion) getApplication();
    TextView textViewNombreAlumnoExamenPracticoPorAlumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examenpracticoporalumno);

        // Relleno la lista de datos listaExamenPracticoPorAlumno
        listaExamenPracticoPorAlumno = inicializarListaExamenPracticoPorAlumno();

        // Obtén una referencia al contenedor donde colocarás las filas
        LinearLayout contenedorFilas = findViewById(R.id.linearLayoutFilasExamenPracticoPorAlumno);

        // Itera sobre la lista de examenPracticoPorAlumno y crea una vista para cada pregunta
        for (ObjetoExamenPracticoPorAlumno objetoExamenPracticoPorAlumno : listaExamenPracticoPorAlumno) {
            View filaView = crearFilaView(objetoExamenPracticoPorAlumno);
            contenedorFilas.addView(filaView);
        }

        MiAplicacion miAplicacion = (MiAplicacion) getApplication();
        textViewNombreAlumnoExamenPracticoPorAlumno = findViewById(R.id.textViewNombreAlumnoExamenPracticoPorAlumno);
        textViewNombreAlumnoExamenPracticoPorAlumno.setText(miAplicacion.getAlumnoActualNumero() + ", " + miAplicacion.getAlumnoActualNombre());
    }

    private ArrayList<ObjetoExamenPracticoPorAlumno> inicializarListaExamenPracticoPorAlumno() {
        for (int i=1; i<=50; i++) {
            String examenPracticoPorAlumno;
            if (i == 1) {
                examenPracticoPorAlumno = "1.Preparar color";
            } else if (i == 2) {
                examenPracticoPorAlumno = "2.Mascarillas";
            } else if (i == 3) {
                examenPracticoPorAlumno = "3.Desmontaje pistola";
            } else if (i == 4) {
                examenPracticoPorAlumno = "4. Lavadoras de pistolas";
            } else if (i == 5) {
                examenPracticoPorAlumno = "5. Regular abanico";
            } else if (i == 6) {
                examenPracticoPorAlumno = "6. Regular parámetros HVLP";
            } else if (i == 7) {
                examenPracticoPorAlumno = "7. Regular parámetros híbrida";
            } else if (i == 8) {
                examenPracticoPorAlumno = "8. Regular parámetros convencional";
            } else if (i == 9) {
                examenPracticoPorAlumno = "9. Viscosímetro";
            } else if (i == 10) {
                examenPracticoPorAlumno = "10. Unidad de mantenimiento";
            } else if (i == 11) {
                examenPracticoPorAlumno = "11. Cabina para pintar";
            } else if (i == 12) {
                examenPracticoPorAlumno = "12. Cabina para secar";
            } else if (i == 13) {
                examenPracticoPorAlumno = "13. Funcionamiento infrarrojos";
            } else if (i == 14) {
                examenPracticoPorAlumno = "14. Mantenimiento infrarrojos";
            } else if (i == 15) {
                examenPracticoPorAlumno = "15. Guía de lijado";
            } else if (i == 16) {
                examenPracticoPorAlumno = "16. Técnica difuminado";
            } else if (i == 17) {
                examenPracticoPorAlumno = "17. Burlete de huecos";
            } else if (i == 18) {
                examenPracticoPorAlumno = "18. Burlete de junquillos";
            } else if (i == 19) {
                examenPracticoPorAlumno = "19. Identificar elementos enmascarado";
            } else if (i == 20) {
                examenPracticoPorAlumno = "20. Lijar al agua";
            } else if (i == 21) {
                examenPracticoPorAlumno = "21. Pulido";
            } else if (i == 22) {
                examenPracticoPorAlumno = "22. Productos pintado plásticos";
            } else if (i == 23) {
                examenPracticoPorAlumno = "23. Preparar elastómero pintar";
            } else if (i == 24) {
                examenPracticoPorAlumno = "24. Separación de residuos";
            } else if (i == 25) {
                examenPracticoPorAlumno = "25. Sabe hacer solapamiento";
            } else if (i == 26) {
                examenPracticoPorAlumno = "26. Pistola de secado agua";
            } else if (i == 27) {
                examenPracticoPorAlumno = "27. Medir presión en cacha";
            } else if (i == 28) {
                examenPracticoPorAlumno = "28. Filtros cabina";
            } else if (i == 29) {
                examenPracticoPorAlumno = "29. Condiciones aplicación en documentación";
            } else if (i == 30) {
                examenPracticoPorAlumno = "30. Diluyente en documentación";
            } else if (i == 31) {
                examenPracticoPorAlumno = "31. Usar lavaojos";
            } else if (i == 32) {
                examenPracticoPorAlumno = "32. Identificar partes pistola";
            } else if (i == 33) {
                examenPracticoPorAlumno = "33. Seleccionar pico y aguja documentación";
            } else if (i == 34) {
                examenPracticoPorAlumno = "34. Preparar mezcla con ficha técnica";
            } else if (i == 35) {
                examenPracticoPorAlumno = "35. Limpiar pistolas a mano";
            } else if (i == 36) {
                examenPracticoPorAlumno = "36. Usar PPS";
            } else if (i == 37) {
                examenPracticoPorAlumno = "37. Comprobar abanico";
            } else if (i == 38) {
                examenPracticoPorAlumno = "38. Movimiento pistola";
            } else if (i == 39) {
                examenPracticoPorAlumno = "39. Panel mando cabina";
            } else if (i == 40) {
                examenPracticoPorAlumno = "40. Colocar lijas en lijadora";
            } else if (i == 41) {
                examenPracticoPorAlumno = "41. Uso y mantenimiento compresores";
            } else if (i == 42) {
                examenPracticoPorAlumno = "42. Centrales aire comprimido (festool...)";
            } else if (i == 43) {
                examenPracticoPorAlumno = "43. Tipos de lijadoras y uso";
            } else if (i == 44) {
                examenPracticoPorAlumno = "44. Tomas, mangueras, presión cada máquina";
            } else if (i == 45) {
                examenPracticoPorAlumno = "45. Formulación color con código";
            } else if (i == 46) {
                examenPracticoPorAlumno = "46. Encontrar color y variante con código";
            } else if (i == 47) {
                examenPracticoPorAlumno = "47. Armario de mezclas";
            } else if (i == 48) {
                examenPracticoPorAlumno = "48. Plano aspirante";
            } else if (i == 49) {
                examenPracticoPorAlumno = "49. Cinta levantagomas";
            } else if (i == 50) {
                examenPracticoPorAlumno = "50. Capas pintado reparación";
            } else {
                examenPracticoPorAlumno = "Nada";
            }

            ObjetoExamenPracticoPorAlumno objetoExamenPracticoPorAlumno = new ObjetoExamenPracticoPorAlumno(examenPracticoPorAlumno);
            listaExamenPracticoPorAlumno.add(objetoExamenPracticoPorAlumno);
        }
        return listaExamenPracticoPorAlumno;
    }
    
    private View crearFilaView (ObjetoExamenPracticoPorAlumno objetoExamenPracticoPorAlumno) {
        // Infla la vista de la fila desde el XML
        View filaView = LayoutInflater.from(this).inflate(R.layout.filaexamenpracticoporalumno, null);

        // Accede a las vistas dentro de la fila y configura sus valores
        TextView textViewPregunta = filaView.findViewById(R.id.textViewPreguntaExamenPracticoPorAlumno);
        RadioGroup radioGroup = filaView.findViewById(R.id.radioGroupExamenPracticoPorAlumno);
        RadioButton radioButtonSi = filaView.findViewById(R.id.radioButtonSiExamenPracticoPorAlumno);
        RadioButton radioButtonNo = filaView.findViewById(R.id.radioButtonNoExamenPracticoPorAlumno);

        textViewPregunta.setText(String.valueOf(objetoExamenPracticoPorAlumno.getPregunta()));

        ObjetoViewExamenPracticoPorAlumno objetoViewExamenPracticoPorAlumno = new ObjetoViewExamenPracticoPorAlumno(textViewPregunta,
                radioGroup, radioButtonSi, radioButtonNo);

        listaViewExamenPracticoPorAlumno.add(objetoViewExamenPracticoPorAlumno);

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
                int fallos = 0;
                for (int i = 1; i <= 50; i++) {
                    String acierta;
                    if (listaViewExamenPracticoPorAlumno.get(i-1).radioGroup.getCheckedRadioButtonId() == listaViewExamenPracticoPorAlumno.get(i-1).getRadioButtonSi().getId()){
                        acierta = "S";
                    } else if (listaViewExamenPracticoPorAlumno.get(i-1).radioGroup.getCheckedRadioButtonId() == listaViewExamenPracticoPorAlumno.get(i-1).getRadioButtonNo().getId()){
                        acierta = "N";
                    } else {
                        acierta = "";
                    }

                    String idalumno = miAplicacion.getAlumnoActualId();
                    String numero = miAplicacion.getAlumnoActualNumero();
                    String nombre = miAplicacion.getAlumnoActualNombre();
                    if(acierta.equals("N")){
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