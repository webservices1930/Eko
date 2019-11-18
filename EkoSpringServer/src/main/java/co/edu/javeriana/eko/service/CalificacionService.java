package co.edu.javeriana.eko.service;

import org.springframework.stereotype.Service;

import co.edu.javeriana.eko.db.controller.DBController;
import co.edu.javeriana.eko.iservice.ICalificacionService;
import co.edu.javeriana.eko.iservice.IPreguntaService;
import co.edu.javeriana.eko.model.Calificacion;
import co.edu.javeriana.eko.model.Pregunta;
import co.edu.javeriana.eko.model.Producto;

@Service
public class CalificacionService implements ICalificacionService {
	
	@Override
	public void crearCalificacion(Calificacion nCalificacion) {
		
		Producto producto = new Producto() {};			
		String coleccion = nombreColeccion(nCalificacion.getId_Producto());
		DBController.insertarCalificacion(coleccion, nCalificacion);
		
	}
	
	
	public void eliminarCalificacion(String idProducto, String idCalificacion ) {
		Producto producto = new Producto() {};				
		String coleccion = nombreColeccion(idProducto);
		DBController.eliminarCalificacion(coleccion, idProducto, idCalificacion);
		
	}
	
	public Calificacion obtenerCalificacion (String idProducto, String idCalificacion) {
		
		Producto producto = new Producto() {};				
		String coleccion = nombreColeccion(idProducto);
		return DBController.obtenerCalificacion(coleccion, idProducto, idCalificacion);		 
		
	}
	
	public void actualizarCalificacion(Calificacion nCalificacion) {		
		
		Producto producto = new Producto() {};				
		String coleccion = nombreColeccion(nCalificacion.getId_Producto());
		DBController.actualizarCalificacion(coleccion, nCalificacion);		
		
	}
	
	
	private String nombreColeccion(String id) {
		
		Producto producto = new Producto() {};		
		Boolean validator = true;	
		String nombreColeccion;
		
		
		if (validator) {
		nombreColeccion = "productos-transporte";
		producto = DBController.buscarEnColeccionTransportePorID(nombreColeccion, id);		
			if(producto.get_id() != "") {	
				return nombreColeccion;
			}		
		}
		
		
		if (validator) {
			nombreColeccion = "productos-evento";			
			producto = DBController.buscarEnColeccionEventoPorID(nombreColeccion, id);	
			if(producto.get_id() != "") {				
				return nombreColeccion;
			}
		}
		
		if (validator) {
			nombreColeccion = "productos-experiencia";
			producto = DBController.buscarEnColeccionExperienciaPorID(nombreColeccion, id);	
			if(producto.get_id() != "") {
				return nombreColeccion;
			}
		}
		if (validator) {
			nombreColeccion = "productos-salida";
			producto = DBController.buscarEnColeccionSalidaPorID(nombreColeccion, id);	
			if(producto.get_id() != "") {
				return nombreColeccion;
			}
		}
		if (validator) {
			nombreColeccion = "productos-sitio";
			producto = DBController.buscarEnColeccionSitioPorID(nombreColeccion, id);	
			if(producto.get_id() != "") {
				return nombreColeccion;
			}
		}
		if (validator) {
			nombreColeccion = "productos-alojamiento";			
			producto = DBController.buscarEnColeccionAlojamientoPorID(nombreColeccion, id);	
			if(producto.get_id() != "") {
				return nombreColeccion;
			}	
		}
		
		
		return "";
	} 
	

}
