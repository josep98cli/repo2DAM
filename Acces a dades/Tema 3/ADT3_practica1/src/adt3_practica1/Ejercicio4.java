/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt3_practica1;

import clasesejercicio4.Alumno;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author vesprada
 */
public class Ejercicio4 {

    public static void main(String[] args) {
        
        ArrayList <Alumno> listaAlumnos = new ArrayList<>();

        File fichero = new File("ejercicio4.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fichero);
            
            NodeList nlist = doc.getElementsByTagName("alumne");
            
            for (int i = 0; i < nlist.getLength(); i++) {
                Node nNode = nlist.item(i);
                
                if (nNode.getNodeType()==Node.ELEMENT_NODE) {
                      Element element = (Element) nNode;
                      
                      String id = element.getAttribute("id");
                                        
                      String nom = element.getElementsByTagName("nom").item(0).getTextContent(); 
                      String cognom=element.getElementsByTagName("cognom").item(0).getTextContent();
                      String curs=element.getElementsByTagName("curs").item(0).getTextContent();
                        int nota = Integer.parseInt(element.getElementsByTagName("nota").item(0).getTextContent()); 
                     Alumno alumne = new Alumno(id, nom, cognom, curs, nota);
                     listaAlumnos.add(alumne);
                }
              
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        for (int i = 0; i < listaAlumnos.size(); i++) {
            System.out.println(listaAlumnos.get(i).toString());
        }
    }

}
