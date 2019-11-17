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

import co.edu.javeriana.eko.iservice.ICatalogoService;
import co.edu.javeriana.eko.iservice.IPreguntaService;
import co.edu.javeriana.eko.model.Calificacion;
import co.edu.javeriana.eko.model.Catalogo;
import co.edu.javeriana.eko.model.Pregunta;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class CatalogoServicesController {

	@Autowired
	ICatalogoService catalogoService;

	private String nombreColeccionCatalogo = "catalogo";

	@RequestMapping(value = "/api/catalogo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> crearCatalogo(@RequestBody Catalogo nCatalogo) {
		catalogoService.crearCatalogo(nCatalogo);
		return new ResponseEntity<String>("{\"respuesta\": \"Se ha creado un catalogo.\"}",
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/catalogo", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> actualizarCatalogo(@RequestBody Catalogo nCatalogo) {
		catalogoService.actualizarCatalogo(nCatalogo);
		return new ResponseEntity<String>("{\"respuesta\": \"Se ha actualizado el catalogo.\"}",
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/catalogo/{idCatalogo}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> eliminarCatalogo(@PathVariable("idCatalogo") String idCatalogo) {
		catalogoService.eliminarCatalogo(idCatalogo);
		return new ResponseEntity<String>("{\"respuesta\": \"Se ha eliminado el catalogo.\"}",
				HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/api/catalogo/{idCatalogo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Catalogo> obtenerCatalogo(@PathVariable("idCatalogo") String idCatalogo) {
		return new ResponseEntity<Catalogo>(
				(Catalogo) catalogoService.obtenerCatalogo(idCatalogo),
				HttpStatus.OK);
	}
}
