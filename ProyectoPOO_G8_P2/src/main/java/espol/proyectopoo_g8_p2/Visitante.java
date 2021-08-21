package espol.proyectopoo_g8_p2;
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
    codigoAcceso=this.codigoAcceso;
    }
        public void setNombreVisitante(String nombreVisitante){
    nombreVisitante=this.nombreVisitante;
    }
         public void setNumCedula(String numCedula){
    numCedula=this.numCedula;
    }
        public void setMzResidente(int mzResidente){
    mzResidente=this.mzResidente;
    } 
        public void setVillaResidente(int villaResidente){
    villaResidente=this.villaResidente;
    } 
      
}

