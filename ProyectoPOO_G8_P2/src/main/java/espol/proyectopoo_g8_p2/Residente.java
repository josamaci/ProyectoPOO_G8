package espol.proyectopoo_g8_p2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class Residente extends Usuario{
    private String correo;
    private String casa;
    private GENERO genero;
    private String nombre;
    private String vehiculo;
    private String cedula;
    private String pinAcceso;
    
        public Residente(String nombreUsuario, String contrasenia, String correo, 
                String casa, String genero, String nombre, String vehiculo, String cedula, String pinAcceso){
            super(nombreUsuario, contrasenia);
            this.genero = GENERO.valueOf(genero.toUpperCase());
            this.nombre = nombre;
            this.vehiculo = vehiculo;
            this.cedula = cedula;
            this.pinAcceso = pinAcceso;
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
        public String getVehiculos(){
            return vehiculo;
        }
        public String getCedula(){
            return cedula;
        }
        public String getPinAcceso(){
            return pinAcceso;
        }
        
        public static List<Residente> cargarResidente(){
        
            String ruta = "residentes.txt";
            List<Residente> residentes = new ArrayList<>();
            
            try(InputStream input = App.class.getResource(ruta).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
                
                String linea;
                
                while((linea=bf.readLine())!=null){
                    System.out.println(linea);
                    String[] p = linea.split(",");
                    
                    Residente residente = new Residente(p[0],p[1],p[2],p[3],p[4],p[5],p[6],p[7],p[8]);
                    residentes.add(residente);
                }
            } catch (IOException ex){
                System.out.println("ERROR: No se pudo cargar la información de los residentes");
                ex.printStackTrace();
            }
        return residentes;
    }
       
 }

