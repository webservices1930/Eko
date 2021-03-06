package co.edu.javeriana.eko.model;

import co.edu.javeriana.eko.utils.TipoProducto;

import java.util.List;

public abstract class Producto {

    // VARIABLES
    private String titulo;
    private String _id;
    private double precio;
    private String infoPaisDestino;
    private String idUsuario;
    private List<Disponibilidad> disponibilidad;
    private List<Calificacion> calificacion;
    private List<Pregunta> pregunta;
    private String descripcion;
    private TipoProducto tipo;
    private String foto;
    private String ciudad;

    // CONSTRUCTORES
    public Producto() {
    }

    public Producto(double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad,
                    List<Calificacion> calificacion, List<Pregunta> pregunta, String descripcion, TipoProducto tipo, String idUsuario, String titulo, String foto, String ciudad) {
        this.titulo = titulo;
        this.precio = precio;
        this.infoPaisDestino = infoPaisDestino;
        this.disponibilidad = disponibilidad;
        this.calificacion = calificacion;
        this.pregunta = pregunta;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.idUsuario = idUsuario;
        this.foto = foto;
        this.ciudad = ciudad;
    }

    public Producto(String _id, double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad
            , List<Calificacion> calificacion, List<Pregunta> pregunta, String descripcion, TipoProducto tipo, String idUsuario, String titulo,String ciudad, String foto) {
        this.titulo = titulo;
        this._id = _id;
        this.precio = precio;
        this.infoPaisDestino = infoPaisDestino;
        this.disponibilidad = disponibilidad;
        this.calificacion = calificacion;
        this.pregunta = pregunta;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.idUsuario = idUsuario;
        this.foto = foto;
        this.ciudad = ciudad;
    }

    // GETTERS Y SETTERS

    public String get_id() {
        return _id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getInfoPaisDestino() {
        return infoPaisDestino;
    }

    public void setInfoPaisDestino(String infoPaisDestino) {
        this.infoPaisDestino = infoPaisDestino;
    }

    public List<Disponibilidad> getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(List<Disponibilidad> disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public List<Calificacion> getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(List<Calificacion> calificacion) {
        this.calificacion = calificacion;
    }

    public List<Pregunta> getPregunta() {
        return pregunta;
    }

    public void setPregunta(List<Pregunta> pregunta) {
        this.pregunta = pregunta;
    }

    // M�TODOS
    public double calcularCalificacionPromedio() {
        int promedio = 0;
        for (Calificacion calificacion : this.calificacion) {
            promedio += calificacion.getValoracion();
        }
        return promedio / this.calificacion.size();
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

}
