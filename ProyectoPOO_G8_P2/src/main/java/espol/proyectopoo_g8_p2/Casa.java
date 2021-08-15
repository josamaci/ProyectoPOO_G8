package espol.proyectopoo_g8_p2;
public class Casa {
    private String manzana;
    private Ubicacion coordenadas;
    private String villa;
    private Residente residente;
     /**
     * Constructor para la clase Propiedad
     * @param manzana - Define la manzana 
     * @param villa - Define la villa donde se encuentra
     * @param coordenadas - Define la ubicacion en coordenadas de la casa
     * @param residente - Define el residente de la casa
     
     */
    
    public Casa(String manzana,Ubicacion coordenadas,String villa,Residente residente){
        this.manzana=manzana;
        this.villa=villa;
        this.residente=residente;
        
    }
    public Casa(String manzana,Ubicacion coordenadas,String villa){
        this.manzana=manzana;
        this.villa=villa;
        this.coordenadas=coordenadas;
        this.residente=null;
        
    }
    public String getManzana(){
    return manzana;
    }
     public Ubicacion getCoordenadas(){
    return coordenadas;
    }
      public String getVilla(){
    return villa;
    }
       public Residente getResidente(){
    return residente;
    }
    }
    
    


