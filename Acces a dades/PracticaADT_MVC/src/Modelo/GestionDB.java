/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vesprada
 */
public class GestionDB {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String BD = "biblioteca";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost/" + BD;
    
    private static GestionDB db = null;
    private Connection conexion = null;
    
    private GestionDB(){
           try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);

            System.out.println("Conectado a la base de datos MySQL [" + BD + "]");
        } catch (Exception e) {
            System.err.println("Error conexión [" + BD + "]: " + e.getMessage());
        }
    }
    
    public static Connection getConexion() {

        if (db == null) {
            db = new GestionDB();
        }
        return db.conexion;

    }
     public static void desconectar() {
        try {
            db.conexion.close();
            System.out.println("Desconectado de la base de datos MySQL [" + BD + "]");
        } catch (SQLException ex) {
            System.err.println("Error desconexión [" + BD + "]: " + ex.getMessage());
        }
    }
}
