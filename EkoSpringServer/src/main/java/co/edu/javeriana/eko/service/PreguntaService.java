package co.edu.javeriana.eko.service;


import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Service;

import co.edu.javeriana.eko.db.controller.DBController;
import co.edu.javeriana.eko.iservice.IPreguntaService;
import co.edu.javeriana.eko.model.Pregunta;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.utils.Utils;


@Service
public class PreguntaService implements IPreguntaService {
	
	@Override
	public void crearPregunta(Pregunta nPregunta) {		
		
		Document pregunta = Utils.deObjetoPreguntaADocumento(nPregunta);			
		DBController.insertarObjeto("producto-pregunta", pregunta);	
		
	}	
	
	
	public void eliminarPregunta(String idPregunta ) {
		DBController.eliminarEnColeccionPorID("producto-pregunta", idPregunta);
		
	}
	
	public Pregunta obtenerPregunta (String idPregunta) {
		return DBController.buscarPreguntaPorID("producto-pregunta", idPregunta);
	}
	
	public void actualizarPregunta(Pregunta nPregunta) {			
		Document nPreguntaDoc = Utils.deObjetoPreguntaADocumento(nPregunta);		
		DBController.actualizarObjeto("producto-pregunta", nPreguntaDoc, nPregunta.get_id());
	}


	@Override
	public List<Pregunta> preguntasProducto(String idProducto) {
		
		return DBController.obtenerPreguntasPorProducto("producto-pregunta",idProducto);
	}



	
	
	
	
}
