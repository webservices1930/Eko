package co.edu.javeriana.eko.model.producto;

import java.util.List;

import co.edu.javeriana.eko.model.Disponibilidad;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.utils.TipoExperiencia;
import co.edu.javeriana.eko.utils.TipoProducto;

public class Experiencia extends Producto{
	private TipoExperiencia tipoExperiencia;
	private int nivelRiesgo;
	private int restriccionEdad;
	private float latitud;
	private float longitud;
	private int duracion;
	private int horaLlegada;
	
	public Experiencia() {
		
	}

	public Experiencia(double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad, String descripcion,
			TipoProducto tipo, TipoExperiencia tipoExperiencia, int nivelRiesgo, int restriccionEdad, float latitud, float longitud,
			int duracion, int horaLlegada) {
		super(precio, infoPaisDestino, disponibilidad, descripcion, tipo);
		this.tipoExperiencia = tipoExperiencia;
		this.nivelRiesgo = nivelRiesgo;
		this.restriccionEdad = restriccionEdad;
		this.latitud = latitud;
		this.longitud = longitud;
		this.duracion = duracion;
		this.horaLlegada = horaLlegada;
	}

	public Experiencia(String _id, double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad,
			String descripcion, TipoProducto tipo, TipoExperiencia tipoExperiencia, int nivelRiesgo, int restriccionEdad, float latitud, float longitud,
			int duracion, int horaLlegada) {
		super(_id, precio, infoPaisDestino, disponibilidad, descripcion, tipo);
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

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(int horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	
	
	
}
