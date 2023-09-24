package com.example.appclase;

public class ObjetoPositivos2 {

    int idAlumno;
    int numero;
    String nombre;
    Boolean seleccionado;
    String comentario;

    public ObjetoPositivos2(int idAlumno, int numero, String nombre) {
        this.idAlumno = idAlumno;
        this.numero = numero;
        this.nombre = nombre;
        this.seleccionado = false;
        this.comentario = "";
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

    public Boolean getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
