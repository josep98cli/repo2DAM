/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicagaletessip;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author vesprada
 */
public class main {
    
    //pot de galetes a 10
    
    private static int galetes=10;
    
    //semáfor indica que la mare ha reposat el pot
    private static final Semaphore NO_HI_HA_GALETES = new Semaphore(0);
    
    //semafor indicador que hi ha galetes 
    private static final Semaphore HI_HA_GALETES = new Semaphore(1);
    
    
    //semáfor per al acces en exclusió mútua
    private static final Semaphore MUTEX = new Semaphore(1);
    
    //procés que executa cada xiquet
    static class Xiquet extends Thread{
        // atribut indentificador
        private int ident;
         // constructor

        public Xiquet(int ident) {
            this.ident = ident;
        }
         public void run(){
             //el xiquet ha de menjar 20 galetes
             for (int i = 0; i < 20; i++) {
                 try{
                     
                     //intenta agafar galetes del pot
                     HI_HA_GALETES.acquire();
                     //intenta accedir en exclusió mútua al pot
                     MUTEX.acquire();
                     //comprovem si queden galetes en el pot
                     if (galetes==0) {
                         //el pot esta buit
                         //mostra el missatge
                         System.out.println("El xiquet"+ident+": Mare s'han acabat les galetes");
                         //avisa a la mare
                         NO_HI_HA_GALETES.release();
                     }else{
                         //el xiquet es menja una galeta
                         galetes--;
                         //indica que els atres ja poden accedir al pot
                         
                         MUTEX.release();
                         System.out.println("Galeta "+galetes+" menjada pel xiquet"+ident+"("+i+")");
                         //allibera el pot de galetes
                         HI_HA_GALETES.release();
                         
                     }
                     
                 }catch(InterruptedException e){
                     e.getMessage();
                 }
             }
             
             //esperem un temps aleatori entre 0 i 1s
             
             try{
                 Random rntemps = new Random();
                 int temps = rntemps.nextInt(1000);
                 //para el fil el temps aleatori
                 Thread.sleep(temps);
             }catch(InterruptedException e){
                 e.getMessage();
             }
         
         }
    
    }
    //un únic procés per a la mare
    static class Mare extends Thread{
         public void run(){
             while(true){
             try{
                 //espera que algun xiquet la avise
                 NO_HI_HA_GALETES.acquire();
                 //ha de plenar el pot en exclusió mutua
                 MUTEX.acquire();
                 galetes=10;
                 MUTEX.release();
                 
                 System.out.println("Ja teniu galetes al pot");
                 //avisa als xiquets que ja hi ha galetes
                 HI_HA_GALETES.release();
                 
                 
             }catch(InterruptedException e){
                 e.getMessage();
             }
             }
             
         }
    
    }
    
    public static void main(String[] args) {
       
        //fiquem en marcha la mare
        new Mare().start();
        for (int i = 1; i < 5; i++) {
            new Xiquet(i).start();
        }
        
    }
}
