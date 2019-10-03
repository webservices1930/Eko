package co.edu.javeriana.eko.model.producto;

import java.util.List;

import co.edu.javeriana.eko.model.Disponibilidad;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.utils.TipoDeSitio;
import co.edu.javeriana.eko.utils.TipoProducto;

public class Sitio extends Producto{
	private TipoDeSitio tipoDeSitio;
	private double latitud;
	private double longitud;
	private int restriccionEdad;
	private boolean consumoObligatorio;
	private int horaApertura;
	private int horaCierre;
	
	public Sitio() {		
	
	}

	public Sitio(double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad, String descripcion,
			TipoProducto tipo, TipoDeSitio tipoDeSitio, double latitud, double longitud, int restriccionEdad,
			boolean consumoObligatorio, int horaApertura, int horaCierre) {
		super(precio, infoPaisDestino, disponibilidad, descripcion, tipo);
		this.tipoDeSitio = tipoDeSitio;
		this.latitud = latitud;
		this.longitud = longitud;
		this.restriccionEdad = restriccionEdad;
		this.consumoObligatorio = consumoObligatorio;
		this.horaApertura = horaApertura;
		this.horaCierre = horaCierre;
	}

	public Sitio(String _id, double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad,
			String descripcion, TipoProducto tipo, TipoDeSitio tipoDeSitio, double latitud, double longitud, int restriccionEdad,
			boolean consumoObligatorio, int horaApertura, int horaCierre) {
		super(_id, precio, infoPaisDestino, disponibilidad, descripcion, tipo);
		this.tipoDeSitio = tipoDeSitio;
		this.latitud = latitud;
		this.longitud = longitud;
		this.restriccionEdad = restriccionEdad;
		this.consumoObligatorio = consumoObligatorio;
		this.horaApertura = horaApertura;
		this.horaCierre = horaCierre;
	}

	public TipoDeSitio getTipoDeSitio() {
		return tipoDeSitio;
	}

	public void setTipoDeSitio(TipoDeSitio tipoDeSitio) {
		this.tipoDeSitio = tipoDeSitio;
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

	public int getRestriccionEdad() {
		return restriccionEdad;
	}

	public void setRestriccionEdad(int restriccionEdad) {
		this.restriccionEdad = restriccionEdad;
	}

	public boolean isConsumoObligatorio() {
		return consumoObligatorio;
	}

	public void setConsumoObligatorio(boolean consumoObligatorio) {
		this.consumoObligatorio = consumoObligatorio;
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
	
	
	
	
}
