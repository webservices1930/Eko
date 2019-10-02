package co.edu.javeriana.eko.services;

import javax.jws.WebResult;
import javax.jws.WebService;

import org.bson.Document;

import co.edu.javeriana.eko.db.controller.DBController;
import co.edu.javeriana.eko.iservice.IProductoService;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.model.producto.Alojamiento;
import co.edu.javeriana.eko.model.producto.Evento;
import co.edu.javeriana.eko.model.producto.Experiencia;
import co.edu.javeriana.eko.model.producto.Salida;
import co.edu.javeriana.eko.model.producto.Sitio;
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
	//** TRANSPORTE **//
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
	
	
	
	//** ALOJAMIENTO **//
	@Override
	public void agregarProductoAlojamiento(Alojamiento nAlojamiento) {
		Document nAlojamientoDoc = Utils.deObjetoAlojamientoADocumento(nAlojamiento);
		DBController.insertarObjeto("productos-alojamiento", nAlojamientoDoc);
	}
	
	@Override
	public Producto buscarProductoAlojamientoPorID(String _id) {
		return DBController.buscarEnColeccionPorID("productos-alojamiento", _id);
	}

	@Override
	public void eliminarProductoAlojamientoPorID(String _id) {
		DBController.eliminarEnColeccionPorID("productos-alojamiento", _id);
	}

	@Override
	public void actualizarProductoAlojamiento(Alojamiento nAlojamiento) {
		// TODO Actualizar objeto en MongoDB
	}

	
	//** SITIO **//
	@Override
	public void agregarProductoSitio(Sitio nSitio) {
		Document nSitioDoc = Utils.deObjetoSitioADocumento(nSitio);
		DBController.insertarObjeto("productos-sitio", nSitioDoc);
	}
	
	@Override
	public Producto buscarProductoSitioPorID(String _id) {
		return DBController.buscarEnColeccionPorID("productos-sitio", _id);
	}

	@Override
	public void eliminarProductoSitioPorID(String _id) {
		DBController.eliminarEnColeccionPorID("productos-sitio", _id);
	}

	@Override
	public void actualizarProductoSitio(Sitio nSitio) {
		// TODO Actualizar objeto en MongoDB
	}
	
	
	//** EXPERIENCIA **//
	@Override
	public void agregarProductoExperiencia(Experiencia nExperiencia) {
		Document nExperienciaDoc = Utils.deObjetoExperienciaADocumento(nExperiencia);
		DBController.insertarObjeto("productos-experiencia", nExperienciaDoc);
	}
	
	@Override
	public Producto buscarProductoExperienciaPorID(String _id) {
		return DBController.buscarEnColeccionPorID("productos-experiencia", _id);
	}

	@Override
	public void eliminarProductoExperienciaPorID(String _id) {
		DBController.eliminarEnColeccionPorID("productos-experiencia", _id);
	}

	@Override
	public void actualizarProductoExperiencia(Experiencia nExperiencia) {
		// TODO Actualizar objeto en MongoDB
	}
	
	
	//** SALIDA **//
	@Override
	public void agregarProductoSalida(Salida nSalida) {
		Document nSalidaDoc = Utils.deObjetoSalidaADocumento(nSalida);
		DBController.insertarObjeto("productos-salida", nSalidaDoc);
	}
	
	@Override
	public Producto buscarProductoSalidaPorID(String _id) {
		return DBController.buscarEnColeccionPorID("productos-salida", _id);
	}

	@Override
	public void eliminarProductoSalidaPorID(String _id) {
		DBController.eliminarEnColeccionPorID("productos-salida", _id);
	}

	@Override
	public void actualizarProductoSalida(Salida nSalida) {
		// TODO Actualizar objeto en MongoDB
	}
	
	
	//** EVENTO **//
	@Override
	public void agregarProductoEvento(Evento nEvento) {
		Document nEventoDoc = Utils.deObjetoEventoADocumento(nEvento);
		DBController.insertarObjeto("productos-evento", nEventoDoc);
	}
	
	@Override
	public Producto buscarProductoEventoPorID(String _id) {
		return DBController.buscarEnColeccionPorID("productos-evento", _id);
	}

	@Override
	public void eliminarProductoEventoPorID(String _id) {
		DBController.eliminarEnColeccionPorID("productos-evento", _id);
	}

	@Override
	public void actualizarProductoEvento(Evento nEvento) {
		// TODO Actualizar objeto en MongoDB
	}
	
}
