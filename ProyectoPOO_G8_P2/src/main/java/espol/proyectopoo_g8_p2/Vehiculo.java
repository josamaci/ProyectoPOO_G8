/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
    
 
    
    public static List<Vehiculo> cargarVehiculos(){
        
            String ruta = "vehiculos.txt";
            List<Vehiculo> vehiculos = new ArrayList<>();
            
            try(InputStream input = App.class.getResource(ruta).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
                
                String linea;
                
                while((linea=bf.readLine())!=null){
                    
                    String[] p = linea.split(",");
                    
                    Vehiculo vehiculo = new Vehiculo(p[0],p[1]);
                    vehiculos.add(vehiculo);
                }
                
            } catch (IOException ex){
                System.out.println("ERROR: No se pudo cargar la información de los residentes");
                ex.printStackTrace();
            }
        return vehiculos;
    }
    public String getNumMatricula(){
        return numMatricula;
    }
    public String getNombrePropietario(){
        return nombrePropietario;
    }
     public void setNumMatricula(String numero){
         
        numMatricula=numero;
    }
    public void setNombrePropietario(String nombre){
        nombrePropietario=nombre;
    }
}
