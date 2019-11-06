/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiobdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class ConexioBdd {

    //en este ejemplo usamos el executeUpdate para insert delete o update
    public static void ejemplo1() {
        try {

            //1.Cagar el driver
            Class.forName("com.mysql.jdbc.Driver");

            //2.Establecer conexion
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/adt4_ejemplo0", "root", "");

            //3.Enviar sentencias
            String sql = "INSERT INTO articulos(nombre, precio, stock, descripcion) VALUES('Bicicleta', 45.0,5,'BHH');";
            Statement sentencia = conexion.createStatement();

            int filas = sentencia.executeUpdate(sql);
            //4.Procesar los resultados
            System.out.println("Filas afectadas " + filas);

            //5.Cerrar conexiones
            sentencia.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexioBdd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexioBdd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //en este ejemplo hacemos un select con el executeQuery
    public static void ejemplo2() {
        try {

            //1.Cagar el driver
            Class.forName("com.mysql.jdbc.Driver");

            //2.Establecer conexion
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/adt4_ejemplo0", "root", "");

            //3.Enviar sentencias
            String sql = "SELECT nombre, precio, stock, descripcion "
                    + "FROM articulos;";

            Statement sentencia = conexion.createStatement();

            ResultSet filas = sentencia.executeQuery(sql);

            while (filas.next()) {
                String nombre = filas.getString("nombre");
                float precio = filas.getFloat("precio");
                int stock = filas.getInt("stock");

                System.out.println("FILA: " + nombre + " " + precio + " " + stock);
            }

            //4.Cerrar conexiones
            sentencia.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexioBdd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexioBdd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void ejemplo3() {
        try {

            //1.Cagar el driver
            Class.forName("com.mysql.jdbc.Driver");

            //2.Establecer conexion
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/adt4_ejemplo0", "root", "");

            //3.Enviar sentencias
            String sql = "UPDATE articulos SET stock = ? WHERE id = ?;";

            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, 70);
            sentencia.setInt(2, 1);
            int filas = sentencia.executeUpdate();
            
            System.out.println("Filas afectadas : "+filas);

            //4.Cerrar conexiones
            sentencia.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexioBdd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexioBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        //ejemplo1();
        //ejemplo2();
        ejemplo3();
    }

}
