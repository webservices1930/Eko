package co.edu.javeriana.eko.xml.manager;

import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.eko.xml.Disponibilidad;
import co.edu.javeriana.eko.xml.Producto;
import co.edu.javeriana.eko.xml.TipoProducto;
import co.edu.javeriana.eko.xml.TipoTransporte;
import co.edu.javeriana.eko.xml.Transporte;

public class UtilsXML {

	/**
	 * Crea un objeto de Tipo Transporte para poderlo escribir en el archivo XML
	 * 
	 * @param nProducto
	 * @return
	 */
	public static Producto crearTransporte(co.edu.javeriana.eko.model.producto.Transporte nProducto) {
		Transporte nProductoXML = new Transporte();

		for (co.edu.javeriana.eko.model.Disponibilidad nDisponibilidad : nProducto.getDisponibilidad()) {
			Disponibilidad nDisponibilidadXML = new Disponibilidad();

			nDisponibilidadXML.setCuposDisponibles(nDisponibilidad.getCuposDisponibles());
			nDisponibilidadXML.setFecha(nDisponibilidad.getFecha());
			nProductoXML.getDisponibilidad().add(nDisponibilidadXML);
		}

		nProductoXML.setDescripcion(nProducto.getDescripcion());
		nProductoXML.setDuracion(nProducto.getDuracion());
		nProductoXML.setHoraLlegada(nProducto.getHoraLlegada());
		nProductoXML.setHoraSalida(nProducto.getHoraSalida());
		nProductoXML.setId(nProducto.get_id());
		nProductoXML.setInfoPaisDestino(nProducto.getInfoPaisDestino());
		nProductoXML.setPrecio(nProducto.getPrecio());
		nProductoXML.setTipo(TipoProducto.TRANSPORTE);

		switch (nProducto.getTipoTransporte()) {
		case AEREO:
			nProductoXML.setTipoTransporte(TipoTransporte.AEREO);
			break;
			
		case MARITIMO:
			nProductoXML.setTipoTransporte(TipoTransporte.MARITIMO);
			break;
			
		case TERRESTRE:
			nProductoXML.setTipoTransporte(TipoTransporte.TERRESTRE);
			break;

		default:
			nProductoXML.setTipoTransporte(TipoTransporte.TERRESTRE);
			break;
		}

		return nProductoXML;
	}
	
	/**
	 * De un objeto tipo Transporte para escribir en el archivo XML lo transforma a un objeto sin estas propiedades
	 * 
	 * @param nProducto
	 * @return
	 */
	public static co.edu.javeriana.eko.model.Producto crearTransporteModel(Transporte nProducto) {
		co.edu.javeriana.eko.model.producto.Transporte nProductoXML = new co.edu.javeriana.eko.model.producto.Transporte();
		List<co.edu.javeriana.eko.model.Disponibilidad> disponibilidad = new ArrayList<co.edu.javeriana.eko.model.Disponibilidad>();

		for (Disponibilidad nDisponibilidad : nProducto.getDisponibilidad()) {
			co.edu.javeriana.eko.model.Disponibilidad nDisponibilidadXML = new co.edu.javeriana.eko.model.Disponibilidad();

			nDisponibilidadXML.setCuposDisponibles(nDisponibilidad.getCuposDisponibles());
			nDisponibilidadXML.setFecha(nDisponibilidad.getFecha());
			disponibilidad.add(nDisponibilidadXML);
		}
		
		nProductoXML.setDisponibilidad(disponibilidad);

		nProductoXML.setDescripcion(nProducto.getDescripcion());
		nProductoXML.setDuracion(nProducto.getDuracion());
		nProductoXML.setHoraLlegada(nProducto.getHoraLlegada());
		nProductoXML.setHoraSalida(nProducto.getHoraSalida());
		nProductoXML.set_id(nProducto.getId());
		nProductoXML.setInfoPaisDestino(nProducto.getInfoPaisDestino());
		nProductoXML.setPrecio(nProducto.getPrecio());
		nProductoXML.setTipo(co.edu.javeriana.eko.utils.TipoProducto.TRANSPORTE);

		switch (nProducto.getTipoTransporte()) {
		case AEREO:
			nProductoXML.setTipoTransporte(co.edu.javeriana.eko.utils.TipoTransporte.AEREO);
			break;
			
		case MARITIMO:
			nProductoXML.setTipoTransporte(co.edu.javeriana.eko.utils.TipoTransporte.MARITIMO);
			break;
			
		case TERRESTRE:
			nProductoXML.setTipoTransporte(co.edu.javeriana.eko.utils.TipoTransporte.TERRESTRE);
			break;

		default:
			nProductoXML.setTipoTransporte(co.edu.javeriana.eko.utils.TipoTransporte.TERRESTRE);
			break;
		}

		return nProductoXML;
	}
}
