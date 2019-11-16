package co.edu.javeriana.eko.model.producto;

import java.util.List;

import co.edu.javeriana.eko.model.Calificacion;
import co.edu.javeriana.eko.model.Disponibilidad;
import co.edu.javeriana.eko.model.Pregunta;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.utils.TipoExperiencia;
import co.edu.javeriana.eko.utils.TipoProducto;

public class Experiencia extends Producto{
	private TipoExperiencia tipoExperiencia;
	private int nivelRiesgo;
	private int restriccionEdad;
	private double latitud;
	private double longitud;
	private int duracion;
	private String horaLlegada;
	
	public Experiencia() {
		
	}

	public Experiencia(double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad, String descripcion,
			List<Calificacion> calificacion, List<Pregunta> pregunta, TipoProducto tipo, TipoExperiencia tipoExperiencia, int nivelRiesgo, int restriccionEdad, double latitud, double longitud,
			int duracion, String horaLlegada, String idUsuario, String titulo) {
		super(precio, infoPaisDestino, disponibilidad, calificacion, pregunta, descripcion, tipo, idUsuario, titulo);
		this.tipoExperiencia = tipoExperiencia;
		this.nivelRiesgo = nivelRiesgo;
		this.restriccionEdad = restriccionEdad;
		this.latitud = latitud;
		this.longitud = longitud;
		this.duracion = duracion;
		this.horaLlegada = horaLlegada;
	}

	public Experiencia(String _id, double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad,
			List<Calificacion> calificacion, List<Pregunta> pregunta, String descripcion, TipoProducto tipo, TipoExperiencia tipoExperiencia, int nivelRiesgo, int restriccionEdad, double latitud, double longitud,
			int duracion, String horaLlegada, String idUsuario, String titulo) {
		super(_id, precio, infoPaisDestino, disponibilidad, calificacion, pregunta, descripcion, tipo, idUsuario, titulo);
		this.tipoExperiencia = tipoExperiencia;
		this.nivelRiesgo = nivelRiesgo;
		this.restriccionEdad = restriccionEdad;
		this.latitud = latitud;
		this.longitud = longitud;
		this.duracion = duracion;
		this.horaLlegada = horaLlegada;
	}

	public TipoExperiencia getTipoExperiencia() {
		return tipoExperiencia;
	}

	public void setTipoExperiencia(TipoExperiencia tipoExperiencia) {
		this.tipoExperiencia = tipoExperiencia;
	}

	public int getNivelRiesgo() {
		return nivelRiesgo;
	}

	public void setNivelRiesgo(int nivelRiesgo) {
		this.nivelRiesgo = nivelRiesgo;
	}

	public int getRestriccionEdad() {
		return restriccionEdad;
	}

	public void setRestriccionEdad(int restriccionEdad) {
		this.restriccionEdad = restriccionEdad;
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

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	
	
	
}
