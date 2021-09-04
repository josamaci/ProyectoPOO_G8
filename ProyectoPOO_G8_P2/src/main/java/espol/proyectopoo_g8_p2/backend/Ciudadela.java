/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2.backend;

import java.util.List;

/**
 *
 * @author andre
 */
public class Ciudadela {
    List<Casa> casas;
    //List<Usuario> usuarios;
    
    public Ciudadela(){
        casas = Casa.cargarCasa();
    }
    
    public List<Casa> getListaCasas(){
        return casas;
    }
    
    public Casa getCasa(Casa c){
        return c;
    }
}
