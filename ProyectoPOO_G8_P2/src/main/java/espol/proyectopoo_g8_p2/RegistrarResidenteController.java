/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2;

import espol.proyectopoo_g8_p2.backend.Casa;
import espol.proyectopoo_g8_p2.backend.Pin;
import espol.proyectopoo_g8_p2.backend.Residente;
import espol.proyectopoo_g8_p2.backend.Ubicacion;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author andre
 */
public class RegistrarResidenteController implements Initializable {


    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private ComboBox<String> cbGenero;
    @FXML
    private TextField txtCedula;
    
    private Casa casaSeleccionada;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("MASCULINO");
        opciones.add("FEMENINO");
        opciones.add("LGBTI");
        
        cbGenero.getItems().addAll(opciones);
        // TODO
    }    
    
    public void setCasa(Casa c){
        casaSeleccionada = c;
    }
    
    
    @FXML
    
    private void Aceptar(ActionEvent event){
        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        String genero = cbGenero.getValue();
        String cedula = txtCedula.getText();
        
        if((!nombre.isBlank()) && (!correo.isBlank() & correo.contains("@")) && 
                (!genero.isBlank()) && (cedula.isBlank() & (cedula.length() == 10))){
            try{
                String[] splitNombre = correo.split("@");
                String nombreU = splitNombre[0];
                String nombreUsuario = nombreU = nombreU.substring(0,1).toUpperCase() + nombreU.substring(1);
                String contrasena = nombreU.toUpperCase();
                String pin = Pin.crearPin(4);
                Ubicacion ubicacion = new Ubicacion(casaSeleccionada.getCoordenadas().getX(),casaSeleccionada.getCoordenadas().getY());
                Casa casa = new Casa(nombre, ubicacion, casaSeleccionada.getManzana(), casaSeleccionada.getVilla());
                
                Residente nuevoResidente = new Residente
        (nombreUsuario, contrasena, correo, casa, genero, nombre, null, cedula, pin);
                
                
            }
            catch(Exception e){
                
            }
        }
    }
    
}    
    

