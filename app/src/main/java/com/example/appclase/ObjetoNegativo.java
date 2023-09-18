package com.example.appclase;

public class ObjetoNegativo {

    int idAlumno;
    int numero;
    String nombre;

    String causa ="";
    String comentario = "";

    public ObjetoNegativo(int idAlumno, int numero, String nombre) {
        this.idAlumno = idAlumno;
        this.numero = numero;
        this.nombre = nombre;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
