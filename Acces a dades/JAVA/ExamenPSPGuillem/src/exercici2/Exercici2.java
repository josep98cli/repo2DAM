/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici2;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class Exercici2 {

    public static ArrayList<String> paraulesArray = new ArrayList<>();
    private final static int NUM_PARTICIPANTS = 5;
    private final static int MAX_LLETRES = 10;
    private static final Semaphore MUTEX = new Semaphore(1);
    
    public static ArrayList<String> paraulesVocabulary = new ArrayList<>();

    public static void main(String[] args) {

        //asci desde la 65 a la 122
        char paraula = 65;

        for (int i = 0; i < 26; i++) {

            String p = String.valueOf(paraula);
            paraulesVocabulary.add(p);
            paraula++;
        }

        for (int i = 0; i < NUM_PARTICIPANTS; i++) {
            Participant p1 = new Participant(i);
            p1.start();

        }
         String paraulesEncadenades="";
        for (int i = 0; i < paraulesArray.size(); i++) {
            paraulesEncadenades += paraulesArray.get(i);
          
          
        }
          System.out.println("Paraules encadenades:  "+paraulesEncadenades);
          
    }

    static class Participant extends Thread {

        private int cont;
        private boolean buit = true;
        private int contparaules = 0;
        public Participant(int cont) {
            this.cont = cont;
        }

        @Override
        public void run() {
           
            while (buit) {
                
                try {
                   
                    MUTEX.acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Exercici2.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (contparaules == 20) {
                  
                    buit = false;
                }
                if (paraulesArray.size() == 0) {
                   
                    String paraula = "";
                    for (int i = 0; i < MAX_LLETRES; i++) {
                        int random = (int) (Math.random() * paraulesVocabulary.size());
                        paraula = paraula + paraulesVocabulary.get(random);
                        paraulesArray.add(paraula);
                       
                    }
                     contparaules++;
                    System.out.println("Participant: " + this.cont + " Paraula " + paraula);

                }
                else if (paraulesArray.size() > 0) {

                    String paraula = paraulesArray.get(paraulesArray.size()-1);
                  
                    paraula =paraula.substring(9,10);

                    for (int i = 0; i < MAX_LLETRES - 1; i++) {
                        int random = (int) (Math.random() * paraulesVocabulary.size());
                        paraula = paraula + paraulesVocabulary.get(random);
                        paraulesArray.add(paraula);
                        
                    }
                    contparaules++;
                    System.out.println("Participant: " + this.cont + " Paraula " + paraula);

                }
                
            MUTEX.release();
            }
            
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Exercici2.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
