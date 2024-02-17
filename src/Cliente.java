public class Cliente extends Sistema {
    private String nombre;
    private String cedula;
    private String correo;
    private String telefono;
    private String direccion;
    private String password;

    public Cliente(String nombre, String cedula, String correo, String telefono, String direccion, String password) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCorreo(){
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getPassword() {
        return password;
    }
}