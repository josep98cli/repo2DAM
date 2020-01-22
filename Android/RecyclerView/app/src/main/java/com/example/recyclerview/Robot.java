package com.example.recyclerview;

public class Robot {
    private String dni;
    private String nombre;
    private char sexo;


    public Robot(String dni, String nombre, char sexo) {
        this.dni = dni;
        this.nombre = nombre;
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }


}
