package co.edu.javeriana.eko.services;

import java.util.ArrayList;
import java.util.List;

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
import co.edu.javeriana.eko.model.Reserva;
import co.edu.javeriana.eko.model.producto.Transporte;
import co.edu.javeriana.eko.utils.Utils;

@WebService(endpointInterface = "co.edu.javeriana.eko.iservice.IProductoService")
public class ProductoServices implements IProductoService {
	
	/* --- Se genera un Singleton de Producto Web Services --- */
	private static final ProductoServices instance = new ProductoServices();
	
	public static ProductoServices getInstance() {
		return instance;
	}
	
	// M�todos para exportar
	@Override
	public double calcularCalificacionPromedio() {
		return Math.random()*10 + 1;
	}
	
	@Override
	public List<Producto> obtenerProductos() {
		System.out.println("Productos Transporte");
		List<Producto> productos = new ArrayList<Producto>();
		
		productos.addAll(DBController.obtenerProductos("productos-transporte"));
		productos.addAll(DBController.obtenerProductos("productos-alojamiento"));
		productos.addAll(DBController.obtenerProductos("productos-evento"));
		productos.addAll(DBController.obtenerProductos("productos-experiencia"));
		productos.addAll(DBController.obtenerProductos("productos-salida"));
		productos.addAll(DBController.obtenerProductos("productos-sitio"));
		return productos;
	}
	
