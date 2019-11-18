package co.edu.javeriana.eko.model;

import java.util.List;

public class Carrito {

	private String _id;	
	private String idUsuario;
	private List<String> productos;
	
	public Carrito() {
		super();
	}

	public Carrito(String _id, String idUsuario, List<String> productos) {
		super();
		this._id = _id;
		this.idUsuario = idUsuario;
		this.productos = productos;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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
	
	
	
}
