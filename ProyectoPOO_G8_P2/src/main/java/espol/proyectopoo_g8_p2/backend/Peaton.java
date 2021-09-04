package espol.proyectopoo_g8_p2.backend;

import java.util.List;
import javafx.scene.control.Alert;

public class Peaton implements Movibles{
    private String numCedula;
    private String pinAcceso;
    public Peaton(String numCedula, String pinAcceso){
        this.numCedula=numCedula;
        this.pinAcceso=pinAcceso;
    }

    public String getNumCedula(){
    return numCedula;
    }
    public String getPinAcceso(){
    return pinAcceso;
    }

    @Override
    public boolean ingreso() {
        List<Residente> residentes = Residente.cargarResidente();
        boolean comp = true;
        for(Residente r: residentes){
            if(r.getCedula().equals(numCedula) && r.getPinAcceso().equals(pinAcceso)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "¡EL PEATÓN PUEDE INGRESAR!");
                alert.show();
                comp = false;
                return true;
            }
        }
        
        if(comp){
            Alert alert = new Alert(Alert.AlertType.ERROR, "¡EL RESIDENTE NO HA SIDO ENCONTRADO!");
            alert.show();
        }
        return false;
    }
}

