package co.edu.javeriana.eko.webservices;

import javax.xml.ws.Endpoint;

import co.edu.javeriana.eko.services.CarritoService;
import co.edu.javeriana.eko.utils.VariablesDeEntorno;

public class CarritoWebService {

	// Url base para todos los End Points de Productos
		private static final String urlCarrito = VariablesDeEntorno.urlDominio + "carrito";
		
		/* --- Se genera un Singleton de Producto Web Service --- */
		private static final CarritoWebService instance = new CarritoWebService();
		
		private CarritoWebService() {}
		
		public static CarritoWebService getInstance() {
			return instance;
		}
		
		/**
		 * Expone todos los servicios de Prodcuto
		 */
		public static void publicarCarritoServices() {
			Endpoint.publish(urlCarrito, new CarritoService());
		}
}
