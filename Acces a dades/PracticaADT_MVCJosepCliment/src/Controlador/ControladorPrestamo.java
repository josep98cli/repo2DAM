/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.PrestamoDAO;
import Vista.JPPrestamo;

/**
 *
 * @author vesprada
 */
public class ControladorPrestamo {
    private PrestamoDAO prestamoDAO;
    private JPPrestamo jpPrestamo;

    public ControladorPrestamo(PrestamoDAO prestamoDAO, JPPrestamo jpPrestamo) {
        this.prestamoDAO = prestamoDAO;
        this.jpPrestamo = jpPrestamo;
    }

    public ControladorPrestamo() {
    }

    
    public PrestamoDAO getPrestamoDAO() {
        return prestamoDAO;
    }

    public void setPrestamoDAO(PrestamoDAO prestamoDAO) {
        this.prestamoDAO = prestamoDAO;
    }

    public JPPrestamo getJpPrestamo() {
        return jpPrestamo;
    }

    public void setJpPrestamo(JPPrestamo jpPrestamo) {
        this.jpPrestamo = jpPrestamo;
    }
    
    
    
}
