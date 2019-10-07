/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.simarro;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class app {

    public static void main(String[] args) {

        try {
            Scanner s = new Scanner(System.in);
            String rutaOrigen;
            String rutaDestino;

            //le pido al usuario que introduzca las carpeta de origen y destino
            //System.out.println("Introduzca la carpeta de origen");
            //rutaOrigen = s.next();
            rutaOrigen = "/home/vesprada/Escriptori/imgOrigen/index.jpeg";

            //System.out.println("Introduzca la carpeta de destino");
            //rutaDestino = s.next();
            //rutaDestino = "/home/vesprada/NetBeansProjects/Reto1JosepCliment/imgDestino/";
            //Creo dos files con las rutas que ha introducido el usuario
            File carpetaOrigen = new File(rutaOrigen);
            //File carpetaDestino = new File(rutaDestino);
            //Metadata meta = ImageMetadataReader.readMetadata(carpetaOrigen);

            Metadata metadata = ImageMetadataReader.readMetadata(carpetaOrigen);

            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    System.out.println(directory.getName() + tag.getTagName() + tag.getDescription());
                            
                }
                if (directory.hasErrors()) {
                    for (String error : directory.getErrors()) {
                        System.err.format("ERROR: %s", error);
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
