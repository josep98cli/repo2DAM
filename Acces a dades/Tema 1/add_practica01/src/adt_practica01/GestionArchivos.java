/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_practica01;

import java.io.File;


/**
 *
 * @author vesprada
 */
public class GestionArchivos {
    
        private String nombreCarpeta;
        private String nuevaCarpeta;
        private String nombreArchivo;

    public GestionArchivos(String nombreCarpeta, String nuevaCarpeta, String nombreArchivo) {
        this.nombreCarpeta = "/home/vesprada/Escriptori/";
        this.nuevaCarpeta = nuevaCarpeta;
        this.nombreArchivo = nombreArchivo;
    }

    public String getNombreCarpeta() {
        return nombreCarpeta;
    }

    public void setNombreCarpeta(String nombreCarpeta) {
        this.nombreCarpeta = nombreCarpeta;
    }

    public String getNuevaCarpeta() {
        return nuevaCarpeta;
    }

    public void setNuevaCarpeta(String nuevaCarpeta) {
        this.nuevaCarpeta = nuevaCarpeta;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    
    public void listarCarpetaTrabajo(){
        File carpetaUsu = new File(nombreCarpeta);
        File[] arrayCarpeta = carpetaUsu.listFiles();
        
        for (int i = 0; i < arrayCarpeta.length; i++) {
            System.out.println(arrayCarpeta[i].getName());
        }
    }
    
    public String informacionDetallada(){
    
        String informacionDetallada="";
        String nombreCarpetaInfo = nombreArchivo;
        
        File ficheroInformacion = new File(nombreCarpeta + nuevaCarpeta);
        File [] ficheroList = ficheroInformacion.listFiles();
        
        for (int i = 0; i < ficheroList.length; i++) {
            if (ficheroList[i].getName().equals(nombreCarpetaInfo)) {
                informacionDetallada = "Nombre: "+ficheroList[i].getName();
                
                if (ficheroList[i].isDirectory()) {
                    informacionDetallada += "\nTipo: "+ "Directorio"; 
                }else{
                    informacionDetallada += "\nTipo: "+ "Fichero";
                }
                
                informacionDetallada += "\nLongitud: " + ficheroList[i].length();
                
                informacionDetallada += "\nUbicación " + ficheroList[i].getAbsolutePath();
                
                informacionDetallada += "\nUltima modificación" + ficheroList[i].lastModified();
            }
        }
        
        
        
        return informacionDetallada;
    }
    
    
    public void creaCarpeta(){
        File fileCarpeta = new File(nombreCarpeta + nuevaCarpeta);
        
        if (!fileCarpeta.mkdir()) {
            System.out.println("El archivo no se puede crear");
        }else{
            fileCarpeta.mkdir();
            System.out.println("Carpeta creada");
        }
    }
    
    public void creaFichero(){}
    
    public void eliminaFichero(){}  

    

        
}

