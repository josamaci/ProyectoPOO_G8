package espol.proyectopoo_g8_p2.backend;
import espol.proyectopoo_g8_p2.App;
import espol.proyectopoo_g8_p2.backend.Usuario;
import espol.proyectopoo_g8_p2.backend.Vehiculo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
public class Residente extends Usuario{
    private String correo;
    private Casa casa;
    private GENERO genero;
    private String nombre;
    private ArrayList<Vehiculo> vehiculos ;
    private String cedula;
    private String pinAcceso;
    private ArrayList<Visitante> visitantes;
    
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
    public static Visitante registrarVisitante(String nombre,String numcedula,String correo,String mzResidente,String villaResidente, LocalDateTime fecha){
    
    List<Visitante> visitantes = Visitante.cargarVisitante();
    char [] chars = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();
    int charsLength = chars.length;
    String codigo;
    boolean c=false;
    do{
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();

        for (int i=0;i<8;i++){
        buffer.append(chars[random.nextInt(charsLength)]);
            }  

        codigo=buffer.toString();

        for(int i=0; i<visitantes.size(); i++){
            if (codigo.equals(visitantes.get(i).getCodigoAcceso())){
                c = true;
        }
    }
    }while(c);
    
    
    String ruta = "src/main/resources/espol/proyectopoo_g8_p2/visitantes.txt";
    try(BufferedWriter bf = new BufferedWriter(new FileWriter(ruta, true))){
            
                    String line = codigo+","+nombre+","+numcedula+","+correo+","+mzResidente+","+villaResidente+","+fecha.getYear()+"-"+fecha.getMonthValue()+"-"+fecha.getDayOfMonth()+"-"+fecha.getHour()+"-"+fecha.getMinute();
                    bf.write(line);
                    bf.newLine();
                
                                
            }catch (FileNotFoundException ex){
                System.out.println("ERROR File");
            } catch (IOException ex){
                System.out.println("ERROR IO");
            }
    return new Visitante(codigo,nombre,numcedula,correo,mzResidente,villaResidente,fecha);
    }

        


        public String getPin(){
            return pinAcceso;
        }
        public void registrarVehiculo(Vehiculo vehiculo){
            vehiculos.add(vehiculo);
        }
        
        

        
        

     public List<Visitante> listaVisitantes(){
     Residente r = (Residente)App.getUsuario();    
     String ruta = "src/main/resources/espol/proyectopoo_g8_p2/visitantes.txt";
            List<Visitante> visitantes = new ArrayList<>();           
            Charset c = Charset.forName("UTF-8");
            try(BufferedReader bf = new BufferedReader(
                                    new FileReader(ruta,c))){
                
                String linea;
                
                while((linea=bf.readLine())!=null){
                    System.out.println(linea);
                    String[] p = linea.split(",");
                    String[] fecha = p[6].split("-");
                    LocalDateTime lc = LocalDateTime.of(Integer.parseInt(fecha[0]), Integer.parseInt(fecha[1]), Integer.parseInt(fecha[2]), Integer.parseInt(fecha[3]), Integer.parseInt(fecha[4]));
                    Visitante v = new Visitante(p[0],p[1],p[2],p[3],p[4],p[5], lc);
                    if(v.getMzResidente().equals(r.getCasa().getManzana()) && v.getVillaResidente().equals(r.getCasa().getVilla())){
                    visitantes.add(v);
                    }
                }
                
            } catch (IOException ex){
                System.out.println("ERROR: No se pudo cargar la información de los visitantes");
            }
        return visitantes;

        }
        
        public void eliminarVisitante(){

        }
  
        
        public static List<Residente> cargarResidente(){
        
            String ruta = "src/main/resources/espol/proyectopoo_g8_p2/residentes.txt";
            List<Residente> residentes = new ArrayList<>();
            List<Casa> casas = Casa.cargarCasa();
            List<Vehiculo> vehiculos = Vehiculo.cargarVehiculos();            
            Charset c = Charset.forName("UTF-8");
            try(BufferedReader bf = new BufferedReader(
                                    new FileReader(ruta,c))){
                
                String linea;
                Casa casa =new Casa();
                
                while((linea=bf.readLine())!=null){
                    System.out.println(linea);
                    String[] p = linea.split(",");
                    for(Casa ca:casas){
                        if(ca.getResidente().equals(p[4])){
                            casa=ca;
                        }
                    }
                    Residente residente = new Residente(p[0],p[1],p[2],casa,p[3],p[4],p[5],p[6]);
                    
                    for(Vehiculo v:vehiculos){
                        if(v.getNombrePropietario().equals(residente.getNombre())){
                            residente.registrarVehiculo(v);
                        }
                    }
                    residentes.add(residente);
                }
            } catch (IOException ex){
                System.out.println("ERROR: No se pudo cargar la información de los residentes");
            }
        System.out.println(residentes);    
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
            String ruta = "src/main/resources/espol/proyectopoo_g8_p2/residentes.txt";
            
            Residente res=null;
            for(Residente r:residentes){
                if (r.getNombreUsuario().equals(usuario)){
                    r.setPinAcceso(pin);
                    res=r;
                    System.out.println(res.getPinAcceso());
                }
            }
            
            try(BufferedWriter bf = new BufferedWriter(new FileWriter(ruta))){
                for(Residente r:residentes){
                    String line = r.getNombreUsuario()+","+r.getContrasenia()+","+r.getCorreo()+","+r.getGenero()
                    +","+r.getNombre()+","+r.getCedula()+","+r.getPinAcceso();
                    bf.write(line);
                    bf.newLine();
                    
                }
                                
            }catch (FileNotFoundException ex){
                System.out.println("ERROR File");
            } catch (IOException ex){
                System.out.println("ERROR IO");
            } 
          return res;  
        }
 }

