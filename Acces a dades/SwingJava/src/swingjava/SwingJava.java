/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingjava;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author vesprada
 */
public class SwingJava extends JFrame{

    private JLabel saludo;
    private JButton botonNombre;
    
    public SwingJava(){
        super("Pantalla Principal");
        
        setBounds(200, 200, 200, 200);
        setLayout(null);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setResizable(false);
        setVisible(true);
        
        crearLabel();
        crearBoton();
    }
    
     private void crearLabel() {
        saludo = new JLabel();
        saludo.setText("Hola");
        saludo.setBounds(50,50,100,50);
        add(saludo);
    }
    
     public void crearBoton(){
         botonNombre = new JButton();
         botonNombre.setBounds(20, 20, 20, 20);
         botonNombre.setText("Vaya caguerola");
         add(botonNombre);
     }
    
    public static void main(String[] args) {
        SwingJava swing = new SwingJava(); 
    }

   
    
}
