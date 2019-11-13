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
import co.edu.javeriana.eko.model.producto.Experiencia;



@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class PreguntaServicesController {
	
	@Autowired
	IProductoService productoService;

	private String nombreColeccionProductoExperiencia = "productos-pregunta";

	@RequestMapping(value = "/api/productos/pregunta", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> agregarProducto(@RequestBody Experiencia nProducto) {
		productoService.crearProducto(nProducto);
		return new ResponseEntity<String>("{\"respuesta\": \"Se ha agregado correctamente el producto.\"}",
				HttpStatus.OK);
	}
	
}
