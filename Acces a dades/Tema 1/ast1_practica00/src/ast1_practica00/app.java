/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast1_practica00;

import java.util.Scanner;

/**
 *
 * @author vesprada
 */
public class app {

    public static void menu(){
        
        
        
    }
    
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        Noticia p = new Noticia(20150801, 1236, "Hola");
        
        System.out.println("Introduce fecha");    
        int fecha = s.nextInt();
        
        System.out.println("Introduce hora");
        int hora = s.nextInt();
        
        System.out.println("Introduce texto");
         String textoNoticia = s.next();
        
        System.out.println("Introduce numero de veces que se ha leido la noticia");
        int numLeido = s.nextInt();
       
      
        //menu();
    }
    
    
}
