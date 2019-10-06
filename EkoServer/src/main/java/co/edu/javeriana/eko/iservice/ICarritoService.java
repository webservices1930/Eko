package co.edu.javeriana.eko.iservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import co.edu.javeriana.eko.model.Carrito;
import co.edu.javeriana.eko.model.Producto;

@WebService
public interface ICarritoService {


	@WebMethod(operationName = "agregarCarrito")
	public void agregarCarrito(@WebParam(name = "carrito") Carrito nCarrito);
		
	@WebMethod(operationName = "obtenerCarritoPorUsuario")
	@WebResult(name="listaCarritoUsuario")	
	public Carrito obtenerCarritoPorUsuario(@WebParam(name = "usuarioID")  String _idUsuario);	

	@WebMethod(operationName = "actualizarCarrito")
	public void actualizarCarrito(@WebParam(name = "carrito") Carrito nCarrito);	
	
	@WebMethod(operationName = "eliminarCarritoPorID")
	public void eliminarCarritoPorID(@WebParam(name = "carritoID") String _id);
	
}
