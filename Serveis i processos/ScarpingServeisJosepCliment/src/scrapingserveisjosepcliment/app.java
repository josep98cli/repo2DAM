package scrapingserveisjosepcliment;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
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
	//creo un objeto con callable el qual creara las peliculas
	
	static class Pelicules implements Callable<String>{
		
		//funcion override de callable que retorna la string con el titulo y a�o
		
		@Override
		public String call() throws Exception {
			
			String retorno="";
			try {
				int random = (int)Math.round(Math.random()*99999);
				String cadena=Integer.toString(random);
				
				if (cadena.length()<2) {
					cadena="0000" + cadena;
				}else if(cadena.length()<3) {
					cadena="000" +cadena;
				}else if(cadena.length()<4) {
					cadena = "00" + cadena;
				}else if(cadena.length()<5) {
					cadena = "0" + cadena;
				}
				
				String linia;
				String pattern="<title>";
				
				String array[]=null;
				String array2[]=null;			
				//Creo el patron para buscar donde se situa el titulo con la variable pattern de arriba inicializada a title 
				Pattern patro = Pattern.compile(pattern);
				Matcher m;
				
				boolean haEntrado= false;
				
				URL web = new URL("https://www.imdb.com/title/tt00"+cadena+"/");
				BufferedReader entradaWeb = new BufferedReader(new
				InputStreamReader(web.openStream()));
				File ficheroHtml = new File("fitxers/tt00"+cadena+".html");
				PrintWriter pw = new PrintWriter(ficheroHtml);
				
				//recorro el html y lo guardo en un fichero html de nombre su id.html
				
			
					//recorro el archivo en busca del patron y le hago dos split para conseguir el titulo que se guarda en la posicion 0 de la array[]
					while((linia = entradaWeb.readLine())!=null) {
					
					pw.write(linia);
					m = patro.matcher(linia);
					
					if(m.find() && !haEntrado) {
						array=linia.split("-");
						array2=array[0].split(">");
						haEntrado=true;
					}
				
				}
					pw.close();
				retorno = array2[1];
				entradaWeb.close();
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.getMessage();
			}
			
			return retorno;
		}
				
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException  {
		
		//Creo una instancia del gestor de hilos ThreadPoolExecuto con 50 hilos (uno para cada pelicula)
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(50);
		List<Pelicules> llistaTasques = new ArrayList<Pelicules>(50);
		
		
		//compruebo la longitud de la cadena y completo con 0 en la parte izquierda hasta que la longitud sea 5
		for (int i = 0; i < 50; i++) {
			Pelicules pel = new Pelicules();
			llistaTasques.add(pel);
		}
			
		List<Future<String>> listaResultados;
			listaResultados = executor.invokeAll(llistaTasques);
			executor.shutdown();
			for (int i = 0; i <listaResultados.size(); i++) {
				String resultat = listaResultados.get(i).get();
				
					//--------------error asi---------------------
					System.out.println(i+"pos."+resultat);
					
				
			}
		
	}

}
