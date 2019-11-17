package co.edu.javeriana.eko.service;

import org.springframework.stereotype.Service;
import org.bson.Document;
import co.edu.javeriana.eko.db.controller.DBController;
import co.edu.javeriana.eko.iservice.ICatalogoService;
import co.edu.javeriana.eko.model.Catalogo;
import co.edu.javeriana.eko.model.Pregunta;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.utils.Utils;

@Service
public class CatalogoService implements ICatalogoService {
	
	@Override
	public void crearCatalogo(Catalogo nCatalogo) {	
		Document nCatalogoDoc = Utils.deObjetoCatalogoADocumento(nCatalogo);
		DBController.insertarObjeto("catalogo", nCatalogoDoc);		
	}	
	
	
	@Override
	public void actualizarCatalogo(Catalogo nCatalogo) {
		Document nCatalogoDoc = Utils.deObjetoCatalogoADocumento(nCatalogo);		
		DBController.actualizarObjeto("catalogo", nCatalogoDoc, nCatalogo.get_id());
		
	}
	
	
	public void eliminarCatalogo(String _id) {
		DBController.eliminarEnColeccionPorID("catalogo", _id);		
	}
	
	@Override
	public Catalogo obtenerCatalogo(String idCatalogo) {
		return DBController.buscarEnColeccionCatalogoPorID("catalogo", idCatalogo);
	}
	
	
}
