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
		Boolean validator = true;	
		String nombreColeccion;
		
		
		if(validator) {
			
			nombreColeccion = "productos-transporte";
			producto = DBController.buscarEnColeccionTransportePorID(nombreColeccion, nPregunta.getId_Producto());			
			if(producto.get_id()!="") {					
				DBController.insertarPregunta(nombreColeccion, nPregunta);
				validator = false;
			}		
		}
		
		if(validator) {
			
			nombreColeccion = "productos-evento";
			producto = DBController.buscarEnColeccionAlojamientoPorID(nombreColeccion, nPregunta.getId_Producto());	
			if(producto.get_id()!="") {
				DBController.insertarPregunta(nombreColeccion, nPregunta);
				validator = false;
			}		
		}
		
		if(validator) {
			
			nombreColeccion = "productos-experiencia";
			producto = DBController.buscarEnColeccionAlojamientoPorID(nombreColeccion, nPregunta.getId_Producto());	
			if(producto.get_id()!="") {
				DBController.insertarPregunta(nombreColeccion, nPregunta);
				validator = false;
			}		
		}
		
		if(validator) {
			
			nombreColeccion = "productos-salida";
			producto = DBController.buscarEnColeccionAlojamientoPorID(nombreColeccion, nPregunta.getId_Producto());	
			if(producto.get_id()!="") {
				DBController.insertarPregunta(nombreColeccion, nPregunta);
				validator = false;
			}		
		}
		
		if(validator) {
			
			nombreColeccion = "productos-sitio";
			producto = DBController.buscarEnColeccionAlojamientoPorID(nombreColeccion, nPregunta.getId_Producto());	
			if(producto.get_id()!="") {
				DBController.insertarPregunta(nombreColeccion, nPregunta);
				validator = false;
			}		
		}
		
		if(validator) {
			
			nombreColeccion = "productos-transporte";
			producto = DBController.buscarEnColeccionAlojamientoPorID(nombreColeccion, nPregunta.getId_Producto());	
			if(producto.get_id()!="") {
				DBController.insertarPregunta(nombreColeccion, nPregunta);
				validator = false;
			}		
		}		
	}
	
	
	
	

	
}
