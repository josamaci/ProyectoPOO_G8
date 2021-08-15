/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2;

/**
 *
 * @author andre
 */
public class Vehiculo {
    private String numMatricula;
    private String nombrePropietario;
    
    public Vehiculo(String num, String nombre){
        numMatricula = num;
        nombrePropietario = nombre;
    }
    
    public String getNumMatricula(){
        return numMatricula;
    }
    
    public String getPropietario(){
        return nombrePropietario;
    }
}
