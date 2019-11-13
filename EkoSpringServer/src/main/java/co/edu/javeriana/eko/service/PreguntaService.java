package co.edu.javeriana.eko.service;


import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Service;

import co.edu.javeriana.eko.db.controller.DBController;
import co.edu.javeriana.eko.iservice.IPreguntaService;
import co.edu.javeriana.eko.model.Pregunta;
import co.edu.javeriana.eko.model.Producto;

public class PreguntaService implements IPreguntaService {
	
	@Override
	public void crearPregunta(String nombreColeccion , Pregunta nPregunta) {
		
		List<Producto> productos = DBController.obtenerProductosPorUsuario(nombreColeccion , nPregunta.getId_Usuario());
		
		
		
		
	}

	
}
