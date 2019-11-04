/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class Pepe {

    public static int calcularLenght(File fichero){
        return (int)fichero.length();
    }
    
    public static void bucle(int lenght){
        boolean end =false;
        
        while(!end){
            
        }
    
    }
    
    public static void main(String[] args) {
        try {
            File fichero = new File("psswd.txt");
            BufferedReader bf = new BufferedReader(new FileReader(fichero));
            int longitudPass = calcularLenght(fichero);
            bucle(longitudPass);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Pepe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
