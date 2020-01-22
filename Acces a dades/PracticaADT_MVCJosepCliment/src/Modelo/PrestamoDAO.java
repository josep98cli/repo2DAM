/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class PrestamoDAO {
      public void insertarPrestamo(Prestamo prestamo){
          GestionDB gestion = GestionDB.crearGestionDB();
        
        try {
          
          Statement st = gestion.getConexion().createStatement();
          st.executeUpdate("INSERT INTO prestamo VALUES('"+prestamo.getISBN()+"', '"+prestamo.getNumSocio()+"','"+prestamo.getF_prestamo()+"', '"+prestamo.getF_devolucion()+"')");
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void leerPrestamo(Prestamo prestamo) throws SQLException{
        GestionDB gestion = GestionDB.crearGestionDB();
        Statement st = gestion.getConexion().createStatement();
        st.execute("SELECT * FROM prestamo WHERE socio = '"+prestamo.getNumSocio()+"' AND libro = '"+prestamo.getISBN()+"'");
    }
    
    public void actualizarPrestamo(Prestamo prestamo){
        
        
    }
    
    public void eliminarPrestamo(Prestamo prestamo){
        try {
            GestionDB gestion = GestionDB.crearGestionDB();
            Statement st = gestion.getConexion().createStatement();
            st.executeUpdate("DELETE FROM prestamo WHERE libro = '"+ prestamo.getISBN()+"' AND socio = '"+prestamo.getNumSocio()+"'");
            
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
