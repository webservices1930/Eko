package co.edu.javeriana.eko.model;

public class Pregunta {
	
	private String _id;		
	private String id_Producto;
	private String id_Usuario ;
	private String descripcion;
	private String respuesta;
	private String fecha_Creacion;
	
	// Constructores
	
	public Pregunta() {}	
	
		
	public Pregunta(String _id, String id_Producto, String id_Usuario, String descripcion, String respuesta,
			String fecha_Creacion) {
		
		this._id = _id;
		this.id_Producto = id_Producto;
		this.id_Usuario = id_Usuario;
		this.descripcion = descripcion;
		this.respuesta = respuesta;
		this.fecha_Creacion = fecha_Creacion;
	}





	// Getters y setters
	
	public String getId_Producto() {
		return id_Producto;
	}


	public void setId_Producto(String id_Producto) {
		this.id_Producto = id_Producto;
	}


	public String getId_Usuario() {
		return id_Usuario;
	}


	public void setId_Usuario(String id_Usuario) {
		this.id_Usuario = id_Usuario;
	}


	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public String getFecha_Creacion() {
		return fecha_Creacion;
	}
	public void setFecha_Creacion(String fecha_Creacion) {
		this.fecha_Creacion = fecha_Creacion;
	}	

}
