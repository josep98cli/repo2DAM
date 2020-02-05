/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_avion;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author vesprada
 */
public class Avion extends JFrame {

    public final int FILAS_AVION = 3;
    public final int COLUMNAS_AVION = 6;

    public static ImageIcon imgAsiento = new ImageIcon("images/asientoNoRes.jpg");
    private JButton[][] matrizBotones;

    public Avion() {
        matrizBotones = new JButton[FILAS_AVION][COLUMNAS_AVION];

        //LE HAGO RESIZE A LA IMAGEN ICON PRINCIPAL
        Image image = imgAsiento.getImage();
        Image newImg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        imgAsiento = new ImageIcon(newImg);

        //crero los paneles
        JFrame jf = new JFrame();
        JPanel jp = new JPanel();

        jf.add(jp);

        for (int i = 0; i < matrizBotones.length; i++) {
            for (int j = 0; j < matrizBotones[i].length; j++) {

                JButton boton = new JButton();
                boton.setSize(100, 100);
                boton.setIcon(imgAsiento);
                jp.add(boton);

                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        //LE HAGO RESIZE A LA IMAGEN ICON RESERVADO
                        ImageIcon imgAsientoReservado = new ImageIcon("images/rojo.jpg");
                        Image image2 = imgAsientoReservado.getImage();
                        Image newImg2 = image2.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
                        imgAsientoReservado = new ImageIcon(newImg2);

                        //compruebo el nombre del icon associado al boton y lo comparo para ver si esta reservado
                        
                        if (imgAsiento == boton.getIcon()) {
                            int input = JOptionPane.showConfirmDialog(null, "Seguro que quieres realizar esta compra?");
                            // 0=yes, 1=no, 2=cancel
                            if (input == 0) {
                                boton.setIcon(imgAsientoReservado);
                                JOptionPane.showMessageDialog(null, "Asiento reservado");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El asiento ya esta reservado");
                        }

                    }
                });
            }
        }

        jp.setLayout(new GridLayout(FILAS_AVION, COLUMNAS_AVION));

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.pack();
        jf.setVisible(true);

    }

}
