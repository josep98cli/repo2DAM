/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici3;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class Exercici3 {

    static class Tasca extends RecursiveTask<Short> {

        private static final int LLINDAR = 5;
        private short[] array;
        private int inici, fi;
        private static int parells, imparells,nombresTres;
        private static final Semaphore MUTEX = new Semaphore(1);
        

        public Tasca(short[] array, int inici, int fi) {
            this.array = array;
            this.inici = inici;
            this.fi = fi;
        }

        private short getMaxSequencial() {
            short max = array[inici];
            for (int i = inici + 1; i < fi; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            return max;
        }

        private short getMaxRecursiu() {
            Tasca t1;
            Tasca t2;
            int mig = (inici + fi) / 2 + 1;
            t1 = new Tasca(array, inici, mig);
            t1.fork();
            t2 = new Tasca(array, mig, fi);
            t2.fork();
            return (short) Math.max(t1.join(), t2.join());
        }

       @Override
        protected Short compute() {
            if (fi - inici <= LLINDAR) {
                return getMaxSequencial();
            } else {
                return getMaxRecursiu();
            }
        }

        public static void main(String[] args) {
            short[] dades = createArray(500000);
            
            ForkJoinPool pool = new ForkJoinPool();
            int inici = 0;
            int fi = dades.length;
            Tasca tasca = new Tasca(dades, inici, fi);

            long time = System.currentTimeMillis();
           
            int result1 = (int) pool.invoke(tasca);
           
            int result = tasca.join();
            
            
            System.out.println("Numeros de parells: " + parells);
            System.out.println("Numero de imparells: " + imparells);
            System.out.println("Quantitat de nombres 3: "+nombresTres);
            System.out.println("Quantitat total de nombres: 500000");
        }

        private static short[] createArray(int size) {
            try {
                short[] ret = new short[size];
                MUTEX.acquire();
                for (int i = 0; i < size; i++) {
                    ret[i] = (short) (Math.random() * 500000);
                    
                    if (ret[i]==3) {
                        nombresTres++;
                    }
                    
                    if (ret[i] % 2 == 0) {
                        parells++;
                        
                    } else {
                        imparells++;
                        
                    }
                    MUTEX.release();
                }
                return ret;
            } catch (InterruptedException ex) {
                Logger.getLogger(Exercici3.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

    }
}
