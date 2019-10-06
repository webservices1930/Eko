package co.edu.javeriana.eko.services;

import java.util.List;

import javax.jws.WebService;

import co.edu.javeriana.eko.db.controller.DBController;
import co.edu.javeriana.eko.iservice.IMarketPlace;
import co.edu.javeriana.eko.model.MarketPlace;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.model.Reserva;
@WebService(endpointInterface = "co.edu.javeriana.eko.iservice.IMarketPlace")
public class MarketPlaceServices implements IMarketPlace {
	
	/* --- Se genera un Singleton del Market Place Web Services --- */
	private static final MarketPlaceServices instance = new MarketPlaceServices();
	
	public static MarketPlaceServices getInstance() {
		return instance;
	}

	// Métodos para exportar
	@Override
	public List<Reserva> buscarReservasClientePorID(String _id) {
		return DBController.buscarEnColeccionReservaPorClienteID("reservas", _id);
	}
}
