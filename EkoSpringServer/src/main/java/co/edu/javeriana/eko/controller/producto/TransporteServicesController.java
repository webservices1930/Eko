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
import co.edu.javeriana.eko.model.producto.Transporte;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class TransporteServicesController {

	@Autowired
	IProductoService productoService;

	private String nombreColeccionProductoTransporte = "productos-transporte";
	
	@RequestMapping(value = "/api/productos/transporte", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> agregarProducto(@RequestBody Transporte nProducto) {
		productoService.crearProducto(nProducto);
		return new ResponseEntity<String>("{\"respuesta\": \"Se ha agregado correctamente el producto.\"}",
				HttpStatus.OK);
	}

	@RequestMapping(value = "/api/productos/transporte/{idProducto}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Transporte> obtenerProducto(@PathVariable("idProducto") String idProducto) {
		return new ResponseEntity<Transporte>(
				(Transporte) productoService.obtenerProducto(nombreColeccionProductoTransporte, idProducto),
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/productos/transporte/{idProducto}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> eliminarProducto(@PathVariable("idProducto") String idProducto) {
		productoService.eliminarProducto(nombreColeccionProductoTransporte, idProducto);
		return new ResponseEntity<String>("{\"respuesta\": \"Se ha eliminado correctamente el producto.\"}",
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/productos/transporte", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> actualizarProducto(@RequestBody Transporte nProducto) {
		productoService.actualizarProducto(nProducto);
		return new ResponseEntity<String>("{\"respuesta\": \"Se ha actualizado correctamente el producto.\"}",
				HttpStatus.OK);
	}
}
