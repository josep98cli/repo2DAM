/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_practica3_2;

import java.util.ArrayList;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;  
import org.xml.sax.SAXException;

/**
 *
 * @author josep
 */
public class ManejadorSAX extends DefaultHandler{
    ArrayList<Receta> listaRecetas = new ArrayList();
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("\nProcesando texto dentro de una etiqueta... ");  
      System.out.println("\tTexto: "+String.valueOf(ch, start, length)); 
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
       System.out.println("\nFin de etiqueta...");  
      System.out.println("\tNamespace uri: "+uri);  
      System.out.println("\tNombre: "+localName);  
      System.out.println("\tNombre con prefijo: "+qName); 
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("ENTRA START ELEMENT");
        Receta receta = new Receta();
        for (int i = 0; i < attributes.getLength(); i++) {
            
            
            if (attributes.getQName(i).equals("tipo")) {
                receta.setTipo(attributes.getValue(i));
                
            }else if(attributes.getQName(i).equals("nombre")){
                receta.setNombre(attributes.getValue(i));
                
            }else if(attributes.getQName(i).equals("descripcion")){
                receta.setDescripcion(attributes.getValue(i));
            }
        }
        if (receta.getTipo()!=null) {
            System.out.println("ENTRA IF");
            listaRecetas.add(receta);
        }
        String valorReceta = receta.getTipo();
        if (valorReceta!=null) {
            System.out.println("\tValor Receta"+valorReceta);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Final del documento");
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Principio del documento ");
    }
    
}
