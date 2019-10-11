package scrapingserveisjosepcliment;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pelicules implements Callable<String[]>{
	@Override
	public String[] call() throws Exception {
		
		String retorno[]=new String[2];
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
			HttpURLConnection huc = (HttpURLConnection) web.openConnection();
			int responseCode = huc.getResponseCode();
			
			BufferedReader entradaWeb = new BufferedReader(new
			InputStreamReader(web.openStream()));
			File ficheroHtml = new File("fitxers/tt00"+cadena+".html");
			
			
			
			if (responseCode!=404) {
				
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
				retorno[0] = array2[1];
				retorno[1] = cadena;
				entradaWeb.close();
			}else {
				for (int i = 0; i < retorno.length; i++) {
					retorno[i]="vacio";
				}
			}
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.getMessage();
		}
		
		return retorno;
	}
			
}


