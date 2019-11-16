package co.edu.javeriana.eko.controller.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.eko.iservice.IProductoService;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.model.producto.Transporte;


@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class ProductoServiceController {
	@Autowired
	IProductoService productoService;
	
	@RequestMapping(value = "/api/productos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> obtenerProductos() {
		return new ResponseEntity(
				productoService.obtenerTodosProductos(),
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/productos/usuario/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> obtenerProductoXUsuario(@PathVariable("idUsuario") String idUsuario) {
		return new ResponseEntity(
				productoService.obtenerProductosPorUsuario(idUsuario),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/api/productos/{idProducto}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> obtenerProducto(@PathVariable("idProducto") String idProducto) {
		return new ResponseEntity<Producto>(
				(Producto) productoService.buscarProductoPorId(idProducto),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/productos/buscar/{cadena}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> buscarEnProductos(@PathVariable("cadena") String cadena){
		return  new ResponseEntity(
				productoService.buscarPorCadena(cadena),
				HttpStatus.OK); 
	}
	
	@RequestMapping(value="/api/productos/twitter/{query}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> twitterApi(@PathVariable("query") String query){
		return  new ResponseEntity(
				productoService.twitterApi(query),
				HttpStatus.OK); 
	}
}
