package co.edu.javeriana.eko.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.bson.Document;

import co.edu.javeriana.eko.db.controller.DBController;
import co.edu.javeriana.eko.iservice.ICatalogoService;
import co.edu.javeriana.eko.model.Catalogo;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.utils.Utils;

@WebService(endpointInterface = "co.edu.javeriana.eko.iservice.ICatalogoService")
public class CatalogoService implements ICatalogoService{

	private static final CatalogoService instance = new CatalogoService();
	
	public static CatalogoService getInstance() {
		return instance;
	}
	
	@Override
	public List<Catalogo> obtenerCatalogos() {
		
		return DBController.obtenerCatalogos("catalogo");
	}

	@Override
	public List<Catalogo> obtenerCatalogosPorUsuario(String _idUsuario) {
		return DBController.obtenerCatalogoPorUsuario("catalogo",_idUsuario);
	}

	@Override
	public void agregarCatalogo(Catalogo nCatalogo) {
		Document nCatalogoDoc = Utils.deObjetoCatalogoADocumento(nCatalogo);
		DBController.insertarObjeto("catalogo", nCatalogoDoc);
		
	}

	@Override
	public Catalogo buscarCatalogoPorID(String _id) {
		return DBController.buscarEnColeccionCatalogoPorID("catalogo", _id);
	}

	@Override
	public void eliminarCatalogoPorID(String _id) {
		DBController.eliminarEnColeccionPorID("catalogo", _id);
		
	}

	@Override
	public void actualizarCatalogo(Catalogo nCatalogo) {
		Document nTransporteDoc = Utils.deObjetoCatalogoADocumento(nCatalogo);		
		DBController.actualizarObjeto("catalogo", nTransporteDoc, nCatalogo.get_id());		
	}

}
