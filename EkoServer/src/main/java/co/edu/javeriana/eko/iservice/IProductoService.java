package co.edu.javeriana.eko.iservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import co.edu.javeriana.eko.model.Calificacion;
import co.edu.javeriana.eko.model.Pregunta;
import co.edu.javeriana.eko.model.Producto;
import co.edu.javeriana.eko.model.producto.Transporte;

@WebService
public interface IProductoService {

	@WebMethod(operationName = "calificacionPromedio")
	public double calcularCalificacionPromedio();
	
	@WebMethod(operationName = "agregarProductoTransporte")
	public void agregarProductoTransporte(@WebParam(name = "transporte") Transporte nTransporte);
	
	@WebMethod(operationName = "buscarProductoTransportePorID")
	@WebResult(name="productoTransporte")
	public Producto buscarProductoTransportePorID(@WebParam(name = "transporteID") String _id);
	
	@WebMethod(operationName = "eliminarProductoTransportePorID")
	public void eliminarProductoTransportePorID(@WebParam(name = "transporteID") String _id);
	
	@WebMethod(operationName = "actualizarProductoTransporte")
	public void actualizarProductoTransporte(@WebParam(name = "transporte") Transporte nTransporte);
	
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
