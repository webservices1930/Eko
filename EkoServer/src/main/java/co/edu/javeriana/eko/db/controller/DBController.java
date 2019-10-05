package co.edu.javeriana.eko.db.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import co.edu.javeriana.eko.model.Usuario;
import co.edu.javeriana.eko.model.producto.Transporte;
import co.edu.javeriana.eko.model.usuario.Cliente;
import co.edu.javeriana.eko.model.usuario.Proveedor;
import co.edu.javeriana.eko.utils.Utils;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.model.producto.Alojamiento;
import co.edu.javeriana.eko.model.producto.Evento;
import co.edu.javeriana.eko.model.producto.Experiencia;
import co.edu.javeriana.eko.model.producto.Salida;
import co.edu.javeriana.eko.model.producto.Sitio;
import co.edu.javeriana.eko.model.producto.Transporte;
import co.edu.javeriana.eko.utils.TipoProducto;
import co.edu.javeriana.eko.utils.Utils;
import static com.mongodb.client.model.Filters.eq;

public final class DBController {
	// Se crea la conexi�n a la Base de Datos
	private static MongoClient clienteMongo = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
	private static String nombreDB = "EkoDB";

	/* --- Se genera un Singleton del Controlador de la Base de Datos --- */
	private static final DBController instance = new DBController();

	public static DBController getInstance() {
		return instance;
	}

