package com.example.appclase;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PositivosAdapter extends RecyclerView.Adapter<PositivosAdapter.PositivoViewHolder> {


    private ArrayList<ObjetoPositivo> listaPositivos;

    public PositivosAdapter(ArrayList<ObjetoPositivo> listaPositivos) {
        this.listaPositivos = listaPositivos;
    }

    @NonNull
    @Override
    public PositivoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filapositivos, parent, false);
        return new PositivoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PositivoViewHolder holder, int position) {

        ObjetoPositivo positivo = listaPositivos.get(position);
        holder.textViewNumeroPositivos.setText(String.valueOf(positivo.getNumero()));
        holder.textViewNombrePositivos.setText(positivo.getNombre());

        // Configura el EditText con el valor del campo Comentario
        holder.editTextComentarioPositivos.setText(positivo.getComentario());

        holder.checkBoxPositivos.setSelected(false);

        // Configura el estado del CheckBox
        holder.checkBoxPositivos.setChecked(positivo.getEstadoCheckBox());

        // Agrega un listener al CheckBox para capturar los cambios de estado
        holder.checkBoxPositivos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Actualiza el estado del CheckBox en el modelo
                positivo.setEstadoCheckBox(isChecked);
            }
        });

        holder.editTextComentarioPositivos.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                positivo.setComentario(editable.toString());
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaPositivos.size();
    }

    public class PositivoViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewNumeroPositivos;
        public TextView textViewNombrePositivos;
        public EditText editTextComentarioPositivos;
        public CheckBox checkBoxPositivos;

        public PositivoViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNumeroPositivos = itemView.findViewById(R.id.textViewNumeroPositivos);
            textViewNombrePositivos = itemView.findViewById(R.id.textViewNombrePositivos);
            checkBoxPositivos = itemView.findViewById(R.id.checkBoxPositivos);

            editTextComentarioPositivos = itemView.findViewById(R.id.editTextComentarioPositivos);
        }
    }
}
