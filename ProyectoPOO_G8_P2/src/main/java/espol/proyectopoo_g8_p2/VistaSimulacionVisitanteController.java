/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2;

import espol.proyectopoo_g8_p2.App;
import espol.proyectopoo_g8_p2.App;
import espol.proyectopoo_g8_p2.App;
import espol.proyectopoo_g8_p2.App;
import espol.proyectopoo_g8_p2.backend.Residente;
import espol.proyectopoo_g8_p2.backend.Vehiculo;
import espol.proyectopoo_g8_p2.backend.Visitante;
import espol.proyectopoo_g8_p2.excepciones.EnBlancoException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author JMaci
 */
public class VistaSimulacionVisitanteController implements Initializable {


    @FXML
    private Button botRegresar;
    @FXML
    private TextField txtCodigo;
    @FXML
    private Button comprobarCodigo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void volver(MouseEvent event) throws IOException {
        App.setRoot("vistaSimulacion");
    }

    @FXML
    private void comprobarCodigo(MouseEvent event) {
        List<Visitante> visitantes = Visitante.cargarVisitante();
        boolean comp = true;
        boolean comp2 = true;
        try{
        String cod = txtCodigo.getText();
        if(cod.isBlank()){
        throw new EnBlancoException();
        }
        
        for(Visitante v:visitantes){
            if(v.getCodigoAcceso().equals(cod)){
                comp2 =false;
                if(v.getUsoCodigo() && v.comprobarFechaIngreso()){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "¡EL VISITANTE PUEDE PASAR!");
                    alert.show();
                    comp =false;
                    v.setUsoCodigo(false);
                 
                }
            }
        }
        
        if(comp2){Alert alert = new Alert(Alert.AlertType.ERROR, "¡NO SE HA ENCONTRADO AL VISITANTE!");
                    alert.show(); }
        if(comp){Alert alert = new Alert(Alert.AlertType.ERROR, "¡EL CÓDIGO YA HA SIDO USADO O ESTÁ FUERA DEL RANGO ESTABLECIDO PARA LA FECHA DE INGRESO!");
                    alert.show();}
        
        txtCodigo.clear();
        
        }catch(EnBlancoException e){
        Alert alert = new Alert(Alert.AlertType.ERROR, "¡NO PUEDE DEJAR EL CAMPO EN BLANCO!");
        alert.show();  
        }
        
    }

}
