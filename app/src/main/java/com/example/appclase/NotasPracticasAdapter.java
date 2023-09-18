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

public class NotasPracticasAdapter extends RecyclerView.Adapter<NotasPracticasAdapter.NotasPracticasViewHolder> {

    private ArrayList<ObjetoNotasPracticas> listaNotasPracticas;

    public NotasPracticasAdapter(ArrayList<ObjetoNotasPracticas> listaNotasPracticas) {
        this.listaNotasPracticas = listaNotasPracticas;
    }

    @NonNull
    @Override
    public NotasPracticasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filanotaspracticas, parent, false);
        return new NotasPracticasViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotasPracticasViewHolder holder, int position) {
        ObjetoNotasPracticas notasPracticas = listaNotasPracticas.get(position);
        holder.textViewNumeroNotasPracticas.setText(String.valueOf(notasPracticas.getNumero()));
        holder.textViewNombreNotasPracticas.setText(notasPracticas.getNombre());

        // Configura el EditText con el valor de los campos
        holder.editTextPra1NotasPracticas.setText(String.valueOf(notasPracticas.getPra1()));
        holder.editTextPra2NotasPracticas.setText(String.valueOf(notasPracticas.getPra2()));
        holder.editTextPra3NotasPracticas.setText(String.valueOf(notasPracticas.getPra3()));
        holder.editTextPra4NotasPracticas.setText(String.valueOf(notasPracticas.getPra4()));
        holder.editTextPra5NotasPracticas.setText(String.valueOf(notasPracticas.getPra5()));
        holder.editTextPra6NotasPracticas.setText(String.valueOf(notasPracticas.getPra6()));
        holder.editTextPra7NotasPracticas.setText(String.valueOf(notasPracticas.getPra7()));
        holder.editTextPra8NotasPracticas.setText(String.valueOf(notasPracticas.getPra8()));
        holder.editTextPra9NotasPracticas.setText(String.valueOf(notasPracticas.getPra9()));
        holder.editTextPra10NotasPracticas.setText(String.valueOf(notasPracticas.getPra10()));
        holder.editTextPra11NotasPracticas.setText(String.valueOf(notasPracticas.getPra11()));
        holder.editTextPra12NotasPracticas.setText(String.valueOf(notasPracticas.getPra12()));
        holder.editTextPra13NotasPracticas.setText(String.valueOf(notasPracticas.getPra13()));
        holder.editTextPra14NotasPracticas.setText(String.valueOf(notasPracticas.getPra14()));


        // Actualiza los campos del objeto ObjetoNotasPracticas cuando se cambie el texto en el EditText
        holder.editTextPra1NotasPracticas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                notasPracticas.setPra1(editable.toString());
            }
        });

        holder.editTextPra2NotasPracticas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                notasPracticas.setPra2(editable.toString());
            }
        });

        holder.editTextPra3NotasPracticas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                notasPracticas.setPra3(editable.toString());
            }
        });

        holder.editTextPra4NotasPracticas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                notasPracticas.setPra4(editable.toString());
            }
        });

        holder.editTextPra5NotasPracticas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                notasPracticas.setPra5(editable.toString());
            }
        });

        holder.editTextPra6NotasPracticas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                notasPracticas.setPra6(editable.toString());
            }
        });

        holder.editTextPra7NotasPracticas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                notasPracticas.setPra7(editable.toString());
            }
        });

        holder.editTextPra8NotasPracticas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                notasPracticas.setPra8(editable.toString());
            }
        });

        holder.editTextPra9NotasPracticas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                notasPracticas.setPra9(editable.toString());
            }
        });

        holder.editTextPra10NotasPracticas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                notasPracticas.setPra10(editable.toString());
            }
        });

        holder.editTextPra11NotasPracticas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                notasPracticas.setPra11(editable.toString());
            }
        });

        holder.editTextPra12NotasPracticas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                notasPracticas.setPra12(editable.toString());
            }
        });

        holder.editTextPra13NotasPracticas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                notasPracticas.setPra13(editable.toString());
            }
        });

        holder.editTextPra14NotasPracticas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                notasPracticas.setPra14(editable.toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaNotasPracticas.size();
    }

    public class NotasPracticasViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewNumeroNotasPracticas;
        public TextView textViewNombreNotasPracticas;
        public EditText editTextPra1NotasPracticas;
        public EditText editTextPra2NotasPracticas;
        public EditText editTextPra3NotasPracticas;
        public EditText editTextPra4NotasPracticas;
        public EditText editTextPra5NotasPracticas;
        public EditText editTextPra6NotasPracticas;
        public EditText editTextPra7NotasPracticas;
        public EditText editTextPra8NotasPracticas;
        public EditText editTextPra9NotasPracticas;
        public EditText editTextPra10NotasPracticas;
        public EditText editTextPra11NotasPracticas;
        public EditText editTextPra12NotasPracticas;
        public EditText editTextPra13NotasPracticas;
        public EditText editTextPra14NotasPracticas;

        public NotasPracticasViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNumeroNotasPracticas = itemView.findViewById(R.id.textViewNumeroNotasPracticas);
            textViewNombreNotasPracticas = itemView.findViewById(R.id.textViewNombreNotasPracticas);
            editTextPra1NotasPracticas = itemView.findViewById(R.id.editTextPra1NotasPracticas);
            editTextPra2NotasPracticas = itemView.findViewById(R.id.editTextPra2NotasPracticas);
            editTextPra3NotasPracticas = itemView.findViewById(R.id.editTextPra3NotasPracticas);
            editTextPra4NotasPracticas = itemView.findViewById(R.id.editTextPra4NotasPracticas);
            editTextPra5NotasPracticas = itemView.findViewById(R.id.editTextPra5NotasPracticas);
            editTextPra6NotasPracticas = itemView.findViewById(R.id.editTextPra6NotasPracticas);
            editTextPra7NotasPracticas = itemView.findViewById(R.id.editTextPra7NotasPracticas);
            editTextPra8NotasPracticas = itemView.findViewById(R.id.editTextPra8NotasPracticas);
            editTextPra9NotasPracticas = itemView.findViewById(R.id.editTextPra9NotasPracticas);
            editTextPra10NotasPracticas = itemView.findViewById(R.id.editTextPra10NotasPracticas);
            editTextPra11NotasPracticas = itemView.findViewById(R.id.editTextPra11NotasPracticas);
            editTextPra12NotasPracticas = itemView.findViewById(R.id.editTextPra12NotasPracticas);
            editTextPra13NotasPracticas = itemView.findViewById(R.id.editTextPra13NotasPracticas);
            editTextPra14NotasPracticas = itemView.findViewById(R.id.editTextPra14NotasPracticas);
        }
    }
}
