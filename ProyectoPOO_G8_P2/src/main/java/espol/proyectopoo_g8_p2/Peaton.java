package espol.proyectopoo_g8_p2;

public class Peaton{
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
    public void setNumCedula(){
    this.numCedula=numCedula;
    }
    public void setPinAcceso(){
    this.pinAcceso=pinAcceso;
    }
}
