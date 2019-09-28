package co.edu.javeriana.eko.utils;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import co.edu.javeriana.eko.model.Disponibilidad;
import co.edu.javeriana.eko.model.producto.Transporte;

public final class Utils {
	/* --- Se genera un Singleton de Variables de Entorno --- */
	private static final Utils instance = new Utils();
	
	public static Utils getInstance() {
		return instance;
	}
	
	/**
	 * Imprime un texto en azul
	 * @param info
	 */
	public static void printInfo(String info) {
		System.out.println(
//				VariablesDeEntorno.ANSI_BLUE +
				"[INFO]: " + info
//				+ VariablesDeEntorno.ANSI_RESET
		);
	}
	
	/**
	 * Imprime el texto en rojo
	 * @param err
	 */
	public static void printErr(String err) {
		System.err.println(
//				VariablesDeEntorno.ANSI_RED +
				"[ERROR]: " + err
//				+ VariablesDeEntorno.ANSI_RESET
		);
	}
	
	/**
	 * Imprime el texto en ver
	 * @param success
	 */
	public static void printSuccess(String success) {
		System.out.println(
//				VariablesDeEntorno.ANSI_GREEN +
				"[�XITO]: " + success
//				+ VariablesDeEntorno.ANSI_RESET
		);
	}
	
	/**
	 * M�todo que convierte un objeto de tipo Transporte a un Documento
	 * 
	 * @param transporte
	 * @return
	 */
	public static Document deObjetoADocumento(Transporte transporte) {
		List<Document> disponibilidad = new ArrayList<Document>();
		
		for (Disponibilidad dis : transporte.getDisponibilidad()) {
			disponibilidad.add(
					new Document("fecha", dis.getFecha())
					.append("cuposDisponibles", dis.getCuposDisponibles())
			);
		}
		
		return new Document("precio", transporte.getPrecio())
				.append("infoPaisDestino", transporte.getInfoPaisDestino())
				.append("disponibilidad", disponibilidad)
				.append("descripcion", transporte.getDescripcion())
				.append("tipo", transporte.getTipo().toString())
				.append("horaSalida", transporte.getHoraSalida())
				.append("horaLlegada", transporte.getHoraLlegada())
				.append("trayecto", transporte.getTrayecto())
				.append("tipoTransporte", transporte.getTipoTransporte().toString())
				.append("duracion", transporte.getDuracion());
	}
}
