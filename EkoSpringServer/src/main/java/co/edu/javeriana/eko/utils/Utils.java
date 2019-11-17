package co.edu.javeriana.eko.utils;

import co.edu.javeriana.eko.model.Carrito;
import co.edu.javeriana.eko.model.Catalogo;
import co.edu.javeriana.eko.model.Disponibilidad;
import co.edu.javeriana.eko.model.Usuario;
import co.edu.javeriana.eko.model.producto.Transporte;
import co.edu.javeriana.eko.model.*;
import co.edu.javeriana.eko.model.producto.*;
import co.edu.javeriana.eko.model.usuario.Cliente;
import co.edu.javeriana.eko.model.usuario.Proveedor;
import org.bson.Document;
import org.bson.types.ObjectId;

import co.edu.javeriana.eko.model.Calificacion;
import co.edu.javeriana.eko.model.Disponibilidad;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.model.producto.Alojamiento;
import co.edu.javeriana.eko.model.producto.Evento;
import co.edu.javeriana.eko.model.producto.Experiencia;
import co.edu.javeriana.eko.model.producto.Salida;
import co.edu.javeriana.eko.model.producto.Sitio;
import co.edu.javeriana.eko.model.Reserva;
import co.edu.javeriana.eko.model.Pregunta;
import co.edu.javeriana.eko.model.producto.Transporte;
import java.util.ArrayList;
import java.util.List;

public final class Utils {
	/* --- Se genera un Singleton de Variables de Entorno --- */
	private static final Utils instance = new Utils();

	public static Utils getInstance() {
		return instance;
	}

	/**
	 * Imprime un texto en azul
	 *
	 * @param info
	 */
	public static void printInfo(String info) {
		System.out.println(
				// VariablesDeEntorno.ANSI_BLUE +
				"[INFO]: " + info
		// + VariablesDeEntorno.ANSI_RESET
		);
	}

	/**
	 * Imprime el texto en rojo
	 *
	 * @param err
	 */
	public static void printErr(String err) {
		System.err.println(
				// VariablesDeEntorno.ANSI_RED +
				"[ERROR]: " + err
		// + VariablesDeEntorno.ANSI_RESET
		);
	}

	/**
	 * Imprime el texto en ver
	 *
	 * @param success
	 */
	public static void printSuccess(String success) {
		System.out.println(
				// VariablesDeEntorno.ANSI_GREEN +
				"[�XITO]: " + success
		// + VariablesDeEntorno.ANSI_RESET
		);
	}
	
	

	/**
	 * Metodo que convierte un Documento con datos de Transporte a un objeto de tipo Transporte
	 * 
	 * @param docProducto
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
				
		producto.setTitulo(docProducto.getString("titulo"));
		producto.setDisponibilidad(disponibilidad);
		producto.setPrecio(docProducto.getDouble("precio"));
		producto.setInfoPaisDestino(docProducto.getString("infoPaisDestino"));
		producto.setDescripcion(docProducto.getString("descripcion"));
		producto.setTipo(TipoProducto.valueOf(docProducto.getString("tipo")));
		producto.setIdUsuario(docProducto.getString("idUsuario"));
	
		return producto;
	}
	

	/**
	 * Metodo que convierte un objeto de tipo Transporte a un Documento
	 *
	 * @param transporte
	 * @return
	 */
	public static Document deObjetoTransporteADocumento(Transporte transporte) {
		List<Document> disponibilidad = new ArrayList<Document>();
		List<Document> preguntas = new ArrayList<Document>();
		List<Document> calificaciones = new ArrayList<Document>();

		for (Disponibilidad dis : transporte.getDisponibilidad()) {
			disponibilidad
					.add(new Document("fecha", dis.getFecha()).append("cuposDisponibles", dis.getCuposDisponibles()));
		}
		
		for (Pregunta pre : transporte.getPregunta()) {			
			preguntas
					.add(new Document("_id",pre.get_id()).append("id_Producto", pre.getId_Producto()).append("id_Usuario", pre.getId_Usuario())
										.append("descripcion", pre.getDescripcion()).append("respuesta", pre.getRespuesta()).append("fecha_Creacion", pre.getFecha_Creacion()));
		}
		
		for (Calificacion cal : transporte.getCalificacion()) {			
			calificaciones
					.add(new Document("_id",cal.get_id()).append("valoracion", cal.getValoracion()).append("id_Producto", cal.getId_Producto())
										.append("id_Usuario", cal.getId_Usuario()).append("comentario", cal.getComentario()).append("fecha_Creacion", cal.getFecha_Creacion()));
		}
		
		System.out.println("Ut_deObTaD -> "+transporte.getTitulo());
		
		return new Document("precio", transporte.getPrecio())	
				.append("titulo", transporte.getTitulo())
				.append("idUsuario", transporte.getIdUsuario())
				.append("infoPaisDestino", transporte.getInfoPaisDestino())
				.append("disponibilidad", disponibilidad)
				.append("pregunta", preguntas)
				.append("calificacion", calificaciones)
				.append("descripcion", transporte.getDescripcion())
				.append("tipo", transporte.getTipo().toString())
				.append("horaSalida", transporte.getHoraSalida())
				.append("horaLlegada", transporte.getHoraLlegada())
				.append("trayecto", transporte.getTrayecto())
				.append("tipoTransporte", transporte.getTipoTransporte().toString())
				.append("duracion", transporte.getDuracion());
	}

