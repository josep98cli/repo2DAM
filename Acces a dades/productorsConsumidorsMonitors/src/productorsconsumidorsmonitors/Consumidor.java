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
class Consumidor implements Runnable{
      private MonitorBuffer buff;

    public Consumidor(MonitorBuffer b) {
        this.buff = b;
    }

    @Override
    public void run() {
        int num;
        for (int i = 0; i < 10; i++) {
            //obtenim el numero corresponent
            num = buff.agafar();
            System.out.println("Consumidor: Número agafat: "+num);
            
            try{
               Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      
}
