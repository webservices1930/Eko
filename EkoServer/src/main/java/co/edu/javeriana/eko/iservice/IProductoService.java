package co.edu.javeriana.eko.iservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import co.edu.javeriana.eko.model.producto.Transporte;

@WebService
public interface IProductoService {

	@WebMethod(operationName = "calificacionPromedio")
	public double calcularCalificacionPromedio();
	
	@WebMethod(operationName = "agregarProductoTransporte")
	public void agregarProductoTransporte(@WebParam(name = "transporte") Transporte nTransporte);
	
	@WebMethod(operationName = "buscarProductoTransportePorID")
	@WebResult(name="productoTransporte")
	public void buscarProductoTransportePorID(@WebParam(name = "transporteID") String _id);
	
	@WebMethod(operationName = "eliminarProductoTransportePorID")
	public void eliminarProductoTransportePorID(@WebParam(name = "transporteID") String _id);
	
	@WebMethod(operationName = "actualizarProductoTransporte")
	public void actualizarProductoTransporte(@WebParam(name = "transporte") Transporte nTransporte);
}
