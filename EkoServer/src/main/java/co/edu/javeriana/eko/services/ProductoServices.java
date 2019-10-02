package co.edu.javeriana.eko.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.bson.Document;

import co.edu.javeriana.eko.db.controller.DBController;
import co.edu.javeriana.eko.iservice.IProductoService;
import co.edu.javeriana.eko.model.Calificacion;
import co.edu.javeriana.eko.model.Pregunta;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.model.producto.Transporte;
import co.edu.javeriana.eko.utils.Utils;

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
		Document nTransporteDoc = Utils.deObjetoTransporteADocumento(nTransporte);
		DBController.insertarObjeto("productos-transporte", nTransporteDoc);
	}

	@Override
	public Producto buscarProductoTransportePorID(String _id) {
		return DBController.buscarEnColeccionPorID("productos-transporte", _id);
	}

	@Override
	public void eliminarProductoTransportePorID(String _id) {
		DBController.eliminarEnColeccionPorID("productos-transporte", _id);
	}

	@Override
	public void actualizarProductoTransporte(Transporte nTransporte) {
		// TODO Actualizar objeto en MongoDB
	}
	
	@Override
	public void agregarCalificacionProducto(Calificacion nCalificacion) {
		Document nCalificacionDoc = Utils.deObjetoCalificacionADocumento(nCalificacion);
		DBController.insertarObjeto("producto-calificacion", nCalificacionDoc);
		
		
	}

	@Override
	public void eliminarCalificacionProducto( String _id) {
		DBController.eliminarEnColeccionPorID("productos-calificacion", _id);		
	}	
	
	
	
	@Override
	public void agregarPreguntaProducto(Pregunta nPregunta) {
		Document nPreguntaDoc = Utils.deObjetoPreguntaADocumento(nPregunta);
		DBController.insertarObjeto("producto-pregunta", nPreguntaDoc);		
	}
	
	
	@Override
	public void eliminarPreguntaProducto(String _id) {
		DBController.eliminarEnColeccionPorID("productos-pregunta", _id);		
	}
	
}
