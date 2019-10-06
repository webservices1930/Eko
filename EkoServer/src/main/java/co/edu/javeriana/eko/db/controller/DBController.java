package co.edu.javeriana.eko.db.controller;

import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import co.edu.javeriana.eko.model.Disponibilidad;
import co.edu.javeriana.eko.model.producto.Transporte;
import co.edu.javeriana.eko.utils.Utils;

public final class DBController {
	// Se crea la conexión a la Base de Datos
	private static MongoClient clienteMongo = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
	private static String nombreDB = "EkoDB";

	/* --- Se genera un Singleton del Controlador de la Base de Datos --- */
	private static final DBController instance = new DBController();

	public static DBController getInstance() {
		return instance;
	}

	/**
	 * Busca una colección en la base de datos dado su nombre
	 * 
	 * @param nombreColeccion
	 */
	public static void buscarCollection(String nombreColeccion) {
		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);

		Document myDoc = coleccion.find().first();
		System.out.println(myDoc.toJson());
	}

	/**
	 * Insertar un nuevo Objeto/Documento (JSON) a la colección especificada
	 * 
	 * @param nombreColeccion
	 * @param nD
	 */
	public static void insertarObjeto(String nombreColeccion, Document nDoc) {
		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);
		
		coleccion.insertOne(nDoc);
	}
	
	/**
	 * Busca en una colección indicada un objeto por su ID
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
	 * Elimina en una colección indicada un objeto por su ID
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
	 * Modificar los cupos disponibles del producto
	 */
	public static boolean modificarCapacidadProducto(String nombreColeccion, String _id) {
		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);
		int cupos=-1;
		boolean cupohay = true;
		
		
		//Se crea el query para modificar la disponibilidad del producto
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(_id));
		
		Document producto = coleccion.find(query).first();
		/*List<Document> docDisponibilidad = (List<Document>) producto.get("disponibilidad");
		for (Document docDis : docDisponibilidad) {
			cupos=docDis.getInteger("cuposDisponibles");
		}*/
		
		if(cupos==0) {
			System.out.println("No se puede reservar mas");
			cupohay=false;
		}else {
			cupos--;
			System.out.println(cupos);
			//coleccion.findOneAndReplace(query, producto);
		}
		return cupohay;
	}

	/**
	 * Cierra la conexión a la Base de Datos de MongoDB
	 */
	public static void cerrarConexionMongoDB() {
		clienteMongo.close();
	}
}
