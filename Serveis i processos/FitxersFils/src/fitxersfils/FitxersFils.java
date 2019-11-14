/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitxersfils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class FitxersFils {

    private static final Semaphore MUTEX = new Semaphore(1);
    private static final Semaphore IMPARELLS = new Semaphore(0);

    public static class LiniesParells extends Thread {

        private int id;

        public LiniesParells() {
        }

        public LiniesParells(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                IMPARELLS.acquire();
                MUTEX.acquire();
                String linia;
                File fichero = new File("/home/vesprada/repoDam/repo2DAM/Serveis i processos/FitxersFils/fitxer.txt");
                BufferedReader br = new BufferedReader(new FileReader(fichero));
                while ((linia = br.readLine()) != null) {

                }

            } catch (InterruptedException ex) {
                Logger.getLogger(FitxersFils.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FitxersFils.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FitxersFils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    public static class LiniesInparells extends Thread {

        private int id;

        public LiniesInparells() {
        }

        public LiniesInparells(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                MUTEX.acquire();

            } catch (InterruptedException ex) {
                Logger.getLogger(FitxersFils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void main(String[] args) {

        new LiniesInparells().start();
        new LiniesParells().start();

    }

}
