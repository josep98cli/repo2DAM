package com.example.projectejosepcliment;

public class Contacto {
    private String nombre;
    private int telefono;
    private String grupo;

    public Contacto(String nombre, int telefono, String grupo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.grupo = grupo;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
