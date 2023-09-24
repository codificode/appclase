package com.example.appclase;

public class ObjetoExamenPracticoPorAlumno {
    String pregunta="";
    String acierta ="";


    public ObjetoExamenPracticoPorAlumno(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getAcierta() {
        return acierta;
    }

    public void setAcierta(String acierta) {
        this.acierta = acierta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
}
