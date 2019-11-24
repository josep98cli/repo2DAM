/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.simarro.acumulador;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class Acumulador {
    
    static class Sumador implements Runnable{
        
        private static int valorSuma=0;
        
        private static final Semaphore MUTEX = new Semaphore(1);

        //atribut
        private int id;

        public Sumador(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            
            try {
                MUTEX.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(Acumulador.class.getName()).log(Level.SEVERE, null, ex);
            }
            valorSuma++;
            System.out.println("Procés "+id+": "+valorSuma);
            MUTEX.release();
            
        }
        
        
    }
    
    public static void main(String[] args) {
        
        //Gestor de fils
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20);
        
        //variable qiamtitat de processos
        int N = 1000;
        //hem de cridar a N processos Sumador
        for (int i = 1; i <= N; i++) {
            executor.execute(new Sumador(i));
        }
        //no podem afegir més processos al gestor
        executor.shutdown();
    }
}
