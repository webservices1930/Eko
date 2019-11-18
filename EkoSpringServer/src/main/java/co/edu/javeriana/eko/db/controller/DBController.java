package co.edu.javeriana.eko.db.controller;

import co.edu.javeriana.eko.model.*;
import co.edu.javeriana.eko.model.producto.*;
import co.edu.javeriana.eko.model.usuario.Proveedor;
import co.edu.javeriana.eko.utils.TipoProducto;
import co.edu.javeriana.eko.utils.Utils;
import twitter4j.JSONArray;
import twitter4j.JSONObject;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterObjectFactory;
import twitter4j.conf.ConfigurationBuilder;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static co.edu.javeriana.eko.utils.Utils.deDocumentoAObjetoTransporte;
import static co.edu.javeriana.eko.utils.Utils.deDocumentoAObjetoAlojamiento;
import static co.edu.javeriana.eko.utils.Utils.deDocumentoAObjetoEvento;
import static co.edu.javeriana.eko.utils.Utils.deDocumentoAObjetoExperiencia;
import static co.edu.javeriana.eko.utils.Utils.deDocumentoAObjetoProducto;
import static co.edu.javeriana.eko.utils.Utils.deDocumentoAObjetoSalida;
import static co.edu.javeriana.eko.utils.Utils.deDocumentoAObjetoSitio;


import static com.mongodb.client.model.Filters.eq;

public final class DBController {
    // Se crea la conexi�n a la Base de Datos
//TODO APRENER A UTILIZAR LA BASE DE DATOS EN LA NUBE ME SALEN CANAS CADA VEZ QUE NO ME VA Y ES PORQUE ESTA EN LOCAL HOST!!!!!

    private static MongoClient clienteMongo = new MongoClient(new MongoClientURI("mongodb://paella:paella@ekodb-shard-00-00-rroku.gcp.mongodb.net:27017,ekodb-shard-00-01-rroku.gcp.mongodb.net:27017,ekodb-shard-00-02-rroku.gcp.mongodb.net:27017/admin?ssl=true&replicaSet=EkoDB-shard-0&authSource=admin&retryWrites=true&w=majority"));
  //  private static MongoClient clienteMongo = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
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
     * Busca todos los productos de una coleccion
     */
    public static List<Producto> obtenerProductos(String nombreColeccion) {
        List<Producto> productos = new ArrayList<Producto>();
        MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
        MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);
        MongoCursor<Document> cursor = coleccion.find().cursor();

