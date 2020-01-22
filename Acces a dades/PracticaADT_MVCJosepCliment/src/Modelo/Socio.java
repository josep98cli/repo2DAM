/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author vesprada
 */
public class Socio {
        private int numSocio;
        private String nombre;
        private String apellidos;
        private int telefono;
        private int edad;
        private String F_alta;

    public Socio(int numSocio, String nombre, String apellidos, int telefono, int edad, String F_alta) {
        this.numSocio = numSocio;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.edad = edad;
        this.F_alta = F_alta;
    }

    public Socio(int numSocio) {
        this.numSocio = numSocio;
    }

    public int getNumSocio() {
        return numSocio;
    }

    public void setNumSocio(int numSocio) {
        this.numSocio = numSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getF_alta() {
        return F_alta;
    }

    public void setF_alta(String F_alta) {
        this.F_alta = F_alta;
    }
}