	/**
	 * Metodo que convierte un Documento con datos de Transporte a un objeto de
	 * tipo Transporte
	 *
	 * @param docTransporte
	 * @return
	 */
	public static Transporte deDocumentoAObjetoTransporte(Document docTransporte) {
		Transporte transporte = new Transporte();
		List<Disponibilidad> disponibilidad = new ArrayList<Disponibilidad>();		
		List<Pregunta> pregunta = new ArrayList<Pregunta>();
		List<Calificacion> calificacion = new ArrayList<Calificacion>();

		System.out.println("DOC TRANSPORTE");
		System.out.println(docTransporte);
		List<Document> docPregunta = (List<Document>) docTransporte.get("pregunta");	
		List<Document> docCalificacion = (List<Document>) docTransporte.get("calificacion");
		
		List<Document> docDisponibilidad = (List<Document>) docTransporte.get("disponibilidad");
		List<String> docTrayecto = (List<String>) docTransporte.get("trayecto");
		
		
		String transporteID = ((ObjectId) docTransporte.getObjectId("_id")).toString();

		transporte.set_id(transporteID);

		for (Document docDis : docDisponibilidad) {
			Disponibilidad nDis = new Disponibilidad();
			nDis.setFecha((String) docDis.get("fecha"));
			nDis.setCuposDisponibles((Integer) docDis.get("cuposDisponibles"));
			disponibilidad.add(nDis);
		}

		if (docPregunta != null) {		
			for (Document docPre : docPregunta) {
				Pregunta nPre = new Pregunta();
				nPre.set_id((String) docPre.get("_id"));
				nPre.setId_Producto((String) docPre.get("id_Producto"));
				nPre.setId_Usuario((String) docPre.get("id_Usuario"));
				nPre.setDescripcion((String) docPre.get("descripcion"));
				nPre.setRespuesta((String) docPre.get("respuesta"));	
				nPre.setFecha_Creacion((String) docPre.get("fecha_Creacion"));	
				pregunta.add(nPre);
			}	
			transporte.setPregunta(pregunta);
		}else {
			List<Pregunta> preg = new ArrayList<Pregunta>(); 
			transporte.setPregunta(preg);			
		}
		
		
		if (docCalificacion != null) {		
			for (Document docPre : docCalificacion) {
				Calificacion nCal = new Calificacion();
				nCal.set_id((String) docPre.get("_id"));
				nCal.setValoracion((Integer) docPre.get("valoracion"));
				nCal.setId_Producto((String) docPre.get("id_Producto"));
				nCal.setId_Usuario((String) docPre.get("id_Usuario"));
				nCal.setComentario((String) docPre.get("comentario"));	
				nCal.setFecha_Creacion((String) docPre.get("fecha_Creacion"));	
				calificacion.add(nCal);
			}	
			transporte.setCalificacion(calificacion);
		}else {
			List<Calificacion> caln = new ArrayList<Calificacion>(); 
			transporte.setCalificacion(caln);			
		}
		
		transporte.setTrayecto(docTrayecto);

		transporte.setTitulo(docTransporte.getString("titulo"));		
		transporte.setDisponibilidad(disponibilidad);		
		transporte.setPrecio(docTransporte.getDouble("precio"));
		transporte.setInfoPaisDestino(docTransporte.getString("infoPaisDestino"));
		transporte.setDescripcion(docTransporte.getString("descripcion"));
		transporte.setTipo(TipoProducto.valueOf(docTransporte.getString("tipo")));
		transporte.setHoraSalida(docTransporte.getString("horaSalida"));
		transporte.setHoraLlegada(docTransporte.getString("horaLlegada"));
		transporte.setTipoTransporte(TipoTransporte.valueOf(docTransporte.getString("tipoTransporte")));
		transporte.setDuracion(docTransporte.getInteger("duracion"));
		transporte.setIdUsuario(docTransporte.getString("idUsuario"));
		
		return transporte;
	}
	
	
	/**
	 * Metodo que convierte un objeto de tipo Alojamiento a un Documento
	 * 
	 * @param alojamiento
	 * @return
	 */
	public static Document deObjetoAlojamientoADocumento(Alojamiento alojamiento) {
		List<Document> disponibilidad = new ArrayList<Document>();
		List<Document> preguntas = new ArrayList<Document>();
		List<Document> calificaciones = new ArrayList<Document>();		
		
		for (Pregunta pre : alojamiento.getPregunta()) {			
			preguntas
					.add(new Document("_id",pre.get_id()).append("id_Producto", pre.getId_Producto()).append("id_Usuario", pre.getId_Usuario())
										.append("descripcion", pre.getDescripcion()).append("respuesta", pre.getRespuesta()).append("fecha_Creacion", pre.getFecha_Creacion()));
		}		
		for (Calificacion cal : alojamiento.getCalificacion()) {			
			calificaciones
					.add(new Document("_id",cal.get_id()).append("valoracion", cal.getValoracion()).append("id_Producto", cal.getId_Producto())
										.append("id_Usuario", cal.getId_Usuario()).append("comentario", cal.getComentario()).append("fecha_Creacion", cal.getFecha_Creacion()));
		}		
		for (Disponibilidad dis : alojamiento.getDisponibilidad()) {
			disponibilidad.add(
					new Document("fecha", dis.getFecha())
					.append("cuposDisponibles", dis.getCuposDisponibles())
			);
		}
		
		return new Document("precio", alojamiento.getPrecio())
				.append("titulo", alojamiento.getTitulo())
				.append("idUsuario", alojamiento.getIdUsuario())
				.append("infoPaisDestino", alojamiento.getInfoPaisDestino())
				.append("disponibilidad", disponibilidad)
				.append("pregunta", preguntas)
				.append("calificacion", calificaciones)
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
				.append("numCamas", alojamiento.getNumCamas())
				.append("numBanios", alojamiento.getNumBanios());
	}
	
