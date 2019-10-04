package co.edu.javeriana.eko.db.controller;

import co.edu.javeriana.eko.model.Usuario;
import co.edu.javeriana.eko.model.producto.Transporte;
import co.edu.javeriana.eko.model.usuario.Cliente;
import co.edu.javeriana.eko.model.usuario.Proveedor;
import co.edu.javeriana.eko.utils.Utils;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public final class DBController {
  // Se crea la conexi�n a la Base de Datos
  private static MongoClient clienteMongo =
      new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
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

    Document myDoc = coleccion.find().first();
    System.out.println(myDoc.toJson());
  }

  /**
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
   * Busca en una colecci�n indicada un objeto por su correo
   *
   * @param nombreColeccion
   * @param correo
   */
  public static Usuario buscarEnColeccionPorCorreo(String nombreColeccion, String correo) {
    MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
    MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);

    Document usuario = coleccion.find(eq("correo", correo)).first();
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
  public static void actualizarUsuarioCliente(
      String nombreColeccion, Usuario usuario, String correo) {
    MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
    MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);

    coleccion.updateOne(
        eq("correo", correo), new Document("$set", new Document("nombre", usuario.getNombre())));
    coleccion.updateOne(
        eq("correo", correo),
        new Document("$set", new Document("contraseña", usuario.getContraseña())));

    coleccion.updateOne(
        eq("correo", correo), new Document("$set", new Document("edad", usuario.getEdad())));
    coleccion.updateOne(
        eq("correo", correo), new Document("$set", new Document("correo", usuario.getCorreo())));
    coleccion.updateOne(
        eq("correo", correo), new Document("$set", new Document("foto", usuario.getFoto())));
    coleccion.updateOne(
        eq("correo", correo),
        new Document("$set", new Document("descripcion", usuario.getDescripcion())));
  }
/**
		  * Actualiza en una colecci�n indicada un objeto por su correo
   *
		   * @param nombreColeccion
   * @param usuario
   */
	public static void actualizarUsuarioProveedor(
			String nombreColeccion, Proveedor usuario, String correo) {

		MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);

		coleccion.updateOne(
				eq("correo", correo), new Document("$set", new Document("nombre", usuario.getNombre())));
		coleccion.updateOne(
				eq("correo", correo),
				new Document("$set", new Document("contraseña", usuario.getContraseña())));

		coleccion.updateOne(
				eq("correo", correo), new Document("$set", new Document("edad", usuario.getEdad())));
		coleccion.updateOne(
				eq("correo", correo), new Document("$set", new Document("correo", usuario.getCorreo())));
		coleccion.updateOne(
				eq("correo", correo), new Document("$set", new Document("foto", usuario.getFoto())));
		coleccion.updateOne(
				eq("correo", correo),
				new Document("$set", new Document("descripcion", usuario.getDescripcion())));
		coleccion.updateOne(
				eq("correo", correo),
				new Document("$set", new Document("contactoFacebook", usuario.getContactoFacebook())));
		coleccion.updateOne(
				eq("correo", correo),
				new Document("$set", new Document("contactoTwitter", usuario.getContactoTwitter())));
		coleccion.updateOne(
				eq("correo", correo),
				new Document("$set", new Document("paginaWeb", usuario.getPaginaWeb())));
		coleccion.updateOne(
				eq("correo", correo),
				new Document("$set", new Document("telefono", usuario.getTelefono())));
	}

  /** Cierra la conexi�n a la Base de Datos de MongoDB */
  public static void cerrarConexionMongoDB() {
    clienteMongo.close();
  }
}
