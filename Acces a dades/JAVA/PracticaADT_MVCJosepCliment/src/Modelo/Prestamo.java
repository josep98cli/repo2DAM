/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


/**
 *
 * @author vesprada
 */
public class Prestamo {
    private int ISBN;
    private int numSocio;
    private String f_prestamo;
    private String f_devolucion;

    public Prestamo(int ISBN, int numSocio, String f_prestamo, String f_devolucion) {
        this.ISBN = ISBN;
        this.numSocio = numSocio;
        this.f_prestamo = f_prestamo;
        this.f_devolucion = f_devolucion;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getNumSocio() {
        return numSocio;
    }

    public void setNumSocio(int numSocio) {
        this.numSocio = numSocio;
    }

    public String getF_prestamo() {
        return f_prestamo;
    }

    public void setF_prestamo(String f_prestamo) {
        this.f_prestamo = f_prestamo;
    }

    public String getF_devolucion() {
        return f_devolucion;
    }

    public void setF_devolucion(String f_devolucion) {
        this.f_devolucion = f_devolucion;
    }
    
    
    
}
