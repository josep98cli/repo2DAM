package ordreexecucio;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class OrdreExecucio {

	static class Ordre implements Runnable{
		//atributs identificador
		private int ordre;
		
		//constructor
		public Ordre(int ordre) {
			this.ordre=ordre;
		}
		//funcio obligatòria de la interfície
		@Override
		public void run() {
			
			try {
				int millisegons = (int) (Math.random()*1000);
				System.out.println("Tasca: "+this.ordre+" Dormint: "+millisegons+" millisegons");
				Thread.sleep(millisegons);
				
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Tasca "+this.ordre+" ha acabat");
		}
		
	}
	public static void main(String[] args) throws InterruptedException{
		//instanciem el gestor de fils
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10); 
		
		//Executar objectes
		for (int i = 0; i < 10; i++) {
			executor.execute(new Ordre(i));
		}
		System.out.println("Nombre de fils: "+executor.getPoolSize());
		executor.shutdown();
	}

}
