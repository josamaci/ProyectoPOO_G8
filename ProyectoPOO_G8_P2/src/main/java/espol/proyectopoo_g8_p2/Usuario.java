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
    
    public boolean equals(Usuario u){
        if (u.nombreUsuario.equals(nombreUsuario) && u.contrasenia.equals(contrasenia)){
        return true;
        }
    return false;
    }
    
    public static List<Usuario> cargarUsuario(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.addAll(Residente.cargarResidente());
        List<Residente>residentes = Residente.cargarResidente();
        for (Usuario usuario: residentes)
            System.out.println(usuario.getNombreUsuario()+" "+usuario.getContrasenia());
        usuarios.addAll(Administrador.cargarAdmin());
        for (Usuario usuario: usuarios)
            System.out.println(usuario.getNombreUsuario()+" "+usuario.getContrasenia());
        return usuarios;
    }
}

