/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici1;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class Exercici1 {

    public static File archiu = new File("moneda.txt");
    public static int totalCares;
    public static int totalCreus;
    public static int contExecucions = 1;

    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(100);

        for (int i = 1; i <= 100; i++) {

            executor.execute(new ExecutaFil(i));

        }
        executor.shutdown();
        String lineaEscriure;

        if (totalCares > totalCreus) {
            FileWriter fw;
            try {
                fw = new FileWriter(archiu, true);

                lineaEscriure = "Llançament " + contExecucions + ": cara" + "(" + totalCares + "/" + totalCreus + ")\n";
                fw.write(lineaEscriure);
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Exercici1.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (totalCreus > totalCares) {
            FileWriter fw;
            try {
                fw = new FileWriter(archiu, true);

                lineaEscriure = "Llançament " + contExecucions + ": creu" + "(" + totalCares + "/" + totalCreus + ")\n";
                fw.write(lineaEscriure);
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Exercici1.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (totalCares == totalCreus) {
            FileWriter fw;
            try {
                fw = new FileWriter(archiu, true);

                lineaEscriure = "Llançament " + contExecucions + ": empat" + "(" + totalCares + "/" + totalCreus + ")\n";
                fw.write(lineaEscriure);
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Exercici1.class.getName()).log(Level.SEVERE, null, ex);
            }
            int total = totalCares+totalCreus;
            System.out.println("Total de tiraes: "+total+" CARES: "+totalCares+ " CREUS: "+totalCreus);
            contExecucions++;
        }
    }

    static class ExecutaFil implements Runnable {

        private int cont;

        public ExecutaFil(int cont) {
            this.cont = cont;
        }

        @Override
        public void run() {
            int tirades = 1000;
            int voltesCara = 0;
            int voltesCreu = 0;
            int random;

            for (int i = 0; i < 1000; i++) {
                random = (int) (Math.random() * 1000);
                if (random % 2 == 0) {
                    voltesCara++;
                } else {
                    voltesCreu++;
                }
            }
            String lineaEscriure;
            lineaEscriure = "Fill " + this.cont + ":Cares: " + voltesCara + " ," + " Creus: " + voltesCreu + "\n";
            System.out.println(lineaEscriure);
            totalCares += voltesCara;
            totalCreus += voltesCreu;

            {

            }

        }
    }
}
