/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mosquedemono;

import java.util.Random;

/**
 *
 * @author vesprada
 */
public class MosQuedemONo {

    /**
     * @param args the command line arguments
     */
    public static final int PORCENTAJE = 100;
    
    public static void main(String[] args) {
        // si ix superior a 50 se queda sino se'n va a casa
        
        
        Random numero = new Random() ;
        
        int num = numero.nextInt(PORCENTAJE);
        if(num>50){
            System.out.println("EN CLASE SE QUEDA");
        }else{
            System.out.println("Santa claus");
        }
        
    }
    
}
