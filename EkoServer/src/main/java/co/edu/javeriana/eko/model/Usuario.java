package co.edu.javeriana.eko.model;

public abstract class Usuario {

    //Variables

    private String nombre;
    private int edad;
    private String foto;
    private String descripcion;
    private String correo;
    private String contraseña;

    //Contructor

    public Usuario(){}

    public Usuario (String nombre, int edad, String foto, String descripcion, String correo, String contraseña){
        this.nombre = nombre;
        this.edad = edad;
        this.foto = foto;
        this.descripcion=descripcion;
        this.correo=correo;
        this.contraseña=contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Object getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
