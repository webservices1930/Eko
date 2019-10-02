package co.edu.javeriana.eko.model;

import java.util.List;

import co.edu.javeriana.eko.utils.TipoProducto;
import co.edu.javeriana.eko.utils.TipoTransporte;

public class Calificacion {
	
	private String _id;	
	private int valoracion;
	private String id_Producto;
	private String comentario;
	private String fecha_Creacion;
	
	
	// Constructores
	public Calificacion() {}
	
	
	public Calificacion(String _id, int valoracion, String id_Producto, String comentario, 
			String fecha_Creacion) {
		
		this._id = _id;
		this.valoracion = valoracion;
		this.id_Producto = id_Producto;
		this.comentario = comentario;
		this.fecha_Creacion = fecha_Creacion;
	}
	// Getters y setters
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public int getValoracion() {
		return valoracion;
	}
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	public String getId_Producto() {
		return id_Producto;
	}
	public void setId_Producto(String id_Producto) {
		this.id_Producto = id_Producto;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getFecha_Creacion() {
		return fecha_Creacion;
	}
	public void setFecha_Creacion(String fecha_Creacion) {
		this.fecha_Creacion = fecha_Creacion;
	}	
	
	
	
	
	

}
