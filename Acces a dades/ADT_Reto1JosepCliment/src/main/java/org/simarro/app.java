/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.simarro;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class app {
	
	
	public static void crearCarpetas(String fechaMod, File imagen, File rutaDestino) {
		System.out.println("Ha entrado");
		String []arrayFecha = fechaMod.split(" ");
		String nomImagen =	imagen.getPath();
		
		String fechaOrdenada = arrayFecha[2]+arrayFecha[1]+arrayFecha[5];
		File carpetaFecha = new File(rutaDestino + "/" + fechaOrdenada);
		String destino = rutaDestino.getAbsolutePath()+"/"+fechaOrdenada+"/"+imagen.getName();
		if (!carpetaFecha.exists()) {
			if (carpetaFecha.mkdirs()) {
			imagen.renameTo(new File(destino));
			}
		}else {
			imagen.renameTo(new File(destino));
		}
	}
	
	
    public static void main(String[] args) {

        try {
            Scanner s = new Scanner(System.in);
            String rutaOrigen;
            String rutaDestino;

            //le pido al usuario que introduzca las carpeta de origen y destino
            //System.out.println("Introduzca la carpeta de origen");
            //rutaOrigen = s.next();
            rutaOrigen = "img";

            //System.out.println("Introduzca la carpeta de destino");
            //rutaDestino = s.next();
            
            //Creo dos files con las rutas que ha introducido el usuario
            File carpetaOrigen = new File(rutaOrigen);
            File carpetaDestino = new File("finImagen");

           
            String fechaMod="";
            
            String []arr_res = null;
            if (carpetaOrigen.isDirectory()) {
				File[] arr_content = carpetaOrigen.listFiles();
				
				for (int i = 0; i < arr_content.length; i++) {
					if (arr_content[i].isFile()) {
						
						 Metadata metadata = ImageMetadataReader.readMetadata(arr_content[i]);
						 for (Directory directory : metadata.getDirectories()) {
				                for (Tag tag : directory.getTags()) {
				                    fechaMod = directory.getDescription(3);  
				                }
				              
				                if (directory.hasErrors()) {
				                    for (String error : directory.getErrors()) {
				                        System.err.format("ERROR: %s", error);
				                    }
				                }
				            }
				           crearCarpetas(fechaMod, arr_content[i],carpetaDestino);
				           
					}
				}
			}
            
            
        } catch (ImageProcessingException ex) {
            Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
