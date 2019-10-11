package scrapingserveisjosepcliment;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class app {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException  {
		
		try{
			
		//Creo una instancia del gestor de hilos ThreadPoolExecuto con 50 hilos (uno para cada pelicula)
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(50);
		List<Pelicules> llistaTasques = new ArrayList<Pelicules>(50);
		
			 FileWriter filewriter = new FileWriter("resultat.html");;
			 PrintWriter printw = new PrintWriter(filewriter);
		           
		     printw.println("<html>");
		     printw.println("<head><title>ExerciciPelicules</title></head>");    
		
		//compruebo la longitud de la cadena y completo con 0 en la parte izquierda hasta que la longitud sea 5
		for (int i = 0; i < 50; i++) {
			Pelicules pel = new Pelicules();
			llistaTasques.add(pel);
		}
			
		List<Future<String[]>> listaResultados;
			listaResultados = executor.invokeAll(llistaTasques);
			executor.shutdown();
			for (int i = 0; i <listaResultados.size(); i++) {
				//String resultat = listaResultados.get(i).get();
					String []arrayFinal = listaResultados.get(i).get();
					System.out.println("Nom pelicula: "+arrayFinal[0]);
					System.out.println("Id pelicula: "+ "/tt00"+arrayFinal[1]+"\n");
					String urlFinal="https://www.imdb.com/title/tt00"+arrayFinal[1]+"/";
					printw.println("<div><a href="+urlFinal+">"+arrayFinal[0]+"</a></div>");
				   
			}
			 
			     printw.println("</body>");
			     printw.println("</html>");
			          
			     printw.close();//cerramos el archivo
			           
			     System.out.println("Generado exitosamente");//si todo sale bien mostramos un mensaje de guardado exitoso
		}catch (Exception e) {
			e.getMessage();
		}
	}
}

