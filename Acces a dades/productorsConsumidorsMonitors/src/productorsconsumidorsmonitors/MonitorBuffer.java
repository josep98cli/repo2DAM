/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorsconsumidorsmonitors;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
class MonitorBuffer {

    //recurs compratit: array 10 integers
    
    private int buffer[] = new int[10];
    private int indexArray = 0;
    private boolean bufferPle = false;
    private boolean bufferBuit = true;
    
    
    public synchronized int agafar() {
        //Mentre el buffer estiga buit, espera
        while(bufferBuit){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(MonitorBuffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //ha d'actualitzar el valor de la posició de l'element en l'array
        indexArray--;
        //Mostrem el valor de l'element agafat de l'index a agafar
        System.out.println("Index de la array de l'element de l'array a agafar: "+indexArray);
        
        //si ja no queden elements pern consumir
        
        if(indexArray==0){
            bufferBuit=true; //el buffer esta buit
        }
        //el buffer segur que ja no esta ple
        bufferPle=false;
        //avisem que ja es pot accedir al buffer per a produir
        notify();
        //retornem el valor de l'element extret
        return (buffer[indexArray]);
    }
    
    //metode per afegir un element al buffer
    public synchronized void afegir(int numero) {
        //mentres el buffer estiga ple espera
        
        while(bufferPle){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(MonitorBuffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        buffer[indexArray] = numero;
        //mostrem per pantalla el element afegit
        
        System.out.println("Index de l'element de l'array afegit: "+indexArray);
        //incrementem el index
        indexArray++;
        //Actualitzem els valors de les variables de condició
        if (indexArray==10) {
            bufferPle=true;
        }
        //el buffer segur que no esta buit
        bufferBuit=false;
        //avisem als processo que ja poden accedir al buffer per consumir
        notify();
        
    }
    
}
