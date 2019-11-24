/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_practica02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class app {

    public static void exercici2() {

        String ruta = "F:/Acces a dades/Tema 1/adt_practica02/ImgExercici2/imagen1.png";
        String ruta2 = "F:/Acces a dades/Tema 1/adt_practica02/ImgExercici2/img2Copia.png";

        File img1 = new File(ruta);
        File img2copia = new File(ruta2);

        if (img1.exists()) {
            try {
                img2copia.createNewFile();

                InputStream in = new FileInputStream(img1);
                OutputStream out = new FileOutputStream(img2copia);

                byte[] listByte = new byte[1024];
                int len;

                while ((len = in.read(listByte)) > 0) {
                    out.write(listByte, 0, len);
                }

                in.close();
                out.close();

                System.out.println("Fichero creado");

            } catch (IOException e) {
                System.out.println("Error");
            }
        }
    }

    public static void exercici3() {

//        String rutaTxt = "F:/Acces a dades/Tema 1/adt_practica02/ficherTxtEx3/exercici3txt.txt";
//        String rutaTxtCopia = "F:/Acces a dades/Tema 1/adt_practica02/ficherTxtEx3/exercici3Copia.txt";
        String rutaTxtLinux = "/media/vesprada/JOSECLIMENT/Acces a dades/Tema 1/adt_practica02/ficherTxtEx3/exercici3txt.txt";
        String rutaTxtCopiaLinux = "/media/vesprada/JOSECLIMENT/Acces a dades/Tema 1/adt_practica02/ficherTxtEx3/ficherTxtEx3Copia.txt";

        File txt1 = new File(rutaTxtLinux);
        File txt2copia = new File(rutaTxtCopiaLinux);
        try {
            FileWriter pw = new FileWriter(txt2copia);
            FileReader fr = new FileReader(txt1);

            int caract = fr.read();

            if (txt1.exists()) {
                while (caract != -1) {
                    char caracter = (char) caract;
                    if (caracter == 'a') {
                        caracter -= 32;
                    }
                    pw.write(caracter);
                    caract = fr.read();
                }
                pw.close();
            } else {
                System.out.println("El fichero no existe");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error al leer el archivo");
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo");
        }

    }

    public static void exercici5() {
        //        String rutaTxt = "F:/Acces a dades/Tema 1/adt_practica02/ficherTxtEx3/exercici5txt.txt";
//        String rutaTxtCopia = "F:/Acces a dades/Tema 1/adt_practica02/ficherTxtEx3/exercici5Copia.txt";
        String rutaTxtLinux = "/media/vesprada/JOSECLIMENT/Acces a dades/Tema 1/adt_practica02/ficherTxtEx5/ficherTxtEx5.txt";
        String rutaTxtCopiaLinux = "/media/vesprada/JOSECLIMENT/Acces a dades/Tema 1/adt_practica02/ficherTxtEx5/ficherTxtEx5Copia.txt";

        File txt1 = new File(rutaTxtLinux);
        File txt2copia = new File(rutaTxtCopiaLinux);
        try {
            FileWriter pw = new FileWriter(txt2copia);
            FileReader fr = new FileReader(txt1);

            int caract = fr.read();

            if (txt1.exists()) {
                while (caract != -1) {
                    char caracter = (char) caract;
                    System.out.println("Caracter antes de convertir: " + caracter + "\n");
                    if (caracter != ' ') {
                        caracter -= 32;
                        System.out.println(caracter);
                        pw.write(caracter);
                    }

                    caract = fr.read();
                }
                pw.close();
            } else {
                System.out.println("El fichero no existe");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error al leer el archivo");
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo");
        }

    }

    public static boolean compareFileContent(File file1, File file2) {

        boolean iguales = true;

        try {
            FileReader fr1 = new FileReader(file1);
            BufferedReader bf1 = new BufferedReader(fr1);

            FileReader fr2 = new FileReader(file2);
            BufferedReader bf2 = new BufferedReader(fr2);

            String cadena1 = bf1.readLine();
            String cadena2 = bf2.readLine();

            while ((cadena1 != null) && (cadena2 != null) && iguales) {
                if (!cadena1.equals(cadena2)) {
                    iguales = false;  
                }else{
                    cadena1 = bf1.readLine();
                    cadena2 = bf2.readLine();
                }

            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error al encontrar el archivo");
        } catch (IOException ex) {
            System.out.println("Error");
        }

        return iguales;
    }

    public static void exercici7(File file1) {

        try {
            FileReader fr1 = new FileReader(file1);
            BufferedReader bf1 = new BufferedReader(fr1);

            int contPalabras = 0;
            int contVocales = 0;
            String cadena = bf1.readLine();

            while (cadena != null) {
                String palabra[] = cadena.split(" ");
                contPalabras += palabra.length;

                for (int i = 0; i < palabra.length; i++) {
                    for (int j = 0; j < palabra[i].length(); j++) {
                        char vocal = palabra[i].charAt(j);
                        if (vocal == 'a' || vocal == 'e' || vocal == 'i' || vocal == 'o' || vocal == 'u') {
                            contVocales++;
                        }
                    }
                }

                cadena = bf1.readLine();

            }
            System.out.println("Hay "+contPalabras+" palabras");
            System.out.println("Hay "+contVocales+ " vocales");
            System.out.println("La media de vocales es: "+contVocales/contPalabras);

        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo");
        }

    }
    
    
    public static void exercici9(){
    
        ArrayList <Jugador>listaJugadores = new ArrayList<>(10);
        File fileEx9= new File("/media/vesprada/JOSECLIMENT/Acces a dades/Tema 1/adt_practica02/exercici9/exercici9.txt");
        
        
        FileReader fr1;
        try {
            fr1 = new FileReader(fileEx9);
            BufferedReader bf1 = new BufferedReader(fr1);
            
            FileWriter fw1 = new FileWriter(fileEx9);
            
            
            String cadena = bf1.readLine();
            String player[];
            while(cadena!=null){
                player=cadena.split(":");
                String nom = player[0];
                int puntuacio = Integer.parseInt(player[1]);
                Jugador jugador =  new Jugador(nom, puntuacio);
                listaJugadores.add(jugador);
                
                
                listaJugadores.sort(new Comparator<Jugador>() {
                    @Override
                    public int compare(Jugador o1, Jugador o2) {
                        if (o1.getPuntuacion()>o2.getPuntuacion()) {
                            return 0;
                        }else{
                            return -1;
                        }
                    }
                });
                
                System.out.println(listaJugadores.toString());
                cadena=bf1.readLine();
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error al encontrar el archivo");
        } catch (IOException ex) {
            System.out.println("No hay permisos para abrir el archivo");
        }
        
        
        
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        File fileEx6 = new File("/media/vesprada/JOSECLIMENT/Acces a dades/Tema 1/adt_practica02/exercici6files/primerFile.txt");
        File fileEx6_2 = new File("/media/vesprada/JOSECLIMENT/Acces a dades/Tema 1/adt_practica02/exercici6files/segonFile.txt");

        File fileEx7 = new File("/media/vesprada/JOSECLIMENT/Acces a dades/Tema 1/adt_practica02/exercici7files/exercici7.txt");
        System.out.println("Elija una opcion: \n"
                + "1.- Ejercicio 2\n"
                + "2.- Ejercicio 3\n"
                + "3.- Ejercicio 5\n"
                + "4.- Ejercicio comparar dos Files\n"
                + "5.- Ejercicio 7\n"
                + "6.- Ejercicio 9\n"
                + "7.- Salir");

        int numop = s.nextInt();

        switch (numop) {

            case 1:
                exercici2();
                break;
            case 2:
                exercici3();
                break;
            case 3:
                exercici5();
                break;
            case 4:
                if (compareFileContent(fileEx6, fileEx6_2)) {
                    System.out.println("Els fichers son iguals");
                } else {
                    System.out.println("Els fichers son diferents");
                }
                break;

            case 5:
                exercici7(fileEx7);
                break;
            
            case 6:
                exercici9();
                break;
        }
    }

}
