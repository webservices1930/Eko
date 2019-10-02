package co.edu.javeriana.eko.model.producto;

import java.util.List;

import co.edu.javeriana.eko.model.Disponibilidad;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.utils.TipoEvento;
import co.edu.javeriana.eko.utils.TipoProducto;

public class Evento extends Producto{
	private TipoEvento tipoEvento;
	private String nombreEvento;
	private int restriccionEdad;
	private int horaApertura;
	private int horaCierre;
	private int maxPersonas;
	private float latitud;
	private float longitud;
	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Evento(double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad, String descripcion,
			TipoProducto tipo, TipoEvento tipoEvento, String nombreEvento, int restriccionEdad, int horaApertura, int horaCierre,
			int maxPersonas, float latitud, float longitud) {
		super(precio, infoPaisDestino, disponibilidad, descripcion, tipo);
		this.tipoEvento = tipoEvento;
		this.nombreEvento = nombreEvento;
		this.restriccionEdad = restriccionEdad;
		this.horaApertura = horaApertura;
		this.horaCierre = horaCierre;
		this.maxPersonas = maxPersonas;
		this.latitud = latitud;
		this.longitud = longitud;
	}
	public Evento(String _id, double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad,
			String descripcion, TipoProducto tipo, TipoEvento tipoEvento, String nombreEvento, int restriccionEdad, int horaApertura, int horaCierre,
			int maxPersonas, float latitud, float longitud) {
		super(_id, precio, infoPaisDestino, disponibilidad, descripcion, tipo);
		this.tipoEvento = tipoEvento;
		this.nombreEvento = nombreEvento;
		this.restriccionEdad = restriccionEdad;
		this.horaApertura = horaApertura;
		this.horaCierre = horaCierre;
		this.maxPersonas = maxPersonas;
		this.latitud = latitud;
		this.longitud = longitud;
	}
	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public String getNombreEvento() {
		return nombreEvento;
	}
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	public int getRestriccionEdad() {
		return restriccionEdad;
	}
	public void setRestriccionEdad(int restriccionEdad) {
		this.restriccionEdad = restriccionEdad;
	}
	public int getHoraApertura() {
		return horaApertura;
	}
	public void setHoraApertura(int horaApertura) {
		this.horaApertura = horaApertura;
	}
	public int getHoraCierre() {
		return horaCierre;
	}
	public void setHoraCierre(int horaCierre) {
		this.horaCierre = horaCierre;
	}
	public int getMaxPersonas() {
		return maxPersonas;
	}
	public void setMaxPersonas(int maxPersonas) {
		this.maxPersonas = maxPersonas;
	}
	public float getLatitud() {
		return latitud;
	}
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}		
}