	/**
	 * Metodo que convierte un Documento con datos de Alojamiento a un objeto de tipo Alojamiento
	 * 
	 * @param docAlojamiento
	 * @return
	 */
	public static Alojamiento deDocumentoAObjetoAlojamiento(Document docAlojamiento) {
		Alojamiento alojamiento = new Alojamiento();
		List<Disponibilidad> disponibilidad = new ArrayList<Disponibilidad>();
		List<Pregunta> pregunta = new ArrayList<Pregunta>();
		List<Calificacion> calificacion = new ArrayList<Calificacion>();

				
		List<Document> docPregunta = (List<Document>) docAlojamiento.get("pregunta");	
		List<Document> docCalificacion = (List<Document>) docAlojamiento.get("calificacion");
		
		List<Document> docDisponibilidad = (List<Document>) docAlojamiento.get("disponibilidad");		
		String alojamientoID = ((ObjectId)docAlojamiento.getObjectId("_id")).toString();
		
		alojamiento.set_id(alojamientoID);
		
		for (Document docDis : docDisponibilidad) {
			Disponibilidad nDis = new Disponibilidad();
			nDis.setFecha((String) docDis.get("fecha"));
			nDis.setCuposDisponibles((Integer) docDis.get("cuposDisponibles"));
			disponibilidad.add(nDis);
		}
		if (docPregunta != null) {		
			for (Document docPre : docPregunta) {
				Pregunta nPre = new Pregunta();
				nPre.set_id((String) docPre.get("_id"));
				nPre.setId_Producto((String) docPre.get("id_Producto"));
				nPre.setId_Usuario((String) docPre.get("id_Usuario"));
				nPre.setDescripcion((String) docPre.get("descripcion"));
				nPre.setRespuesta((String) docPre.get("respuesta"));	
				nPre.setFecha_Creacion((String) docPre.get("fecha_Creacion"));	
				pregunta.add(nPre);
			}	
			alojamiento.setPregunta(pregunta);
		}else {
			List<Pregunta> preg = new ArrayList<Pregunta>(); 
			alojamiento.setPregunta(preg);			
		}
		
		
		if (docCalificacion != null) {		
			for (Document docPre : docCalificacion) {
				Calificacion nCal = new Calificacion();
				nCal.set_id((String) docPre.get("_id"));
				nCal.setValoracion((Integer) docPre.get("valoracion"));
				nCal.setId_Producto((String) docPre.get("id_Producto"));
				nCal.setId_Usuario((String) docPre.get("id_Usuario"));
				nCal.setComentario((String) docPre.get("comentario"));	
				nCal.setFecha_Creacion((String) docPre.get("fecha_Creacion"));	
				calificacion.add(nCal);
			}	
			alojamiento.setCalificacion(calificacion);
		}else {
			List<Calificacion> caln = new ArrayList<Calificacion>(); 
			alojamiento.setCalificacion(caln);			
		}
		

		alojamiento.setTitulo(docAlojamiento.getString("titulo"));
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
		alojamiento.setNumCamas(docAlojamiento.getInteger("numCamas"));
		alojamiento.setNumBanios(docAlojamiento.getInteger("numBanios"));
		alojamiento.setIdUsuario(docAlojamiento.getString("idUsuario"));

		return alojamiento;
	}
	
