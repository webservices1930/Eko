package co.edu.javeriana.eko.model.producto;

import java.util.List;

import co.edu.javeriana.eko.model.Calificacion;
import co.edu.javeriana.eko.model.Disponibilidad;
import co.edu.javeriana.eko.model.Pregunta;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.utils.TipoProducto;
import co.edu.javeriana.eko.utils.TipoSalida;

public class Salida extends Producto{
	private TipoSalida tipoSalida;
	private int duracion;
	private List<String> trayecto;
	private int restriccionEdad;
	private String guia;
	
	public Salida() {
		
	}

	public Salida(double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad, String descripcion,
			List<Calificacion> calificacion, List<String> pregunta,TipoProducto tipo, TipoSalida tipoSalida, int duracion, List<String> trayecto, int restriccionEdad, String guia, String idUsuario, String titulo) {
		super(precio, infoPaisDestino, disponibilidad, calificacion, pregunta, descripcion, tipo, idUsuario, titulo);
		this.tipoSalida = tipoSalida;
		this.duracion = duracion;
		this.trayecto = trayecto;
		this.restriccionEdad = restriccionEdad;
		this.guia = guia;
	}

	public Salida(String _id, double precio, String infoPaisDestino, List<Disponibilidad> disponibilidad,
			List<Calificacion> calificacion, List<String> pregunta,String descripcion, TipoProducto tipo, TipoSalida tipoSalida, int duracion, List<String> trayecto, int restriccionEdad, String guia, String idUsuario, String titulo) {
		super(_id, precio, infoPaisDestino, disponibilidad, calificacion, pregunta, descripcion, tipo, idUsuario, titulo);
		this.tipoSalida = tipoSalida;
		this.duracion = duracion;
		this.trayecto = trayecto;
		this.restriccionEdad = restriccionEdad;
		this.guia = guia;
	}

	public TipoSalida getTipoSalida() {
		return tipoSalida;
	}

	public void setTipoSalida(TipoSalida tipoSalida) {
		this.tipoSalida = tipoSalida;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public List<String> getTrayecto() {
		return trayecto;
	}

	public void setTrayecto(List<String> trayecto) {
		this.trayecto = trayecto;
	}

	public int getRestriccionEdad() {
		return restriccionEdad;
	}

	public void setRestriccionEdad(int restriccionEdad) {
		this.restriccionEdad = restriccionEdad;
	}

	public String getGuia() {
		return guia;
	}

	public void setGuia(String guia) {
		this.guia = guia;
	}
	
	
	
	
}
