package co.edu.javeriana.eko.controller;

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

import co.edu.javeriana.eko.iservice.ICarritoService;
import co.edu.javeriana.eko.model.Carrito;
import co.edu.javeriana.eko.model.producto.Alojamiento;



@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class CarritoServiceController {
	@Autowired
	ICarritoService carritoService;
	
	private String nombreColeccionCarrito= "carrito";

	@RequestMapping(value = "/api/carrito", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> agregarCarrito(@RequestBody Carrito nCarrito) {
		carritoService.crearCarrito(nCarrito);
		return new ResponseEntity<String>("{\"respuesta\": \"Se ha agregado correctamente el carrito.\"}",
				HttpStatus.OK);
	}

	@RequestMapping(value = "/api/carrito/usuario/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Carrito> obtenerCarritoPorUsuario(@PathVariable("idUsuario") String idUsuario) {
		return new ResponseEntity<Carrito>(
				(Carrito) carritoService.obtenerCarritoPorUsuario(idUsuario),
				HttpStatus.OK);
	}	
			
	@RequestMapping(value = "/api/carrito/{idCarrito}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> eliminarCarrito(@PathVariable("idCarrito") String idCarrito) {
		carritoService.eliminarCarritoPorID(idCarrito);
		return new ResponseEntity<String>("{\"respuesta\": \"Se ha eliminado correctamente el carrito.\"}",
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/carrito", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> actualizarCarrito(@RequestBody Carrito nCarrito) {
		carritoService.actualizarCarrito(nCarrito);
		return new ResponseEntity<String>("{\"respuesta\": \"Se ha actualizado correctamente el carrito.\"}",
				HttpStatus.OK);
	}
}
