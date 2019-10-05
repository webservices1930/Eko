package co.edu.javeriana.eko.model;

import co.edu.javeriana.eko.utils.TipoUsuario;

public abstract class Usuario {

    //Variables

    private String nombre;
    private int edad;
    private String foto;
    private String descripcion;
    private String correo;
    private String contrasena;
    private TipoUsuario tipoUsuario;

    //Contructor

    public Usuario(){}

    public Usuario (String nombre, int edad, String foto, String descripcion, String correo, String contrasena, TipoUsuario tipoUsuario){
        this.nombre = nombre;
        this.edad = edad;
        this.foto = foto;
        this.descripcion=descripcion;
        this.correo=correo;
        this.contrasena=contrasena;
        this.tipoUsuario = tipoUsuario;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
