package co.edu.javeriana.eko.model.producto;

import java.util.List;

import co.edu.javeriana.eko.model.Calificacion;
import co.edu.javeriana.eko.model.Disponibilidad;
import co.edu.javeriana.eko.model.Pregunta;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.utils.TipoEvento;
import co.edu.javeriana.eko.utils.TipoProducto;

public class Evento extends Producto{
	private TipoEvento tipoEvento;
	private String nombreEvento;
	private int restriccionEdad;
	private String horaApertura;
	private String horaCierre;
	private int maxPersonas;
	private double latitud;
	private double longitud;
	public Evento() {
		super();

	}
	public Evento(double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad, String descripcion,
			List<Calificacion> calificacion, List<Pregunta> pregunta, TipoProducto tipo, TipoEvento tipoEvento, String nombreEvento, int restriccionEdad, String horaApertura, String horaCierre,
			int maxPersonas, double latitud, double longitud, String idUsuario, String titulo,String foto, String ciudad) {
		super(precio, infoPaisDestino, disponibilidad, calificacion, pregunta, descripcion, tipo, idUsuario, titulo,foto,ciudad);
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
			List<Calificacion> calificacion, List<Pregunta> pregunta, String descripcion, TipoProducto tipo, TipoEvento tipoEvento, String nombreEvento, int restriccionEdad, String horaApertura, String horaCierre,
			int maxPersonas, double latitud, double longitud, String idUsuario, String titulo,String foto, String ciudad) {
		super(_id, precio, infoPaisDestino, disponibilidad, calificacion, pregunta, descripcion, tipo, idUsuario, titulo,foto, ciudad);
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
	public String getHoraApertura() {
		return horaApertura;
	}
	public void setHoraApertura(String horaApertura) {
		this.horaApertura = horaApertura;
	}
	public String getHoraCierre() {
		return horaCierre;
	}
	public void setHoraCierre(String horaCierre) {
		this.horaCierre = horaCierre;
	}
	public int getMaxPersonas() {
		return maxPersonas;
	}
	public void setMaxPersonas(int maxPersonas) {
		this.maxPersonas = maxPersonas;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}


}
