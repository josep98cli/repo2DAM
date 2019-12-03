/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorsconsumidorsmonitors;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
class Productor implements Runnable{

    private MonitorBuffer buff;
    
    
    //constructor
    
    public Productor(MonitorBuffer b){
        this.buff = b;
    }
    
    
    
    @Override
    public void run() {
        //valor aleatori
        int numero = 0;
        Random rn = new Random();
        //Produira 10 elements
        for (int i = 0; i < 10; i++) 
        {
           // generem numero aleatori
            numero = rn.nextInt(100);
            System.out.println("Productor: Numero produit: "+numero);
            //inserim l'element en el buffer
            buff.afegir(numero);
            
            
            try{
               Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
