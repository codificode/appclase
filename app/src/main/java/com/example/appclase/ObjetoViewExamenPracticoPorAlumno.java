package com.example.appclase;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ObjetoViewExamenPracticoPorAlumno {
    TextView textViewPregunta;
    RadioGroup radioGroup;
    RadioButton radioButtonSi;
    RadioButton radioButtonNo;

    public ObjetoViewExamenPracticoPorAlumno(TextView textViewPregunta, RadioGroup radioGroup, RadioButton radioButtonSi, RadioButton radioButtonNo) {
        this.textViewPregunta = textViewPregunta;
        this.radioGroup = radioGroup;
        this.radioButtonSi = radioButtonSi;
        this.radioButtonNo = radioButtonNo;
    }

    public TextView getTextViewPregunta() {
        return textViewPregunta;
    }

    public void setTextViewPregunta(TextView textViewPregunta) {
        this.textViewPregunta = textViewPregunta;
    }

    public RadioGroup getRadioGroup() {
        return radioGroup;
    }

    public void setRadioGroup(RadioGroup radioGroup) {
        this.radioGroup = radioGroup;
    }

    public RadioButton getRadioButtonSi() {
        return radioButtonSi;
    }

    public void setRadioButtonSi(RadioButton radioButtonSi) {
        this.radioButtonSi = radioButtonSi;
    }

    public RadioButton getRadioButtonNo() {
        return radioButtonNo;
    }

    public void setRadioButtonNo(RadioButton radioButtonNo) {
        this.radioButtonNo = radioButtonNo;
    }
}
