/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast1_practica00;

import java.util.ArrayList;

/**
 *
 * @author vesprada
 */
public class Periodico {
    
    ArrayList<Noticia> listaNoticias;
    int numNoticias;

    public Periodico(int numNoticias) {
        this.numNoticias = numNoticias;
        listaNoticias =  new ArrayList(1000);
    }
    
    public void insertar(Noticia n){
        if (numNoticias != 0) {
            listaNoticias.add(n);
            numNoticias ++ ;
        }
    }
    
    public Noticia primeraNoticia(int d, int m, int a){
        if (listaNoticias.get(0)== null) {
            return null;
        } else {
            return listaNoticias.get(0);
        }
    }
    
    public void masPopulares(){
        
    }
    
    public void borrarAnteriores(int d, int m, int a){}
}
