/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semafors_thread;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class procesHolaMon implements Runnable {

    //inicialitzem el semàfor, inicialment a 0 (en roig)
    private static final Semaphore SEMAFOR = new Semaphore(1);
    private static final Semaphore SEMAFOR2 = new Semaphore(0);
    
    private int nProces;

    public procesHolaMon(int nProces) {
        this.nProces = nProces;
    }

    @Override
    public void run() {

        if (nProces == 1) {
            try {
                SEMAFOR.acquire();
                System.out.print("Hola...");
                SEMAFOR2.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(procesHolaMon.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (nProces == 2) {
            try {
                SEMAFOR2.acquire();
                System.out.println("..Mon");
                SEMAFOR.release();
                
            } catch (InterruptedException ex) {
                ex.getMessage();
            }
        }
    }

}
