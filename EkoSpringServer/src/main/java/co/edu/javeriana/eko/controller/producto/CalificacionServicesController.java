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

import co.edu.javeriana.eko.iservice.ICalificacionService;
import co.edu.javeriana.eko.model.Calificacion;
import co.edu.javeriana.eko.model.Pregunta;



@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class CalificacionServicesController {
	
	@Autowired
	ICalificacionService calificacionService;

	private String nombreColeccionProductoPregunta = "productos-calificacion";

	@RequestMapping(value = "/api/productos/calificacion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> agregarPregunta(@RequestBody Calificacion nCalificacion) {
		calificacionService.crearCalificacion(nCalificacion);
		return new ResponseEntity<String>("{\"respuesta\": \"Se ha anexado correctamente la calificación al producto.\"}",
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/productos/calificacion/{idProducto}/{idCalificacion}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> eliminarPregunta(@PathVariable("idProducto") String idProducto, @PathVariable("idCalificacion") String idCalificacion ) {
		calificacionService.eliminarCalificacion(idProducto, idCalificacion );
		return new ResponseEntity<String>("{\"respuesta\": \"Se ha eliminado correctamente la calificacion.\"}",
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/productos/calificacion/{idProducto}/{idPregunta}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Calificacion> obtenerProducto(@PathVariable("idProducto") String idProducto, @PathVariable("idPregunta") String idPregunta) {
		return new ResponseEntity<Calificacion>(
				(Calificacion) calificacionService.obtenerCalificacion(idProducto, idPregunta),
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/productos/calificacion", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> actualizarCalificacion(@RequestBody Calificacion nCalificacion) {
		calificacionService.actualizarCalificacion(nCalificacion);
		return new ResponseEntity<String>("{\"respuesta\": \"Se ha actualizado correctamente la calificacion.\"}",
				HttpStatus.OK);
	}
	

}
