/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author JMaci
 */
public class InicioSesionController implements Initializable {


    @FXML
    private Button botonRegresar;
    @FXML
    private TextField textNombre;
    @FXML
    private TextField textContra;
    @FXML
    private Button botonInicioSesion;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void iniciarSesion(MouseEvent event) throws IOException{
        String usuario="";
        String contrasenia="";   
        
        try{
            
        usuario = textNombre.getText();
        if(usuario.isBlank()){
        throw new NullPointerException();}

        contrasenia = textContra.getText();
        if(contrasenia.isBlank()){
        throw new NullPointerException();}
        
        for(Residente r: PrincipalController.getResidentes()){
            if(r.getNombreUsuario().equals(usuario)){
                if(r.getContrasenia().equals(contrasenia)){
                    App.setRoot("vistaResidente");
                }
                else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "CONTRASEÑA INCORRECTA");
                alert.show();
                textNombre.clear();
                }
            }else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "USUARIO NO ENCONTRADO");
                alert.show();
                textNombre.clear();
                textContra.clear();
            }
        }
        
        }catch(NullPointerException e){
        Alert alert = new Alert(Alert.AlertType.ERROR, "¡NO PUEDE DEJAR NINGUNO DE LOS CAMPOS EN BLANCO!");
        alert.show();
            
        }
    }

    @FXML
    private void regresarPrincipal(MouseEvent event) throws IOException {
        App.setRoot("principal");
    }

}
