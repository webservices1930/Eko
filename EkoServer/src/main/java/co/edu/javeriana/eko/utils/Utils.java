package co.edu.javeriana.eko.utils;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import co.edu.javeriana.eko.model.Disponibilidad;
import co.edu.javeriana.eko.model.producto.Alojamiento;
import co.edu.javeriana.eko.model.producto.Evento;
import co.edu.javeriana.eko.model.producto.Experiencia;
import co.edu.javeriana.eko.model.producto.Salida;
import co.edu.javeriana.eko.model.producto.Sitio;
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
	 * Método que convierte un objeto de tipo Alojamiento a un Documento
	 * 
	 * @param alojamiento
	 * @return
	 */
	public static Document deObjetoAlojamientoADocumento(Alojamiento alojamiento) {
		List<Document> disponibilidad = new ArrayList<Document>();
		
		for (Disponibilidad dis : alojamiento.getDisponibilidad()) {
			disponibilidad.add(
					new Document("fecha", dis.getFecha())
					.append("cuposDisponibles", dis.getCuposDisponibles())
			);
		}
		
		return new Document("precio", alojamiento.getPrecio())
				.append("infoPaisDestino", alojamiento.getInfoPaisDestino())
				.append("disponibilidad", disponibilidad)
				.append("descripcion", alojamiento.getDescripcion())
				.append("tipo", alojamiento.getTipo().toString())
				.append("tipoAlojamiento", alojamiento.getTipoAlojamiento().toString())
				.append("latitud", alojamiento.getLatitud())
				.append("longitud", alojamiento.getLongitud())
				.append("habitaciones", alojamiento.getHabitaciones())
				.append("desayuno", alojamiento.isDesayuno())
				.append("almuerzo", alojamiento.isAlmuerzo())
				.append("cena", alojamiento.isCena())
				.append("internet", alojamiento.isInternet())
				.append("television", alojamiento.isTelevision())
				.append("numeroCamas", alojamiento.getNumCamas())
				.append("numeroBaños", alojamiento.getNumBaños());
	}
	
	
	/**
	 * Método que convierte un objeto de tipo Sitio a un Documento
	 * 
	 * @param alojamiento
	 * @return
	 */
	public static Document deObjetoSitioADocumento(Sitio sitio) {
		List<Document> disponibilidad = new ArrayList<Document>();
		
		for (Disponibilidad dis : sitio.getDisponibilidad()) {
			disponibilidad.add(
					new Document("fecha", dis.getFecha())
					.append("cuposDisponibles", dis.getCuposDisponibles())
			);
		}
		
		return new Document("precio", sitio.getPrecio())
				.append("infoPaisDestino", sitio.getInfoPaisDestino())
				.append("disponibilidad", disponibilidad)
				.append("descripcion", sitio.getDescripcion())
				.append("tipo", sitio.getTipo().toString())
				.append("tipoSitio", sitio.getTipoDeSitio().toString())
				.append("latitud", sitio.getLatitud())
				.append("longitud", sitio.getLongitud())
				.append("restriccionEdad", sitio.getRestriccionEdad())
				.append("consumoObligatorio", sitio.isConsumoObligatorio())
				.append("horaApertura", sitio.getHoraApertura())
				.append("horaCierre", sitio.getHoraCierre());
	}
	
	/**
	 * Método que convierte un objeto de tipo Experiencia a un Documento
	 * 
	 * @param alojamiento
	 * @return
	 */
	public static Document deObjetoExperienciaADocumento(Experiencia experiencia) {
		List<Document> disponibilidad = new ArrayList<Document>();
		
		for (Disponibilidad dis : experiencia.getDisponibilidad()) {
			disponibilidad.add(
					new Document("fecha", dis.getFecha())
					.append("cuposDisponibles", dis.getCuposDisponibles())
			);
		}
		
		return new Document("precio", experiencia.getPrecio())
				.append("infoPaisDestino", experiencia.getInfoPaisDestino())
				.append("disponibilidad", disponibilidad)
				.append("descripcion", experiencia.getDescripcion())
				.append("tipo", experiencia.getTipo().toString())
				.append("tipoExperiencia", experiencia.getTipoExperiencia().toString())
				.append("nivelRiesgo", experiencia.getNivelRiesgo())
				.append("restriccionEdad", experiencia.getRestriccionEdad())
				.append("latitud", experiencia.getLatitud())
				.append("longitud", experiencia.getLongitud())
				.append("duracion", experiencia.getDuracion())
				.append("horaLlegada", experiencia.getHoraLlegada());
	}
	
	/**
	 * Método que convierte un objeto de tipo Salida a un Documento
	 * 
	 * @param alojamiento
	 * @return
	 */
	public static Document deObjetoSalidaADocumento(Salida salida) {
		List<Document> disponibilidad = new ArrayList<Document>();
		
		for (Disponibilidad dis : salida.getDisponibilidad()) {
			disponibilidad.add(
					new Document("fecha", dis.getFecha())
					.append("cuposDisponibles", dis.getCuposDisponibles())
			);
		}
		
		return new Document("precio", salida.getPrecio())
				.append("infoPaisDestino", salida.getInfoPaisDestino())
				.append("disponibilidad", disponibilidad)
				.append("descripcion", salida.getDescripcion())
				.append("tipo", salida.getTipo().toString())
				.append("tipoSalida", salida.getTipoSalida().toString())
				.append("duracion", salida.getDuracion())
				.append("trayecto", salida.getTrayecto())
				.append("restriccionEdad", salida.getRestriccionEdad())
				.append("guia", salida.getGuia());
	}
	
	/**
	 * Método que convierte un objeto de tipo Evento a un Documento
	 * 
	 * @param alojamiento
	 * @return
	 */
	public static Document deObjetoEventoADocumento(Evento evento) {
		List<Document> disponibilidad = new ArrayList<Document>();
		
		for (Disponibilidad dis : evento.getDisponibilidad()) {
			disponibilidad.add(
					new Document("fecha", dis.getFecha())
					.append("cuposDisponibles", dis.getCuposDisponibles())
			);
		}
		
		return new Document("precio", evento.getPrecio())
				.append("infoPaisDestino", evento.getInfoPaisDestino())
				.append("disponibilidad", disponibilidad)
				.append("descripcion", evento.getDescripcion())
				.append("tipo", evento.getTipo().toString())
				.append("tipoEvento", evento.getTipoEvento().toString())
				.append("nombreEvento", evento.getNombreEvento())
				.append("restriccionEdad", evento.getRestriccionEdad())
				.append("horaApertura", evento.getHoraApertura())
				.append("horaCierre", evento.getHoraCierre())
				.append("maxPersonas", evento.getMaxPersonas())
				.append("latitud", evento.getLatitud())
				.append("longitud", evento.getLongitud());
	}
}
