/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasexamen;

/**
 *
 * @author vesprada
 */
public class Alumno {
    private int id;
    private String nom;
    private String cognom;
    private String curs;

    public Alumno(int id, String nom, String cognom, String curs) {
        this.id = id;
        this.nom = nom;
        this.cognom = cognom;
        this.curs = curs;
    }

    public Alumno() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getCurs() {
        return curs;
    }

    public void setCurs(String curs) {
        this.curs = curs;
    }

    
    
}
