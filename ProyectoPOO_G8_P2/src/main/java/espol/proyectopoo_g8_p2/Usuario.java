package espol.proyectopoo_g8_p2;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    private String nombreUsuario;
    private String contrasenia;
    
    public Usuario(String nombreUsuario,String contrasenia){
        this.nombreUsuario=nombreUsuario;
        this.contrasenia=contrasenia;
    }
    
    public String getNombreUsuario(){
        return nombreUsuario;
    }
    
    public String getContrasenia(){
        return contrasenia;
    }
      public String setNombreUsuario(String nombre){
        nombreUsuario=nombre;
    }
    
    public String setContrasenia(String contra){
        contrasenia=contra;
    }
    
    public boolean equals(Usuario u){
        if (u.nombreUsuario.equals(nombreUsuario) && u.contrasenia.equals(contrasenia)){
        return true;
        }
    return false;
    }
    
    public static List<Usuario> cargarUsuario(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.addAll(Residente.cargarResidente());
        usuarios.addAll(Administrador.cargarAdmin());
        
        return usuarios;
    }
}

