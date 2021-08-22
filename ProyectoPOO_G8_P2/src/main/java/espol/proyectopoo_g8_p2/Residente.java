package espol.proyectopoo_g8_p2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
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
        
        public Residente(String nombreUsuario, String contrasenia, String correo, 
                Casa casa, String genero, String nombre,ArrayList<Vehiculo> vehiculos,String cedula, String pinAcceso){
            super(nombreUsuario, contrasenia);
            this.correo = correo;
            this.casa = casa;
            this.genero = GENERO.valueOf(genero.toUpperCase());
            this.nombre = nombre;
            this.cedula = cedula;
            this.pinAcceso = pinAcceso;
            this.vehiculos = vehiculos;
            
        }

        public void mostrarInformacion(){

        }

        public void cambiarPin(String pinAcceso){
            this.pinAcceso = pinAcceso;
        }

        public void registrarVehiculo(){}

        public String getPin(){
            return pinAcceso;
        }
        public void registrarVehiculo(Vehiculo vehiculo){
            vehiculos.add(vehiculo);
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
                                if(vehiculos.get(j).getNombrePropietario().equals(residente.getNombre())){
                                    residente = new Residente(p[0],p[1],p[2],casas.get(i),p[4],p[5],null,p[7],p[8]);
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
            genero=g;
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
       
        public static Residente CambiarPinResidente(String pin, String usuario) throws IOException{
            List <Residente> residentes = cargarResidente();
            String ruta = "residentes.txt";
            
            Residente res=null;
            for(Residente r:residentes){
                if (r.getNombreUsuario().equals(usuario)){
                    r.setPinAcceso(pin);
                    res=r;
                }
            }
            
            
            try(BufferedWriter bf = new BufferedWriter(new FileWriter(App.class.getResource(ruta).getFile(),false))){
                for(Residente r:residentes){
                    String line = r.getNombreUsuario()+","+r.getContrasenia()+","+r.getCorreo()+",casa,"+r.getGenero()
                    +",vehiculo,"+r.getPinAcceso()+","+r.getCedula()+","+r.getPinAcceso();
                    bf.write(line);
                    bf.newLine();
                }
                bf.close();
                
            }catch (FileNotFoundException ex){
                System.out.println("ERROR");
            } catch (IOException ex){
                System.out.println("ERROR");
            } 
          return res;  
        }
 }

