package com.example.appclase;

public class ObjetoFalta {
    int idAlumno;
    int numero;
    String nombre;
    Boolean primera;
    Boolean segunda;
    Boolean tercera;

    public ObjetoFalta(int idAlumno, int numero, String nombre) {
        this.idAlumno = idAlumno;
        this.numero = numero;
        this.nombre = nombre;
        this.primera = false;
        this.segunda = false;
        this.tercera = false;
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

    public Boolean getPrimera() {
        return primera;
    }

    public void setPrimera(Boolean primera) {
        this.primera = primera;
    }

    public Boolean getSegunda() {
        return segunda;
    }

    public void setSegunda(Boolean segunda) {
        this.segunda = segunda;
    }

    public Boolean getTercera() {
        return tercera;
    }

    public void setTercera(Boolean tercera) {
        this.tercera = tercera;
    }

    @Override
    public String toString(){
        return idAlumno + numero + nombre + String.valueOf(primera) + String.valueOf(segunda) + String.valueOf(tercera);
    }

}
