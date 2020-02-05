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
import org.w3c.dom.NodeList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vesprada
 */
public class Ejercicio1 {
    
    public static void main(String[] args) {
        
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            
            Document document = builder.parse("ejercici1.xml");
            
            Element rootElement = document.getDocumentElement();
            NodeList prestamo = (NodeList) document.getElementsByTagName("prestamo");
            
            Element libro = document.createElement("libro");
            Element titulo = document.createElement("titulo");
            Element autor = document.createElement("autor");
            Element año = document.createElement("año");
            Element editorial = document.createElement("editorial");
            
            libro.setAttribute("isbn", "84-857-547-R");
            titulo.setTextContent("Pepe 11");
            autor.setTextContent("Pepe");
            año.setTextContent("1990");
            editorial.setTextContent("Eclipse");
            
            libro.appendChild(titulo);
            libro.appendChild(autor);
            libro.appendChild(año);
            libro.appendChild(editorial);
            
            prestamo.item(0).appendChild(libro);
            
             Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.METHOD, "xml");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            
            
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("ejercici1.xml"));
            
            trans.transform(source, result);
        } catch (Exception ex) {
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
