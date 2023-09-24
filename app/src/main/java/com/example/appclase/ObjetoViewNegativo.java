package com.example.appclase;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ObjetoViewNegativo {
    TextView textViewNumero;
    TextView textViewNombre;
    RadioGroup radioGroup;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    RadioButton radioButton5;
    RadioButton radioButton6;
    EditText editTextComentario;

    public ObjetoViewNegativo(TextView textViewNumero, TextView textViewNombre, RadioGroup radioGroup, RadioButton radioButton1, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, EditText editTextComentario) {
        this.textViewNumero = textViewNumero;
        this.textViewNombre = textViewNombre;
        this.radioGroup = radioGroup;
        this.radioButton1 = radioButton1;
        this.radioButton2 = radioButton2;
        this.radioButton3 = radioButton3;
        this.radioButton4 = radioButton4;
        this.radioButton5 = radioButton5;
        this.radioButton6 = radioButton6;
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

    public RadioGroup getRadioGroup() {
        return radioGroup;
    }

    public void setRadioGroup(RadioGroup radioGroup) {
        this.radioGroup = radioGroup;
    }

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton radioButton1) {
        this.radioButton1 = radioButton1;
    }

    public RadioButton getRadioButton2() {
        return radioButton2;
    }

    public void setRadioButton2(RadioButton radioButton2) {
        this.radioButton2 = radioButton2;
    }

    public RadioButton getRadioButton3() {
        return radioButton3;
    }

    public void setRadioButton3(RadioButton radioButton3) {
        this.radioButton3 = radioButton3;
    }

    public RadioButton getRadioButton4() {
        return radioButton4;
    }

    public void setRadioButton4(RadioButton radioButton4) {
        this.radioButton4 = radioButton4;
    }

    public RadioButton getRadioButton5() {
        return radioButton5;
    }

    public void setRadioButton5(RadioButton radioButton5) {
        this.radioButton5 = radioButton5;
    }

    public RadioButton getRadioButton6() {
        return radioButton6;
    }

    public void setRadioButton6(RadioButton radioButton6) {
        this.radioButton6 = radioButton6;
    }

    public EditText getEditTextComentario() {
        return editTextComentario;
    }

    public void setEditTextComentario(EditText editTextComentario) {
        this.editTextComentario = editTextComentario;
    }
}
