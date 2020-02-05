/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.SocioDAO;
import Vista.JPSocio;

/**
 *
 * @author vesprada
 */
public class ControladorSocio {
    private SocioDAO socioDAO;
    private JPSocio jpSocio;

    public ControladorSocio() {
    }

    public ControladorSocio(SocioDAO socioDAO, JPSocio jpSocio) {
        this.socioDAO = socioDAO;
        this.jpSocio = jpSocio;
    }

    public SocioDAO getSocioDAO() {
        return socioDAO;
    }

    public void setSocioDAO(SocioDAO socioDAO) {
        this.socioDAO = socioDAO;
    }

    public JPSocio getJpSocio() {
        return jpSocio;
    }

    public void setJpSocio(JPSocio jpSocio) {
        this.jpSocio = jpSocio;
    }
    
    
    
}
