package co.edu.javeriana.eko.utils;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import co.edu.javeriana.eko.model.Disponibilidad;
import co.edu.javeriana.eko.model.Producto;
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
	 * Método que convierte un Documento con datos de Transporte a un objeto de tipo Transporte
	 * 
	 * @param transporte
	 * @return
	 */
	public static Producto deDocumentoAObjetoProducto(Document docProducto) {
		Producto producto= new Producto() {};
		List<Disponibilidad> disponibilidad = new ArrayList<Disponibilidad>();
		
		List<Document> docDisponibilidad = (List<Document>) docProducto.get("disponibilidad");		
		String transporteID = ((ObjectId)docProducto.getObjectId("_id")).toString();
		
		producto.set_id(transporteID);
		
		for (Document docDis : docDisponibilidad) {
			Disponibilidad nDis = new Disponibilidad();
			nDis.setFecha((String) docDis.get("fecha"));
			nDis.setCuposDisponibles((Integer) docDis.get("cuposDisponibles"));
			disponibilidad.add(nDis);
		}
				
		
		producto.setDisponibilidad(disponibilidad);
		producto.setPrecio(docProducto.getDouble("precio"));
		producto.setInfoPaisDestino(docProducto.getString("infoPaisDestino"));
		producto.setDescripcion(docProducto.getString("descripcion"));
		producto.setTipo(TipoProducto.valueOf(docProducto.getString("tipo")));
		producto.setIdUsuario(docProducto.getString("idUsuario"));
	
		return producto;
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
				.append("idusuario", transporte.getIdUsuario())
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
		transporte.setIdUsuario(docTransporte.getString("idUsuario"));
		
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
				.append("idusuario", alojamiento.getIdUsuario())
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
	 * Método que convierte un Documento con datos de Alojamiento a un objeto de tipo Alojamiento
	 * 
	 * @param alojamiento
	 * @return
	 */
	public static Alojamiento deDocumentoAObjetoAlojamiento(Document docAlojamiento) {
		Alojamiento alojamiento = new Alojamiento();
		List<Disponibilidad> disponibilidad = new ArrayList<Disponibilidad>();
		
		List<Document> docDisponibilidad = (List<Document>) docAlojamiento.get("disponibilidad");		
		String alojamientoID = ((ObjectId)docAlojamiento.getObjectId("_id")).toString();
		
		alojamiento.set_id(alojamientoID);
		
		for (Document docDis : docDisponibilidad) {
			Disponibilidad nDis = new Disponibilidad();
			nDis.setFecha((String) docDis.get("fecha"));
			nDis.setCuposDisponibles((Integer) docDis.get("cuposDisponibles"));
			disponibilidad.add(nDis);
		}
						
		alojamiento.setDisponibilidad(disponibilidad);
		alojamiento.setPrecio(docAlojamiento.getDouble("precio"));
		alojamiento.setInfoPaisDestino(docAlojamiento.getString("infoPaisDestino"));		
		alojamiento.setDescripcion(docAlojamiento.getString("descripcion"));
		alojamiento.setTipo(TipoProducto.valueOf(docAlojamiento.getString("tipo")));
		alojamiento.setTipoAlojamiento(TipoAlojamiento.valueOf(docAlojamiento.getString("tipoAlojamiento")));
		alojamiento.setLatitud(docAlojamiento.getDouble("latitud"));	
		alojamiento.setLongitud(docAlojamiento.getDouble("longitud"));
		alojamiento.setHabitaciones(docAlojamiento.getInteger("habitaciones"));
		alojamiento.setDesayuno(docAlojamiento.getBoolean("desayuno"));
		alojamiento.setAlmuerzo(docAlojamiento.getBoolean("almuerzo"));
		alojamiento.setCena(docAlojamiento.getBoolean("cena"));
		alojamiento.setInternet(docAlojamiento.getBoolean("internet"));
		alojamiento.setTelevision(docAlojamiento.getBoolean("television"));
		alojamiento.setNumCamas(docAlojamiento.getInteger("numeroCamas"));
		alojamiento.setNumBaños(docAlojamiento.getInteger("numeroBaños"));
		alojamiento.setIdUsuario(docAlojamiento.getString("idUsuario"));

		return alojamiento;
	}
	
	/**
	 * Método que convierte un objeto de tipo Sitio a un Documento
	 * 
	 * @param sitio
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
				.append("idusuario", sitio.getIdUsuario())
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
	 * Método que convierte un Documento con datos de Sitio a un objeto de tipo Sitio
	 * 
	 * @param sitio
	 * @return
	 */
	public static Sitio deDocumentoAObjetoSitio(Document docSitio) {
		Sitio sitio = new Sitio();
		List<Disponibilidad> disponibilidad = new ArrayList<Disponibilidad>();
		
		List<Document> docDisponibilidad = (List<Document>) docSitio.get("disponibilidad");		
		String sitioID = ((ObjectId)docSitio.getObjectId("_id")).toString();
		
		sitio.set_id(sitioID);
		
		for (Document docDis : docDisponibilidad) {
			Disponibilidad nDis = new Disponibilidad();
			nDis.setFecha((String) docDis.get("fecha"));
			nDis.setCuposDisponibles((Integer) docDis.get("cuposDisponibles"));
			disponibilidad.add(nDis);
		}
						
		sitio.setDisponibilidad(disponibilidad);
		sitio.setPrecio(docSitio.getDouble("precio"));
		sitio.setInfoPaisDestino(docSitio.getString("infoPaisDestino"));		
		sitio.setDescripcion(docSitio.getString("descripcion"));
		sitio.setTipo(TipoProducto.valueOf(docSitio.getString("tipo")));
		sitio.setTipoDeSitio(TipoDeSitio.valueOf(docSitio.getString("tipoSitio")));
		sitio.setLatitud(docSitio.getDouble("latitud"));	
		sitio.setLongitud(docSitio.getDouble("longitud"));
		sitio.setRestriccionEdad(docSitio.getInteger("restriccionEdad"));
		sitio.setConsumoObligatorio(docSitio.getBoolean("consumoObligatorio"));
		sitio.setHoraApertura(docSitio.getInteger("horaApertura"));
		sitio.setHoraCierre(docSitio.getInteger("horaCierre"));
		sitio.setIdUsuario(docSitio.getString("idUsuario"));
				
		return sitio;
	}
	/**
	 * Método que convierte un objeto de tipo Experiencia a un Documento
	 * 
	 * @param experiencia
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
				.append("idusuario", experiencia.getIdUsuario())
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
	 * Método que convierte un Documento con datos de Experiencia a un objeto de tipo Experiencia
	 * 
	 * @param experiencia
	 * @return
	 */
	public static Experiencia deDocumentoAObjetoExperiencia(Document docExperiencia) {
		Experiencia experiencia= new Experiencia();
		List<Disponibilidad> disponibilidad = new ArrayList<Disponibilidad>();
		
		List<Document> docDisponibilidad = (List<Document>) docExperiencia.get("disponibilidad");		
		String experienciaID = ((ObjectId)docExperiencia.getObjectId("_id")).toString();
		
		experiencia.set_id(experienciaID);
		
		for (Document docDis : docDisponibilidad) {
			Disponibilidad nDis = new Disponibilidad();
			nDis.setFecha((String) docDis.get("fecha"));
			nDis.setCuposDisponibles((Integer) docDis.get("cuposDisponibles"));
			disponibilidad.add(nDis);
		}
						
		experiencia.setDisponibilidad(disponibilidad);
		experiencia.setPrecio(docExperiencia.getDouble("precio"));
		experiencia.setInfoPaisDestino(docExperiencia.getString("infoPaisDestino"));		
		experiencia.setDescripcion(docExperiencia.getString("descripcion"));
		experiencia.setTipo(TipoProducto.valueOf(docExperiencia.getString("tipo")));
		experiencia.setTipoExperiencia(TipoExperiencia.valueOf(docExperiencia.getString("tipoExperiencia")));
		experiencia.setLatitud(docExperiencia.getDouble("latitud"));	
		experiencia.setLongitud(docExperiencia.getDouble("longitud"));
		experiencia.setRestriccionEdad(docExperiencia.getInteger("restriccionEdad"));
		experiencia.setNivelRiesgo(docExperiencia.getInteger("nivelRiesgo"));
		experiencia.setDuracion(docExperiencia.getInteger("duracion"));
		experiencia.setHoraLlegada(docExperiencia.getInteger("horaLlegada"));
		experiencia.setIdUsuario(docExperiencia.getString("idUsuario"));
					
		return experiencia;
	}
	
	/**
	 * Método que convierte un objeto de tipo Salida a un Documento
	 * 
	 * @param salida
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
				.append("idusuario", salida.getIdUsuario())
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
	 * Método que convierte un Documento con datos de Salida a un objeto de tipo Salida
	 * 
	 * @param salida
	 * @return
	 */
	public static Salida deDocumentoAObjetoSalida(Document docSalida) {
		Salida salida= new Salida();
		List<Disponibilidad> disponibilidad = new ArrayList<Disponibilidad>();
		List<String> docTrayecto = (List<String>) docSalida.get("trayecto");
		List<Document> docDisponibilidad = (List<Document>) docSalida.get("disponibilidad");		
		String salidaID = ((ObjectId)docSalida.getObjectId("_id")).toString();
		
		salida.set_id(salidaID);
		
		for (Document docDis : docDisponibilidad) {
			Disponibilidad nDis = new Disponibilidad();
			nDis.setFecha((String) docDis.get("fecha"));
			nDis.setCuposDisponibles((Integer) docDis.get("cuposDisponibles"));
			disponibilidad.add(nDis);
		}
						
		salida.setDisponibilidad(disponibilidad);
		salida.setPrecio(docSalida.getDouble("precio"));
		salida.setInfoPaisDestino(docSalida.getString("infoPaisDestino"));		
		salida.setDescripcion(docSalida.getString("descripcion"));
		salida.setTipo(TipoProducto.valueOf(docSalida.getString("tipo")));
		salida.setTipoSalida(TipoSalida.valueOf(docSalida.getString("tipoSalida")));				
		salida.setRestriccionEdad(docSalida.getInteger("restriccionEdad"));
		salida.setTrayecto(docTrayecto);
		salida.setDuracion(docSalida.getInteger("duracion"));
		salida.setGuia(docSalida.getString("guia"));	
		salida.setIdUsuario(docSalida.getString("idUsuario"));
		
		return salida;
	}
	
	/**
	 * Método que convierte un objeto de tipo Evento a un Documento
	 * 
	 * @param evento
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
				.append("idusuario", evento.getIdUsuario())
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
	
	/**
	 * Método que convierte un Documento con datos de Evento a un objeto de tipo Evento
	 * 
	 * @param evento
	 * @return
	 */
	public static Evento deDocumentoAObjetoEvento(Document docEvento) {
		Evento evento = new Evento();
		List<Disponibilidad> disponibilidad = new ArrayList<Disponibilidad>();		
		List<Document> docDisponibilidad = (List<Document>) docEvento.get("disponibilidad");		
		String eventoID = ((ObjectId)docEvento.getObjectId("_id")).toString();
		
		evento.set_id(eventoID);
		
		for (Document docDis : docDisponibilidad) {
			Disponibilidad nDis = new Disponibilidad();
			nDis.setFecha((String) docDis.get("fecha"));
			nDis.setCuposDisponibles((Integer) docDis.get("cuposDisponibles"));
			disponibilidad.add(nDis);
		}
						
		evento.setDisponibilidad(disponibilidad);
		evento.setPrecio(docEvento.getDouble("precio"));
		evento.setInfoPaisDestino(docEvento.getString("infoPaisDestino"));		
		evento.setDescripcion(docEvento.getString("descripcion"));
		evento.setTipo(TipoProducto.valueOf(docEvento.getString("tipo")));
		evento.setTipoEvento(TipoEvento.valueOf(docEvento.getString("tipoEvento")));				
		evento.setRestriccionEdad(docEvento.getInteger("restriccionEdad"));		
		evento.setNombreEvento(docEvento.getString("nombreEvento"));
		evento.setHoraApertura(docEvento.getInteger("horaApertura"));						
		evento.setHoraCierre(docEvento.getInteger("horaCierre"));
		evento.setMaxPersonas(docEvento.getInteger("maxPersonas"));
		evento.setLatitud(docEvento.getDouble("latitud"));
		evento.setLongitud(docEvento.getDouble("longitud"));
		evento.setIdUsuario(docEvento.getString("idUsuario"));
		return evento;
	}
}
