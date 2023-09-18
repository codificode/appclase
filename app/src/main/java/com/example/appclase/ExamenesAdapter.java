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

public class ExamenesAdapter extends RecyclerView.Adapter<ExamenesAdapter.ExamenViewHolder> {

    private ArrayList<ObjetoExamen> listaExamenes;

    public ExamenesAdapter(ArrayList<ObjetoExamen> listaExamenes) {
        this.listaExamenes = listaExamenes;
    }

    @NonNull
    @Override
    public ExamenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filaexamenes, parent, false);
        return new ExamenViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamenViewHolder holder, int position) {
        ObjetoExamen examen = listaExamenes.get(position);
        holder.textViewNumeroExamenes.setText(String.valueOf(examen.getNumero()));
        holder.textViewNombreExamenes.setText(examen.getNombre());

        // Configura el EditText con el valor de los campos
        holder.editTextPar1Examenes.setText(String.valueOf(examen.getPar1()));
        holder.editTextPar2Examenes.setText(String.valueOf(examen.getPar2()));
        holder.editTextPar3Examenes.setText(String.valueOf(examen.getPar3()));
        holder.editTextPar4Examenes.setText(String.valueOf(examen.getPar4()));
        holder.editTextPar5Examenes.setText(String.valueOf(examen.getPar5()));
        holder.editTextPar6Examenes.setText(String.valueOf(examen.getPar6()));
        holder.editTextRec1Examenes.setText(String.valueOf(examen.getRec1()));
        holder.editTextRec2Examenes.setText(String.valueOf(examen.getRec2()));
        holder.editTextRec3Examenes.setText(String.valueOf(examen.getRec3()));
        holder.editTextRec4Examenes.setText(String.valueOf(examen.getRec4()));
        holder.editTextRec5Examenes.setText(String.valueOf(examen.getRec5()));
        holder.editTextRec6Examenes.setText(String.valueOf(examen.getRec6()));
        holder.editTextRec21Examenes.setText(String.valueOf(examen.getRec21()));
        holder.editTextRec22Examenes.setText(String.valueOf(examen.getRec22()));
        holder.editTextRec23Examenes.setText(String.valueOf(examen.getRec23()));
        holder.editTextRec24Examenes.setText(String.valueOf(examen.getRec24()));
        holder.editTextRec25Examenes.setText(String.valueOf(examen.getRec25()));
        holder.editTextRec26Examenes.setText(String.valueOf(examen.getRec26()));
        holder.editTextFinalExamenes.setText(String.valueOf(examen.getExfinal()));


        // Actualiza los campos del objeto ObjetoExamen cuando se cambie el texto en el EditText
        holder.editTextPar1Examenes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                examen.setPar1(editable.toString());
            }
        });

        holder.editTextPar2Examenes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                examen.setPar2(editable.toString());
            }
        });

        holder.editTextPar3Examenes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                examen.setPar3(editable.toString());
            }
        });

        holder.editTextPar4Examenes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                examen.setPar4(editable.toString());
            }
        });

        holder.editTextPar5Examenes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                examen.setPar5(editable.toString());
            }
        });

        holder.editTextPar6Examenes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                examen.setPar6(editable.toString());
            }
        });

        holder.editTextRec1Examenes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                examen.setRec1(editable.toString());
            }
        });

        holder.editTextRec2Examenes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                examen.setRec2(editable.toString());
            }
        });

        holder.editTextRec3Examenes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                examen.setRec3(editable.toString());
            }
        });

        holder.editTextRec4Examenes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                examen.setRec4(editable.toString());
            }
        });

        holder.editTextRec5Examenes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                examen.setRec5(editable.toString());
            }
        });

        holder.editTextRec6Examenes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                examen.setRec6(editable.toString());
            }
        });

        holder.editTextRec21Examenes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                examen.setRec21(editable.toString());
            }
        });

        holder.editTextRec22Examenes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                examen.setRec22(editable.toString());
            }
        });

        holder.editTextRec23Examenes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                examen.setRec23(editable.toString());
            }
        });

        holder.editTextRec24Examenes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                examen.setRec24(editable.toString());
            }
        });

        holder.editTextRec25Examenes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                examen.setRec25(editable.toString());
            }
        });

        holder.editTextRec26Examenes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                examen.setRec26(editable.toString());
            }
        });

        holder.editTextFinalExamenes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                examen.setExfinal(editable.toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaExamenes.size();
    }

    public class ExamenViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewNumeroExamenes;
        public TextView textViewNombreExamenes;
        public EditText editTextPar1Examenes;
        public EditText editTextPar2Examenes;
        public EditText editTextPar3Examenes;
        public EditText editTextPar4Examenes;
        public EditText editTextPar5Examenes;
        public EditText editTextPar6Examenes;
        public EditText editTextRec1Examenes;
        public EditText editTextRec2Examenes;
        public EditText editTextRec3Examenes;
        public EditText editTextRec4Examenes;
        public EditText editTextRec5Examenes;
        public EditText editTextRec6Examenes;
        public EditText editTextRec21Examenes;
        public EditText editTextRec22Examenes;
        public EditText editTextRec23Examenes;
        public EditText editTextRec24Examenes;
        public EditText editTextRec25Examenes;
        public EditText editTextRec26Examenes;
        public EditText editTextFinalExamenes;

        public ExamenViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNumeroExamenes = itemView.findViewById(R.id.textViewNumeroExamenes);
            textViewNombreExamenes = itemView.findViewById(R.id.textViewNombreExamenes);
            editTextPar1Examenes = itemView.findViewById(R.id.editTextPar1Examenes);
            editTextPar2Examenes = itemView.findViewById(R.id.editTextPar2Examenes);
            editTextPar3Examenes = itemView.findViewById(R.id.editTextPar3Examenes);
            editTextPar4Examenes = itemView.findViewById(R.id.editTextPar4Examenes);
            editTextPar5Examenes = itemView.findViewById(R.id.editTextPar5Examenes);
            editTextPar6Examenes = itemView.findViewById(R.id.editTextPar6Examenes);
            editTextRec1Examenes = itemView.findViewById(R.id.editTextRec1Examenes);
            editTextRec2Examenes = itemView.findViewById(R.id.editTextRec2Examenes);
            editTextRec3Examenes = itemView.findViewById(R.id.editTextRec3Examenes);
            editTextRec4Examenes = itemView.findViewById(R.id.editTextRec4Examenes);
            editTextRec5Examenes = itemView.findViewById(R.id.editTextRec5Examenes);
            editTextRec6Examenes = itemView.findViewById(R.id.editTextRec6Examenes);
            editTextRec21Examenes = itemView.findViewById(R.id.editTextRec21Examenes);
            editTextRec22Examenes = itemView.findViewById(R.id.editTextRec22Examenes);
            editTextRec23Examenes = itemView.findViewById(R.id.editTextRec23Examenes);
            editTextRec24Examenes = itemView.findViewById(R.id.editTextRec24Examenes);
            editTextRec25Examenes = itemView.findViewById(R.id.editTextRec25Examenes);
            editTextRec26Examenes = itemView.findViewById(R.id.editTextRec26Examenes);
            editTextFinalExamenes = itemView.findViewById(R.id.editTextFinalExamenes);
        }
    }
}
