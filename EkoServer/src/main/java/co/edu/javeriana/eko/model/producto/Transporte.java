package co.edu.javeriana.eko.model.producto;

import java.util.List;

import co.edu.javeriana.eko.model.Disponibilidad;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.utils.TipoProducto;
import co.edu.javeriana.eko.utils.TipoTransporte;

public class Transporte extends Producto {
	private int horaSalida;
	private int horaLlegada;
	private List<String> trayecto;
	private TipoTransporte tipoTransporte;
	private int duracion;

	// CONSTRUCTORES
	public Transporte() {
	}

	public Transporte(double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad, String descripcion,
			TipoProducto tipo, int horaSalida, int horaLlegada, List<String> trayecto, TipoTransporte tipoTransporte,
			int duracion, String idUsuario) {
		super(precio, infoPaisDestino, disponibilidad, descripcion, tipo, idUsuario);
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.trayecto = trayecto;
		this.tipoTransporte = tipoTransporte;
		this.duracion = duracion;
	}

	public Transporte(String _id, double precio, String infoPaisDestino,List<Disponibilidad> disponibilidad,
			String descripcion, TipoProducto tipo, int horaSalida, int horaLlegada, List<String> trayecto,
			TipoTransporte tipoTransporte, int duracion, String idUsuario) {
		super(_id, precio, infoPaisDestino, disponibilidad, descripcion, tipo, idUsuario);
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.trayecto = trayecto;
		this.tipoTransporte = tipoTransporte;
		this.duracion = duracion;
	}

	// GETTERS Y SETTERS
	public int getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(int horaSalida) {
		this.horaSalida = horaSalida;
	}

	public int getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(int horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public List<String> getTrayecto() {
		return trayecto;
	}

	public void setTrayecto(List<String> trayecto) {
		this.trayecto = trayecto;
	}

	public TipoTransporte getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(TipoTransporte tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}
	
	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	// MÉTODOS
	public void ObtenerTrayecto() {
		System.out.println(" --- El trayecto ha sido asignado ---");
	}
}
