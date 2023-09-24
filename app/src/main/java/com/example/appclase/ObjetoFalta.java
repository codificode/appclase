package com.example.appclase;

public class ObjetoFalta {
    int idAlumno;
    int numero;
    String nombre;
    Boolean primera;
    Boolean segunda;
    Boolean tercera;
    Boolean retr1;
    Boolean retr2;
    Boolean retr3;

    public ObjetoFalta(int idAlumno, int numero, String nombre) {
        this.idAlumno = idAlumno;
        this.numero = numero;
        this.nombre = nombre;
        this.primera = false;
        this.segunda = false;
        this.tercera = false;
        this.retr1 = false;
        this.retr2 = false;
        this.retr3 = false;
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

    public Boolean getRetr1() {
        return retr1;
    }

    public void setRetr1(Boolean retr1) {
        this.retr1 = retr1;
    }

    public Boolean getRetr2() {
        return retr2;
    }

    public void setRetr2(Boolean retr2) {
        this.retr2 = retr2;
    }

    public Boolean getRetr3() {
        return retr3;
    }

    public void setRetr3(Boolean retr3) {
        this.retr3 = retr3;
    }

    @Override
    public String toString(){
        return idAlumno + numero + nombre + String.valueOf(primera) + String.valueOf(segunda) + String.valueOf(tercera) + String.valueOf(retr1) + String.valueOf(retr2) + String.valueOf(retr3);
    }

}
