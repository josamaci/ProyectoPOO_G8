package espol.proyectopoo_g8_p2.backend;

import espol.proyectopoo_g8_p2.App;
import espol.proyectopoo_g8_p2.backend.Residente;
import espol.proyectopoo_g8_p2.backend.Ubicacion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//comentario
public class Casa {
    private String manzana;
    private Ubicacion coordenadas;
    private String villa;
    private String residente;
     /**
     * Constructor para la clase Propiedad
     * @param manzana - Define la manzana 
     * @param villa - Define la villa donde se encuentra
     * @param coordenadas - Define la ubicacion en coordenadas de la casa
     * @param residente - Define el residente de la casa
     
     */
    
    public Casa(String manzana,Ubicacion coordenadas,String villa,String residente){
        this.manzana=manzana;
        this.coordenadas=coordenadas;
        this.villa=villa;
        this.residente=residente;
        
    }
    public Casa(String manzana,Ubicacion coordenadas,String villa){
        this.manzana=manzana;
        this.coordenadas=coordenadas;
        this.villa=villa;
        residente="";
    }
    public Casa(){
    }
    
       
        public static List<Casa> cargarCasa(){
        
            String ruta = "casas.txt";
            List<Casa> casas = new ArrayList<>();
            
            try(InputStream input = App.class.getResource(ruta).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
                
                String linea;
                
                while((linea=bf.readLine())!=null){
                    
                    String[] p = linea.split(",");
                    String[] u = p[1].split(":");
                    
                    Ubicacion ubicacion = new Ubicacion(Double.valueOf(u[0]),Double.valueOf(u[1]));
                    Casa casa = new Casa(p[0],ubicacion,p[2],p[3]);
                    casas.add(casa);
                }
            } catch (IOException ex){
                System.out.println("ERROR: No se pudo cargar la información de las casas");

            }
        return casas;
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
       public String getResidente(){
    return residente;
    }
       public void setManzana(String manzana){
    this.manzana=manzana;
    }
     public void setCoordenadas(Ubicacion u){
   coordenadas=u;
    }
     public void setVilla(String villa){
    this.villa=villa;
    }
    
       public void setResidente(String res){
    residente=res;
    }
       
    }
    
    


