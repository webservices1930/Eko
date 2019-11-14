package co.edu.javeriana.eko.iservice;

import co.edu.javeriana.eko.model.Pregunta;

public interface IPreguntaService {

	public void crearPregunta(Pregunta nPregunta);
	public void eliminarPregunta(String idProducto, String idPregunta );
	public Pregunta obtenerPregunta (String idProducto, String idPregunta);
	public void actualizarPregunta(Pregunta nPregunta);
	
}
