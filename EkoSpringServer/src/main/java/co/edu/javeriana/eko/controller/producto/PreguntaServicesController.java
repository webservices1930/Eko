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

import co.edu.javeriana.eko.iservice.IPreguntaService;
import co.edu.javeriana.eko.iservice.IProductoService;
import co.edu.javeriana.eko.model.Pregunta;
import co.edu.javeriana.eko.model.producto.Experiencia;
import co.edu.javeriana.eko.model.producto.Transporte;



@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class PreguntaServicesController {
	
	@Autowired
	IPreguntaService preguntaService;

	private String nombreColeccionProductoPregunta = "productos-pregunta";

	@RequestMapping(value = "/api/productos/pregunta", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> agregarPregunta(@RequestBody Pregunta nPregunta) {
		preguntaService.crearPregunta(nPregunta);
		return new ResponseEntity<String>("{\"respuesta\": \"Se ha anexado correctamente la pregunta al producto.\"}",
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/productos/pregunta/{idProducto}/{idPregunta}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> eliminarPregunta(@PathVariable("idProducto") String idProducto, @PathVariable("idPregunta") String idPregunta ) {
		preguntaService.eliminarPregunta(idProducto, idPregunta );
		return new ResponseEntity<String>("{\"respuesta\": \"Se ha eliminado correctamente la pregunta.\"}",
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/productos/pregunta/{idProducto}/{idPregunta}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pregunta> obtenerPregunta(@PathVariable("idProducto") String idProducto, @PathVariable("idPregunta") String idPregunta) {
		return new ResponseEntity<Pregunta>(
				(Pregunta) preguntaService.obtenerPregunta(idProducto, idPregunta),
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/productos/pregunta", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> actualizarPregunta(@RequestBody Pregunta nPregunta) {
		preguntaService.actualizarPregunta(nPregunta);
		return new ResponseEntity<String>("{\"respuesta\": \"Se ha actualizado correctamente la pregunta.\"}",
				HttpStatus.OK);
	}
	
}
