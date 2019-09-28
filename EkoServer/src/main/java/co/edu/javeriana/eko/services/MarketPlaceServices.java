package co.edu.javeriana.eko.services;

import javax.jws.WebService;

import co.edu.javeriana.eko.iservice.IMarketPlace;
import co.edu.javeriana.eko.model.MarketPlace;
import co.edu.javeriana.eko.xml.manager.XMLFilesController;

@WebService(endpointInterface = "co.edu.javeriana.eko.iservice.IMarketPlace")
public class MarketPlaceServices implements IMarketPlace {
	
	/* --- Se genera un Singleton del Market Place Web Services --- */
	private static final MarketPlaceServices instance = new MarketPlaceServices();
	
	public static MarketPlaceServices getInstance() {
		return instance;
	}

	@Override
	public String obtenerTodosLosProductos() {
		return XMLFilesController.obtenerTodosLosProductos();
	}

}
