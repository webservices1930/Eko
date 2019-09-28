package co.edu.javeriana.eko.webservices;

import javax.xml.ws.Endpoint;

import co.edu.javeriana.eko.services.MarketPlaceServices;
import co.edu.javeriana.eko.utils.VariablesDeEntorno;

public class MarketPlaceWebServices {
	// Url base para todos los End Points de Productos
	private static final String urlMarketPlace = VariablesDeEntorno.urlDominio + "market-place";

	/* --- Se genera un Singleton de Producto Web Service --- */
	private static final MarketPlaceWebServices instance = new MarketPlaceWebServices();

	private MarketPlaceWebServices() {}

	public static MarketPlaceWebServices getInstance() {
		return instance;
	}
	
	/**
	 * Expone todos los servicios del Market Place
	 */
	public static void publicarMarketPlaceServices() {
		Endpoint.publish(urlMarketPlace, new MarketPlaceServices());
	}
}
