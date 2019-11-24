package activitat1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Activitat1 {

    static class Multiple implements Callable<Boolean> {

        private int numero;
        //constructor

        public Multiple(int numero) {
            this.numero = numero;
        }

        //Override de call
        @Override
        public Boolean call() throws Exception {
            if ((numero % 2) == 0 && (numero % 3) == 0) {
                return true;
            }
            return false;
        }

    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        List<Multiple> llistaMultiple = new ArrayList<Multiple>();

        for (int i = 0; i < 10; i++) {
            Multiple mult = new Multiple(i);
            Future<Boolean> ft = executor.submit(mult);
            System.out.println(ft);
        }
    }

}
