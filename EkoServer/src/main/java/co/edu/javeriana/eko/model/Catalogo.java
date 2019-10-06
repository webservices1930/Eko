package co.edu.javeriana.eko.model;

import java.util.List;

public class Catalogo {

	private String _id;
	private String nombre;
	private String idUsuario;
	private List<String> productos;
	private double precio;
	private String descripcion;
	
	public Catalogo() {	
		super();
	}

	public Catalogo(String _id, String nombre, String idUsuario, List<String> productos, double precio,
			String descripcion) {
		super();
		this._id = _id;
		this.nombre = nombre;
		this.idUsuario = idUsuario;
		this.productos = productos;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<String> getProductos() {
		return productos;
	}

	public void setProductos(List<String> productos) {
		this.productos = productos;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
