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
		
		Producto producto = new Producto() {};				
		String coleccion = nombreColeccion(nPregunta.getId_Producto());
		DBController.insertarPregunta(coleccion, nPregunta);		
		
	}	
	
	
	public void eliminarPregunta(String idProducto, String idPregunta ) {
		Producto producto = new Producto() {};				
		String coleccion = nombreColeccion(idProducto);
		DBController.eliminarPregunta(coleccion, idProducto, idPregunta);
		
	}
	
	public Pregunta obtenerPregunta (String idProducto, String idPregunta) {
		
		Producto producto = new Producto() {};				
		String coleccion = nombreColeccion(idProducto);
		return DBController.obtenerPregunta(coleccion, idProducto, idPregunta);		 
		
	}
	
	public void actualizarPregunta(Pregunta nPregunta) {		
		
		Producto producto = new Producto() {};				
		String coleccion = nombreColeccion(nPregunta.getId_Producto());
		DBController.actualizarPregunta(coleccion, nPregunta);		
		
	}
	
	
	
	
	private String nombreColeccion(String id) {
		
		Producto producto = new Producto() {};		
		Boolean validator = true;	
		String nombreColeccion;
		
		if(validator) {
			
			nombreColeccion = "productos-transporte";
			producto = DBController.buscarEnColeccionTransportePorID(nombreColeccion, id);			
			if(producto.get_id()!="") {					
				return nombreColeccion;
			}		
		}
		
		if(validator) {
			
			nombreColeccion = "productos-evento";
			producto = DBController.buscarEnColeccionEventoPorID(nombreColeccion, id);	
			if(producto.get_id()!="") {
				return nombreColeccion;
			}		
		}
		
		if(validator) {
			
			nombreColeccion = "productos-experiencia";
			producto = DBController.buscarEnColeccionExperienciaPorID(nombreColeccion, id);	
			if(producto.get_id()!="") {
				return nombreColeccion;
			}		
		}
		
		if(validator) {
			
			nombreColeccion = "productos-salida";
			producto = DBController.buscarEnColeccionSalidaPorID(nombreColeccion, id);	
			if(producto.get_id()!="") {
				return nombreColeccion;
			}		
		}
		
		if(validator) {
			
			nombreColeccion = "productos-sitio";
			producto = DBController.buscarEnColeccionSitioPorID(nombreColeccion, id);	
			if(producto.get_id()!="") {
				return nombreColeccion;
			}		
		}
		
		if(validator) {
			
			nombreColeccion = "productos-alojamiento";
			producto = DBController.buscarEnColeccionAlojamientoPorID(nombreColeccion, id);	
			if(producto.get_id()!="") {
				return nombreColeccion;
			}		
		}		
		
		
		return "";
	} 
	

	
}
