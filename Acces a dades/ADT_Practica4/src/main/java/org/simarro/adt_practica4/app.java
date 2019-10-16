/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.simarro.adt_practica4;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author vesprada
 */
public class app {

    public static String sacarAnyo(Document documentPelicula, Elements infoPelicula) {

        Element lista = infoPelicula.first();
        return lista.child(3).text();

    }

    public static String sacarTitulo(Document documentPelicula, Elements infoPelicula) {

        Element lista = infoPelicula.first();
        return lista.child(1).text();
    }

    public static void sacarInfo(String id) {

        try {
            String urlPelicula = "https://www.filmaffinity.com/es/film" + id + ".html";
            Document documentPelicula = Jsoup.connect(urlPelicula).get();

            Elements infoPelicula = documentPelicula.getElementsByClass("movie-info");
            String titulo = sacarTitulo(documentPelicula, infoPelicula);
            //String ano = sacarAnyo(documentPelicula, infoPelicula);
            System.out.println(titulo);

        } catch (IOException ex) {
            ex.getMessage();
        }

    }

    public static void main(String[] args) {

        
        try {
            String url = "https://www.filmaffinity.com/es/cat_new_th_es.html";
           
            Document doc = Jsoup.connect(url).get();
            //Saco los titulos de todas las peliculas y consigo el id para acceder a cada una de las URL de las peliculas
            Elements parhaps = doc.getElementsByClass("movie-poster");
            
            for (Element img : parhaps) {
                String attr = img.attr("data-movie-id");
                System.out.println(attr);
                sacarInfo(attr);
            }

        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}
