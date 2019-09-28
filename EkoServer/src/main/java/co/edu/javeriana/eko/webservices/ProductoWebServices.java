package co.edu.javeriana.eko.webservices;

import javax.xml.ws.Endpoint;

import co.edu.javeriana.eko.services.ProductoServices;
import co.edu.javeriana.eko.utils.VariablesDeEntorno;

public class ProductoWebServices {
	
	// Url base para todos los End Points de Productos
	private static final String urlProducto = VariablesDeEntorno.urlDominio + "producto";
	
	/* --- Se genera un Singleton de Producto Web Service --- */
	private static final ProductoWebServices instance = new ProductoWebServices();
	
	private ProductoWebServices() {}
	
	public static ProductoWebServices getInstance() {
		return instance;
	}
	
	/**
	 * Expone todos los servicios de Prodcuto
	 */
	public static void publicarProductoServices() {
		Endpoint.publish(urlProducto, new ProductoServices());
	}
}
