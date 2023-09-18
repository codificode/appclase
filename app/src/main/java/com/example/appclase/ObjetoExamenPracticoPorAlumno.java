package com.example.appclase;

public class ObjetoExamenPracticoPorAlumno {
    String numeroPregunta="";
    String acierta ="";


    public ObjetoExamenPracticoPorAlumno(String numeroPregunta) {
        this.numeroPregunta = numeroPregunta;
    }

    public String getAcierta() {
        return acierta;
    }

    public void setAcierta(String acierta) {
        this.acierta = acierta;
    }

    public String getNumeroPregunta() {
        return numeroPregunta;
    }

    public void setNumeroPregunta(String numeroPregunta) {
        this.numeroPregunta = numeroPregunta;
    }
}
