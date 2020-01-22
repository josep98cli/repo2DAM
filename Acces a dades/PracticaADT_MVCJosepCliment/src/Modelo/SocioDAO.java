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
public class SocioDAO {
     public void insertarSocio(Socio socio){
          GestionDB gestion = GestionDB.crearGestionDB();
        
        try {
          
          Statement st = gestion.getConexion().createStatement();
          st.executeUpdate("INSERT INTO socio (nombre, apellidos, telefono, edad, falta) VALUES('"+socio.getNombre()+"','"+socio.getApellidos()+"', '"+socio.getTelefono()+"', '"+socio.getEdad()+"', '"+socio.getF_alta()+"')");
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void leerSocio(Socio socio) throws SQLException{
        GestionDB gestion = GestionDB.crearGestionDB();
        Statement st = gestion.getConexion().createStatement();
        st.executeUpdate("SELECT * FROM socio WHERE numsocio ='"+socio.getNumSocio()+"'");
    }
    
    public void actualizarSocio(Socio socio){
        
        
    }
    
    public void eliminarSocio(Socio socio){
        try {
            GestionDB gestion = GestionDB.crearGestionDB();
            Statement st = gestion.getConexion().createStatement();
            st.executeUpdate("DELETE FROM TABLE WHERE socio = '"+socio.getNumSocio()+"'");
            
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
