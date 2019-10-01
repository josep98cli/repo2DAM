package activitat1;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Activitat1{
	
	static class Multiple implements Callable<Boolean>{

	private int numero;
	private int divisor;
	//constructor
	
	public Multiple(int numero, int divisor) {
		this.numero = numero;
		this.divisor=divisor;
	}

	@Override
	public Boolean call() throws Exception {
		if ((numero%divisor)==0) {
			return true;
		}
		return false;
	}
	
	
	
}


	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		List<Multiple> llistaMultiple = new ArrayList<Multiple>();
	}

}

