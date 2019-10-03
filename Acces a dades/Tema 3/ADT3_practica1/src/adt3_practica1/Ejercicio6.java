/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt3_practica1;

import clasesejercicio4.Alumno;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
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
public class Ejercicio6 {
     public static void main(String[] args) {

        ArrayList<Alumno> listaAlumnosDAM = new ArrayList<>();
        ArrayList<Alumno> listaAlumnosASIX = new ArrayList<>();

        File fichero = new File("ejercicio4.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fichero);

            NodeList nlist = doc.getElementsByTagName("alumne");

            for (int i = 0; i < nlist.getLength(); i++) {
                Node nNode = nlist.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;

                    String id = element.getAttribute("id");

                    String nom = element.getElementsByTagName("nom").item(0).getTextContent();
                    String cognom = element.getElementsByTagName("cognom").item(0).getTextContent();
                    String curs = element.getElementsByTagName("curs").item(0).getTextContent();
                    int nota = Integer.parseInt(element.getElementsByTagName("nota").item(0).getTextContent()); 
                    Alumno alumne = new Alumno(id, nom, cognom, curs, nota);
                    
                    if (alumne.getCurs().equals("2nDAM")) {
                        listaAlumnosDAM.add(alumne);
                    } else {
                        listaAlumnosASIX.add(alumne);
                    }
                    
                    listaAlumnosDAM.sort(new Comparator<Alumno>() {
                        @Override
                        public int compare(Alumno o1, Alumno o2) {
                            if (o1.getNota()>o2.getNota()) {
                                return -1;
                            }else{
                                return 0;
                            }
                        }
                    });
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
            System.out.println("ALUMNOS ORDENADOS DE MAYOR A MENOR NOTA : \n");
            System.out.println("ALUMNOS EN DAM: ");
            for (int i = 0; i < listaAlumnosDAM.size(); i++) {
                System.out.println(listaAlumnosDAM.get(i).toString());
            }
            
            System.out.println("\nALUMNOS EN ASIX: ");
            
            for (int i = 0; i < listaAlumnosASIX.size(); i++) {
                System.out.println(listaAlumnosASIX.get(i).toString());
        }
    }
}
