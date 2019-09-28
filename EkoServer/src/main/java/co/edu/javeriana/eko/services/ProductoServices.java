package co.edu.javeriana.eko.services;

import javax.jws.WebResult;
import javax.jws.WebService;

import org.bson.Document;

import co.edu.javeriana.eko.db.controller.DBController;
import co.edu.javeriana.eko.iservice.IProductoService;
import co.edu.javeriana.eko.model.producto.Transporte;
import co.edu.javeriana.eko.utils.Utils;
import co.edu.javeriana.eko.xml.manager.UtilsXML;
import co.edu.javeriana.eko.xml.manager.XMLFilesController;

@WebService(endpointInterface = "co.edu.javeriana.eko.iservice.IProductoService")
public class ProductoServices implements IProductoService {
	
	/* --- Se genera un Singleton de Producto Web Services --- */
	private static final ProductoServices instance = new ProductoServices();
	
	public static ProductoServices getInstance() {
		return instance;
	}
	
	// Métodos para exportar
	@Override
	public double calcularCalificacionPromedio() {
		return Math.random()*10 + 1;
	}

	@Override
	public void agregarProductoTransporte(Transporte nTransporte) {
		Document nTransporteDoc = Utils.deObjetoADocumento(nTransporte);
		DBController.insertarObjeto("productos-transporte", nTransporteDoc);
//		XMLFilesController.agregarProductoEnXML(UtilsXML.crearTransporte(nTransporte));
	}

	@Override
	public void buscarProductoTransportePorID(String _id) {
		DBController.buscarEnColeccionPorID("productos-transporte", _id);
//		return (Transporte) XMLFilesController.buscarProductoEnXMLPorID(_id);
	}

	@Override
	public void eliminarProductoTransportePorID(String _id) {
		DBController.eliminarEnColeccionPorID("productos-transporte", _id);
//		XMLFilesController.eliminarProductoEnXMLPorID(_id);
	}

	@Override
	public void actualizarProductoTransporte(Transporte nTransporte) {
		// TODO Actualizar objeto en MongoDB
//		XMLFilesController.actualizarProductoEnXMLPorID(UtilsXML.crearTransporte(nTransporte));
	}
	
}