	/**
	 * Metodo que convierte un objeto de tipo Sitio a un Documento
	 * 
	 * @param sitio
	 * @return
	 */
	public static Document deObjetoSitioADocumento(Sitio sitio) {
		List<Document> disponibilidad = new ArrayList<Document>();
		List<Document> preguntas = new ArrayList<Document>();
		List<Document> calificaciones = new ArrayList<Document>();

		
		
		for (Pregunta pre : sitio.getPregunta()) {			
			preguntas
					.add(new Document("_id",pre.get_id()).append("id_Producto", pre.getId_Producto()).append("id_Usuario", pre.getId_Usuario())
										.append("descripcion", pre.getDescripcion()).append("respuesta", pre.getRespuesta()).append("fecha_Creacion", pre.getFecha_Creacion()));
			
		}
		
		for (Calificacion cal : sitio.getCalificacion()) {			
			calificaciones
					.add(new Document("_id",cal.get_id()).append("valoracion", cal.getValoracion()).append("id_Producto", cal.getId_Producto())
										.append("id_Usuario", cal.getId_Usuario()).append("comentario", cal.getComentario()).append("fecha_Creacion", cal.getFecha_Creacion()));
			
		}
		
		for (Disponibilidad dis : sitio.getDisponibilidad()) {
			disponibilidad.add(
					new Document("fecha", dis.getFecha())
					.append("cuposDisponibles", dis.getCuposDisponibles())
			);
		}
		
		return new Document("precio", sitio.getPrecio())
				.append("titulo", sitio.getTitulo())
				.append("idUsuario", sitio.getIdUsuario())
				.append("infoPaisDestino", sitio.getInfoPaisDestino())
				.append("pregunta", preguntas)
				.append("calificacion", calificaciones)
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
	 * Metodo que convierte un Documento con datos de Sitio a un objeto de tipo Sitio
	 * 
	 * @param docSitio
	 * @return
	 */
	public static Sitio deDocumentoAObjetoSitio(Document docSitio) {
		Sitio sitio = new Sitio();
		List<Disponibilidad> disponibilidad = new ArrayList<Disponibilidad>();
		List<Pregunta> pregunta = new ArrayList<Pregunta>();
		List<Calificacion> calificacion = new ArrayList<Calificacion>();

				
		List<Document> docPregunta = (List<Document>) docSitio.get("pregunta");	
		List<Document> docCalificacion = (List<Document>) docSitio.get("calificacion");
		
		List<Document> docDisponibilidad = (List<Document>) docSitio.get("disponibilidad");		
		String sitioID = ((ObjectId)docSitio.getObjectId("_id")).toString();
		
		sitio.set_id(sitioID);
		
		for (Document docDis : docDisponibilidad) {
			Disponibilidad nDis = new Disponibilidad();
			nDis.setFecha((String) docDis.get("fecha"));
			nDis.setCuposDisponibles((Integer) docDis.get("cuposDisponibles"));
			disponibilidad.add(nDis);
		}
		
		if (docPregunta != null) {		
			for (Document docPre : docPregunta) {
				Pregunta nPre = new Pregunta();
				nPre.set_id((String) docPre.get("_id"));
				nPre.setId_Producto((String) docPre.get("id_Producto"));
				nPre.setId_Usuario((String) docPre.get("id_Usuario"));
				nPre.setDescripcion((String) docPre.get("descripcion"));
				nPre.setRespuesta((String) docPre.get("respuesta"));	
				nPre.setFecha_Creacion((String) docPre.get("fecha_Creacion"));	
				pregunta.add(nPre);
			}	
			sitio.setPregunta(pregunta);
		}else {
			List<Pregunta> preg = new ArrayList<Pregunta>(); 
			sitio.setPregunta(preg);			
		}
		
		
		if (docCalificacion != null) {		
			for (Document docPre : docCalificacion) {
				Calificacion nCal = new Calificacion();
				nCal.set_id((String) docPre.get("_id"));
				nCal.setValoracion((Integer) docPre.get("valoracion"));
				nCal.setId_Producto((String) docPre.get("id_Producto"));
				nCal.setId_Usuario((String) docPre.get("id_Usuario"));
				nCal.setComentario((String) docPre.get("comentario"));	
				nCal.setFecha_Creacion((String) docPre.get("fecha_Creacion"));	
				calificacion.add(nCal);
			}	
			sitio.setCalificacion(calificacion);
		}else {
			List<Calificacion> caln = new ArrayList<Calificacion>(); 
			sitio.setCalificacion(caln);			
		}
		

						
		sitio.setTitulo(docSitio.getString("titulo"));
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
		sitio.setHoraApertura(docSitio.getString("horaApertura"));
		sitio.setHoraCierre(docSitio.getString("horaCierre"));
		sitio.setIdUsuario(docSitio.getString("idUsuario"));
				
		return sitio;
	}
	/**
	 * Metodo que convierte un objeto de tipo Experiencia a un Documento
	 * 
	 * @param experiencia
	 * @return
	 */
	public static Document deObjetoExperienciaADocumento(Experiencia experiencia) {
		List<Document> disponibilidad = new ArrayList<Document>();
		List<Document> preguntas = new ArrayList<Document>();
		List<Document> calificaciones = new ArrayList<Document>();

		
		
		for (Pregunta pre : experiencia.getPregunta()) {			
			preguntas
					.add(new Document("_id",pre.get_id()).append("id_Producto", pre.getId_Producto()).append("id_Usuario", pre.getId_Usuario())
										.append("descripcion", pre.getDescripcion()).append("respuesta", pre.getRespuesta()).append("fecha_Creacion", pre.getFecha_Creacion()));
			
		}
		
		for (Calificacion cal : experiencia.getCalificacion()) {			
			calificaciones
					.add(new Document("_id",cal.get_id()).append("valoracion", cal.getValoracion()).append("id_Producto", cal.getId_Producto())
										.append("id_Usuario", cal.getId_Usuario()).append("comentario", cal.getComentario()).append("fecha_Creacion", cal.getFecha_Creacion()));
			
		}
		
		for (Disponibilidad dis : experiencia.getDisponibilidad()) {
			disponibilidad.add(
					new Document("fecha", dis.getFecha())
					.append("cuposDisponibles", dis.getCuposDisponibles())
			);
		}
		
		return new Document("precio", experiencia.getPrecio())
				.append("titulo", experiencia.getTitulo())
				.append("infoPaisDestino", experiencia.getInfoPaisDestino())
				.append("idUsuario", experiencia.getIdUsuario())
				.append("disponibilidad", disponibilidad)
				.append("pregunta", preguntas)
				.append("calificacion", calificaciones)
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
	 * Metodo que convierte un Documento con datos de Experiencia a un objeto de tipo Experiencia
	 * 
	 * @param docExperiencia
	 * @return
	 */
	public static Experiencia deDocumentoAObjetoExperiencia(Document docExperiencia) {
		Experiencia experiencia= new Experiencia();
		List<Disponibilidad> disponibilidad = new ArrayList<Disponibilidad>();
		List<Pregunta> pregunta = new ArrayList<Pregunta>();
		List<Calificacion> calificacion = new ArrayList<Calificacion>();

				
		List<Document> docPregunta = (List<Document>) docExperiencia.get("pregunta");	
		List<Document> docCalificacion = (List<Document>) docExperiencia.get("calificacion");
		
		List<Document> docDisponibilidad = (List<Document>) docExperiencia.get("disponibilidad");		
		String experienciaID = ((ObjectId)docExperiencia.getObjectId("_id")).toString();
		
		experiencia.set_id(experienciaID);
		
		for (Document docDis : docDisponibilidad) {
			Disponibilidad nDis = new Disponibilidad();
			nDis.setFecha((String) docDis.get("fecha"));
			nDis.setCuposDisponibles((Integer) docDis.get("cuposDisponibles"));
			disponibilidad.add(nDis);
		}
		
		if (docPregunta != null) {		
			for (Document docPre : docPregunta) {
				Pregunta nPre = new Pregunta();
				nPre.set_id((String) docPre.get("_id"));
				nPre.setId_Producto((String) docPre.get("id_Producto"));
				nPre.setId_Usuario((String) docPre.get("id_Usuario"));
				nPre.setDescripcion((String) docPre.get("descripcion"));
				nPre.setRespuesta((String) docPre.get("respuesta"));	
				nPre.setFecha_Creacion((String) docPre.get("fecha_Creacion"));	
				pregunta.add(nPre);
			}	
			experiencia.setPregunta(pregunta);
		}else {
			List<Pregunta> preg = new ArrayList<Pregunta>(); 
			experiencia.setPregunta(preg);			
		}
		
		
		if (docCalificacion != null) {		
			for (Document docPre : docCalificacion) {
				Calificacion nCal = new Calificacion();
				nCal.set_id((String) docPre.get("_id"));
				nCal.setValoracion((Integer) docPre.get("valoracion"));
				nCal.setId_Producto((String) docPre.get("id_Producto"));
				nCal.setId_Usuario((String) docPre.get("id_Usuario"));
				nCal.setComentario((String) docPre.get("comentario"));	
				nCal.setFecha_Creacion((String) docPre.get("fecha_Creacion"));	
				calificacion.add(nCal);
			}	
			experiencia.setCalificacion(calificacion);
		}else {
			List<Calificacion> caln = new ArrayList<Calificacion>(); 
			experiencia.setCalificacion(caln);			
		}
		

						
		experiencia.setTitulo(docExperiencia.getString("titulo"));
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
		experiencia.setHoraLlegada(docExperiencia.getString("horaLlegada"));
		experiencia.setIdUsuario(docExperiencia.getString("idUsuario"));
					
		return experiencia;
	}
	
	/**
	 * Metodo que convierte un objeto de tipo Salida a un Documento
	 * 
	 * @param salida
	 * @return
	 */
	public static Document deObjetoSalidaADocumento(Salida salida) {
		List<Document> disponibilidad = new ArrayList<Document>();
		List<Document> preguntas = new ArrayList<Document>();
		List<Document> calificaciones = new ArrayList<Document>();

		
		
		for (Pregunta pre : salida.getPregunta()) {			
			preguntas
					.add(new Document("_id",pre.get_id()).append("id_Producto", pre.getId_Producto()).append("id_Usuario", pre.getId_Usuario())
										.append("descripcion", pre.getDescripcion()).append("respuesta", pre.getRespuesta()).append("fecha_Creacion", pre.getFecha_Creacion()));
			
		}
		
		for (Calificacion cal : salida.getCalificacion()) {			
			calificaciones
					.add(new Document("_id",cal.get_id()).append("valoracion", cal.getValoracion()).append("id_Producto", cal.getId_Producto())
										.append("id_Usuario", cal.getId_Usuario()).append("comentario", cal.getComentario()).append("fecha_Creacion", cal.getFecha_Creacion()));
			
		}
		
		for (Disponibilidad dis : salida.getDisponibilidad()) {
			disponibilidad.add(
					new Document("fecha", dis.getFecha())
					.append("cuposDisponibles", dis.getCuposDisponibles())
			);
		}
		
		return new Document("precio", salida.getPrecio())
				.append("titulo", salida.getTitulo())
				.append("idUsuario", salida.getIdUsuario())
				.append("infoPaisDestino", salida.getInfoPaisDestino())
				.append("disponibilidad", disponibilidad)
				.append("pregunta", preguntas)
				.append("calificacion", calificaciones)
				.append("descripcion", salida.getDescripcion())
				.append("tipo", salida.getTipo().toString())
				.append("tipoSalida", salida.getTipoSalida().toString())
				.append("duracion", salida.getDuracion())
				.append("trayecto", salida.getTrayecto())
				.append("restriccionEdad", salida.getRestriccionEdad())
				.append("guia", salida.getGuia());
	}
	
	/**
	 * Metodo que convierte un Documento con datos de Salida a un objeto de tipo Salida
	 * 
	 * @param docSalida
	 * @return
	 */
	public static Salida deDocumentoAObjetoSalida(Document docSalida) {
		Salida salida= new Salida();
		List<Disponibilidad> disponibilidad = new ArrayList<Disponibilidad>();
		List<Pregunta> pregunta = new ArrayList<Pregunta>();
		List<Calificacion> calificacion = new ArrayList<Calificacion>();

				
		List<Document> docPregunta = (List<Document>) docSalida.get("pregunta");	
		List<Document> docCalificacion = (List<Document>) docSalida.get("calificacion");
		
		
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
		
		if (docPregunta != null) {		
			for (Document docPre : docPregunta) {
				Pregunta nPre = new Pregunta();
				nPre.set_id((String) docPre.get("_id"));
				nPre.setId_Producto((String) docPre.get("id_Producto"));
				nPre.setId_Usuario((String) docPre.get("id_Usuario"));
				nPre.setDescripcion((String) docPre.get("descripcion"));
				nPre.setRespuesta((String) docPre.get("respuesta"));	
				nPre.setFecha_Creacion((String) docPre.get("fecha_Creacion"));	
				pregunta.add(nPre);
			}	
			salida.setPregunta(pregunta);
		}else {
			List<Pregunta> preg = new ArrayList<Pregunta>(); 
			salida.setPregunta(preg);			
		}
		
		
		if (docCalificacion != null) {		
			for (Document docPre : docCalificacion) {
				Calificacion nCal = new Calificacion();
				nCal.set_id((String) docPre.get("_id"));
				nCal.setValoracion((Integer) docPre.get("valoracion"));
				nCal.setId_Producto((String) docPre.get("id_Producto"));
				nCal.setId_Usuario((String) docPre.get("id_Usuario"));
				nCal.setComentario((String) docPre.get("comentario"));	
				nCal.setFecha_Creacion((String) docPre.get("fecha_Creacion"));	
				calificacion.add(nCal);
			}	
			salida.setCalificacion(calificacion);
		}else {
			List<Calificacion> caln = new ArrayList<Calificacion>(); 
			salida.setCalificacion(caln);			
		}
		

			
		salida.setTitulo(docSalida.getString("titulo"));
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
	 * Metodo que convierte un objeto de tipo Evento a un Documento
	 * 
	 * @param evento
	 * @return
	 */
	public static Document deObjetoEventoADocumento(Evento evento) {
		List<Document> disponibilidad = new ArrayList<Document>();
		List<Document> preguntas = new ArrayList<Document>();
		List<Document> calificaciones = new ArrayList<Document>();

		
		
		for (Pregunta pre : evento.getPregunta()) {			
			preguntas
					.add(new Document("_id",pre.get_id()).append("id_Producto", pre.getId_Producto()).append("id_Usuario", pre.getId_Usuario())
										.append("descripcion", pre.getDescripcion()).append("respuesta", pre.getRespuesta()).append("fecha_Creacion", pre.getFecha_Creacion()));
			
		}
		
		for (Calificacion cal : evento.getCalificacion()) {			
			calificaciones
					.add(new Document("_id",cal.get_id()).append("valoracion", cal.getValoracion()).append("id_Producto", cal.getId_Producto())
										.append("id_Usuario", cal.getId_Usuario()).append("comentario", cal.getComentario()).append("fecha_Creacion", cal.getFecha_Creacion()));
			
		}
		
		for (Disponibilidad dis : evento.getDisponibilidad()) {
			disponibilidad.add(
					new Document("fecha", dis.getFecha())
					.append("cuposDisponibles", dis.getCuposDisponibles())
			);
		}
		
		return new Document("precio", evento.getPrecio())
				.append("titulo", evento.getTitulo())
				.append("idUsuario", evento.getIdUsuario())
				.append("infoPaisDestino", evento.getInfoPaisDestino())
				.append("disponibilidad", disponibilidad)
				.append("pregunta", preguntas)
				.append("calificacion", calificaciones)
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
	 * Metodo que convierte un Documento con datos de Evento a un objeto de tipo Evento
	 * 
	 * @param docEvento
	 * @return
	 */
	public static Evento deDocumentoAObjetoEvento(Document docEvento) {
		Evento evento = new Evento();
		List<Disponibilidad> disponibilidad = new ArrayList<Disponibilidad>();
		List<Pregunta> pregunta = new ArrayList<Pregunta>();
		List<Calificacion> calificacion = new ArrayList<Calificacion>();

				
		List<Document> docPregunta = (List<Document>) docEvento.get("pregunta");	
		List<Document> docCalificacion = (List<Document>) docEvento.get("calificacion");
		
		List<Document> docDisponibilidad = (List<Document>) docEvento.get("disponibilidad");		
		String eventoID = ((ObjectId)docEvento.getObjectId("_id")).toString();
		
		evento.set_id(eventoID);
		
		for (Document docDis : docDisponibilidad) {
			Disponibilidad nDis = new Disponibilidad();
			nDis.setFecha((String) docDis.get("fecha"));
			nDis.setCuposDisponibles((Integer) docDis.get("cuposDisponibles"));
			disponibilidad.add(nDis);
		}
		
		if (docPregunta != null) {		
			for (Document docPre : docPregunta) {
				Pregunta nPre = new Pregunta();
				nPre.set_id((String) docPre.get("_id"));
				nPre.setId_Producto((String) docPre.get("id_Producto"));
				nPre.setId_Usuario((String) docPre.get("id_Usuario"));
				nPre.setDescripcion((String) docPre.get("descripcion"));
				nPre.setRespuesta((String) docPre.get("respuesta"));	
				nPre.setFecha_Creacion((String) docPre.get("fecha_Creacion"));	
				pregunta.add(nPre);
			}	
			evento.setPregunta(pregunta);
		}else {
			List<Pregunta> preg = new ArrayList<Pregunta>(); 
			evento.setPregunta(preg);			
		}
		
		
		if (docCalificacion != null) {		
			for (Document docPre : docCalificacion) {
				Calificacion nCal = new Calificacion();
				nCal.set_id((String) docPre.get("_id"));
				nCal.setValoracion((Integer) docPre.get("valoracion"));
				nCal.setId_Producto((String) docPre.get("id_Producto"));
				nCal.setId_Usuario((String) docPre.get("id_Usuario"));
				nCal.setComentario((String) docPre.get("comentario"));	
				nCal.setFecha_Creacion((String) docPre.get("fecha_Creacion"));	
				calificacion.add(nCal);
			}	
			evento.setCalificacion(calificacion);
		}else {
			List<Calificacion> caln = new ArrayList<Calificacion>(); 
			evento.setCalificacion(caln);			
		}
		

		
		evento.setTitulo(docEvento.getString("titulo"));
		evento.setDisponibilidad(disponibilidad);
		evento.setPrecio(docEvento.getDouble("precio"));
		evento.setInfoPaisDestino(docEvento.getString("infoPaisDestino"));		
		evento.setDescripcion(docEvento.getString("descripcion"));
		evento.setTipo(TipoProducto.valueOf(docEvento.getString("tipo")));
		evento.setTipoEvento(TipoEvento.valueOf(docEvento.getString("tipoEvento")));				
		evento.setRestriccionEdad(docEvento.getInteger("restriccionEdad"));		
		evento.setNombreEvento(docEvento.getString("nombreEvento"));
		evento.setHoraApertura(docEvento.getString("horaApertura"));						
		evento.setHoraCierre(docEvento.getString("horaCierre"));
		evento.setMaxPersonas(docEvento.getInteger("maxPersonas"));
		evento.setLatitud(docEvento.getDouble("latitud"));
		evento.setLongitud(docEvento.getDouble("longitud"));
		evento.setIdUsuario(docEvento.getString("idUsuario"));
		return evento;
		
	}

	/**
	 * Metodo que convierte un objeto de tipo Cliente a un Documento
	 *
	 * @param usuario
	 * @return
	 */
	public static Document deObjetoClienteADocumento(Cliente usuario) {

		return new Document("nombre", usuario.getNombre()).append("edad", usuario.getEdad())
				.append("foto", usuario.getFoto()).append("descripcion", usuario.getDescripcion())
				.append("correo", usuario.getCorreo()).append("contrasena", usuario.getContrasena())
				.append("tipoUsuario", usuario.getTipoUsuario().toString());
	}

	/**
	 * Metodo que convierte un objeto de tipo Proveedor a un Documento
	 *
	 * @param usuario
	 * @return
	 */
	public static Document deObjetoProveedorADocumento(Proveedor usuario) {

		return new Document("nombre", usuario.getNombre()).append("edad", usuario.getEdad())
				.append("foto", usuario.getFoto()).append("descripcion", usuario.getDescripcion())
				.append("correo", usuario.getCorreo()).append("contrasena", usuario.getContrasena())
				.append("contactoTwitter", usuario.getContactoTwitter())
				.append("contactoFacebook", usuario.getContactoFacebook()).append("telefono", usuario.getTelefono())
				.append("paginaWeb", usuario.getPaginaWeb()).append("tipoUsuario", usuario.getTipoUsuario().toString());
	}

	/**
	 * Metodo que convierte un Documento con datos de Usuario a un objeto de tipo
	 * Usuario
	 *
	 * @param docUsuario
	 * @return
	 */
	public static Usuario deDocumentoAObjetoUsuario(Document docUsuario) {

		if (docUsuario.getString("tipoUsuario").equals("CLIENTE")) {
			return deDocumentoAObjetoCliente(docUsuario);
		} else if (docUsuario.getString("tipoUsuario").equals("PROVEEDOR")) {
			return deDocumentoAObjetoProveedor(docUsuario);
		}

		return null;
	}

	/**
	 * Metodo que convierte un Documento con datos de Usuario a un objeto de tipo
	 * Usuario
	 *
	 * @param docUsuario
	 * @return
	 */
	public static Cliente deDocumentoAObjetoCliente(Document docUsuario) {
		Cliente usuario = new Cliente();
		usuario.setNombre(docUsuario.getString("nombre"));
		usuario.setEdad(docUsuario.getInteger("edad"));
		usuario.setFoto(docUsuario.getString("foto"));
		usuario.setNombre(docUsuario.getString("nombre"));
		usuario.setDescripcion(docUsuario.getString("descripcion"));
		usuario.setCorreo(docUsuario.getString("correo"));
		usuario.setContrasena(docUsuario.getString("contrasena"));
		usuario.setTipoUsuario(TipoUsuario.valueOf(docUsuario.getString("tipoUsuario")));

		return usuario;
	}

	/**
	 * Metodo que convierte un Documento con datos de Usuario a un objeto de tipo
	 * Usuario
	 *
	 * @param docUsuario
	 * @return
	 */
	public static Proveedor deDocumentoAObjetoProveedor(Document docUsuario) {
		Proveedor usuario = new Proveedor();
		usuario.setNombre(docUsuario.getString("nombre"));
		usuario.setEdad(docUsuario.getInteger("edad"));
		usuario.setFoto(docUsuario.getString("foto"));
		usuario.setNombre(docUsuario.getString("nombre"));
		usuario.setDescripcion(docUsuario.getString("descripcion"));
		usuario.setCorreo(docUsuario.getString("correo"));
		usuario.setContrasena(docUsuario.getString("contrasena"));
		usuario.setTipoUsuario(TipoUsuario.valueOf(docUsuario.getString("tipoUsuario")));
		usuario.setPaginaWeb(docUsuario.getString("paginaWeb"));
		usuario.setContactoFacebook(docUsuario.getString("contactoFacebook"));
		usuario.setContactoTwitter(docUsuario.getString("contactoTwitter"));
		usuario.setTelefono(docUsuario.getString("telefono"));

		return usuario;
	}
	
	/**
	 * Metodo que convierte un objeto de tipo Catalogoa un Documento
	 * 
	 * @param catalogo
	 * @return
	 */
	public static Document deObjetoCatalogoADocumento(Catalogo catalogo) {
		List<Document> productos = new ArrayList<Document>();
		List<Document> disponibilidad = new ArrayList<Document>();
		
		for (String p: catalogo.getProductos()) {					
			
			productos.add(					
					new Document("idProducto", p)							
			);
		}
		
		return new Document("descripcion", catalogo.getDescripcion())
				.append("idUsuario", catalogo.getIdUsuario())
				.append("nombre", catalogo.getNombre())
				.append("precio", catalogo.getPrecio())
				.append("productos", productos);
	}
	
	/**
	 * Metodo que convierte un Documento con datos de Catalogo a un objeto de tipo Catalogo
	 * 
	 * @param docCatalogo
	 * @return
	 */
	public static Catalogo deDocumentoAObjetoCatalogo(Document docCatalogo) {
		Catalogo catalogo= new Catalogo();		
		List<String> productos = new ArrayList<String>();
		List<Document> docProductos = (List<Document>) docCatalogo.get("productos");	
		
		String catalogoID = ((ObjectId)docCatalogo.getObjectId("_id")).toString();
		
		catalogo.set_id(catalogoID);
		
		for (Document docProd : docProductos) {
			String p = "";
			p = docProd.getString("idProducto");			
			productos.add(p);
		}
						
		catalogo.setDescripcion(docCatalogo.getString("descripcion"));
		catalogo.setIdUsuario(docCatalogo.getString("idUsuario"));
		catalogo.setNombre(docCatalogo.getString("nombre"));
		catalogo.setPrecio(docCatalogo.getDouble("precio"));
		catalogo.setProductos(productos);
	
		return catalogo;
		
	}
	
	
	/**
	 * Metodo que convierte un objeto de tipo Reserva a un Documento
	 * 
	 * @param reserva
	 * @return
	 */
	public static Document deObjetoReservaADocumento(Reserva reserva) {

		return new Document("fecha", reserva.getFechas())
				.append("id_cliente", reserva.getClienteid())
				.append("id_producto", reserva.getProductoid());
	}
	
	/**
	 * Metodo que convierte un Documento con datos de Reserva a un objeto de tipo Reserva
	 * 
	 * @param docReserva
	 * @return
	 */
	public static Reserva deDocumentoAObjetoReserva(Document docReserva) {
		Reserva reserva=new Reserva();
		
		//List<String> docFecha = (List<String>) docReserva.get("fecha");
		String reservaID = ((ObjectId)docReserva.getObjectId("_id")).toString();
		
		reserva.set_id(reservaID);
		
		reserva.setFechas(docReserva.getString("fecha"));
		
		reserva.setClienteid(docReserva.getString("id_cliente"));
		
		reserva.setProductoid(docReserva.getString("id_producto"));
		return reserva;
	}
	
	
	/**
	 * Metodo que convierte un objeto de tipo Carrito a un Documento
	 * 
	 * @param carrito
	 * @return
	 */
	public static Document deObjetoCarritoADocumento(Carrito carrito) {
		List<Document> productos= new ArrayList<Document>();
		
		for (String p: carrito.getProductos()) {
			productos.add(new Document("producto", p));
		}		
		return new Document("idUsuario", carrito.getIdUsuario())
				.append("productos", productos);
				
	}
	
	/**
	 * Metodo que convierte un Documento con datos de Salida a un objeto de tipo Salida
	 * 
	 * @param salida
	 * @return
	 */
	public static Carrito deDocumentoAObjetoCarrito(Document docCarrito) {
		Carrito carrito = new Carrito();
		List<String> productos = new ArrayList<String>();
		List<Document> docProductos= (List<Document>) docCarrito.get("productos");	
		
		String salidaID = ((ObjectId)docCarrito.getObjectId("_id")).toString();
		
		carrito.set_id(salidaID);
		
		for (Document prod: docProductos) {
			String p = prod.getString("producto");
			productos.add(p);
		}
						
		carrito.setIdUsuario(docCarrito.getString("idUsuario"));
		carrito.setProductos(productos);
		
		
		return carrito;
	}	
	/**
	 * M�todo que convierte un objeto de tipo Calificacion a un Documento
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
	 * M�todo que convierte un Documento con datos de Calificacion a un objeto de tipo Calificacion
	 * 
	 * @param calificacion
	 * @return
	 */
	public static Calificacion deDocumentoAObjetoCalificacion(Document docCalificacion) {
		Calificacion calificacion = new Calificacion();					
		
		calificacion.setValoracion(docCalificacion.getInteger("valoracion"));
		calificacion.setId_Usuario(docCalificacion.getString("id_Producto"));
		calificacion.setId_Usuario(docCalificacion.getString("id_Usuario"));
		calificacion.setComentario(docCalificacion.getString("comentario"));
		calificacion.setFecha_Creacion(docCalificacion.getString("fecha_Creacion"));			
		
		return calificacion;		
		
	}
	
	
	/**
	 * M�todo que convierte un objeto de tipo Pregunta a un Documento
	 * 
	 * @param pregunta
	 * @return
	 */
	public static Document deObjetoPreguntaADocumento(Pregunta pregunta) {		
	
		return new Document("id_Producto", pregunta.getId_Producto())
				.append("id_Usuario", pregunta.getId_Usuario())
				.append("descripcion", pregunta.getDescripcion())				
				.append("respuesta", pregunta.getRespuesta())
				.append("fecha_Creacion", pregunta.getFecha_Creacion());
	}

	/**
	 * M�todo que convierte un Documento con datos de Pregunta a un objeto de tipo Pregunta
	 * 
	 * @param pregunta
	 * @return
	 */
	public static Pregunta deDocumentoAObjetoPregunta(Document docPregunta) {
		
		Pregunta pregunta = new Pregunta();		
		
		pregunta.setId_Producto(docPregunta.getString("id_Producto"));
		pregunta.setId_Usuario(docPregunta.getString("id_Usuario"));
		pregunta.setDescripcion(docPregunta.getString("descripcion"));
		pregunta.setRespuesta(docPregunta.getString("respuesta"));
		pregunta.setFecha_Creacion(docPregunta.getString("fecha_Creacion"));			
		
		return pregunta;
		
	}

}

