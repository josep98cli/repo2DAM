/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.LibroDAO;
import Vista.JPLibro;

/**
 *
 * @author vesprada
 */
public class ControladorLibro {
    public LibroDAO libroDAO;
    public JPLibro jplibro;

    public ControladorLibro(LibroDAO libroDAO, JPLibro jplibro) {
        this.libroDAO = libroDAO;
        this.jplibro = jplibro;
    }

    public ControladorLibro() {
    }
}


