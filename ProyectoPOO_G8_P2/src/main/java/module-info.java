module espol.proyectopoo_g8_p2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens espol.proyectopoo_g8_p2 to javafx.fxml;
    exports espol.proyectopoo_g8_p2;
    requires java.mail;
}
