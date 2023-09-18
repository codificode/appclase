package com.example.appclase;

public class ObjetoPositivo {

    int idAlumno;
    int numero;
    String nombre;

    Boolean estadoCheckBox = false;
    String comentario = "";

    public ObjetoPositivo(int idAlumno, int numero, String nombre) {
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

    public Boolean getEstadoCheckBox() {
        return estadoCheckBox;
    }

    public void setEstadoCheckBox(Boolean estadoCheckBox) {
        this.estadoCheckBox = estadoCheckBox;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}