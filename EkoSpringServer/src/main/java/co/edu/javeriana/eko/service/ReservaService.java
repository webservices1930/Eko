package co.edu.javeriana.eko.service;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.javeriana.eko.db.controller.DBController;
import co.edu.javeriana.eko.iservice.IProductoService;
import co.edu.javeriana.eko.iservice.IReservaService;
import co.edu.javeriana.eko.model.Disponibilidad;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.model.Reserva;
import co.edu.javeriana.eko.utils.Utils;

@Service
public class ReservaService implements IReservaService {
	
	@Autowired
	IProductoService productoService;

	@Override
	public boolean crearReserva(Reserva nReserva) {
		Document nReservaDoc = Utils.deObjetoReservaADocumento(nReserva);
        Producto producto = productoService.buscarProductoPorId(nReserva.getProductoid());
        List<Disponibilidad> listaDisponibilidad = producto.getDisponibilidad();
		int count = 0;
		
		for (Disponibilidad dispo : listaDisponibilidad) {
			if(dispo.getFecha().equals(nReserva.getFechas())) {
				if (dispo.getCuposDisponibles() == 0) {
					return false;
				}
				
				dispo.setCuposDisponibles(dispo.getCuposDisponibles() - 1);
				listaDisponibilidad.set(count, dispo);
				break;
			}
			++count;
		}
		
		producto.setDisponibilidad(listaDisponibilidad);
		productoService.actualizarProducto(producto);
        DBController.insertarObjeto("reservas", nReservaDoc);
        return true;
	}

	@Override
	public List<Reserva> obtenerRerservasClientePorID(String _id) {
		return DBController.buscarEnColeccionReservaPorClienteID("reservas", _id);
	}

	@Override
	public void cancelarReservaPorID(String _id) {
		Reserva reserva = DBController.buscarEnColeccionReservaPorID("reservas", _id);
		Producto producto = productoService.buscarProductoPorId(reserva.getProductoid());
		List<Disponibilidad> listaDisponibilidad = producto.getDisponibilidad();
		int count = 0;
		
		for (Disponibilidad dispo : listaDisponibilidad) {
			if(dispo.getFecha().equals(reserva.getFechas())) {
				dispo.setCuposDisponibles(dispo.getCuposDisponibles() + 1);
				listaDisponibilidad.set(count, dispo);
				break;
			}
			++count;
		}
		
		producto.setDisponibilidad(listaDisponibilidad);
		productoService.actualizarProducto(producto);
		DBController.eliminarEnColeccionPorID("reservas", _id);
	}

	@Override
	public void actualizarReserva(Reserva nReserva) {
		Document nReDocument = Utils.deObjetoReservaADocumento(nReserva);
        DBController.actualizarObjeto("reservas", nReDocument, nReserva.get_id());
	}

	@Override
	public Reserva obtenerReservaPorID(String _id) {
		return DBController.buscarEnColeccionReservaPorID("reservas", _id);
	}

}
