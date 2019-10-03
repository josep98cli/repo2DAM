/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_practica3_2;


import java.io.FileInputStream;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.xml.sax.InputSource;

import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author josep
 */
public class ADT_Practica3_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {  
         // Creamos la factoria de parseadores por defecto  
         XMLReader reader = XMLReaderFactory.createXMLReader();  
         // Añadimos nuestro manejador al reader  
         reader.setContentHandler(new ManejadorSAX());           
         // Procesamos el xml de ejemplo  
         reader.parse(new InputSource(new FileInputStream("ejercicio1.xml")));  
         
      }catch (Exception ex) {  
            Logger.getLogger(ADT_Practica3_2.class.getName()).log(Level.SEVERE, null, ex);
      }

    }
    
}
