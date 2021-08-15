package espol.proyectopoo_g8_p2;

import java.io.IOException;
import javafx.fxml.FXML;

public class InicioSesionController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("principal");
    }
}