package com.example.appclase;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExamenPracticoPorAlumnoAdapter extends RecyclerView.Adapter<ExamenPracticoPorAlumnoAdapter.ExamenPracticoPorAlumnoViewHolder> {


    private ArrayList<ObjetoExamenPracticoPorAlumno> listaExamenPracticoPorAlumno;

    public ExamenPracticoPorAlumnoAdapter(ArrayList<ObjetoExamenPracticoPorAlumno> listaExamenPracticoPorAlumno) {
        this.listaExamenPracticoPorAlumno = listaExamenPracticoPorAlumno;
    }

    @NonNull
    @Override
    public ExamenPracticoPorAlumnoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filaexamenpracticoporalumno, parent, false);
        return new ExamenPracticoPorAlumnoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamenPracticoPorAlumnoViewHolder holder, int position) {

        ObjetoExamenPracticoPorAlumno examenPracticoPorAlumno = listaExamenPracticoPorAlumno.get(position);
        holder.textViewNumPreguntaExamenPracticoPorAlumno.setText(examenPracticoPorAlumno.getNumeroPregunta());

        // Configura radiobuttons
        holder.radioButtonSiExamenPracticoPorAlumno.setSelected(false);
        holder.radioButtonNoExamenPracticoPorAlumno.setSelected(false);

        // Configura el estado de los RadioButtons
        String selectedAcierta = examenPracticoPorAlumno.getAcierta();
        setSelectedRadioButton(holder, selectedAcierta);

        holder.radioGroupExamenPracticoPorAlumno.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                // Aquí actualizamos la opción (acierta)
                String selectedAcierta = getAciertaFromRadioButtonId(checkedId);
                examenPracticoPorAlumno.setAcierta(selectedAcierta);
            }
        });

    }

    private void setSelectedRadioButton(ExamenPracticoPorAlumnoViewHolder holder, String selectedAcierta) {
        // Dependiendo de la opción (acierta o no) seleccionada, marca el RadioButton correspondiente
        // Aquí asumimos que la opción (Si/No) devuelve un identificador válido de RadioButton
        int radioButtonId = getRadioButtonIdFromAcierta(selectedAcierta);

        // Marca el RadioButton correspondiente
        if (radioButtonId != -1) {
            holder.radioGroupExamenPracticoPorAlumno.check(radioButtonId);
        }
    }

    private int getRadioButtonIdFromAcierta(String acierta) {
        switch (acierta) {
            case "Si":
                return R.id.radioButtonSiExamenPracticoPorAlumno;
            case "No":
                return R.id.radioButtonNoExamenPracticoPorAlumno;
            default:
                return -1;  // Si no se encuentra una causa válida
        }
    }
    private String getAciertaFromRadioButtonId(int radioButtonId) {
        if (radioButtonId == R.id.radioButtonSiExamenPracticoPorAlumno) {
            return "Si";
        } else if (radioButtonId == R.id.radioButtonNoExamenPracticoPorAlumno) {
            return "No";
        }
        // Default case: Si no se completa
        return "";
    }

    @Override
    public int getItemCount() {
        return listaExamenPracticoPorAlumno.size();
    }

    public class ExamenPracticoPorAlumnoViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewNumPreguntaExamenPracticoPorAlumno;
        public RadioGroup radioGroupExamenPracticoPorAlumno;
        public RadioButton radioButtonSiExamenPracticoPorAlumno;
        public RadioButton radioButtonNoExamenPracticoPorAlumno;

        public ExamenPracticoPorAlumnoViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNumPreguntaExamenPracticoPorAlumno = itemView.findViewById(R.id.textViewNumPreguntaExamenPracticoPorAlumno);
            radioGroupExamenPracticoPorAlumno = itemView.findViewById(R.id.radioGroupExamenPracticoPorAlumno);
            radioButtonSiExamenPracticoPorAlumno = itemView.findViewById(R.id.radioButtonSiExamenPracticoPorAlumno);
            radioButtonNoExamenPracticoPorAlumno = itemView.findViewById(R.id.radioButtonNoExamenPracticoPorAlumno);
        }
    }
}
