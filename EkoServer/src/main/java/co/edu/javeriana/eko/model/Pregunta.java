package co.edu.javeriana.eko.model;

public class Pregunta {
	
	private String _id;		
	private String id_Servicio;
	private String descripcion;
	private String respuesta;
	private String fecha_Creacion;
	
	// Constructores
	
	public Pregunta() {}	
	
	public Pregunta(String _id, String id_Servicio, String descripcion, String respuesta, 
			String fecha_Creacion) {
		
		this._id = _id;
		this.id_Servicio = id_Servicio;
		this.descripcion = descripcion;
		this.respuesta = respuesta;
		this.fecha_Creacion = fecha_Creacion;
	}
	
	
	
	// Getters y setters
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getId_Servicio() {
		return id_Servicio;
	}
	public void setId_Servicio(String id_Servicio) {
		this.id_Servicio = id_Servicio;
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
