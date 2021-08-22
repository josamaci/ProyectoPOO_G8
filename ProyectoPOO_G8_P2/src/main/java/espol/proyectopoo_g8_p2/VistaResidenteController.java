/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2;

import espol.proyectopoo_g8_p2.backend.Residente;
import espol.proyectopoo_g8_p2.backend.Vehiculo;
import espol.proyectopoo_g8_p2.backend.Visitante;
import espol.proyectopoo_g8_p2.excepciones.EnBlancoException;
import espol.proyectopoo_g8_p2.excepciones.PinException;
import espol.proyectopoo_g8_p2.excepciones.VehiculoException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
/**
 * FXML Controller class
 *
 * @author JMaci
 */
public class VistaResidenteController implements Initializable {


    @FXML
    private Button botonCerrar;
    @FXML
    private HBox vbnombre;
    @FXML
    private Label lblNombre;
    @FXML
    private HBox vbCorreo;
    @FXML
    private Label lblCorreo;
    @FXML
    private HBox vbVilla;
    @FXML
    private Label lblVilla;
    @FXML
    private HBox vbManzana;
    @FXML
    private Label lblManzana;
    @FXML
    private HBox vbCedula;
    @FXML
    private Label lblCedula;
    @FXML
    private HBox vbPin;
    @FXML
    private Label lblPin;
    @FXML
    private TextField txtPin;
    @FXML
    private Button botonPin;
    @FXML
    private GridPane gridVehiculo;
    @FXML
    private TextField txtVehiculo;
    @FXML
    private Button botonVehiculo;
    @FXML
    private TextField txtNombreVisitante;
    @FXML
    private TextField txtCedulaVisitante;
    @FXML
    private TextField txtCorreoVisitante;
    @FXML
    private TextField txtAnioVisita;
    @FXML
    private ComboBox<String> ComboMesVisita;
    @FXML
    private TextField txtDiaVisita;
    @FXML
    private ComboBox<Integer> ComboHoraVisita;
    @FXML
    private ComboBox<Integer> ComboMinutoVisita;
    @FXML
    private TableView<Visitante> tableVisitante;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Residente r = (Residente)App.getUsuario();
        lblNombre.setText(r.getNombre());
        lblCorreo.setText(r.getCorreo());
        lblVilla.setText(r.getCasa().getVilla());
        lblManzana.setText(r.getCasa().getManzana());
        lblCedula.setText(r.getCedula());
        lblPin.setText(r.getPinAcceso());
        
        List<Vehiculo> vehiculos = Vehiculo.cargarVehiculos();
        
        int x=0;
        int y=0;
        for(Vehiculo v:vehiculos){
            if(v.getNombrePropietario().equals(lblNombre.getText())){
                Label lbl= new Label();
                lbl.setText(v.getNumMatricula());
                gridVehiculo.add(lbl,y,x);
                x++;
            }
        }
    }    

    @FXML
    private void cerrarSesion(MouseEvent event) throws IOException{
        App.setRoot("principal");
    }

    @FXML
    private void cambiarPin(MouseEvent event) throws PinException, EnBlancoException, IOException{
        String pin;
        pin = txtPin.getText();
        try{
            
            int com = Integer.parseInt(pin);
            
            if(pin.length()==0){
            throw new EnBlancoException();}
            
            if(pin.length()!=4 || pin.equals(lblPin.getText())){
                txtPin.clear();
            throw new PinException();
            }
            
            Residente r = Residente.CambiarPinResidente(pin, App.getUsuario().getNombreUsuario());
            lblPin.setText(r.getPinAcceso());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Se ha cambiado su pin de acceso.");
            alert.show();
            
        }catch(PinException e){
            if (pin.equals(lblPin.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR, "¡El pin no debe ser igual al anterior!");
            alert.show();
            }
            else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "¡El pin ingresado no es válido, debe tener 4 dígitos!");
            alert.show();}
        
        }catch(EnBlancoException e){
        Alert alert = new Alert(Alert.AlertType.ERROR, "¡NO PUEDE DEJAR RL CAMPO EN BLANCO!");
        alert.show(); 
        
        }catch(NumberFormatException e){
            txtPin.clear();
        Alert alert = new Alert(Alert.AlertType.ERROR, "¡DEBE INGRESAR NÚMEROS!");
        alert.show(); 
        
        }
        
    }

    @FXML
    private void registrarVehiculo(MouseEvent event) throws VehiculoException, EnBlancoException, IOException{
        try{
        String mat = txtVehiculo.getText();
        if(mat.isBlank()){
        throw new EnBlancoException();
        }
        
        Vehiculo veh = new Vehiculo(mat,lblNombre.getText());
        List<Vehiculo> vehiculos;
        vehiculos = Vehiculo.cargarVehiculos();
        int x=gridVehiculo.getRowCount();
        int y=0;
        for(Vehiculo v: vehiculos){
            if(v.getNumMatricula().equals(mat)){
                throw new VehiculoException();
            }   
        }    
        Label lbl= new Label();
        lbl.setText(veh.getNumMatricula());
        gridVehiculo.add(lbl,y,x);
        
        Vehiculo.AgregarVehiculo(veh);
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Se ha agredado el vehículo.");
            alert.show();
        
        }catch(EnBlancoException e){
        Alert alert = new Alert(Alert.AlertType.ERROR, "¡NO PUEDE DEJAR RL CAMPO EN BLANCO!");
        alert.show();  
        }catch(VehiculoException e){
            txtVehiculo.clear();
        Alert alert = new Alert(Alert.AlertType.ERROR, "¡LA MATRÍCULA YA ESTÁ REGISTRADA!");
        alert.show();  
        }catch (IOException ex){
                System.out.println("ERROR IO");
        }
        
        
    }

    @FXML
    private void ingresarVisita(MouseEvent event) {
    }
    
    
}
