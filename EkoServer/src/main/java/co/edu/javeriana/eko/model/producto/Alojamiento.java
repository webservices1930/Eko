package co.edu.javeriana.eko.model.producto;

import java.util.List;

import co.edu.javeriana.eko.model.Disponibilidad;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.utils.TipoAlojamiento;
import co.edu.javeriana.eko.utils.TipoProducto;

public class Alojamiento extends Producto{
	private TipoAlojamiento tipoAlojamiento;
	private double latitud;
	private double longitud;
	private int habitaciones;
	private boolean desayuno;
	private boolean almuerzo;
	private boolean cena;
	private boolean internet;
	private boolean television;
	private int numCamas;
	private int numBanios;	
	


	public Alojamiento() {
		
	}

	public Alojamiento(double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad, String descripcion,
			TipoProducto tipo, TipoAlojamiento tipoAlojamiento, double latitud, double longitud, int habitaciones, boolean desayuno,
			boolean almuerzo, boolean cena, boolean internet, boolean television, int numCamas, int numBanios, String idUsuario) {
		super(precio, infoPaisDestino, disponibilidad, descripcion, tipo, idUsuario);
		this.tipoAlojamiento = tipoAlojamiento;
		this.latitud = latitud;
		this.longitud = longitud;
		this.habitaciones = habitaciones;
		this.desayuno = desayuno;
		this.almuerzo = almuerzo;
		this.cena = cena;
		this.internet = internet;
		this.television = television;
		this.numCamas = numCamas;
		this.numBanios = numBanios;		
	}

	public Alojamiento(String _id, double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad,
			String descripcion, TipoProducto tipo,TipoAlojamiento tipoAlojamiento, double latitud, double longitud, int habitaciones, boolean desayuno,
			boolean almuerzo, boolean cena, boolean internet, boolean television, int numCamas, int numBanios, String idUsuario) {
		super(_id, precio, infoPaisDestino, disponibilidad, descripcion, tipo, idUsuario);
		this.tipoAlojamiento = tipoAlojamiento;
		this.latitud = latitud;
		this.longitud = longitud;
		this.habitaciones = habitaciones;
		this.desayuno = desayuno;
		this.almuerzo = almuerzo;
		this.cena = cena;
		this.internet = internet;
		this.television = television;
		this.numCamas = numCamas;
		this.numBanios = numBanios;
	}

	public TipoAlojamiento getTipoAlojamiento() {
		return tipoAlojamiento;
	}

	public void setTipoAlojamiento(TipoAlojamiento tipoAlojamiento) {
		this.tipoAlojamiento = tipoAlojamiento;
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

	public int getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	public boolean isDesayuno() {
		return desayuno;
	}

	public void setDesayuno(boolean desayuno) {
		this.desayuno = desayuno;
	}

	public boolean isAlmuerzo() {
		return almuerzo;
	}

	public void setAlmuerzo(boolean almuerzo) {
		this.almuerzo = almuerzo;
	}

	public boolean isCena() {
		return cena;
	}

	public void setCena(boolean cena) {
		this.cena = cena;
	}

	public boolean isInternet() {
		return internet;
	}

	public void setInternet(boolean internet) {
		this.internet = internet;
	}

	public boolean isTelevision() {
		return television;
	}

	public void setTelevision(boolean television) {
		this.television = television;
	}

	public int getNumCamas() {
		return numCamas;
	}

	public void setNumCamas(int numCamas) {
		this.numCamas = numCamas;
	}

	public int getNumBanios() {
		return numBanios;
	}

	public void setNumBanios(int numBanios) {
		this.numBanios = numBanios;
	}
	
	
	
}
