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

public class NegativosAdapter extends RecyclerView.Adapter<NegativosAdapter.NegativoViewHolder> {


    private ArrayList<ObjetoNegativo> listaNegativos;

    public NegativosAdapter(ArrayList<ObjetoNegativo> listaNegativos) {
        this.listaNegativos = listaNegativos;
    }

    @NonNull
    @Override
    public NegativoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filanegativos, parent, false);
        return new NegativoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NegativoViewHolder holder, int position) {

        ObjetoNegativo negativo = listaNegativos.get(position);
        holder.textViewNumeroNegativos.setText(String.valueOf(negativo.getNumero()));
        holder.textViewNombreNegativos.setText(negativo.getNombre());

        // Configura el EditText con el valor del campo Comentario
        holder.editTextComentarioNegativos.setText(negativo.getComentario());
        holder.radioButton1Negativos.setSelected(false);
        holder.radioButton2Negativos.setSelected(false);
        holder.radioButton3Negativos.setSelected(false);
        holder.radioButton4Negativos.setSelected(false);
        holder.radioButton5Negativos.setSelected(false);

        // Configura el estado de los RadioButtons
        String selectedCausa = negativo.getCausa();
        setSelectedRadioButton(holder, selectedCausa);

        holder.radioGroupNegativos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                // Aquí actualizamos la causa seleccionada
                String selectedCausa = getCausaFromRadioButtonId(checkedId);
                negativo.setCausa(selectedCausa);
            }
        });

        holder.editTextComentarioNegativos.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                negativo.setComentario(editable.toString());
            }
        });

    }

    private void setSelectedRadioButton(NegativoViewHolder holder, String selectedCausa) {
        // Dependiendo de la causa seleccionada, marca el RadioButton correspondiente
        // Aquí asumimos que getCausa devuelve un identificador válido de RadioButton
        int radioButtonId = getRadioButtonIdFromCausa(selectedCausa);

        // Marca el RadioButton correspondiente
        if (radioButtonId != -1) {
            holder.radioGroupNegativos.check(radioButtonId);
        }
    }

    private int getRadioButtonIdFromCausa(String causa) {
        switch (causa) {
            case "para/lava/cambia antes de tiempo":
                return R.id.radioButton1Negativos;
            case "no recoge":
                return R.id.radioButton2Negativos;
            case "juega/molesta":
                return R.id.radioButton2Negativos;
            case "no trabaja":
                return R.id.radioButton2Negativos;
            case "otros":
                return R.id.radioButton2Negativos;
            default:
                return -1;  // Si no se encuentra una causa válida
        }
    }
    private String getCausaFromRadioButtonId(int radioButtonId) {
        if (radioButtonId == R.id.radioButton1Negativos) {
            return "para/lava/cambia antes de tiempo";
        } else if (radioButtonId == R.id.radioButton2Negativos) {
            return "no recoge";
        } else if (radioButtonId == R.id.radioButton3Negativos) {
            return "juega/molesta";
        } else if (radioButtonId == R.id.radioButton4Negativos) {
            return "no trabaja";
        } else if (radioButtonId == R.id.radioButton5Negativos) {
            return "otros";
        }
        // Default case: Si no se encuentra una causa válida
        return "";
    }


    @Override
    public int getItemCount() {
        return listaNegativos.size();
    }

    public class NegativoViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewNumeroNegativos;
        public TextView textViewNombreNegativos;
        public EditText editTextComentarioNegativos;
        public RadioGroup radioGroupNegativos;
        public RadioButton radioButton1Negativos;
        public RadioButton radioButton2Negativos;
        public RadioButton radioButton3Negativos;
        public RadioButton radioButton4Negativos;
        public RadioButton radioButton5Negativos;

        public NegativoViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNumeroNegativos = itemView.findViewById(R.id.textViewNumeroNegativos);
            textViewNombreNegativos = itemView.findViewById(R.id.textViewNombreNegativos);
            radioGroupNegativos = itemView.findViewById(R.id.radioGroupNegativos);
            radioButton1Negativos = itemView.findViewById(R.id.radioButton1Negativos);
            radioButton2Negativos = itemView.findViewById(R.id.radioButton2Negativos);
            radioButton3Negativos = itemView.findViewById(R.id.radioButton3Negativos);
            radioButton4Negativos = itemView.findViewById(R.id.radioButton4Negativos);
            radioButton5Negativos = itemView.findViewById(R.id.radioButton5Negativos);
            editTextComentarioNegativos = itemView.findViewById(R.id.editTextComentarioNegativos);
        }
    }
}
