package co.edu.javeriana.eko.service;

import org.bson.Document;
import org.springframework.stereotype.Service;

import co.edu.javeriana.eko.db.controller.DBController;
import co.edu.javeriana.eko.iservice.ICarritoService;
import co.edu.javeriana.eko.model.Carrito;
import co.edu.javeriana.eko.model.producto.Alojamiento;
import co.edu.javeriana.eko.utils.Utils;

@Service
public class CarritoService implements ICarritoService {

	@Override
	public void crearCarrito(Carrito nCarrito) {
		Document nCarritoDoc = Utils.deObjetoCarritoADocumento(nCarrito);
		DBController.insertarObjeto("carrito", nCarritoDoc);		
	}

	@Override
	public Carrito obtenerCarritoPorUsuario(String idUsuario) {
		return DBController.buscarCarritoEnColeccionPorID("carrito", idUsuario);
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
