package espol.proyectopoo_g8_p2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class Residente extends Usuario{
    private String correo;
    private Casa casa;
    private GENERO genero;
    private String nombre;
    private ArrayList<Vehiculo> vehiculos ;
    private String cedula;
    private String pinAcceso;
    
        public Residente(String nombreUsuario, String contrasenia, String correo, 
                Casa casa, String genero, String nombre, String cedula, String pinAcceso){
            super(nombreUsuario, contrasenia);
            this.correo = correo;
            this.casa = casa;
            this.genero = GENERO.valueOf(genero.toUpperCase());
            this.nombre = nombre;
            this.cedula = cedula;
            this.pinAcceso = pinAcceso;
           vehiculos = new ArrayList();
            
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
  
        
        public static List<Residente> cargarResidente(){
        
            String ruta = "residentes.txt";
            List<Residente> residentes = new ArrayList<>();
            List<Casa> casas = Casa.cargarCasa();
            List<Vehiculo> vehiculos = Vehiculo.cargarVehiculos();            
            
            try(InputStream input = App.class.getResource(ruta).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
                
                String linea;
                
                while((linea=bf.readLine())!=null){
                    
                    String[] p = linea.split(",");
                    
                    Residente residente = new Residente(p[0],p[1],p[2],null,p[4],p[5],null,p[7],p[8]);
                    
                    for (int i=0;i<casas.size();i++) {
                        if(casas.get(i).getResidente().equals(residente.getNombre())){             
                            residente = new Residente(p[0],p[1],p[2],casas.get(i),p[4],p[5],null,p[7],p[8]);
                            for(int j=0;j<vehiculos.size();j++){
                                if(vehiculos.get(j).getPropietario().equals(residente.getNombre())){
                                    residente = new Residente(p[0],p[1],p[2],casas.get(i),p[4],p[5],vehiculos.get(j),p[7],p[8]);
                                    residentes.add(residente);
                                } 
                            }
                        }
                    }
                }
            } catch (IOException ex){
                System.out.println("ERROR: No se pudo cargar la información de los residentes");
            }
        return residentes;
    }
          public String getCorreo(){
            return correo;
        }
        public GENERO getGenero(){
            return genero;
        }
        public Casa getCasa(){
            return casa;
        }
        public String getNombre(){
            return nombre;
        }
        public Vehiculo getVehiculo(){
            return vehiculo;
        }
        public String getCedula(){
            return cedula;
        }
        public String getPinAcceso(){
            return pinAcceso;
        }
         public void setCorreo(String c){
            correo=c;
        }
        public void setGenero(GENERO g){
            return genero;
        }
        public void setCasa(Casa casa){
            this.casa=casa;
        }
        public void setNombre(String nombre){
            this.nombre=nombre;
        }
       public void setCedula(String cedula){
            this.cedula=cedula;
        }
         public void setPinAcceso(String pinAcceso){
            this.pinAcceso=pinAcceso;
        }
       
 }

