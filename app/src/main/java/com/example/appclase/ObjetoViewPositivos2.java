package com.example.appclase;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class ObjetoViewPositivos2 {
    TextView textViewNumero;
    TextView textViewNombre;
    CheckBox checkBox;
    EditText editTextComentario;

    public ObjetoViewPositivos2(TextView textViewNumero, TextView textViewNombre, CheckBox checkBox, EditText editTextComentario) {
        this.textViewNumero = textViewNumero;
        this.textViewNombre = textViewNombre;
        this.checkBox = checkBox;
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

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public EditText getEditTextComentario() {
        return editTextComentario;
    }

    public void setEditTextComentario(EditText editTextComentario) {
        this.editTextComentario = editTextComentario;
    }
}