	@Override
	public Producto buscarProductoPorId(String _id) {
		System.out.println("Buscar Producto por ID");
		Producto producto = new Producto() {};		
		try {
			producto = buscarProductoTransportePorID(_id);	
			if(producto.get_id()!="") {
				return producto;
			}		
		}catch (Exception e) {
			// TODO: handle exception
		}
		try {
			producto = buscarProductoAlojamientoPorID(_id);
			if(producto.get_id()!="") {
				return producto;
			}			
		}catch (Exception e) {
			// TODO: handle exception
		}
		try {
			producto = buscarProductoEventoPorID(_id);		
			if(producto.get_id()!="") {
				return producto;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			producto = buscarProductoExperienciaPorID(_id);		
			if(producto.get_id()!="") {
				return producto;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			producto = buscarProductoSalidaPorID(_id);
			if(producto.get_id()!="") {
				return producto;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			producto = buscarProductoSitioPorID(_id);				
			if(producto.get_id()!="") {
				return producto;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return producto;
	}
	
	@Override
	public List<Producto> obtenerProductosPorUsuario(String _idUsuario) {
		System.out.println("Productos Usuario" + _idUsuario);
		List<Producto> productos = new ArrayList<Producto>();
		
		productos.addAll(DBController.obtenerProductosPorUsuario("productos-transporte",_idUsuario));
		productos.addAll(DBController.obtenerProductosPorUsuario("productos-alojamiento",_idUsuario));
		productos.addAll(DBController.obtenerProductosPorUsuario("productos-evento",_idUsuario));
		productos.addAll(DBController.obtenerProductosPorUsuario("productos-experiencia",_idUsuario));
		productos.addAll(DBController.obtenerProductosPorUsuario("productos-salida",_idUsuario));
		productos.addAll(DBController.obtenerProductosPorUsuario("productos-sitio",_idUsuario));
		return productos;
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
		Document nTransporteDoc = Utils.deObjetoTransporteADocumento(nTransporte);		
		DBController.actualizarObjeto("productos-transporte", nTransporteDoc, nTransporte.get_id());
	}
	
	
	
	//** ALOJAMIENTO **//
	@Override
	public void agregarProductoAlojamiento(Alojamiento nAlojamiento) {
		Document nAlojamientoDoc = Utils.deObjetoAlojamientoADocumento(nAlojamiento);
		DBController.insertarObjeto("productos-alojamiento", nAlojamientoDoc);
	}
	
	@Override
	public Producto buscarProductoAlojamientoPorID(String _id) {
		return DBController.buscarEnColeccionAlojamientoPorID("productos-alojamiento", _id);
	}

	@Override
	public void eliminarProductoAlojamientoPorID(String _id) {
		DBController.eliminarEnColeccionPorID("productos-alojamiento", _id);
	}

	@Override
	public void actualizarProductoAlojamiento(Alojamiento nAlojamiento) {
		Document nAlojamientoDoc = Utils.deObjetoAlojamientoADocumento(nAlojamiento);		
		DBController.actualizarObjeto("productos-alojamiento", nAlojamientoDoc, nAlojamiento.get_id());
	}

	
	//** SITIO **//
	@Override
	public void agregarProductoSitio(Sitio nSitio) {
		Document nSitioDoc = Utils.deObjetoSitioADocumento(nSitio);
		DBController.insertarObjeto("productos-sitio", nSitioDoc);
	}
	
	@Override
	public Producto buscarProductoSitioPorID(String _id) {
		return DBController.buscarEnColeccionSitioPorID("productos-sitio", _id);
	}

	@Override
	public void eliminarProductoSitioPorID(String _id) {
		DBController.eliminarEnColeccionPorID("productos-sitio", _id);
	}

	@Override
	public void actualizarProductoSitio(Sitio nSitio) {
		Document nSitioDoc = Utils.deObjetoSitioADocumento(nSitio);		
		DBController.actualizarObjeto("productos-sitio", nSitioDoc, nSitio.get_id());
	}
	
	
	//** EXPERIENCIA **//
	@Override
	public void agregarProductoExperiencia(Experiencia nExperiencia) {
		Document nExperienciaDoc = Utils.deObjetoExperienciaADocumento(nExperiencia);
		DBController.insertarObjeto("productos-experiencia", nExperienciaDoc);
	}
	
	@Override
	public Producto buscarProductoExperienciaPorID(String _id) {
		return DBController.buscarEnColeccionExperienciaPorID("productos-experiencia", _id);
	}

	@Override
	public void eliminarProductoExperienciaPorID(String _id) {
		DBController.eliminarEnColeccionPorID("productos-experiencia", _id);
	}

	@Override
	public void actualizarProductoExperiencia(Experiencia nExperiencia) {
		Document nExperienciaDoc = Utils.deObjetoExperienciaADocumento(nExperiencia);		
		DBController.actualizarObjeto("productos-experiencia", nExperienciaDoc, nExperiencia.get_id());
	}
	
	
	//** SALIDA **//
	@Override
	public void agregarProductoSalida(Salida nSalida) {
		Document nSalidaDoc = Utils.deObjetoSalidaADocumento(nSalida);
		DBController.insertarObjeto("productos-salida", nSalidaDoc);
	}
	
	@Override
	public Producto buscarProductoSalidaPorID(String _id) {
		return DBController.buscarEnColeccionSalidaPorID("productos-salida", _id);
	}

	@Override
	public void eliminarProductoSalidaPorID(String _id) {
		DBController.eliminarEnColeccionPorID("productos-salida", _id);
	}

	@Override
	public void actualizarProductoSalida(Salida nSalida) {
		Document nSalidaDoc = Utils.deObjetoSalidaADocumento(nSalida);		
		DBController.actualizarObjeto("productos-salida", nSalidaDoc, nSalida.get_id());
	}
	
	
	//** EVENTO **//
	@Override
	public void agregarProductoEvento(Evento nEvento) {
		Document nEventoDoc = Utils.deObjetoEventoADocumento(nEvento);
		DBController.insertarObjeto("productos-evento", nEventoDoc);
	}
	
	@Override
	public Producto buscarProductoEventoPorID(String _id) {
		return DBController.buscarEnColeccionEventoPorID("productos-evento", _id);
	}

	@Override
	public void eliminarProductoEventoPorID(String _id) {
		DBController.eliminarEnColeccionPorID("productos-evento", _id);
	}

	@Override
	public void actualizarProductoEvento(Evento nEvento) {
		Document nEventoDoc = Utils.deObjetoEventoADocumento(nEvento);		
		DBController.actualizarObjeto("productos-evento", nEventoDoc, nEvento.get_id());
	}
	
	@Override
	public void agregarReserva(Reserva nReserva) {
		Document nReservaDoc = Utils.deObjetoReservaADocumento(nReserva);
		//System.out.println("aqui"+nReserva.getFechas());
		if(DBController.modificarCapacidadProducto("productos-transporte", nReserva.getProductoid())==true)
		DBController.insertarObjeto("reservas", nReservaDoc);
		else
			System.out.println("Reservas llenas");
	}
}
