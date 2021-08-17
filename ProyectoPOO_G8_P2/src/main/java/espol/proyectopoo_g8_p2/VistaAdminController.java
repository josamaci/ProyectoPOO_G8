/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
/**
 * FXML Controller class
 *
 * @author andre
 */
public class VistaAdminController implements Initializable {


    @FXML
    private Pane panelMapa;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<Casa> casas = Casa.cargarCasa();
        for(Casa c: casas){
            Rectangle r = new Rectangle(50,50, Color.RED);
            StackPane st = new StackPane();
            st.getChildren().addAll(r);
            
            panelMapa.getChildren().addAll(st);
            
            st.setLayoutX(c.getCoordenadas().getX());
            st.setLayoutY(c.getCoordenadas().getY());
                   
        }
    }    
    @FXML
    public void regresarInicioSesion(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(App.class.getResource("inicioSesion.fxml"));
        Parent viewInicio = loader.load();
        App.setRoot("principal");   
    }
}
