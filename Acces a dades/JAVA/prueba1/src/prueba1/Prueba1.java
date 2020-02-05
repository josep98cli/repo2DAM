/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba1;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



/**
 *
 * @author vesprada
 */
public class Prueba1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        
        Professor p1 = new Professor(1, "Pepe", "apellido 1", "apellido 2");
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        // OPERACIONS INSERTAR, MODIFICAR Y ELIMINAR
        
        //INSERTAR
        //session.saveOrUpdate(p1); //busca si existe, si no existe lo crea y si existe lo modifica
        
        //session.getTransaction().commit();
        
        //ProfesorJPA p2 = (ProfesorJPA) session.get(ProfesorJPA.class, 1001);
        //System.out.println(p2.getNombre());
        
        Query query = session.createQuery("SELECT p FROM Professor p WHERE nombre LIKE '%U%'");
        List<Professor> profesores = query.list();
        
        for(Professor p:profesores){
            System.out.println("Nombre = "+p.getNombre());
        }
        
        session.close();
    }
    
}
