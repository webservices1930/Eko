package co.edu.javeriana.eko.services;

import java.util.List;

import javax.jws.WebService;

import org.bson.Document;

import co.edu.javeriana.eko.db.controller.DBController;
import co.edu.javeriana.eko.iservice.ICarritoService;
import co.edu.javeriana.eko.model.Carrito;
import co.edu.javeriana.eko.utils.Utils;

@WebService(endpointInterface = "co.edu.javeriana.eko.iservice.ICarritoService")
public class CarritoService implements ICarritoService {

	private static final CarritoService instance = new CarritoService();
	
	public static CarritoService getInstance() {
		return instance;
	}
	
	@Override
	public void agregarCarrito(Carrito nCarrito) {
		Document nCarritoDoc = Utils.deObjetoCarritoADocumento(nCarrito);
		DBController.insertarObjeto("carrito", nCarritoDoc);

	}

	@Override
	public Carrito obtenerCarritoPorUsuario(String _idUsuario) {		
		return DBController.buscarCarritoEnColeccionPorID("carrito", _idUsuario);
	}


	@Override
	public void actualizarCarrito(Carrito nCarrito) {
		Document nCarritoDoc = Utils.deObjetoCarritoADocumento(nCarrito);		
		DBController.actualizarObjeto("carrito", nCarritoDoc, nCarrito.get_id());
	}

	@Override
	public void eliminarCarritoPorID(String _id) {
		DBController.eliminarEnColeccionPorID("carrito", _id);

	}

}
