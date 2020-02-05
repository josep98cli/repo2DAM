/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast1_practica00;

/**
 *
 * @author vesprada
 */
public class Noticia {
    private int fecha;
    private int hora;
    private String textoNoticia;
    private int numLeido;

    public Noticia(int fecha, int hora, String textoNoticia) {
        this.fecha = fecha;
        this.hora = hora;
        this.textoNoticia = textoNoticia;
    }

    public int getFecha() {
        return fecha;
    }

    public int getNumLeido() {
        return numLeido;
    }
    
    public void incLecturas(){
    
    }
     public boolean igualData(int d, int m, int a){
        int data = d * 10000 + m * 1000 + a*100;
         if (data == fecha) {
             return true;
         }else{
             return false;
         }
     }

    @Override
    public String toString() {
        String s = "";
        s+=fecha%100 + "/" + (fecha/100)%100 + (fecha/1000) + " - ";
        s+=(hora/100) + ":" + (hora%100) + "\n";
        s+=textoNoticia + "\n";
        s+="Leida " + numLeido + "veces\n";
        
        return s;
    }
     
     
     
}
