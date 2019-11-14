package co.edu.javeriana.eko.iservice;

import co.edu.javeriana.eko.model.Calificacion;
import co.edu.javeriana.eko.model.Pregunta;

public interface ICalificacionService {

	
	public void crearCalificacion(Calificacion nCalificacion);
	public void eliminarCalificacion(String idProducto, String idCalificacion );
	public Calificacion obtenerCalificacion (String idProducto, String idCalificacion);
	public void actualizarCalificacion(Calificacion nCalificacion);

}
