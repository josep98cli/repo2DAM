/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_practica02;

/**
 *
 * @author vesprada
 */
public class Jugador {
    
    
    private String nom;
    private int puntuacion;

    public Jugador(String nom, int puntuacion) {
        this.nom = nom;
        this.puntuacion = puntuacion;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    
}
