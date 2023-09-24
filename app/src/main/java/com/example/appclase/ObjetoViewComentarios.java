package com.example.appclase;

import android.widget.EditText;
import android.widget.TextView;

public class ObjetoViewComentarios {
    TextView textViewNumero;
    TextView textViewNombre;
    EditText editTextComentario;

    public ObjetoViewComentarios(TextView textViewNumero, TextView textViewNombre, EditText editTextComentario) {
        this.textViewNumero = textViewNumero;
        this.textViewNombre = textViewNombre;
        this.editTextComentario = editTextComentario;
    }

    public TextView getTextViewNumero() {
        return textViewNumero;
    }

    public void setTextViewNumero(TextView textViewNumero) {
        this.textViewNumero = textViewNumero;
    }

    public TextView getTextViewNombre() {
        return textViewNombre;
    }

    public void setTextViewNombre(TextView textViewNombre) {
        this.textViewNombre = textViewNombre;
    }

    public EditText getEditTextComentario() {
        return editTextComentario;
    }

    public void setEditTextComentario(EditText editTextComentario) {
        this.editTextComentario = editTextComentario;
    }
}
