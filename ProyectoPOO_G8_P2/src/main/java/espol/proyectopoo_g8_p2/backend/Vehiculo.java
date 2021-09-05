/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2.backend;

import espol.proyectopoo_g8_p2.App;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;

/**
 *
 * @author andre
 */
public class Vehiculo implements Movibles{
    private String numMatricula;
    private String nombrePropietario;
    
    public Vehiculo(String num, String nombre){
        numMatricula = num;
        nombrePropietario = nombre;
    }
    public Vehiculo(String num){
        numMatricula = num;
        nombrePropietario = null;
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
    
    public static void AgregarVehiculo(Vehiculo veh) throws IOException{
            List <Vehiculo> vehiculos = cargarVehiculos();
            String ruta = "src/main/resources/espol/proyectopoo_g8_p2/vehiculos.txt";
            vehiculos.add(veh);
            try(BufferedWriter bf = new BufferedWriter(new FileWriter(ruta))){
            for(Vehiculo v: vehiculos){
                    String line = v.getNumMatricula()+","+v.getNombrePropietario();
                    bf.write(line);
                    bf.newLine();
                }
                                
            }catch (FileNotFoundException ex){
                System.out.println("ERROR File");
            } catch (IOException ex){
                System.out.println("ERROR IO");
            }
            
        }

    @Override
    public boolean ingreso() {
        List<Vehiculo> vehiculos = Vehiculo.cargarVehiculos();
        boolean comp = true;
        
        for(Vehiculo v: vehiculos){
            if(v.getNumMatricula().equals(numMatricula)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "¡EL VEHÍCULO PUEDE INGRESAR!");
                alert.show();
                comp = false;
                return true;
            }
        }
        
        if(comp){
            Alert alert = new Alert(Alert.AlertType.ERROR, "¡EL VEHÍCULO NO HA SIDO ENCONTRADO!");
            alert.show();
        }
    return false;
    }
}
