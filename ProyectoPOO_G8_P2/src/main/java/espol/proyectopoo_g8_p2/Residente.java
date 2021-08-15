package espol.proyectopoo_g8_p2;
public class Residente extends Usuario{
    private String correo;
    private String casa;
    private Genero genero;
    private String nombre;
    private ArrayList<Vehiculo> vehiculos= new ArrayList();
    private String cedula;
    private String pinAcceso;
            
    public void mostrarInformacion(){
        
    }
    public String cambiarPin(pinAcceso){
        return pinAcceso;
    }
    public String cambiarPin(pinAcceso){
        return pinAcceso;
    }
    public void registrarVehiculo(){
        
    }
    public String registrarVisitante(){
        return "";
    }
    public void listaVisitantes(){
        
    }
    public void eliminarVisitante(){
        
    }
    public String getCorreo(){
        return correo;
    }
    public Genero getGenero(){
        return genero;
    }
    public String getCasa(){
        return casa;
    }
    public String getNombre(){
        return nombre;
    }
    public ArrayList<Vehiculo> getVehiculos(){
        return vehiculos;
    }
    public String getCedula(){
        return cedula;
    }
     public String getPinAcceso(){
        return pinAcceso;
    }
    }

