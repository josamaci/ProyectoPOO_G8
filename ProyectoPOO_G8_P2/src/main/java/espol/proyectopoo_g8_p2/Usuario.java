package espol.proyectopoo_g8_p2;

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
}

