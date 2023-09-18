package com.example.appclase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FaltasAdapter extends RecyclerView.Adapter<FaltasAdapter.FaltaViewHolder> {

    private ArrayList<ObjetoFalta> listaFaltas;

    public FaltasAdapter(ArrayList<ObjetoFalta> listaFaltas) {
        this.listaFaltas = listaFaltas;
    }

    @NonNull
    @Override
    public FaltaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filafaltas, parent, false);
        return new FaltaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FaltaViewHolder holder, int position) {
    ObjetoFalta falta = listaFaltas.get(position);
    holder.textViewNumeroFaltas.setText(String.valueOf(falta.getNumero()));
    holder.textViewNombreFaltas.setText(falta.getNombre());

    holder.checkBoxPrimeraFaltas.setSelected(false);
    holder.checkBoxSegundaFaltas.setSelected(false);
    holder.checkBoxTerceraFaltas.setSelected(false);

    // Configura el estado inicial del CheckBox
    holder.checkBoxPrimeraFaltas.setChecked(falta.getPrimera());
        holder.checkBoxSegundaFaltas.setChecked(falta.getSegunda());
        holder.checkBoxTerceraFaltas.setChecked(falta.getTercera());

    // Maneja los cambios del CheckBox
    holder.checkBoxPrimeraFaltas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // Obtén la posición actual usando holder.getAdapterPosition()
            int adapterPosition = holder.getAdapterPosition();
            if (adapterPosition != RecyclerView.NO_POSITION) {
                // Cuando el usuario marca o desmarca el CheckBox
                // Actualiza el objeto en la lista en la posición correspondiente
                listaFaltas.get(adapterPosition).setPrimera(isChecked);
            }
        }
    });

        holder.checkBoxSegundaFaltas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Obtén la posición actual usando holder.getAdapterPosition()
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    // Cuando el usuario marca o desmarca el CheckBox
                    // Actualiza el objeto en la lista en la posición correspondiente
                    listaFaltas.get(adapterPosition).setSegunda(isChecked);
                }
            }
        });

        holder.checkBoxTerceraFaltas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Obtén la posición actual usando holder.getAdapterPosition()
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    // Cuando el usuario marca o desmarca el CheckBox
                    // Actualiza el objeto en la lista en la posición correspondiente
                    listaFaltas.get(adapterPosition).setTercera(isChecked);
                }
            }
        });
}

    @Override
    public int getItemCount() {
        return listaFaltas.size();
    }

    public class FaltaViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewNumeroFaltas;
        public TextView textViewNombreFaltas;
        public CheckBox checkBoxPrimeraFaltas;
        public CheckBox checkBoxSegundaFaltas;
        public CheckBox checkBoxTerceraFaltas;

        public FaltaViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNumeroFaltas = itemView.findViewById(R.id.textViewNumeroFaltas);
            textViewNombreFaltas = itemView.findViewById(R.id.textViewNombreFaltas);
            checkBoxPrimeraFaltas = itemView.findViewById(R.id.checkBoxPrimeraFaltas);
            checkBoxSegundaFaltas = itemView.findViewById(R.id.checkBoxSegundaFaltas);
            checkBoxTerceraFaltas = itemView.findViewById(R.id.checkBoxTerceraFaltas);
        }
    }
}
