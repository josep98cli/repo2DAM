/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt1_practica03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author vesprada
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ObjectOutputStream os = null;
        File archiu = new File("vehiculo.bin");
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Elija una opción: ");
            System.out.println("Opcion 1.- Insertar vehículo");
            System.out.println("Opcion 2.- Visualizar vehículos");
            System.out.println("OPcion 3.- Salir");
            int numop = s.nextInt();
            switch (numop) {

                case 1:
                    System.out.println("Introduce la marca.");
                    String marca = s.next();

                    System.out.println("Introduzca el modelo.");
                    String modelo = s.next();

                    System.out.println("Introduzca la matricula.");
                    String matricula = s.next();

                    System.out.println("Introduzca la potencia.");
                    int potencia = s.nextInt();

                    System.out.println("Introduce color.");
                    String color = s.next();
                    Vehiculo v = new Vehiculo(marca, modelo, matricula, potencia, color);
                    if (archiu.length()==0) {
                        os = new ObjectOutputStream(new FileOutputStream(archiu));
                        os.writeObject(v);
                    }else{
                        os = new Append(new FileOutputStream(archiu));
                        os.writeObject(v);
                    }
                    //My name is josep i sol punxar en la masia 
                    
                   
                    os.close();
                    break;

                case 2: {

                    ObjectInputStream is = new ObjectInputStream(new FileInputStream(archiu));
                    try {

                        Vehiculo ve = (Vehiculo) is.readObject();

                        while (ve!=null) {
                            if (ve instanceof Vehiculo) {
                                System.out.println(ve.toString());
                            }
                            ve = (Vehiculo) is.readObject();
                        }

                    } catch (ClassNotFoundException ex) {
                        System.out.println("No se encuentra el archivo");
                    }
                }
                break;

                case 3:
                    System.out.println("Salir");
                    break;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException ex) {
            System.out.println("Fin");
        }
    }

}