	/**
	 * Busca una colecci�n en la base de datos dado su nombre
	 *
	 * @param nombreColeccion
	 */
	public static void buscarCollection(String nombreColeccion) {
		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);			
	}

	/**
	 * 
	 * Busca todos los productos de una coleccion
	 * 
	 * */
	public static List<Producto> obtenerProductos(String nombreColeccion){
		List<Producto> productos = new ArrayList<Producto>();
		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);			
		MongoCursor<Document> cursor = coleccion.find().cursor();
		
		try {
			while(cursor.hasNext()) {
				Producto p = new Producto() {};
				Document doc = cursor.next();				
				p = Utils.deDocumentoAObjetoProducto(doc);				
				productos.add(p);
			}
		}finally {
			cursor.close();
		}
		return productos;
	}
	
	/**
	 * 
	 * Busca todos los productos de un usuario
	 * 
	 * */
	public static List<Producto> obtenerProductosPorUsuario(String nombreColeccion, String _id){
		List<Producto> productos = new ArrayList<Producto>();
		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);			
		BasicDBObject query = new BasicDBObject();		
		query.put("idusuario", _id);
		MongoCursor<Document> cursor = coleccion.find(query).cursor();
		try {
			while(cursor.hasNext()) {
				Producto p = new Producto() {};
				Document doc = cursor.next();				
				p = Utils.deDocumentoAObjetoProducto(doc);				
				productos.add(p);
			}
		}finally {
			cursor.close();
		}
		return productos;
	}
	
	
	/**
	 * Insertar un nuevo Objeto/Documento (JSON) a la colecci�n especificada
	 * 
	 * Insertar un nuevo Objeto/Documento (JSON) a la colecci�n especificada
	 *
	 * @param nombreColeccion
	 * @param nDoc
	 */
	public static void insertarObjeto(String nombreColeccion, Document nDoc) {
		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);

		coleccion.insertOne(nDoc);
		
	}
	
	public static void actualizarObjeto(String nombreColeccion, Document nDoc, String _id) {
		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);
		BasicDBObject query = new BasicDBObject();		
		query.put("_id", new ObjectId(_id));		
		coleccion.findOneAndReplace(query, nDoc);
	}
		

	/**
	 * Busca en una colecci�n indicada un objeto por su ID
	 *
	 * @param nombreColeccion
	 * @param _id
	 */
	public static Transporte buscarEnColeccionPorID(String nombreColeccion, String _id) {
		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);

		// Se crea el query con un objeto ID del tipo que utiliza MongoDB
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(_id));
				

		Document transporte = coleccion.find(query).first();
		return Utils.deDocumentoAObjetoTransporte(transporte);		
	}
	
	/**
	 * Busca en una colecci�n indicada un objeto por su ID
	 * 
	 * @param nombreColeccion
	 * @param _id
	 */
	public static Alojamiento buscarEnColeccionAlojamientoPorID(String nombreColeccion, String _id) {
		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);
		
		// Se crea el query con un objeto ID del tipo que utiliza MongoDB
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(_id));
				
		Document alojamiento = coleccion.find(query).first();
		return Utils.deDocumentoAObjetoAlojamiento(alojamiento);		
	}
	
	/**
	 * Busca en una colecci�n indicada un objeto por su ID
	 * 
	 * @param nombreColeccion
	 * @param _id
	 */
	public static Experiencia buscarEnColeccionExperienciaPorID(String nombreColeccion, String _id) {
		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);
		 
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(_id));				
		Document experiencia = coleccion.find(query).first();
		return Utils.deDocumentoAObjetoExperiencia(experiencia);		
	}
	
	/**
	 * Busca en una colecci�n indicada un objeto por su ID
	 * 
	 * @param nombreColeccion
	 * @param _id
	 */
	public static Salida buscarEnColeccionSalidaPorID(String nombreColeccion, String _id) {
		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);
		 
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(_id));				
		Document salida = coleccion.find(query).first();
		return Utils.deDocumentoAObjetoSalida(salida);		
	}
	
	/**
	 * Busca en una colecci�n indicada un objeto por su ID
	 * 
	 * @param nombreColeccion
	 * @param _id
	 */
	public static Evento buscarEnColeccionEventoPorID(String nombreColeccion, String _id) {
		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);
		 
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(_id));				
		Document evento = coleccion.find(query).first();
		return Utils.deDocumentoAObjetoEvento(evento);		
	}
	
	/**
	 * Busca en una colecci�n indicada un objeto por su ID
	 * 
	 * @param nombreColeccion
	 * @param _id
	 */
	public static Sitio buscarEnColeccionSitioPorID(String nombreColeccion, String _id) {
		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);
		
		// Se crea el query con un objeto ID del tipo que utiliza MongoDB
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(_id));
				
		Document sitio = coleccion.find(query).first();
		return Utils.deDocumentoAObjetoSitio(sitio);		
	}

	/**
	 * Busca en una colecci�n indicada un objeto por su correo
	 *
	 * @param nombreColeccion
	 * @param correo
	 */
	public static Usuario buscarEnColeccionPorCorreo(String nombreColeccion, String correo) {
		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);

		Document usuario = coleccion.find(eq("correo", correo)).first();
		return Utils.deDocumentoAObjetoUsuario(usuario);
	}

	/**
	 * Busca en una colecci�n indicada un objeto por su correo
	 *
	 * @param nombreColeccion
	 * @param correo
	 */
	public static Usuario buscarContrasenaUsuario(String nombreColeccion, String correo) {
		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);

		Document usuario = coleccion.find(eq("correo", correo)).first();

		if (usuario == null) {
			return null;
		}

		return Utils.deDocumentoAObjetoCliente(usuario);
	}

	/**
	 * Elimina en una colecci�n indicada un objeto por su ID
	 *
	 * @param nombreColeccion
	 * @param _id
	 */
	public static void eliminarEnColeccionPorID(String nombreColeccion, String _id) {
		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);

		// Se crea el query con un objeto ID del tipo que utiliza MongoDB
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(_id));

		coleccion.deleteOne(query);
	}

	/**
	 * Elimina en una colecci�n indicada un objeto por su ID
	 *
	 * @param nombreColeccion
	 * @param correo
	 */
	public static void eliminarEnColeccionPorCorreo(String nombreColeccion, String correo) {
		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);

		coleccion.deleteOne(eq("correo", correo));
	}

	/**
	 * Actualiza en una colecci�n indicada un objeto por su correo
	 *
	 * @param nombreColeccion
	 * @param usuario
	 */
	public static void actualizarUsuarioCliente(String nombreColeccion, Usuario usuario, String correo) {
		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);

		coleccion.updateOne(eq("correo", correo), new Document("$set", new Document("nombre", usuario.getNombre())));
		coleccion.updateOne(eq("correo", correo),
				new Document("$set", new Document("contrasena", usuario.getContrasena())));

		coleccion.updateOne(eq("correo", correo), new Document("$set", new Document("edad", usuario.getEdad())));
		coleccion.updateOne(eq("correo", correo), new Document("$set", new Document("correo", usuario.getCorreo())));
		coleccion.updateOne(eq("correo", correo), new Document("$set", new Document("foto", usuario.getFoto())));
		coleccion.updateOne(eq("correo", correo),
				new Document("$set", new Document("descripcion", usuario.getDescripcion())));
	}

	/**
	 * Actualiza en una colecci�n indicada un objeto por su correo
	 *
	 * @param nombreColeccion
	 * @param usuario
	 */
	public static void actualizarUsuarioProveedor(String nombreColeccion, Proveedor usuario, String correo) {

		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);

		coleccion.updateOne(eq("correo", correo), new Document("$set", new Document("nombre", usuario.getNombre())));
		coleccion.updateOne(eq("correo", correo),
				new Document("$set", new Document("contrasena", usuario.getContrasena())));

		coleccion.updateOne(eq("correo", correo), new Document("$set", new Document("edad", usuario.getEdad())));
		coleccion.updateOne(eq("correo", correo), new Document("$set", new Document("correo", usuario.getCorreo())));
		coleccion.updateOne(eq("correo", correo), new Document("$set", new Document("foto", usuario.getFoto())));
		coleccion.updateOne(eq("correo", correo),
				new Document("$set", new Document("descripcion", usuario.getDescripcion())));
		coleccion.updateOne(eq("correo", correo),
				new Document("$set", new Document("contactoFacebook", usuario.getContactoFacebook())));
		coleccion.updateOne(eq("correo", correo),
				new Document("$set", new Document("contactoTwitter", usuario.getContactoTwitter())));
		coleccion.updateOne(eq("correo", correo),
				new Document("$set", new Document("paginaWeb", usuario.getPaginaWeb())));
		coleccion.updateOne(eq("correo", correo),
				new Document("$set", new Document("telefono", usuario.getTelefono())));
	}

	/** Cierra la conexi�n a la Base de Datos de MongoDB */
	public static void cerrarConexionMongoDB() {
		clienteMongo.close();
	}
}
