package co.edu.javeriana.eko.model;

import java.util.List;

import co.edu.javeriana.eko.utils.TipoProducto;

public abstract class Producto {
	
	// VARIABLES
	private String _id;
	private double precio;
	private String infoPaisDestino;
	private List<Disponibilidad> disponibilidad;
	private String descripcion;
	private TipoProducto tipo;

	// CONSTRUCTORES
	public Producto() {}
	
	public Producto(double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad,
			String descripcion, TipoProducto tipo) {
		this.precio = precio;
		this.infoPaisDestino = infoPaisDestino;
		this.disponibilidad = disponibilidad;
		this.descripcion = descripcion;
		this.tipo = tipo;
	}
	
	public Producto(String _id, double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad,
			String descripcion, TipoProducto tipo) {
		this._id = _id;
		this.precio = precio;
		this.infoPaisDestino = infoPaisDestino;
		this.disponibilidad = disponibilidad;
		this.descripcion = descripcion;
		this.tipo = tipo;
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
	
	// MÉTODOS
	public double calcularCalificacionPromedio() {
		return 0;
	}
}
