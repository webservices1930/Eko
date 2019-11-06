package co.edu.javeriana.eko.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Service;

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

@Service
public class ProductoService implements IProductoService {

	@Override
	public void crearProducto(Producto nProducto) {
		switch (nProducto.getTipo()) {
		case ALOJAMIENTO:
			Document nAlojamientoDoc = Utils.deObjetoAlojamientoADocumento((Alojamiento) nProducto);
			DBController.insertarObjeto("productos-alojamiento", nAlojamientoDoc);
			break;

		case EVENTO:
			Document nEventoDoc = Utils.deObjetoEventoADocumento((Evento) nProducto);
			DBController.insertarObjeto("productos-evento", nEventoDoc);
			break;

		case EXPERIENCIA:
			Document nExperienciaDoc = Utils.deObjetoExperienciaADocumento((Experiencia) nProducto);
			DBController.insertarObjeto("productos-experiencia", nExperienciaDoc);
			break;

		case SALIDA:
			Document nSalidaDoc = Utils.deObjetoSalidaADocumento((Salida) nProducto);
			DBController.insertarObjeto("productos-salida", nSalidaDoc);
			break;

		case SITIO:
			Document nSitioDoc = Utils.deObjetoSitioADocumento((Sitio) nProducto);
			DBController.insertarObjeto("productos-sitio", nSitioDoc);
			break;

		case TRANSPORTE:
			Document nTransporteDoc = Utils.deObjetoTransporteADocumento((Transporte) nProducto);
			DBController.insertarObjeto("productos-transporte", nTransporteDoc);
			break;

		default:
			break;
		}
	}

	@Override
	public Producto obtenerProducto(String nombreColeccion, String idProducto) {
		return DBController.buscarEnColeccionPorID(nombreColeccion, idProducto);
	}

	@Override
	public void eliminarProducto(String nombreColeccion, String idProducto) {
		DBController.eliminarEnColeccionPorID(nombreColeccion, idProducto);
	}

	@Override
	public void actualizarProducto(Producto nProducto) {
		switch (nProducto.getTipo()) {
		case ALOJAMIENTO:
			Document nAlojamientoDoc = Utils.deObjetoAlojamientoADocumento((Alojamiento) nProducto);
			DBController.actualizarObjeto("productos-alojamiento", nAlojamientoDoc, nProducto.get_id());
			break;

		case EVENTO:
			Document nEventoDoc = Utils.deObjetoEventoADocumento((Evento) nProducto);
			DBController.actualizarObjeto("productos-evento", nEventoDoc, nProducto.get_id());
			break;

		case EXPERIENCIA:
			Document nExperienciaDoc = Utils.deObjetoExperienciaADocumento((Experiencia) nProducto);
			DBController.actualizarObjeto("productos-experiencia", nExperienciaDoc, nProducto.get_id());
			break;

		case SALIDA:
			Document nSalidaDoc = Utils.deObjetoSalidaADocumento((Salida) nProducto);
			DBController.actualizarObjeto("productos-salida", nSalidaDoc, nProducto.get_id());
			break;

		case SITIO:
			Document nSitioDoc = Utils.deObjetoSitioADocumento((Sitio) nProducto);
			DBController.actualizarObjeto("productos-sitio", nSitioDoc, nProducto.get_id());
			break;

		case TRANSPORTE:
			Document nTransporteDoc = Utils.deObjetoTransporteADocumento((Transporte) nProducto);
			DBController.actualizarObjeto("productos-transporte", nTransporteDoc, nProducto.get_id());
			break;

		default:
			break;
		}
	}

}
