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
import repasexamen.HeaderOut;
import repasexamen.RepasExamen;
import repasexamen.Vehiculo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author josep
 */
public class GestionVehiculos {

    private static final String nomFitxer = "vehiculos.dat";;
    public static ArrayList<Vehiculo> veh = new ArrayList();

    

    public void insertarVehiculos() throws FileNotFoundException, IOException {
        Scanner s = new Scanner(System.in);
        File fichero = new File(GestionVehiculos.nomFitxer);
        HeaderOut oos = new HeaderOut(new FileOutputStream(fichero, true));

        System.out.println("Introduce marca");
        String marca = s.next();

        System.out.println("Introduce modelo");
        String modelo = s.next();

        System.out.println("Introduce matricula");
        String matricula = s.next();

        System.out.println("Introduce potencia");
        int potencia = s.nextInt();

        System.out.println("Introduce color");
        String color = s.next();

        Vehiculo v = new Vehiculo(marca, modelo, matricula, potencia, color);
        veh.add(v);

        for (int i = 0; i < veh.size(); i++) {
            oos.writeObject(veh.get(i));
        }
        oos.close();
    }

    public static void leerVehiculo() {

        try {
            File fichero = new File(GestionVehiculos.nomFitxer);
            ObjectInputStream ois = new ObjectInputStream((new FileInputStream(fichero)));
            Vehiculo aux = (Vehiculo) ois.readObject();
            while (aux != null) {

                if (aux instanceof Vehiculo) {
                    System.out.println(aux);
                }
                aux = (Vehiculo) ois.readObject();
            }
            ois.close();

        } catch (EOFException ex) {
            System.out.println("Final del archivo");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RepasExamen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(RepasExamen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean initzialitzarVehicul(Vehiculo v) throws IOException {

        File fitxer = new File(GestionVehiculos.nomFitxer);
         if(!fitxer.exists()){
             ObjectOutputStream objectoos  = new ObjectOutputStream(new FileOutputStream(fitxer));
              objectoos.writeObject(v);
                objectoos.close();
                return true;
         }else{
             return false;
         }
    }
}
