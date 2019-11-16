package co.edu.javeriana.eko.iservice;

import java.util.List;

import co.edu.javeriana.eko.model.Reserva;

public interface IReservaService {
	
	public boolean crearReserva(Reserva nReserva);
	
	public List<Reserva> obtenerRerservasClientePorID(String _id);
	
	public void actualizarReserva(Reserva nReserva);
	
	public void cancelarReservaPorID(String _id);
	
	public Reserva obtenerReservaPorID(String _id);

}
