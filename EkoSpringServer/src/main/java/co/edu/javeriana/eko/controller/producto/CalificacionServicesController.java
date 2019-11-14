package co.edu.javeriana.eko.controller.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.eko.iservice.ICalificacionService;
import co.edu.javeriana.eko.iservice.IPreguntaService;
import co.edu.javeriana.eko.model.Calificacion;
import co.edu.javeriana.eko.model.Pregunta;



@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class CalificacionServicesController {
	
	@Autowired
	ICalificacionService calificacionService;

	private String nombreColeccionProductoPregunta = "productos-calificacion";

	@RequestMapping(value = "/api/productos/calificacion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> agregarCalificacion(@RequestBody Calificacion nCalificacion) {
		calificacionService.crearCalificacion(nCalificacion);
		return new ResponseEntity<String>("{\"respuesta\": \"Se ha anexado correctamente la calificación al producto.\"}",
				HttpStatus.OK);
	}
	

}
