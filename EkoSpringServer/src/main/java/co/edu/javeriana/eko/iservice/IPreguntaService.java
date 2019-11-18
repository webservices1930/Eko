package co.edu.javeriana.eko.iservice;

import java.util.List;

import co.edu.javeriana.eko.model.Pregunta;

public interface IPreguntaService {

	public void crearPregunta(Pregunta nPregunta);
	public void eliminarPregunta(String idPregunta );
	public Pregunta obtenerPregunta (String idPregunta);
	public void actualizarPregunta(Pregunta nPregunta);
	public List<Pregunta> preguntasProducto(String idProducto);
	
}
