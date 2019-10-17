package co.edu.javeriana.eko.iservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import co.edu.javeriana.eko.model.Calificacion;
import co.edu.javeriana.eko.model.Pregunta;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.model.producto.Alojamiento;
import co.edu.javeriana.eko.model.producto.Evento;
import co.edu.javeriana.eko.model.producto.Experiencia;
import co.edu.javeriana.eko.model.producto.Salida;
import co.edu.javeriana.eko.model.producto.Sitio;
import co.edu.javeriana.eko.model.Reserva;
import co.edu.javeriana.eko.model.producto.Transporte;

@WebService
public interface IProductoService {

	@WebMethod(operationName = "calificacionPromedio")
	public double calcularCalificacionPromedio();
	
	
	
	@WebMethod(operationName = "obtenerProductos")
	@WebResult(name="listadoProductos")
	public List<Producto> obtenerProductos();	
	
	@WebMethod(operationName = "buscarProductoPorId")
	@WebResult(name="producto")	
	public Producto buscarProductoPorId(@WebParam(name = "productoID")String _id);
	
	@WebMethod(operationName = "obtenerProductosPorUsuario")
	@WebResult(name="listaProductosUsuario")	
	public List<Producto> obtenerProductosPorUsuario(@WebParam(name = "usuarioID")  String _idUsuario);
	
	//** TRANSPORTE **//
	@WebMethod(operationName = "agregarProductoTransporte")
	public void agregarProductoTransporte(@WebParam(name = "transporte") Transporte nTransporte);
	
	@WebMethod(operationName = "buscarProductoTransportePorID")
	@WebResult(name="productoTransporte")
	public Producto buscarProductoTransportePorID(@WebParam(name = "transporteID") String _id);
	
	@WebMethod(operationName = "eliminarProductoTransportePorID")
	public void eliminarProductoTransportePorID(@WebParam(name = "transporteID") String _id);
	
	@WebMethod(operationName = "actualizarProductoTransporte")
	public void actualizarProductoTransporte(@WebParam(name = "transporte") Transporte nTransporte);

	
	//** ALOJAMIENTO **//
	@WebMethod(operationName = "agregarProductoAlojamiento")
	public void agregarProductoAlojamiento(@WebParam(name = "alojamiento") Alojamiento nAlojamiento);

	@WebMethod(operationName = "buscarProductoAlojamientoPorID")
	@WebResult(name="productoAlojamiento")
	public Producto buscarProductoAlojamientoPorID(@WebParam(name = "alojamientoID") String _id);

	@WebMethod(operationName = "eliminarProductoAlojamientoPorID")
	public void eliminarProductoAlojamientoPorID(@WebParam(name = "alojamientoID") String _id);

	@WebMethod(operationName = "actualizarProductoAlojamiento")
	public void actualizarProductoAlojamiento(@WebParam(name = "transporte") Alojamiento nAlojamiento);

	
	//** SITIO **//
	@WebMethod(operationName = "agregarProductoSitio")
	public void agregarProductoSitio(@WebParam(name = "sitio") Sitio nSitio);
	
	@WebMethod(operationName = "buscarProductoSitioPorID")
	@WebResult(name="productoSitio")
	public Producto buscarProductoSitioPorID(@WebParam(name = "sitioID") String _id);
	
	@WebMethod(operationName = "eliminarProductoSitioPorID")
	public void eliminarProductoSitioPorID(@WebParam(name = "sitioID") String _id);
	
	@WebMethod(operationName = "actualizarProductoSitio")
	public void actualizarProductoSitio(@WebParam(name = "sitio") Sitio nSitio);


	
	
	//** EXPERIENCIA **//
	@WebMethod(operationName = "agregarProductoExperiencia")
	public void agregarProductoExperiencia(@WebParam(name = "experiencia") Experiencia nExperiencia);
	
	@WebMethod(operationName = "buscarProductoExperienciaPorID")
	@WebResult(name="productoExperiencia")
	public Producto buscarProductoExperienciaPorID(@WebParam(name = "experienciaID") String _id);
	
	@WebMethod(operationName = "eliminarProductoExperienciaPorID")
	public void eliminarProductoExperienciaPorID(@WebParam(name = "experienciaID") String _id);
	
	@WebMethod(operationName = "actualizarProductoExperiencia")
	public void actualizarProductoExperiencia(@WebParam(name = "experiencia") Experiencia nExperiencia);
		
	
	//** SALIDA **//
	@WebMethod(operationName = "agregarProductoSalida")
	public void agregarProductoSalida(@WebParam(name = "salida") Salida nSalida);
	
	@WebMethod(operationName = "buscarProductoSalidaPorID")
	@WebResult(name="productoSalida")
	public Producto buscarProductoSalidaPorID(@WebParam(name = "salidaID") String _id);
	
	@WebMethod(operationName = "eliminarProductoSalidaPorID")
	public void eliminarProductoSalidaPorID(@WebParam(name = "salidaID") String _id);
	
	@WebMethod(operationName = "actualizarProductoSalida")
	public void actualizarProductoSalida(@WebParam(name = "salida") Salida nSalida);
	
	
	//** EVENTO **//
	@WebMethod(operationName = "agregarProductoEvento")
	public void agregarProductoEvento(@WebParam(name = "evento") Evento nEvento);
	
	@WebMethod(operationName = "buscarProductoEventoPorID")
	@WebResult(name="productoEvento")
	public Producto buscarProductoEventoPorID(@WebParam(name = "eventoID") String _id);
	
	@WebMethod(operationName = "eliminarProductoEventoPorID")
	public void eliminarProductoEventoPorID(@WebParam(name = "eventoID") String _id);
	
	@WebMethod(operationName = "actualizarProductoEvento")
	public void actualizarProductoEvento(@WebParam(name = "evento") Evento nEvento);
	
	//Reserva

	@WebMethod(operationName = "agregarReserva")
	public void agregarReserva(@WebParam(name = "reserva") Reserva nReserva);
	
	@WebMethod(operationName = "buscarReservasClientePorID")
	@WebResult(name="reservasCliente")
	public List<Reserva> buscarReservasClientePorID(@WebParam(name = "clienteID") String _id);
	
	@WebMethod(operationName = "eliminarReservaPorID")
	public void eliminarReservaPorID(@WebParam(name = "reservaID") String _id);

	@WebMethod(operationName = "actualizarReserva")
	public void actualizarReserva(@WebParam(name = "reserva") Reserva nReserva);

	@WebMethod(operationName = "cancelarReserva")
	public void cancelarReserva(@WebParam(name = "reserva") Reserva nReserva);



	// calificaciones
	
	@WebMethod(operationName = "agregarCalificacionProducto")
	public void agregarCalificacionProducto(@WebParam(name = "calificacion") Calificacion nCalificacion);
	
	
	@WebMethod(operationName = "eliminarCalificacionProducto")
	public void eliminarCalificacionProducto(@WebParam(name = "calificacionID") String _id);
	
	
	// preguntas
	
	@WebMethod(operationName = "agregarPreguntaProducto")
	public void agregarPreguntaProducto(@WebParam(name = "pregunta") Pregunta nPregunta);
	
	
	@WebMethod(operationName = "eliminarPreguntaProducto")
	public void eliminarPreguntaProducto(@WebParam(name = "preguntaID") String _id);
	
	
	@WebMethod(operationName = "buscarPreguntaProductoPorID")
	@WebResult(name="productoPregunta")
	public Pregunta buscarPreguntaProductoPorID(@WebParam(name = "preguntaID") String _id);
	
	
	
}