        try {
            while (cursor.hasNext()) {
                Producto p = new Producto() {
                };
                Document doc = cursor.next();
                p = Utils.deDocumentoAObjetoProducto(doc);
                productos.add(p);
            }
        } finally {
            cursor.close();
        }
        return productos;
    }

    /**
     * Busca todos los productos de un usuario
     */
    public static List<Producto> obtenerProductosPorUsuario(String nombreColeccion, String _id) {
        List<Producto> productos = new ArrayList<Producto>();
        MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
        MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);
        BasicDBObject query = new BasicDBObject();
        query.put("idusuario", _id);
        MongoCursor<Document> cursor = coleccion.find(query).cursor();
        try {
            while (cursor.hasNext()) {
                Producto p = new Producto() {
                };
                Document doc = cursor.next();
                p = Utils.deDocumentoAObjetoProducto(doc);
                productos.add(p);
            }
        } finally {
            cursor.close();
        }
        return productos;
    }

    /**
     * Insertar un nuevo Objeto/Documento (JSON) a la colecci�n especificada
     * <p>
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
        
        System.out.println(nDoc);
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
    public static Transporte buscarEnColeccionTransportePorID(String nombreColeccion, String _id) {
        MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
        MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);
        Transporte transp = new Transporte() {};
        // Se crea el query con un objeto ID del tipo que utiliza MongoDB
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(_id));

        Document transporte = coleccion.find(query).first();
        
        if(transporte != null) {
        Transporte transporte1 = deDocumentoAObjetoTransporte(transporte);
        return transporte1;
        }
        
        transp.set_id("");
        return transp;
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
        Alojamiento aloja = new Alojamiento() {};
        // Se crea el query con un objeto ID del tipo que utiliza MongoDB
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(_id));

        Document alojamiento = coleccion.find(query).first();
        if(alojamiento != null) {
        return Utils.deDocumentoAObjetoAlojamiento(alojamiento);
        }
        
        aloja.set_id("");
        return aloja;
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
        Experiencia expe = new Experiencia() {};
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(_id));
        Document experiencia = coleccion.find(query).first();
        
        if(experiencia != null) {
        return Utils.deDocumentoAObjetoExperiencia(experiencia);
        }
        
        expe.set_id("");
        return expe;
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
        Salida salir = new Salida() {};
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(_id));
        Document salida = coleccion.find(query).first();
        
        if(salida != null) {
        return Utils.deDocumentoAObjetoSalida(salida);
        }
        
        salir.set_id("");
        return salir;
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
        Evento event = new Evento () {};
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(_id));
        Document evento = coleccion.find(query).first();
        
        if(evento != null) {
        return Utils.deDocumentoAObjetoEvento(evento);
        }
        
        event.set_id("");
        return event;
        
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
        Sitio sit = new Sitio() {};
        // Se crea el query con un objeto ID del tipo que utiliza MongoDB
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(_id));

        Document sitio = coleccion.find(query).first();
        if(sitio != null) {
        return Utils.deDocumentoAObjetoSitio(sitio);
        }
        sit.set_id("");
        return sit;
        
        
    }

    /**
     * Busca en una colecci�n indicada un objeto por su ID
     *
     * @param nombreColeccion
     * @param _id
     */
    public static Catalogo buscarEnColeccionCatalogoPorID(String nombreColeccion, String _id) {
        MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
        MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);

        // Se crea el query con un objeto ID del tipo que utiliza MongoDB
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(_id));

        Document catalogo = coleccion.find(query).first();
        return Utils.deDocumentoAObjetoCatalogo(catalogo);
    }

    /**
     * Busca en una colecci�n de reserva indicada un cliente por su ID
     *
     * @param nombreColeccion
     * @param _id
     */
    public static List<Reserva> buscarEnColeccionReservaPorClienteID(String nombreColeccion, String _id) {


        List<Reserva> reservas = new ArrayList<Reserva>();
        MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
        MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);
        BasicDBObject query = new BasicDBObject();
        query.put("id_cliente", _id);
        MongoCursor<Document> cursor = coleccion.find(query).cursor();
        try {
            while (cursor.hasNext()) {
                Reserva r = new Reserva() {
                };
                Document doc = cursor.next();
                r = Utils.deDocumentoAObjetoReserva(doc);
                reservas.add(r);
            }
        } finally {
            cursor.close();
        }
        return reservas;
    }
    
    
    public static Reserva buscarEnColeccionReservaPorID(String nombreColeccion, String _id) {
        MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
        MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);

        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(_id));
        Document reserva = coleccion.find(query).first();
        return Utils.deDocumentoAObjetoReserva(reserva);
    }

    /**
     * Elimina en una colecci�n indicada un objeto por su ID
     * <p>
     * Busca todos los productos de una coleccion
     */
    public static List<Catalogo> obtenerCatalogos(String nombreColeccion) {
        List<Catalogo> catalogos = new ArrayList<Catalogo>();
        MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
        MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);
        MongoCursor<Document> cursor = coleccion.find().cursor();

        try {
            while (cursor.hasNext()) {
                Catalogo p = new Catalogo() {
                };
                Document doc = cursor.next();
                p = Utils.deDocumentoAObjetoCatalogo(doc);
                catalogos.add(p);
            }
        } finally {
            cursor.close();
        }
        return catalogos;
    }

    /**
     * Busca todos los productos de un usuario
     */
    public static List<Catalogo> obtenerCatalogoPorUsuario(String nombreColeccion, String _id) {
        List<Catalogo> catalogos = new ArrayList<Catalogo>();
        MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
        MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);
        BasicDBObject query = new BasicDBObject();
        query.put("idUsuario", _id);
        MongoCursor<Document> cursor = coleccion.find(query).cursor();
        try {
            while (cursor.hasNext()) {
                Catalogo p = new Catalogo() {
                };
                Document doc = cursor.next();
                p = Utils.deDocumentoAObjetoCatalogo(doc);
                catalogos.add(p);
            }
        } finally {
            cursor.close();
        }
        return catalogos;
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
     * Modificar los cupos disponibles del producto
     */
    public static void modificarCapacidadProductoAnadir(Producto producto) {
        int cupos = 0;
        int disponibilidad = 0;
        List<Disponibilidad> listaProductoCopia = producto.getDisponibilidad();
        for (int i = 0; i < listaProductoCopia.size(); i++) {
            if (producto.getDisponibilidad().get(i).getCuposDisponibles() > 0) {
                disponibilidad = producto.getDisponibilidad().get(i).getCuposDisponibles();
                cupos = +1;
                producto.getDisponibilidad().get(i).setCuposDisponibles(disponibilidad - cupos);
                actualizarProducto(producto);
                break;
            }
        }
    }

    /**
     * Modificar los cupos disponibles del producto
     */
    public static void modificarCapacidadProductoCancelar(Producto producto) {
        int cupos = 0;
        int disponibilidad = 0;
        List<Disponibilidad> listaProductoCopia = producto.getDisponibilidad();
        for (int i = 0; i < listaProductoCopia.size(); i++) {
            if (producto.getDisponibilidad().get(i).getCuposDisponibles() > 0) {
                disponibilidad = producto.getDisponibilidad().get(i).getCuposDisponibles();
                cupos = +1;
                producto.getDisponibilidad().get(i).setCuposDisponibles(disponibilidad + cupos);
                actualizarProducto(producto);
                break;
            }
        }
    }

    public static void actualizarProducto(Producto producto) {
        if (producto.getTipo().equals(TipoProducto.TRANSPORTE)) {
            Document nTransporteDoc = Utils.deObjetoTransporteADocumento((Transporte) producto);
            actualizarObjeto("productos-transporte", (Document) nTransporteDoc, producto.get_id());

        }
        if (producto.getTipo().equals(TipoProducto.ALOJAMIENTO)) {
            Document nAlojamiento = Utils.deObjetoAlojamientoADocumento((Alojamiento) producto);
            actualizarObjeto("productos-alojamiento", (Document) nAlojamiento, producto.get_id());

        }
        if (producto.getTipo().equals(TipoProducto.EVENTO)) {
            Document nAlojamiento = Utils.deObjetoEventoADocumento((Evento) producto);
            actualizarObjeto("productos-evento", (Document) nAlojamiento, producto.get_id());

        }
        if (producto.getTipo().equals(TipoProducto.EXPERIENCIA)) {
            Document nAlojamiento = Utils.deObjetoExperienciaADocumento((Experiencia) producto);
            actualizarObjeto("productos-experiencia", (Document) nAlojamiento, producto.get_id());

        }
        if (producto.getTipo().equals(TipoProducto.SALIDA)) {
            Document nAlojamiento = Utils.deObjetoSalidaADocumento((Salida) producto);
            actualizarObjeto("productos-salida", (Document) nAlojamiento, producto.get_id());

        }
        if (producto.getTipo().equals(TipoProducto.SITIO)) {
            Document nAlojamiento = Utils.deObjetoSitioADocumento((Sitio) producto);
            actualizarObjeto("productos-sitio", (Document) nAlojamiento, producto.get_id());

        }
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
     * Busca en una colecci�n indicada un objeto por su ID
     *
     * @param nombreColeccion
     * @param _id
     */

    public static Pregunta buscarPreguntaPorID(String nombreColeccion, String _id) {
        MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
        MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);

        // Se crea el query con un objeto ID del tipo que utiliza MongoDB
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(_id));

        Document pregunta = coleccion.find(query).first();
        return Utils.deDocumentoAObjetoPregunta(pregunta);
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

    /**
     * Cierra la conexi�n a la Base de Datos de MongoDB
     */
    public static void cerrarConexionMongoDB() {
        clienteMongo.close();
    }


    /**
     * Busca en una colecci�n indicada un objeto por su ID
     *
     * @param nombreColeccion
     * @param _id
     */
    public static Carrito buscarCarritoEnColeccionPorID(String nombreColeccion, String _id) {
        MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
        MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);

        // Se crea el query con un objeto ID del tipo que utiliza MongoDB
        BasicDBObject query = new BasicDBObject();
        query.put("idUsuario", _id);


        Document carrito = coleccion.find(query).first();
        return Utils.deDocumentoAObjetoCarrito(carrito);
    }

    
    public static String twitterAPI(String query)  {
    	String res = "";
    	ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDaemonEnabled(true)
        	.setOAuthConsumerKey("pqshFC0Lty6Xk7XHfTvcfR3g0")
        	.setOAuthConsumerSecret("U3LHX2PTq4VK9RbujNRr86IIcdoeCIQ7kBKTbz7lpEgVwrA9i0")
        	.setOAuthAccessToken("175229799-yoMqJPVn28XLwxnkLK9UX7IHK9rO65p0w9msKv2O")
        	.setOAuthAccessTokenSecret("U0Yn39cHmg5zfix4Om1okdlKI6QTP8cLtNSSwo0S6xejU")
        	.setJSONStoreEnabled(true);
        
        TwitterFactory tf = new TwitterFactory(configurationBuilder.build());
        twitter4j.Twitter twitter = tf.getInstance();
        List<Status> status;
		try {
			//status = twitter.getHomeTimeline();
			Query q = new Query("("+query+")AND(lang:es)");
			QueryResult result = twitter.search(q);
			status = result.getTweets();
			JSONArray tweets = new JSONArray();
			for(Status s: status) {
				JSONObject j = new JSONObject();
				j.append("userName", s.getUser().getName())
				.append("text", s.getText())
				.append("creation", s.getCreatedAt());
				tweets.put(j);
			}
			res = TwitterObjectFactory.getRawJSON(status);
			//System.out.println(res);
			System.out.println(tweets.toString());
			return tweets.toString();

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
    }


    /**
     * Inserta en una colecci�n indicada una pregunta
     *
     * @param nombreColeccion
     * @param usuario
     */
    public static void insertarPregunta(String nombreColeccion, Pregunta nPregunta) {
    	
    	
    	
        MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
        MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);
        
        
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(nPregunta.getId_Producto()) );
        
        Document docProducto = coleccion.find(query).first();           
        
        
        Producto producto = new Producto() {};      
        
        if (nombreColeccion ==  "productos-transporte") 
        	producto= Utils.deDocumentoAObjetoTransporte(docProducto);        

        if (nombreColeccion ==  "productos-experiencia")
            producto= Utils.deDocumentoAObjetoExperiencia(docProducto);
        
        if (nombreColeccion ==  "productos-salida")
            producto= Utils.deDocumentoAObjetoSalida(docProducto);
        
        if (nombreColeccion ==  "productos-sitio")
            producto= Utils.deDocumentoAObjetoSitio(docProducto);
        
        if (nombreColeccion ==  "productos-alojamiento")
            producto= Utils.deDocumentoAObjetoAlojamiento(docProducto);
        
        if (nombreColeccion ==  "productos-evento")
            producto= Utils.deDocumentoAObjetoEvento(docProducto);
        
        
        
        List<Pregunta> pregunta = producto.getPregunta();        
        pregunta.add(nPregunta);     
        
        producto.setPregunta(pregunta);        
        actualizarProducto(producto);       
        
    }
    
    
    
    /**
     * Elimina en una colecci�n indicada una pregunta
     *
     * @param nombreColeccion
     * @param usuario
     */
    public static void eliminarPregunta(String nombreColeccion, String idProducto, String idPregunta) {
        MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
        MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);
        
        
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(idProducto) );
        
        Document docProducto = coleccion.find(query).first();        
        //System.out.println(docProducto.toJson());          
        
        Producto producto = new Producto() {};      
        
        if (nombreColeccion ==  "productos-transporte") 
        	producto= Utils.deDocumentoAObjetoTransporte(docProducto);        

        if (nombreColeccion ==  "productos-experiencia")
            producto= Utils.deDocumentoAObjetoExperiencia(docProducto);
        
        if (nombreColeccion ==  "productos-salida")
            producto= Utils.deDocumentoAObjetoSalida(docProducto);
        
        if (nombreColeccion ==  "productos-sitio")
            producto= Utils.deDocumentoAObjetoSitio(docProducto);
        
        if (nombreColeccion ==  "productos-alojamiento")
            producto= Utils.deDocumentoAObjetoAlojamiento(docProducto);  
        
        if (nombreColeccion ==  "productos-evento")
            producto= Utils.deDocumentoAObjetoEvento(docProducto);
        
        List<Pregunta> pregunta = producto.getPregunta(); 
        
        
        int posicion=0, remover = 0;        
        for(Pregunta pre : pregunta) {
        	if (pre.get_id().equals(idPregunta)) {        		
        		remover=posicion;        		
        	}
        	posicion++;
        }
        pregunta.remove(remover);
        producto.setPregunta(pregunta);        
        actualizarProducto(producto);
        
    }
    
    
    /**
     * Retorna una pregunta
     *
     * @param nombreColeccion
     * @param usuario
     */
    public static Pregunta obtenerPregunta(String nombreColeccion, String idProducto, String idPregunta) {
    	
    	Pregunta preg = new Pregunta();
    	
        MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
        MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);        
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(idProducto) );        
        Document docProducto = coleccion.find(query).first();        
        
        Producto producto = new Producto() {};      
        
        if (nombreColeccion ==  "productos-transporte") 
        	producto= Utils.deDocumentoAObjetoTransporte(docProducto);        

        if (nombreColeccion ==  "productos-experiencia")
            producto= Utils.deDocumentoAObjetoExperiencia(docProducto);
        
        if (nombreColeccion ==  "productos-salida")
            producto= Utils.deDocumentoAObjetoSalida(docProducto);
        
        if (nombreColeccion ==  "productos-sitio")
            producto= Utils.deDocumentoAObjetoSitio(docProducto);
        
        if (nombreColeccion ==  "productos-alojamiento")
            producto= Utils.deDocumentoAObjetoAlojamiento(docProducto); 
        
        if (nombreColeccion ==  "productos-evento")
            producto= Utils.deDocumentoAObjetoEvento(docProducto);
        
        List<Pregunta> pregunta = producto.getPregunta();        
        int posicion=0, remover = 0;        
        for(Pregunta pre : pregunta) {
        	if (pre.get_id().equals(idPregunta)) {        		
        		preg = pre;        		
        	}
        	posicion++;
        }
        
        return preg;        
    }
    
    /**
     * Actualiza una pregunta
     *
     * @param nombreColeccion
     * @param usuario
     */
    public static void actualizarPregunta(String nombreColeccion, Pregunta nPregunta) {
        MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
        MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);
        
        
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(nPregunta.getId_Producto()) );
        
        Document docProducto = coleccion.find(query).first();        
        //System.out.println(docProducto.toJson());          
        
        Producto producto = new Producto() {};      
        
        if (nombreColeccion ==  "productos-transporte") 
        	producto= Utils.deDocumentoAObjetoTransporte(docProducto);        

        if (nombreColeccion ==  "productos-experiencia")
            producto= Utils.deDocumentoAObjetoExperiencia(docProducto);
        
        if (nombreColeccion ==  "productos-salida")
            producto= Utils.deDocumentoAObjetoSalida(docProducto);
        
        if (nombreColeccion ==  "productos-sitio")
            producto= Utils.deDocumentoAObjetoSitio(docProducto);
        
        if (nombreColeccion ==  "productos-alojamiento")
            producto= Utils.deDocumentoAObjetoAlojamiento(docProducto);  
        
        if (nombreColeccion ==  "productos-evento")
            producto= Utils.deDocumentoAObjetoEvento(docProducto);
        
        List<Pregunta> pregunta = producto.getPregunta(); 
        int posicion=0, remover = 0;        
        for(Pregunta pre : pregunta) {
        	if (pre.get_id().equals(nPregunta.get_id())) {        		
        		remover=posicion;        		
        	}
        	posicion++;
        }
        pregunta.remove(remover);        
        pregunta.add(nPregunta);     
        
        producto.setPregunta(pregunta);        
        actualizarProducto(producto);
        
    }
    

   
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Inserta en una colecci�n indicada una pregunta
     *
     * @param nombreColeccion
     * @param usuario
     */
    public static void insertarCalificacion(String nombreColeccion, Calificacion nCalificacion) {
        MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
        MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);
        
        
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(nCalificacion.getId_Producto()) );
        
        Document docProducto = coleccion.find(query).first();        
        //System.out.println(docProducto.toJson());          
        
        Producto producto = new Producto() {};      
        
        if (nombreColeccion ==  "productos-transporte") 
        	producto= Utils.deDocumentoAObjetoTransporte(docProducto);        

        if (nombreColeccion ==  "productos-experiencia")
            producto= Utils.deDocumentoAObjetoExperiencia(docProducto);
        
        if (nombreColeccion ==  "productos-salida")
            producto= Utils.deDocumentoAObjetoSalida(docProducto);
        
        if (nombreColeccion ==  "productos-sitio")
            producto= Utils.deDocumentoAObjetoSitio(docProducto);
        
        if (nombreColeccion ==  "productos-alojamiento")
            producto= Utils.deDocumentoAObjetoAlojamiento(docProducto); 
        
        if (nombreColeccion ==  "productos-evento")
            producto= Utils.deDocumentoAObjetoEvento(docProducto);
        
        List<Calificacion> calificacion = producto.getCalificacion();        
        calificacion.add(nCalificacion);     
        
        producto.setCalificacion(calificacion);        
        actualizarProducto(producto);
        
    }
    
    
    /**
     * Elimina en una colecci�n indicada una calificacion
     *
     * @param nombreColeccion
     * @param usuario
     */
    public static void eliminarCalificacion(String nombreColeccion, String idProducto, String idCalificacion) {
        MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
        MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);
        
        
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(idProducto) );
        
        Document docProducto = coleccion.find(query).first();        
        //System.out.println(docProducto.toJson());          
        
        Producto producto = new Producto() {};      
        
        if (nombreColeccion ==  "productos-transporte") 
        	producto= Utils.deDocumentoAObjetoTransporte(docProducto);        

        if (nombreColeccion ==  "productos-experiencia")
            producto= Utils.deDocumentoAObjetoExperiencia(docProducto);
        
        if (nombreColeccion ==  "productos-salida")
            producto= Utils.deDocumentoAObjetoSalida(docProducto);
        
        if (nombreColeccion ==  "productos-sitio")
            producto= Utils.deDocumentoAObjetoSitio(docProducto);
        
        if (nombreColeccion ==  "productos-alojamiento")
            producto= Utils.deDocumentoAObjetoAlojamiento(docProducto); 
        
        if (nombreColeccion ==  "productos-evento")
            producto= Utils.deDocumentoAObjetoEvento(docProducto);
        
        List<Calificacion> calificacion = producto.getCalificacion();
        
        int posicion=0, remover = 0;        
        for(Calificacion cal : calificacion) {
        	if (cal.get_id().equals(idCalificacion)) {        		
        		remover=posicion;        		
        	}
        	posicion++;
        }
        calificacion.remove(remover);       
                
        producto.setCalificacion(calificacion);     
        actualizarProducto(producto);
        
    }
    
    
    /**
     * Retorna una pregunta
     *
     * @param nombreColeccion
     * @param usuario
     */
    public static Calificacion obtenerCalificacion(String nombreColeccion, String idProducto, String idCalificacion) {
    	
    	Calificacion nota = new Calificacion();
    	
        MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
        MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);        
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(idProducto) );        
        Document docProducto = coleccion.find(query).first();        
        
        Producto producto = new Producto() {};      
        
        if (nombreColeccion ==  "productos-transporte") 
        	producto= Utils.deDocumentoAObjetoTransporte(docProducto);        

        if (nombreColeccion ==  "productos-experiencia")
            producto= Utils.deDocumentoAObjetoExperiencia(docProducto);
        
        if (nombreColeccion ==  "productos-salida")
            producto= Utils.deDocumentoAObjetoSalida(docProducto);
        
        if (nombreColeccion ==  "productos-sitio")
            producto= Utils.deDocumentoAObjetoSitio(docProducto);
        
        if (nombreColeccion ==  "productos-alojamiento")
            producto= Utils.deDocumentoAObjetoAlojamiento(docProducto);   
        
        if (nombreColeccion ==  "productos-evento")
            producto= Utils.deDocumentoAObjetoEvento(docProducto);
        
        List<Calificacion> calificacion = producto.getCalificacion();
        
        int posicion=0, remover = 0;        
        for(Calificacion cal : calificacion) {
        	if (cal.get_id().equals(idCalificacion)) {        		
        		nota=cal;        		
        	}
        	posicion++;
        }
        
        return nota;
        
    }
    
    /**
     * Actualiza una calificacion
     *
     * @param nombreColeccion
     * @param usuario
     */
    public static void actualizarCalificacion(String nombreColeccion, Calificacion nCalificacion) {
        MongoDatabase baseDeDatos = clienteMongo.getDatabase(nombreDB);
        MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);
        
        
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(nCalificacion.getId_Producto()) );
        
        Document docProducto = coleccion.find(query).first();        
        //System.out.println(docProducto.toJson());          
        
        Producto producto = new Producto() {};      
        
        if (nombreColeccion ==  "productos-transporte") 
        	producto= Utils.deDocumentoAObjetoTransporte(docProducto);        

        if (nombreColeccion ==  "productos-experiencia")
            producto= Utils.deDocumentoAObjetoExperiencia(docProducto);
        
        if (nombreColeccion ==  "productos-salida")
            producto= Utils.deDocumentoAObjetoSalida(docProducto);
        
        if (nombreColeccion ==  "productos-sitio")
            producto= Utils.deDocumentoAObjetoSitio(docProducto);
        
        if (nombreColeccion ==  "productos-alojamiento")
            producto= Utils.deDocumentoAObjetoAlojamiento(docProducto); 
        
        if (nombreColeccion ==  "productos-evento")
            producto= Utils.deDocumentoAObjetoEvento(docProducto);
        
        List<Calificacion> calificacion = producto.getCalificacion();
        
        int posicion=0, remover = 0;        
        for(Calificacion cal : calificacion) {
        	if (cal.get_id().equals(nCalificacion.get_id())) {        		
        		remover=posicion;        		
        	}
        	posicion++;
        }
        calificacion.remove(remover);           
        calificacion.add(nCalificacion);     
        
        producto.setCalificacion(calificacion);        
        actualizarProducto(producto);
        
    }
    
}

