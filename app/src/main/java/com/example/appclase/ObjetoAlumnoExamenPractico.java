package com.example.appclase;

public class ObjetoAlumnoExamenPractico {

    String id;
    String nombre;
    String numero;

    public ObjetoAlumnoExamenPractico(String id, String nombre, String numero) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString(){
        return numero + ", " + nombre;
    }

}
