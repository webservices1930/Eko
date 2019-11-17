package co.edu.javeriana.eko.model.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.eko.model.Calificacion;
import co.edu.javeriana.eko.model.Disponibilidad;
import co.edu.javeriana.eko.model.Pregunta;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.utils.TipoProducto;
import co.edu.javeriana.eko.utils.TipoTransporte;

@Component
public class Transporte extends Producto {
	private String horaSalida;
	private String horaLlegada;
	private List<String> trayecto;
	private TipoTransporte tipoTransporte;
	private int duracion;

	// CONSTRUCTORES
	public Transporte() {
	}
	
	public Transporte(double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad, String descripcion,
			List<Calificacion> calificacion, List<String> pregunta ,TipoProducto tipo, String horaSalida, String horaLlegada, List<String> trayecto, TipoTransporte tipoTransporte,
			int duracion, String idUsuario, String titulo) {
		super(precio, infoPaisDestino, disponibilidad, calificacion, pregunta, descripcion, tipo, idUsuario, titulo);
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.trayecto = trayecto;
		this.tipoTransporte = tipoTransporte;
		this.duracion = duracion;
	}

	public Transporte(String _id, double precio, String infoPaisDestino,List<Disponibilidad> disponibilidad,
			List<Calificacion> calificacion, List<String> pregunta ,String descripcion, TipoProducto tipo, String horaSalida, String horaLlegada, List<String> trayecto,
			TipoTransporte tipoTransporte, int duracion, String idUsuario, String titulo) {
		super(_id, precio, infoPaisDestino, disponibilidad, calificacion, pregunta, descripcion, tipo, idUsuario, titulo);
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.trayecto = trayecto;
		this.tipoTransporte = tipoTransporte;
		this.duracion = duracion;
	}

	// GETTERS Y SETTERS
	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(String horaLlegada) {
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

	// M�TODOS
	public void ObtenerTrayecto() {
		System.out.println(" --- El trayecto ha sido asignado ---");
	}
}
