/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorsconsumidors;

import java.util.ArrayDeque;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josep
 */
public class ProductorsConsumidors {

    private static ArrayDeque cua = new ArrayDeque(10);
    private static int produits = 1;
    private static int consumits = 1;

    private static final Semaphore MUTEX = new Semaphore(1);
    private static final Semaphore PROD_CUA = new Semaphore(10);
    private static final Semaphore CONS_CUA = new Semaphore(0);

    static class Productors extends Thread {

        private int ident;

        public Productors(int ident) {
            this.ident = ident;
        }

        @Override
        public void run() {
            try {

                for (int i = 0; i < 20; i++) {

                    PROD_CUA.acquire();
                    MUTEX.acquire();

                    int random = new Random().ints(0, 100).findFirst().getAsInt();
                    cua.addLast(random);

                    Thread.sleep(new Random().longs(0, 900).findFirst().getAsLong());

                    System.out.println("Hem produit" + "(" + ident + "): " + cua + " Produits: " + produits);
                    produits++;

                    MUTEX.release();
                    CONS_CUA.release();

                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ProductorsConsumidors.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    static class Consumidors extends Thread {

        private int ident;

        public Consumidors(int ident) {
            this.ident = ident;
        }

        @Override
        public void run() {
            try {
             
                    for (int i = 0; i < 20; i++) {
                        CONS_CUA.acquire();
                        MUTEX.acquire();

                        Thread.sleep((long) (Math.random() * 900));

                        cua.pollFirst();

                        System.out.println("Hem consumit" + "(" + ident + ")" +cua+ " Consumits: " + consumits);
                        consumits++;

                        MUTEX.release();
                        PROD_CUA.release();
                    }
                    
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ProductorsConsumidors.class.getName()).log(Level.SEVERE, null, ex);
            }
      
        }

    }

    public static void main(String[] args) {

        for (int i = 1; i < 6; i++) {
            new Productors(i).start();
            new Consumidors(i).start();
        }

    }
}
