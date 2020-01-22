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
public class LibroDAO {
    public void insertarLibro(Libro libro){
          GestionDB gestion = GestionDB.crearGestionDB();
        
        try {
          
          Statement st = gestion.getConexion().createStatement();
          st.executeUpdate("INSERT INTO libro VALUES('"+ libro.getISBN() + "', '"+libro.getTitulo() + "','"+ libro.getAutor()+"','"+ libro.getEjemplares()+"', '"+libro.getAño()+"', '"+ libro.getEditorial()+"', '"+libro.getPaginas() +"')");
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void leerLibro(Libro libro) throws SQLException{
        GestionDB gestion = GestionDB.crearGestionDB();
        Statement st = gestion.getConexion().createStatement();
        st.executeUpdate("SELECT * FROM libros WHERE ISBN = '"+libro.getISBN()+"'");
    }
    
    public void actualizarLibro(Libro libro){
        
        
    }
    
    public void eliminarLibro(Libro libro){
        try {
            GestionDB gestion = GestionDB.crearGestionDB();
            Statement st = gestion.getConexion().createStatement();
            st.executeUpdate("DELETE FROM libro WHERE ISBN ="+ libro.getISBN()+"");
            
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
