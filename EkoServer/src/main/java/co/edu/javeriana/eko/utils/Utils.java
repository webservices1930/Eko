package co.edu.javeriana.eko.utils;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import co.edu.javeriana.eko.model.Calificacion;
import co.edu.javeriana.eko.model.Disponibilidad;
import co.edu.javeriana.eko.model.Pregunta;
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
				"[ÉXITO]: " + success
//				+ VariablesDeEntorno.ANSI_RESET
		);
	}
	
	/**
	 * Método que convierte un objeto de tipo Transporte a un Documento
	 * 
	 * @param transporte
	 * @return
	 */
	public static Document deObjetoTransporteADocumento(Transporte transporte) {
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
	
	/**
	 * Método que convierte un Documento con datos de Transporte a un objeto de tipo Transporte
	 * 
	 * @param transporte
	 * @return
	 */
	public static Transporte deDocumentoAObjetoTransporte(Document docTransporte) {
		Transporte transporte = new Transporte();
		List<Disponibilidad> disponibilidad = new ArrayList<Disponibilidad>();
		
		List<Document> docDisponibilidad = (List<Document>) docTransporte.get("disponibilidad");
		List<String> docTrayecto = (List<String>) docTransporte.get("trayecto");
		String transporteID = ((ObjectId)docTransporte.getObjectId("_id")).toString();
		
		transporte.set_id(transporteID);
		
		for (Document docDis : docDisponibilidad) {
			Disponibilidad nDis = new Disponibilidad();
			nDis.setFecha((String) docDis.get("fecha"));
			nDis.setCuposDisponibles((Integer) docDis.get("cuposDisponibles"));
			disponibilidad.add(nDis);
		}
		
		transporte.setTrayecto(docTrayecto);
		
		transporte.setDisponibilidad(disponibilidad);
		transporte.setPrecio(docTransporte.getDouble("precio"));
		transporte.setInfoPaisDestino(docTransporte.getString("infoPaisDestino"));
		transporte.setDescripcion(docTransporte.getString("descripcion"));
		transporte.setTipo(TipoProducto.valueOf(docTransporte.getString("tipo")));
		transporte.setHoraSalida(docTransporte.getInteger("horaSalida"));
		transporte.setHoraLlegada(docTransporte.getInteger("horaLlegada"));
		transporte.setTipoTransporte(TipoTransporte.valueOf(docTransporte.getString("tipoTransporte")));
		transporte.setDuracion(docTransporte.getInteger("duracion"));
		
		return transporte;
	}
	
	/**
	 * Método que convierte un objeto de tipo Calificacion a un Documento
	 * 
	 * @param calificacion
	 * @return
	 */
	public static Document deObjetoCalificacionADocumento(Calificacion calificacion) {		
		
		return new Document("valoracion", calificacion.getValoracion())				
				.append("id_Producto", calificacion.getId_Producto())
				.append("comentario", calificacion.getComentario())
				.append("fecha_Creacion", calificacion.getFecha_Creacion());
	}
	
	
	/**
	 * Método que convierte un objeto de tipo Pregunta a un Documento
	 * 
	 * @param pregunta
	 * @return
	 */
	public static Document deObjetoPreguntaADocumento(Pregunta pregunta) {		
	
		return new Document("id_Servicio", pregunta.getId_Servicio())
				.append("descripcion", pregunta.getDescripcion())				
				.append("respuesta", pregunta.getRespuesta())
				.append("fecha_Creacion", pregunta.getFecha_Creacion());
	}
	
	
	
	
	
	
	
	
}
