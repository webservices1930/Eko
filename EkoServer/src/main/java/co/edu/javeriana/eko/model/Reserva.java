package co.edu.javeriana.eko.model;

import java.util.List;

public class Reserva {

	private String _id;
	private String fechas;
	private String clienteid;
	private String productoid;
	//private List<Plan> plan;
	//private Usuario cliente;
	
	public Reserva() {
		
	}
	public Reserva(String _id, String fechas,String clientid, String productid) {
		this._id = _id;
		this.fechas = fechas;
		this.clienteid = clientid;
		this.productoid = productid;
	}
	public Reserva( String fechas,String clientid, String productid ) {
		this.fechas = fechas;
		this.clienteid = clientid;
		this.productoid = productid;
	}
	
	public String get_id() {
		return _id;
	}
	
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getFechas() {
		return fechas;
	}
	public void setFechas(String fechas) {
		this.fechas = fechas;
	}
	public String getClienteid() {
		return clienteid;
	}
	public void setClienteid(String clienteid) {
		this.clienteid = clienteid;
	}
	public String getProductoid() {
		return productoid;
	}
	public void setProductoid(String productoid) {
		this.productoid = productoid;
	}

	
	
}
