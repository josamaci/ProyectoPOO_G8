/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2;

import espol.proyectopoo_g8_p2.backend.Casa;
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
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
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
    
    private double anchorX;
    private double anchorY;
    private double NodeX;
    private double NodeY;
    private VBox datosResidente;
    private Label nombre;

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
            //panelMapa.getChildren().addAll(r);
            
            Group root = new Group();
            root.getChildren().addAll(r);
            panelMapa.getChildren().addAll(root);
            
            r.setLayoutX(c.getCoordenadas().getX());
            r.setLayoutY(c.getCoordenadas().getY());
            
            r.setOnMouseEntered(event ->{
                event.consume();
                datosResidente = new VBox();
                datosResidente.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                datosResidente.getChildren().add(new Label(c.getManzana()));
                datosResidente.getChildren().add(new Label(c.getVilla()));
                datosResidente.getChildren().add(new Label(c.getResidente()));
                
                
                panelMapa.getChildren().addAll(datosResidente);
                
                datosResidente.setLayoutX(c.getCoordenadas().getX()+50);
                datosResidente.setLayoutY(c.getCoordenadas().getY());
                
            });
            
            r.setOnMouseExited(event ->{
                event.consume();
                datosResidente.setVisible(false);
                
                
            });
      
            r.setOnMousePressed(event -> {
                anchorX = event.getSceneX();
                anchorY = event.getSceneY();       
                NodeX= event.getX();
                NodeY= event.getY();
            });
            
            r.setOnMouseDragged(event -> {
                r.setTranslateX(event.getSceneX() - anchorX);
                r.setTranslateY(event.getSceneY() - anchorY);
                             
            });
            
            r.setOnMouseReleased(event -> {
                r.setLayoutX(event.getSceneX() - NodeX);
                r.setLayoutY(event.getSceneY() - NodeY - 73);
                r.setTranslateX(0);
                r.setTranslateY(0);
                c.getCoordenadas().setX(r.getLayoutX());
                c.getCoordenadas().setY(r.getLayoutY());
                
            });
        }
    }
            
    @FXML
    public void regresarInicioSesion(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(App.class.getResource("inicioSesion.fxml"));
        Parent viewInicio = loader.load();
        App.setRoot("principal");   
    }
}
