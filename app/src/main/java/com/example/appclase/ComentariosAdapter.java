package com.example.appclase;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ComentariosAdapter extends RecyclerView.Adapter<ComentariosAdapter.ComentarioViewHolder> {

    private ArrayList<ObjetoComentario> listaComentarios;

    public ComentariosAdapter(ArrayList<ObjetoComentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    @NonNull
    @Override
    public ComentarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filacomentarios, parent, false);
        return new ComentarioViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ComentarioViewHolder holder, int position) {
        ObjetoComentario comentario = listaComentarios.get(position);
        holder.textViewNumeroComentarios.setText(String.valueOf(comentario.getNumero()));
        holder.textViewNombreComentarios.setText(comentario.getNombre());

        // Configura el EditText con el valor del campo comentario
        holder.editTextComentarioComentarios.setText(comentario.getComentario());

        // Actualiza el campo comentario del objeto ObjetoComentario cuando se cambie el texto en el EditText
        holder.editTextComentarioComentarios.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                comentario.setComentario(editable.toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaComentarios.size();
    }

    public class ComentarioViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewNumeroComentarios;
        public TextView textViewNombreComentarios;
        public EditText editTextComentarioComentarios;

        public ComentarioViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNumeroComentarios = itemView.findViewById(R.id.textViewNumeroComentarios);
            textViewNombreComentarios = itemView.findViewById(R.id.textViewNombreComentarios);
            editTextComentarioComentarios = itemView.findViewById(R.id.editTextComentarioComentarios);
        }
    }
}
