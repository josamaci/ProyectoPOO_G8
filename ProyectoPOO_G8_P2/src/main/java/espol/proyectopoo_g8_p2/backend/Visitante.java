package espol.proyectopoo_g8_p2.backend;
import java.time.LocalDateTime;

    public class Visitante{
    private String codigoAcceso;
    private String nombreVisitante;
    private String numCedula;
    private int mzResidente;
    private int villaResidente;
    private LocalDateTime fechaIngreso;
    
    public Visitante(String codigoAcceso,String nombreVisitante,String numcedula,int mzResidente,int villaResidente,LocalDateTime fechaIngreso){
    this.codigoAcceso=codigoAcceso;
    this.nombreVisitante=nombreVisitante;
    this.numCedula=numcedula;
    this.mzResidente=mzResidente;
    this.villaResidente=villaResidente;
    this.fechaIngreso = fechaIngreso;
    }
    
    public void registrarVisita(String ca,String nv,int nc,int mz,int villa,LocalDateTime f){
        
    }
    public String getCodigoAcceso(){
    return codigoAcceso;
    }
        public String getNombreVisitante(){
    return nombreVisitante;
    } 
        public String getNumCedula(){
    return numCedula;
    } 
        public int getMzResidente(){
    return mzResidente;
    } 
        public int getVillaResidente(){
    return villaResidente;
    } 
        public LocalDateTime getFechaIngreso(){
    return fechaIngreso;
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
        public void setMzResidente(int mzResidente){
    this.mzResidente=mzResidente;
    } 
        public void setVillaResidente(int villaResidente){
    this.villaResidente=villaResidente;
    } 
      
}

