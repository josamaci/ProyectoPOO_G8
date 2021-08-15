package espol.proyectopoo_g8_p2;
import java.util.ArrayList;
public class Residente extends Usuario{
    private String correo;
    private String casa;
    private GENERO genero;
    private String nombre;
    private ArrayList<Vehiculo> vehiculos;
    private String cedula;
    private String pinAcceso;
    
    public Residente(String nombreUsuario, String contrasenia, String correo, String casa, String genero, String nombre, String cedula){
    super(nombreUsuario, contrasenia);
    pinAcceso=null;
    vehiculos= new ArrayList();
    this.genero = GENERO.valueOf(genero.toUpperCase());
    this.nombre = nombre;
    this.cedula = cedula;
    }
    
    public void mostrarInformacion(){
        
    }
    
    public void cambiarPin(String pinAcceso){
        this.pinAcceso = pinAcceso;
    }
    public String getPin(){
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
    public GENERO getGenero(){
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

