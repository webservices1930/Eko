package co.edu.javeriana.eko.webservices;

import javax.xml.ws.Endpoint;

import co.edu.javeriana.eko.services.CatalogoService;
import co.edu.javeriana.eko.services.ProductoServices;
import co.edu.javeriana.eko.utils.VariablesDeEntorno;

public class CatalogoWebService {

private static final String urlCatalogo = VariablesDeEntorno.urlDominio + "catalogo";
	
	/* --- Se genera un Singleton de Producto Web Service --- */
	private static final CatalogoWebService instance = new CatalogoWebService();
	
	private CatalogoWebService() {}
	
	public static CatalogoWebService getInstance() {
		return instance;
	}
	
	/**
	 * Expone todos los servicios de Prodcuto
	 */
	public static void publicarCatalogoServices() {
		Endpoint.publish(urlCatalogo, new CatalogoService());
	}


}
