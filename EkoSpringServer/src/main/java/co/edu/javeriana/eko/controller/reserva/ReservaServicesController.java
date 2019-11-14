package co.edu.javeriana.eko.controller.reserva;

import java.util.List;

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

import co.edu.javeriana.eko.iservice.IReservaService;
import co.edu.javeriana.eko.model.Reserva;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class ReservaServicesController {

	@Autowired
	IReservaService reservaService;
	
	private String nombreColeccionReservas = "reservas";
	
	@RequestMapping(value = "/api/reserva", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> agregarReserva(@RequestBody Reserva nReserva) {
		boolean fueCreada = reservaService.crearReserva(nReserva);
		
		if (!fueCreada) {
			return new ResponseEntity<String>("{\"respuesta\": \"No se pudo reservar el producto seleccionado.\"}",
					HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>("{\"respuesta\": \"Se ha agregado correctamente el la reserva.\"}",
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/reservas/cliente/{idCliente}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Reserva>> obtenerReservasPorClienteID(@PathVariable("idCliente") String idCliente) {
		return new ResponseEntity<List<Reserva>>(
				reservaService.obtenerRerservasClientePorID(idCliente),
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/reserva", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> actualizarReserva(@RequestBody Reserva nReserva) {
		reservaService.actualizarReserva(nReserva);
		return new ResponseEntity<String>("{\"respuesta\": \"Se ha actualizado correctamente el la reserva.\"}",
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/reserva/{idReserva}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> cancelarReserva(@PathVariable("idReserva") String idReserva) {
		reservaService.cancelarReservaPorID(idReserva);
		return new ResponseEntity<String>("{\"respuesta\": \"Se ha actualizado correctamente el la reserva.\"}",
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/reserva/{idReserva}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Reserva> obtenerReserva(@PathVariable("idReserva") String idReserva) {
		return new ResponseEntity<Reserva>(reservaService.obtenerReservaPorID(idReserva),
				HttpStatus.OK);
	}
}
