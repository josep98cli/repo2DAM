/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasexamen;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class RepasExamen {

    

    public static void main(String[] args) throws IOException, FileNotFoundException {
        
        Scanner s = new Scanner(System.in);
        GestionVehiculos gv = new GestionVehiculos();
        
        int numop = 0;
        while (numop != 3) {
            menu();
            numop = s.nextInt();
            switch (numop) {
                case 1: {
                    gv.insertarVehiculos();
                }
                break;

                case 2:

                    gv.leerVehiculo();

                    break;

                case 3:
                    break;
            }
        }

    }

    public static void menu() {
        System.out.println("1-Insertar vehiculo\n"
                + "2.-Visualizar vehiculos\n"
                + "3.-Salir\n");

    }

   

}
