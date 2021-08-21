package espol.proyectopoo_g8_p2;

public class Peaton{
    private String numcedula;
    private String pinAcceso;
    public Peaton(String numCedula, String pinAcceso){
        this.numCedula=numCedula;
        this.pinAcceso=pinAcceso;
    }

    public String getNumCedula(){
    return numcedula;
    }
    public String getPinAcceso(){
    return pinAcceso;
    }
    public void setNumCedula(){
    this.numCedula=numcedula;
    }
    public void setPinAcceso(){
    this.pinAcceso=pinAcceso;
    }
}
