/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semafors_thread;

/**
 *
 * @author vesprada
 */
public class Main {
    public static void main(String[] args) {
        //crear i ficar en marxa els 2 processos
        
        for (int i = 0; i < 5; i++) {
            new Thread(new procesHolaMon(2)).start();
            new Thread(new procesHolaMon(1)).start();
        }
        
    }
}
