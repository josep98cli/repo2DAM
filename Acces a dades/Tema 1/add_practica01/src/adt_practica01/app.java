/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_practica01;

import java.util.Scanner;

/**
 *
 * @author vesprada
 */
public class app {
    
    public static void menu(){
    
        System.out.println("1.- Asignar carpeta de trabajo\n"
                + "2.- Listado de la carpeta de trabajo\n"
                + "3.-Información detallada de un archivo\n"
                + "4.-Creación de un directorio\n"
                + "5.-Creación de un fichero\n"
                + "6.-Eliminación de un fichero\n"
                + "7.-Salir");
    }
    
    public static void main(String[] args) {
        
        Scanner s  = new Scanner(System.in);
        GestionArchivos gestion = new GestionArchivos("","","");
        
        
        int numop = 0;
        
        do{
        menu();
        
        System.out.println("Elija una opcion");
        numop = s.nextInt();
        
        
            switch(numop){
                case 1:
                    System.out.println("Introduzca nombre de la carpeta: ");
                    String rutaUsu = s.next();
                    
                    gestion.setNuevaCarpeta(rutaUsu);
                    gestion.creaCarpeta();
                    
                    break;
                case 2:
                    gestion.listarCarpetaTrabajo();
                    break;
                case 3:
                    System.out.println("Introduce nombre directorio");
                    gestion.setNombreArchivo(s.next());
                    
                    System.out.println(gestion.informacionDetallada());
                    break;
                    
                case 7:
                    System.out.println("Saliendo..");
                    break;
                    
                    
                    
            }
            
        }while(numop!=7);
        
    }
    
}
