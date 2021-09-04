package espol.proyectopoo_g8_p2;

import espol.proyectopoo_g8_p2.backend.Casa;
import espol.proyectopoo_g8_p2.backend.Ciudadela;
import espol.proyectopoo_g8_p2.backend.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Usuario u;
    private static Scene scene;
    private static Casa c;
    private List<Casa> casas;
    private static Ciudadela ciudadela;
    
    @Override
    public void init(){
        ciudadela = new Ciudadela();
    }
    
    @Override
    public void start(Stage stage) throws IOException {
        try{
        scene = new Scene(loadFXML("principal"), 700, 700);
        stage.setScene(scene);
        stage.show();
        }catch(IOException e){
        e.printStackTrace();
        }
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    public static void setRoot(Parent root) {
        scene.setRoot(root);
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Usuario getUsuario(){
        return u;
    }
    
    public static void setUsuario(Usuario u){
        App.u = u;
    }
    
    public List<Casa> getCasa(){
        casas = Casa.cargarCasa();
        return casas;
    }
    
    public static Ciudadela getCiudadela(){
        return ciudadela;
    }
    
    public static void setCasa(Casa c){
        App.c = c;
    }
    
}