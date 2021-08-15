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
}

