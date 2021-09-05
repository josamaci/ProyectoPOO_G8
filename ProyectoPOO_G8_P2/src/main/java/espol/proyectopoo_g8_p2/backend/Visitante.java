package espol.proyectopoo_g8_p2.backend;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

    public class Visitante{
    private String codigoAcceso;
    private String nombreVisitante;
    private String numCedula;
    private String mzResidente;
    private String villaResidente;
    private LocalDateTime fechaIngreso;
    private String correo;
    private boolean usoCodigo;
    
    /**
     * Constructor que crea un Visitante 
     * @param codigoAcceso
     * @param nombreVisitante
     * @param numCedula
     * @param correo
     * @param mzResidente
     * @param villaResidente
     * @param fechaIngreso 
     */
    public Visitante(String codigoAcceso,String nombreVisitante,String numCedula,String correo, String mzResidente,String villaResidente,LocalDateTime fechaIngreso){
    this.codigoAcceso=codigoAcceso;
    this.nombreVisitante=nombreVisitante;
    this.numCedula=numCedula;
    this.mzResidente=mzResidente;
    this.villaResidente=villaResidente;
    this.fechaIngreso = fechaIngreso;
    this.correo = correo;
    this.usoCodigo = true;
    }
    /**
     * Constructor que crea un Visitante sin correo
     * @param codigoAcceso
     * @param nombreVisitante
     * @param numCedula
     * @param mzResidente
     * @param villaResidente
     * @param fechaIngreso 
     */
    public Visitante(String codigoAcceso,String nombreVisitante,String numCedula, String mzResidente,String villaResidente,LocalDateTime fechaIngreso){
    this.codigoAcceso=codigoAcceso;
    this.nombreVisitante=nombreVisitante;
    this.numCedula=numCedula;
    this.mzResidente=mzResidente;
    this.villaResidente=villaResidente;
    this.fechaIngreso = fechaIngreso;
    this.correo = null;
    this.usoCodigo = true;
    }
    
    /**
     * Constructor vacío de visitante
     */
    public Visitante(){
    
    }
    
    /**
     * Método estático que devuelve la lista de los visitantes que se encuentran en visitantes.txt
     * @return visitantes
     */
    public static List<Visitante> cargarVisitante(){
        
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
                    visitantes.add(v);
                }
            } catch (IOException ex){
                System.out.println("ERROR: No se pudo cargar la información de los visitantes");
            }
        System.out.println(visitantes);    
        return visitantes;
    } 
    
    /**
     * getter que devuelve el código de acceso del visitante
     * @return codigoAcceso
     */
    public String getCodigoAcceso(){
    return codigoAcceso;
    }
    /**
     * getter que devuelve el nombre del visitante
     * @return nombreVisitante
     */
        public String getNombreVisitante(){
    return nombreVisitante;
    } 
    /**
     * getter que devuelve el número de cédula del visitante
     * @return numCedula
     */
        public String getNumCedula(){
    return numCedula;
    } 
    /**
     * getter que devuelve la manzana de la casa del residente
     * @return mzResidente
     */
        public String getMzResidente(){
    return mzResidente;
    } 
    /**
     * getter que devuelve la villa de la casa del residente
     * @return villaResidente
     */
        public String getVillaResidente(){
    return villaResidente;
    } 
    /**
     * getter que devuelve la fecha de ingreso a la casa del residente
     * @return fechaIngreso
     */
        public LocalDateTime getFechaIngreso(){
    return fechaIngreso;
    }
        /**
     * getter que devuelve un boolean si se usó la 
     * @return usoCodigo
     */
        public boolean getUsoCodigo(){
    return usoCodigo;
    }
    public void setCodigoAcceso(String codigoAcceso){
    this.codigoAcceso = codigoAcceso;
    }
        public void setNombreVisitante(String nombreVisitante){
    this.nombreVisitante=nombreVisitante;
    }
         public void setNumCedula(String numCedula){
    this.numCedula=numCedula;
    }
        public void setMzResidente(String mzResidente){
    this.mzResidente=mzResidente;
    } 
        public void setVillaResidente(String villaResidente){
    this.villaResidente=villaResidente;
    } 
        public void setUsoCodigo(boolean bool){
    usoCodigo = bool;
    }   
    public boolean comprobarFechaIngreso(){
        if(fechaIngreso.minusMinutes(5).isBefore(LocalDateTime.now()) && fechaIngreso.minusMinutes(-5).isAfter(LocalDateTime.now())){
            return true;}
            
        return false;
        }
}

