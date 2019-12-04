/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorsconsumidorsmonitors;

/**
 *
 * @author vesprada
 */
public class ProductorsConsumidorsMonitors {

    /**
     * programa principal
     */
    public static void main(String[] args) {
        // creem el monitor:  buffer
        
        MonitorBuffer buffer = new MonitorBuffer();
        //Creem productor
        Productor p = new Productor(buffer);
        //Creem consumidor
        Consumidor c = new Consumidor(buffer);
        //Creem els fils
        Thread productor = new Thread(p);
        Thread consumidor = new Thread(c);
        //Els fiquem en marcha

        productor.start();
        consumidor.start();
        
    }
    
}
