package co.edu.javeriana.eko.iservice;

import java.util.List;

import co.edu.javeriana.eko.model.Calificacion;
import co.edu.javeriana.eko.model.Pregunta;

public interface ICalificacionService {

	
	public void crearCalificacion(Calificacion nCalificacion);
	public void eliminarCalificacion(String idCalificacion );
	public Calificacion obtenerCalificacion (String idCalificacion);
	public void actualizarCalificacion(Calificacion nCalificacion);
	public List<Calificacion> calificacionProProducto(String idProducto);

}
