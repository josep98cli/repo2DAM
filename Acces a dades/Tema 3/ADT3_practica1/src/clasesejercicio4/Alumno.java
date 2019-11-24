/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesejercicio4;

/**
 *
 * @author vesprada
 */
public class Alumno {
    
    private String id;
    private String nom;
    private String cognom;
    private String curs;
    private int nota;

    public Alumno(String id, String nom, String cognom, String curs, int nota) {
        this.id = id;
        this.nom = nom;
        this.cognom = cognom;
        this.curs = curs;
        this.nota = nota;
    }

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nom=" + nom + ", cognom=" + cognom + ", curs=" + curs + ", nota=" + nota + '}';
    }

    
    

    
    
    
}
