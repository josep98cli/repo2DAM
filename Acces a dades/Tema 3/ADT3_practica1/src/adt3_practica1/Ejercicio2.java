/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt3_practica1;


import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author vesprada
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            
            Document document = builder.newDocument();
           
            Element alumnos = document.createElement("alumnos");
            Element alumno = document.createElement("alumno");
            Element nombre = document.createElement("nombre");
            Element apellido = document.createElement("apellido");
            Element edad = document.createElement("edad");
            
            nombre.setTextContent("Juan");
            apellido.setTextContent("Marti Lopez");
            edad.setTextContent("18");
            
            alumno.appendChild(nombre);
            alumno.appendChild(apellido);
            alumno.appendChild(edad);
            
            alumnos.appendChild(alumno);
            
            document.appendChild(alumnos);
            
            
  
            nombre = document.createElement("nombre");
            apellido = document.createElement("apellido");
            edad = document.createElement("edad");
            
            nombre.setTextContent("Pepe");
            apellido.setTextContent("Martinez Juan");
            edad.setTextContent("58");
            
            alumno.appendChild(nombre);
            alumno.appendChild(apellido);
            alumno.appendChild(edad);
            
            alumnos.appendChild(alumno);
            
            Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.METHOD, "xml");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("ejercici2.xml"));
            trans.transform(source, result);
            
        } catch (Exception ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
