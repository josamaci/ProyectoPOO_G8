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
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

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
        
        //if((!nombre.isBlank()) && (!correo.isBlank() & correo.contains("@")) && 
        //        (!genero.isBlank()) && (cedula.isBlank() & (cedula.length() == 10))){
        
        if(!nombre.isBlank()){
            if(!correo.isBlank() & correo.contains("@")){
                if(!genero.isBlank()){
                    if(!cedula.isBlank() & cedula.length()==10){
                        try{    
                            String nombreUsuario = nombre.substring(0,1).toUpperCase() + nombre.substring(1);
                            String contrasena = cedula;
                            String pin = Pin.crearPin(4);
                            Residente nuevoResidente = new Residente(nombreUsuario, contrasena, correo, casaSeleccionada, genero, nombre, null, cedula, pin);
                            
                            try{
                                App.getUsuario().nuevoUsuario(nuevoResidente);
                            }catch(Exception ex){
                                System.out.println("Error añadiendo reisdente");
                            }
                            //ERROR: Ubicacion ubicacion = new Ubicacion(casaSeleccionada.getCoordenadas().getX(),casaSeleccionada.getCoordenadas().getY());
                            //casaSeleccionada.setResidente(nombre);
                            //Casa casa = new Casa(nombre, ubicacion, casaSeleccionada.getManzana(), casaSeleccionada.getVilla());                          
                            
                            try{
                    
                                FXMLLoader loader = new FXMLLoader(App.class.getResource("vistaAdmin.fxml"));
                                App.setRoot("vistaAdmin");
                        
                        //5. Pasamos al infromacion al controlador
                        
                        
                        
                            }catch(IOException ex){
                        //event -> es una referencia al evento que ocurrio
                        //generar el nuevo contenido a partir de VistaAgredecimeinto.fxml
                        
                                System.out.println("No se ha podido cargar la vista");
                                System.out.println("VistaPrincipal.fxml");
                            }
                        }
                        catch(Exception e){
                            System.out.println("Error cargando información del residente");
                        }
                    }
                    else{
                        System.out.println("Error cedula");
                    }
                }
                else{
                    System.out.println("Error genero");
                }
            }
            else{
                System.out.println("Error correo");
            }
        }
        else{
            System.out.println("Error nombre");
        }
    }
    
    @FXML
    
    private void Cancelar(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(App.class.getResource("vistaAdmin.fxml"));
            Parent viewInicio = loader.load();
            App.setRoot("vistaAdmin");
        }catch(IOException e){
            System.out.println("Error cargando vistaAdmin.fxml");
        }
    }
    
}    
    

