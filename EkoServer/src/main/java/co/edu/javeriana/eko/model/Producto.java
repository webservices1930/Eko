package co.edu.javeriana.eko.model;

import java.util.List;

import co.edu.javeriana.eko.utils.TipoProducto;

public abstract class Producto {
	
	// VARIABLES
	private String _id;
	private double precio;
	private String infoPaisDestino;
	private String idUsuario;
	private List<Disponibilidad> disponibilidad;
	private List<Calificacion> calificacion;
	private List<Pregunta> pregunta;
	private String descripcion;
	private TipoProducto tipo;

	// CONSTRUCTORES
	public Producto() {}
	
	public Producto(double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad,
			String descripcion, TipoProducto tipo, String idUsuario) {
			
		this.precio = precio;
		this.infoPaisDestino = infoPaisDestino;
		this.disponibilidad = disponibilidad;
		this.calificacion = calificacion;
		this.pregunta = pregunta;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.idUsuario = idUsuario;
	}
	
	public Producto(String _id, double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad,
			String descripcion, TipoProducto tipo, String idUsuario) {			
		this._id = _id;
		this.precio = precio;
		this.infoPaisDestino = infoPaisDestino;
		this.disponibilidad = disponibilidad;
		this.calificacion = calificacion;
		this.pregunta = pregunta;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.idUsuario = idUsuario;
	}

	// GETTERS Y SETTERS

	public String get_id() {
		return _id;
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
		infoPaisDestino = infoPaisDestino;
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
		int promedio = 0 ;		
		for (Calificacion calificacion : this.calificacion) {
			 promedio += calificacion.getValoracion();
		}		
		return promedio/this.calificacion.size();
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
