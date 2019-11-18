package co.edu.javeriana.eko.service;

import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Service;

import co.edu.javeriana.eko.db.controller.DBController;
import co.edu.javeriana.eko.iservice.ICalificacionService;
import co.edu.javeriana.eko.iservice.IPreguntaService;
import co.edu.javeriana.eko.model.Calificacion;
import co.edu.javeriana.eko.model.Pregunta;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.utils.Utils;

@Service
public class CalificacionService implements ICalificacionService {
	
	@Override
	public void crearCalificacion(Calificacion nCalificacion) {
		
		Document calificacion = Utils.deObjetoCalificacionADocumento(nCalificacion);			
		DBController.insertarObjeto("producto-calificacion", calificacion);	
		
	}
	
	
	public void eliminarCalificacion(String idCalificacion ) {
		DBController.eliminarEnColeccionPorID("producto-calificacion", idCalificacion);
		
	}
	
	public Calificacion obtenerCalificacion (String idCalificacion) {
		
		return DBController.buscarCalidicacionPorID("producto-calificacion", idCalificacion);
		
	}
	
	public void actualizarCalificacion(Calificacion nCalificacion) {		
		
		Document nCalificacionDoc = Utils.deObjetoCalificacionADocumento(nCalificacion);		
		DBController.actualizarObjeto("producto-calificacion", nCalificacionDoc, nCalificacion.get_id());
		
	}
	

	@Override
	public List<Calificacion> calificacionProProducto(String idProducto) {
		return DBController.obtenerCalificacionPorProducto("producto-calificacion",idProducto);
	}


	

}
